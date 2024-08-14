package com.example.kafka_learn.dto.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Sherif.Abdulraheem 13/08/2024 - 17:08
 **/
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@EqualsAndHashCode(exclude = {"isPrimary"})
public class OrganizationRole implements Serializable {
    private static final long serialVersionUID = -41793919580370558L;
    @JsonProperty("organization_id")
    private UUID organizationId;
    @JsonProperty("user_role")
    private String userRole;
    @JsonProperty("is_primary")
    private Boolean isPrimary;

    public static OrganizationRoleBuilder builder() {
        return new OrganizationRoleBuilder();
    }

    public UUID getOrganizationId() {
        return this.organizationId;
    }

    public String getUserRole() {
        return this.userRole;
    }

    public Boolean getIsPrimary() {
        return this.isPrimary;
    }

    @JsonProperty("organization_id")
    public void setOrganizationId(final UUID organizationId) {
        this.organizationId = organizationId;
    }

    @JsonProperty("user_role")
    public void setUserRole(final String userRole) {
        this.userRole = userRole;
    }

    @JsonProperty("is_primary")
    public void setIsPrimary(final Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public OrganizationRole() {
    }

    public OrganizationRole(final UUID organizationId, final String userRole, final Boolean isPrimary) {
        this.organizationId = organizationId;
        this.userRole = userRole;
        this.isPrimary = isPrimary;
    }

    public static class OrganizationRoleBuilder {
        private UUID organizationId;
        private String userRole;
        private Boolean isPrimary;

        OrganizationRoleBuilder() {
        }

        @JsonProperty("organization_id")
        public OrganizationRoleBuilder organizationId(final UUID organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        @JsonProperty("user_role")
        public OrganizationRoleBuilder userRole(final String userRole) {
            this.userRole = userRole;
            return this;
        }

        @JsonProperty("is_primary")
        public OrganizationRoleBuilder isPrimary(final Boolean isPrimary) {
            this.isPrimary = isPrimary;
            return this;
        }

        public OrganizationRole build() {
            return new OrganizationRole(this.organizationId, this.userRole, this.isPrimary);
        }

        public String toString() {
            return "OrganizationRole.OrganizationRoleBuilder(organizationId=" + this.organizationId + ", userRole=" + this.userRole + ", isPrimary=" + this.isPrimary + ")";
        }
    }
}
