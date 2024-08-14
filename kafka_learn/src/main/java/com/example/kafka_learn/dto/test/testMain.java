package com.example.kafka_learn.dto.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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
        if(userPayload.getOrgRoles().size()==1){
            userPayload.getOrgRoles().stream().findFirst().get().setIsPrimary(true);
        }
        log.info("new Org Roles {}", new ObjectMapper().writeValueAsString(userPayload.getOrgRoles()));

        userPayload.getUserMetadata().addAll(dbPayload.getUserMetadata());
        log.info("User MetaData {}", new ObjectMapper().writeValueAsString(userPayload.getUserMetadata()));
        log.info("Is Update required {}", isUpadeRequired(userPayload, dbPayload));
        log.info("Is Update required {}", isUpadeRequired(userPayload, userPayload));

        UserV3 uv3 = new UserV3();
        uv3.setEmail("aaa@gmail.com");
        uv3.setUsername("comand");
        UserV3 uv3a = new UserV3();
        uv3a.setUsername("comand");
        uv3a.setEmail("aaa@gmail.com");

        log.info("UV required {}", uv3a.equals(uv3));

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
        orgRole.setUserRole("admin");
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
}
