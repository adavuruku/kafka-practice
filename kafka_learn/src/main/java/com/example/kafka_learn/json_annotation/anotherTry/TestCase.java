package com.example.kafka_learn.json_annotation.anotherTry;

import com.example.kafka_learn.json_annotation.RoleType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by Sherif.Abdulraheem 21/08/2024 - 21:27
 **/
public class TestCase {
    public static void main(String[] args) throws JsonProcessingException {
        String json = "{ \"ucn\":\"1234\", \"other_roles\": { \"aide\": { \"identifier\": \"11\", \"metadata\": { \"staff_legacy_id\": \"66c4ed06a79b7618319ce634\", \"title\": \"Ms\" }, \"orgs\": [ { \"href\": \"\", \"sourcedId\": \"068n15hlum4fuia399sg\", \"type\": \"org\" } ], \"role\": \"aide\", \"userIds\": [ { \"identifier\": \"66c4ed06a79b7618319ce634\", \"type\": \"legacy_id\" } ] },\"sherif\": { \"identifier\": \"11\", \"metadata\": { \"staff_legacy_id\": \"66c4ed06a79b7618319ce634\", \"title\": \"Ms\" }, \"orgs\": [ { \"href\": \"\", \"sourcedId\": \"068n15hlum4fuia399sg\", \"type\": \"org\" } ], \"role\": \"aide\", \"userIds\": [ { \"identifier\": \"66c4ed06a79b7618319ce634\", \"type\": \"legacy_id\" } ] },\"teacher\": { \"identifier\": \"11\", \"metadata\": { \"staff_legacy_id\": \"66c4ed06a79b7618319ce634\", \"title\": \"Ms\" }, \"orgs\": [ { \"href\": \"\", \"sourcedId\": \"068n15hlum4fuia399sg\", \"type\": \"org\" } ], \"role\": \"teacher\", \"userIds\": [ { \"identifier\": \"66c4ed06a79b7618319ce634\", \"type\": \"legacy_id\" } ] } }}";
        ObjectMapper objectMapper = new ObjectMapper();
        RoleType[] roleTypesArray = RoleType.values();
        System.out.println(Arrays.toString(roleTypesArray));
        BaseOrg borg = objectMapper.readValue(json, BaseOrg.class);
        System.out.println(borg.getOtherRoles().keySet());
        System.out.println(borg.getOtherRoles().get(RoleType.AIDE));
        System.out.println(borg.getOtherRoles().get(RoleType.TEACHER));
        System.out.println(borg.getAdditionalProperties().get("ucn"));



//        RoleType[] roleTypesArray = RoleType.values();
        Set<String> roleKeys = borg.getOtherRoles().keySet();
//        RoleType[] roleTypesArray = RoleType.values();
//        Set<String> roleKeys = borg.getOtherRoles().keySet();

        List<String> roleTypesList = Arrays.stream(roleTypesArray)
                .map(RoleType::getType)
                .filter(roleKeys::contains)
                .collect(Collectors.toList());
        System.out.println(roleTypesList);
        Map<String, OrgRole> roles = borg.getOtherRoles();
        List<OrgRole> orgRoles = new ArrayList<>();
        for(String roleKey : roleKeys){
            OrgRole userOrganizatonRole = roles.get(roleKey);
            orgRoles.add(userOrganizatonRole);
        }
        System.out.println(orgRoles);

    }
}
