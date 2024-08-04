package com.Hmac.vansoMock;



import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StreamUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Slf4j
public class HMAC {



    private HMAC(){

    }
    public static Boolean verifyHMAC(HttpServletRequest request, String sharedSecret, String appendUrlPath)
    {
        try {
            String body = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
            String path = String.format("%s%s", appendUrlPath, new URI(request.getRequestURI()).getPath());
            String timestamp = request.getHeader("timestamp");
            String macString = path + timestamp + body;
            // Verify request not too old
            if (Long.parseLong(timestamp) < (System.currentTimeMillis() - 30000)) {
                log.info("failed time check");
                throw new RuntimeException();
            }
            // Verify signature
            if (!generateHMACSignature(macString, sharedSecret).equals(request.getHeader("signature"))) {
                log.info("failed signature check");
                throw new RuntimeException();
            }
        }catch (RuntimeException | IOException | URISyntaxException e){
            log.info(e.getMessage());
            throw new RuntimeException();
        }
        return true;
    }
    public static String generateHMACSignature(String macString, String secret)
    {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(), "HmacSHA256"));
            byte[] signature = mac.doFinal(macString.getBytes(StandardCharsets.UTF_8));
            byte[] base64 = Base64.getEncoder().encode(signature);
            return new String(base64, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException();
        }
    }

}
