package com.example.kafka_learn.json_annotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

/**
 * Created by Sherif.Abdulraheem 19/08/2024 - 11:22
 **/
public class TestAnotation {
    public static void main(String[] args) throws JsonProcessingException {
//        String sam = " ";
//        System.out.println(sam.isBlank());
//        List<String> list = new ArrayList<>();
//        list.add("High");
//        List<String> list2 = new ArrayList<>();
//        list2 = null;
//        Set<String> mergedSet = new HashSet<>(list);
//        mergedSet.addAll(list2 == null? Collections.emptySet() :list2);
//        System.out.println(mergedSet.size());

        String json = "{ \"name\": \"John\",\"dept\": \"Agric\", \"title\": \"Teacher\", \"metadata\": { \"other_roles\": { \"aide\": { \"identifier\": \"11\", \"metadata\": { \"staff_legacy_id\": \"66c4ed06a79b7618319ce634\", \"title\": \"Ms\" }, \"orgs\": [ { \"href\": \"\", \"sourcedId\": \"068n15hlum4fuia399sg\", \"type\": \"org\" } ], \"role\": \"aide\", \"userIds\": [ { \"identifier\": \"66c4ed06a79b7618319ce634\", \"type\": \"legacy_id\" } ] } }, \"teacher_legacy_id\": \"66c4e24dbe53d103e01ada8a\" } }";

        ObjectMapper mapper = new ObjectMapper();


//        UserUpdate user = mapper.readValue(json, UserUpdate.class);
//        UserUpdateBaseModel user = mapper.readValue(json, UserUpdateBaseModel.class);
//
//        System.out.println(user.getName());
//        System.out.println(user.getTitle());
////        System.out.println(user.getMetadata().getOrDefault("other_roles", null));
//        System.out.println(user.getMetadata().getAdditionalProperties().getOrDefault("other_roles", null));
////        Map<String, Object> metaData = (Map<String, Object>) user.getMetaData();
////        Map<String, Object> otherRoles = getValueOrNull(user.getMetaData(),"other_roles");
//////        Map<String, Object> orgs = (Map<String, Object>) otherRoles.get("aide");
//////        System.out.println(orgs);
////
//        Map<String, Object> otherRoles = getObjectValueOrNull(user.getMetadata().getAdditionalProperties(),"other_roles");
//        if(otherRoles != null) {
//            //get the keys
//            String role = otherRoles.keySet().stream().findFirst().orElse(null);
//            Map<String, Object> roleMap = getObjectValueOrNull(otherRoles,role);
//            if(roleMap != null) {
//                System.out.println(roleMap);
//            }
//        }
////        System.out.println(otherRoles.keySet());
////
////        // Use the getValueOrNull method
////        if(otherRoles != null) {
////            Map<String, Object> orgs = getObjectValueOrNull(otherRoles, "orgs");
////            Map<String, Object> role = getObjectValueOrNull(otherRoles, "role");
////        }
//
//        Map<String , Object> kk = Collections.emptyMap();
//        String roleKey = kk.keySet().stream().findFirst().orElse(null);
//        System.out.println(roleKey == null);
//
//        List<String> jj = new ArrayList<>();
//        jj.add(GetStr());
//        jj.add(GetStr());
//        System.out.println(jj);
//
//        Object tyoe = "aide";
//        RoleType rt = RoleType.fromType(tyoe.toString());
//        System.out.println(rt);

    }

    public static String GetStr(){
        return null;
    }

    public static Map<String, Object> getObjectValueOrNull(Map<String, Object> mapRecord, String key) {
        Object mapObject = mapRecord.getOrDefault(key, null);
        if (mapObject instanceof Map) {
                return (Map<String, Object>) mapObject;
        }

        return Collections.emptyMap();
    }
//    public static <T, K> getObjectValueOrNull(Map<T, K> mapRecord, K key) {
//        if (mapRecord.containsKey(key) ) {
//            return (Map<String, Object>) mapRecord.get(key);
//        }
//        return null;
//    }
}