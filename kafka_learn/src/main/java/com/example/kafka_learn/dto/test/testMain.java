package com.example.kafka_learn.dto.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Sherif.Abdulraheem 13/08/2024 - 17:23
 **/
@Slf4j
public class testMain {
    public static final UUID NIL_GUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
    public static void main(String[] args) throws JsonProcessingException {
        UserV2 userPayload = createUserV2();
        UserV2 dbPayload = createUserV2AsDB();
        log.info(new ObjectMapper().writeValueAsString(userPayload));
        log.info(new ObjectMapper().writeValueAsString(dbPayload));
        boolean isOrgDifferent = findIfOrgDiffers(userPayload.getOrgRoles(), dbPayload.getOrgRoles());
        log.info("findIfOrgDiffers {} payload {} dbPayload {} ",isOrgDifferent,
        new ObjectMapper().writeValueAsString(userPayload.getOrgRoles()),
                new ObjectMapper().writeValueAsString(dbPayload.getOrgRoles()));

        boolean isMetaDifferent = findMetaChange(userPayload.getUserMetadata(), dbPayload.getUserMetadata());
        log.info("findMetaChange {} payload {} dbPayload {} ",isMetaDifferent,
                new ObjectMapper().writeValueAsString(userPayload.getUserMetadata()),
                new ObjectMapper().writeValueAsString(dbPayload.getUserMetadata()));

        userPayload.getOrgRoles().addAll(dbPayload.getOrgRoles());
//        if(userPayload.getOrgRoles().size()==1){
//            userPayload.getOrgRoles().stream().findFirst().get().setIsPrimary(true);
//        }
//        log.info("new Org Roles {}", new ObjectMapper().writeValueAsString(userPayload.getOrgRoles()));
        log.info("new Org Roles {}", new ObjectMapper().writeValueAsString(buildOrganizationRoleChanges(userPayload.getOrgRoles(), dbPayload.getOrgRoles())));

        //payload will add
//        userPayload.getUserMetadata().addAll(dbPayload.getUserMetadata());
//        Map<String, Object> newMetadata = dbPayload.getUserMetadata().stream()
//                .collect(Collectors.toMap(
//                        meta -> meta.getAttributeKey(),
//                        meta -> meta.getAttributeValue(),
//                        (oldValue, newValue) -> newValue));
//        for(Metadata metadata : userPayload.getUserMetadata()){
//            if(newMetadata.containsKey(metadata.getAttributeKey())){
//                metadata.setAttributeValue(String.valueOf(newMetadata.get(metadata.getAttributeKey())));
//            }
//        }
//
//        for(Metadata metadata : dbPayload.getUserMetadata()){
//            if(!userPayload.getUserMetadata().contains(metadata)){
//                userPayload.getUserMetadata().add(metadata);
//            }
//        }


        log.info("User MetaData {}", new ObjectMapper().writeValueAsString(
                buildRoleChanges(userPayload.getUserMetadata(), null))
        );
        log.info("Is Update required {}", isUpadeRequired(userPayload, dbPayload));
        log.info("Is Update required {}", isUpadeRequired(userPayload, userPayload));

        UserV3 uv3 = new UserV3();
        uv3.setEmail("aaa@gmail.com");
        uv3.setUsername("comand");
        UserV3 uv3a = new UserV3();
        uv3a.setUsername("comand");
        uv3a.setEmail("aaa@gmail.com");

        log.info("UV required {}", uv3a.equals(uv3));

        testMap();

    }

    public static UserV2 createUserV2() throws JsonProcessingException {

        //source identifier
        SourceSystemIdentifier src1 = new SourceSystemIdentifier();
        src1.setSourceId("123abc204");
        src1.setSourceSystem("UCN");
        Set<SourceSystemIdentifier> src_identifier = new HashSet<>();
        src_identifier.add(src1);

        //or_roles
        OrganizationRole orgRole = new OrganizationRole();
        orgRole.setUserRole("teacher");
        orgRole.setIsPrimary(false);
//        orgRole.setOrganizationId(NIL_GUID);
        orgRole.setIsPrimary(null);
        orgRole.setOrganizationId(UUID.fromString("22cced62-a7cf-4d94-864c-287948bf8b88"));

        Set<OrganizationRole> org_roles = new HashSet<>();
        org_roles.add(orgRole);

        // metadata sets
        Set<Metadata> metadataSet = new HashSet<>();
        Metadata mtData = new Metadata();
        mtData.setAttributeKey("top_name");
        mtData.setAttributeValue("toppy");
        metadataSet.add(mtData);
        mtData = new Metadata();
        mtData.setAttributeKey("color");
        mtData.setAttributeValue("#546as3");
        metadataSet.add(mtData);

        mtData = new Metadata();
        mtData.setAttributeKey("title");
        mtData.setAttributeValue("Madam");
        metadataSet.add(mtData);

        UserV2 userV2 = new UserV2();
        userV2.setEmail("aa@bb.cc");
        userV2.setFamilyName("Cane");
        userV2.setGender(null);

        userV2.setGrade(null);
        userV2.setGivenName("able");
        userV2.setMiddleName("tomas");
        userV2.setType("student");

        userV2.setOrgRoles(org_roles);
        userV2.setSourceSystemIdentifiers(src_identifier);
        userV2.setType("student");
        userV2.setUserMetadata(metadataSet);

        return userV2;
    }

    public static UserV2 createUserV2AsDB() throws JsonProcessingException {

        //source identifier
        SourceSystemIdentifier dbSrcIdentifier = new SourceSystemIdentifier();
        dbSrcIdentifier.setSourceId("123abc204");
        dbSrcIdentifier.setSourceSystem("UCN");
        Set<SourceSystemIdentifier> db_src_identifier = new HashSet<>();
        db_src_identifier.add(dbSrcIdentifier);

        //or_roles
        OrganizationRole dbOrgRole = new OrganizationRole();
        dbOrgRole.setUserRole("teacher");
        dbOrgRole.setIsPrimary(true);
        dbOrgRole.setOrganizationId(UUID.fromString("22cced62-a7cf-4d94-864c-287948bf8b88"));

        Set<OrganizationRole> db_org_roles = new HashSet<>();
        db_org_roles.add(dbOrgRole);

        // metadata sets
        Set<Metadata> dbMetadataSet = new HashSet<>();
        Metadata dbMtData = new Metadata();
        dbMtData.setAttributeKey("title");
        dbMtData.setAttributeValue("Mr");
        dbMetadataSet.add(dbMtData);

        dbMtData = new Metadata();
        dbMtData.setAttributeKey("font-size");
        dbMtData.setAttributeValue("25");
        dbMetadataSet.add(dbMtData);

        dbMtData = new Metadata();
        dbMtData.setAttributeKey("title");
        dbMtData.setAttributeValue("Mrs");
        dbMetadataSet.add(dbMtData);

        UserV2 userV2 = new UserV2();
        userV2.setEmail("aa@bb.cc");
        userV2.setFamilyName("Cane");
        userV2.setGender(null);

        userV2.setGrade(null);
        userV2.setGivenName("able");
        userV2.setMiddleName("tomas");
        userV2.setType("student");

        userV2.setOrgRoles(db_org_roles);
        userV2.setSourceSystemIdentifiers(db_src_identifier);
        userV2.setType("student");
        userV2.setUserMetadata(dbMetadataSet);

        return userV2;
    }

    public static boolean findIfOrgDiffers(Set<OrganizationRole> orgPayload, Set<OrganizationRole> dbPayload){
        return orgPayload.equals(dbPayload);
    }

    public static boolean findMetaChange(Set<Metadata> metaPayload, Set<Metadata> dbMetaPayload){
        return metaPayload.equals(dbMetaPayload);
    }

    public static boolean isUpadeRequired(UserV2 userV2, UserV2 dbUserV2){
        return userV2.equals(dbUserV2);
    }

    public static Set<OrganizationRole> buildOrganizationRoleChanges(Set<OrganizationRole> newOrgRolePayload, Set<OrganizationRole> dbPayload){
        Map<String, OrganizationRole> dbOrgRoleMap = dbPayload.stream()
                .collect(Collectors.toMap(
                        organizationRole-> String.valueOf(organizationRole.getOrganizationId()).concat(organizationRole.getUserRole()),
                        organizationRole -> organizationRole,
                        (oldValue, newValue) -> newValue));

        for(OrganizationRole orgRole : newOrgRolePayload){
            String roleKey = String.valueOf(orgRole.getOrganizationId()).concat(orgRole.getUserRole());
            if(dbOrgRoleMap.containsKey(roleKey)){
                boolean existingPrimary = dbOrgRoleMap.get(roleKey).getIsPrimary();
                dbOrgRoleMap.get(roleKey).setUserRole(orgRole.getUserRole());
                dbOrgRoleMap.get(roleKey).setIsPrimary(orgRole.getIsPrimary() != null? orgRole.getIsPrimary(): existingPrimary);
            }else{
                dbOrgRoleMap.put(roleKey, orgRole);
            }
        }
        return new HashSet<>(dbOrgRoleMap.values());

    }

    public static Set<Metadata> buildRoleChanges(Set<Metadata> newMetadataPayload, Set<Metadata> dbPayload){
//        Map<String, Metadata> dbRoleMap = new HashMap<>();
//        for(Metadata orgMetadata : dbPayload){
//            dbRoleMap.put(orgMetadata.getAttributeKey(), orgMetadata);
//        }
        Map<String, Metadata> dbRoleMap = new HashMap<>();
        if(dbPayload != null && !dbPayload.isEmpty()){
            dbRoleMap = dbPayload.stream()
                    .collect(Collectors.toMap(
                            Metadata::getAttributeKey,
                            meta -> meta,
                            (oldValue, newValue) -> newValue));
        }


        for(Metadata orgMetadata : newMetadataPayload){
            if(dbRoleMap.containsKey(orgMetadata.getAttributeKey())){
                dbRoleMap.get(orgMetadata.getAttributeKey()).setAttributeValue(orgMetadata.getAttributeValue());
            }else{
                dbRoleMap.put(orgMetadata.getAttributeKey(), orgMetadata);
            }
        }
       return new HashSet<>(dbRoleMap.values());
    }

    public static void testMap(){
        String json = "{\n" +
                "  \"metadata\": {\n" +
                "    \"other_roles\": {\n" +
                "      \"aide\": {\n" +
                "        \"identifier\": \"11\",\n" +
                "        \"metadata\": {\n" +
                "          \"staff_legacy_id\": \"66c4ed06a79b7618319ce634\",\n" +
                "          \"title\": \"Ms\"\n" +
                "        },\n" +
                "        \"orgs\": [\n" +
                "          {\n" +
                "            \"href\": \"\",\n" +
                "            \"sourcedId\": \"068n15hlum4fuia399sg\",\n" +
                "            \"type\": \"org\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"role\": \"aide\",\n" +
                "        \"userIds\": [\n" +
                "          {\n" +
                "            \"identifier\": \"66c4ed06a79b7618319ce634\",\n" +
                "            \"type\": \"legacy_id\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    },\n" +
                "    \"teacher_legacy_id\": \"66c4e24dbe53d103e01ada8a\"\n" +
                "  }\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, Object> map = mapper.readValue(json, Map.class);

            // Access the data
            Map<String, Object> metadata = (Map<String, Object>) map.get("metadata");
            Map<String, Object> otherRoles = (Map<String, Object>) metadata.get("other_roles");
            Map<String, Object> aide = (Map<String, Object>) otherRoles.get("aide");
            String identifier = (String) aide.get("identifier");

            System.out.println("Identifier: " + identifier);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Set<Metadata> mt = new HashSet<>();
        Metadata m1 = new Metadata();
        m1.setAttributeKey("aide");
        m1.setAttributeValue("11");
        mt.add(m1);
        Metadata m2 = new Metadata();
        m2.setAttributeKey("EdnitionId");
        m2.setAttributeValue("12324242");
        mt.add(m2);

        mt.removeIf(metadata -> metadata.getAttributeKey().equals("EdnitionId"));
        System.out.println(mt.stream().filter(metadata -> metadata.getAttributeKey().equals("aide")).count());
        try {
            System.out.println("Here res -> " + new ObjectMapper().writeValueAsString(mt));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
