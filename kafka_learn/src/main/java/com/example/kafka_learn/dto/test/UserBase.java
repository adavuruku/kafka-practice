package com.example.kafka_learn.dto.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Sherif.Abdulraheem 13/08/2024 - 17:07
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@EqualsAndHashCode(callSuper = true)
public class UserBase extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1381978745219526505L;
    private String email;
    @JsonProperty("given_name")
    private String givenName;
    @JsonProperty("middle_name")
    private String middleName;
    @JsonProperty("family_name")
    private String familyName;
    private String type;
    private String gender;
    private Date dob;
    private String username;
    private String password;
    private String grade;
    @JsonProperty("org_roles")
    private Set<OrganizationRole> orgRoles;
    @JsonProperty("source_system_identifiers")
    private Set<SourceSystemIdentifier> sourceSystemIdentifiers;

    public boolean isRoostervent() {
        return isRoostervent;
    }

    public void setRoostervent(boolean roostervent) {
        isRoostervent = roostervent;
    }

    private boolean isRoostervent;

    protected UserBase(final UserBaseBuilder<?, ?> b) {
        super(b);
        this.email = b.email;
        this.givenName = b.givenName;
        this.middleName = b.middleName;
        this.familyName = b.familyName;
        this.type = b.type;
        this.gender = b.gender;
        this.dob = b.dob;
        this.username = b.username;
        this.password = b.password;
        this.grade = b.grade;
        this.orgRoles = b.orgRoles;
        this.sourceSystemIdentifiers = b.sourceSystemIdentifiers;
        this.isRoostervent = b.isRoostervent;
    }

    public static UserBaseBuilder<?, ?> builder() {
        return new UserBaseBuilderImpl();
    }

    public String getEmail() {
        return this.email;
    }

    public String getGivenName() {
        return this.givenName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public String getType() {
        return this.type;
    }

    public String getGender() {
        return this.gender;
    }

    public Date getDob() {
        return this.dob;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getGrade() {
        return this.grade;
    }

    public Set<OrganizationRole> getOrgRoles() {
        return this.orgRoles;
    }

    public Set<SourceSystemIdentifier> getSourceSystemIdentifiers() {
        return this.sourceSystemIdentifiers;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    @JsonProperty("given_name")
    public void setGivenName(final String givenName) {
        this.givenName = givenName;
    }

    @JsonProperty("middle_name")
    public void setMiddleName(final String middleName) {
        this.middleName = middleName;
    }

    @JsonProperty("family_name")
    public void setFamilyName(final String familyName) {
        this.familyName = familyName;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public void setDob(final Date dob) {
        this.dob = dob;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setGrade(final String grade) {
        this.grade = grade;
    }

    @JsonProperty("org_roles")
    public void setOrgRoles(final Set<OrganizationRole> orgRoles) {
        this.orgRoles = orgRoles;
    }

    @JsonProperty("source_system_identifiers")
    public void setSourceSystemIdentifiers(final Set<SourceSystemIdentifier> sourceSystemIdentifiers) {
        this.sourceSystemIdentifiers = sourceSystemIdentifiers;
    }

    public UserBase() {
    }

    @EqualsAndHashCode.Include
    private Object[] getFieldsToIgnore(){
        if(isRoostervent){
            return new Object[]{username, password, dob, gender, grade};
        }else{
            return new Object[]{

            };
        }
    }
    public abstract static class UserBaseBuilder<C extends UserBase, B extends UserBaseBuilder<C, B>> extends BaseModel.BaseModelBuilder<C, B> {
        private String email;
        private String givenName;
        private String middleName;
        private String familyName;
        private String type;
        private String gender;
        private Date dob;
        private String username;
        private String password;
        private String grade;
        private Set<OrganizationRole> orgRoles;
        private Set<SourceSystemIdentifier> sourceSystemIdentifiers;
        private boolean isRoostervent;
        public UserBaseBuilder() {
        }

        protected abstract B self();

        public abstract C build();

        public B email(final String email) {
            this.email = email;
            return this.self();
        }

        @JsonProperty("given_name")
        public B givenName(final String givenName) {
            this.givenName = givenName;
            return this.self();
        }

        @JsonProperty("middle_name")
        public B middleName(final String middleName) {
            this.middleName = middleName;
            return this.self();
        }

        @JsonProperty("family_name")
        public B familyName(final String familyName) {
            this.familyName = familyName;
            return this.self();
        }

        public B type(final String type) {
            this.type = type;
            return this.self();
        }

        public B gender(final String gender) {
            this.gender = gender;
            return this.self();
        }

        public B dob(final Date dob) {
            this.dob = dob;
            return this.self();
        }

        public B isRosterEvent(final boolean isRoostervent) {
            this.isRoostervent = isRoostervent;
            return this.self();
        }

        public B username(final String username) {
            this.username = username;
            return this.self();
        }

        public B password(final String password) {
            this.password = password;
            return this.self();
        }

        public B grade(final String grade) {
            this.grade = grade;
            return this.self();
        }

        @JsonProperty("org_roles")
        public B orgRoles(final Set<OrganizationRole> orgRoles) {
            this.orgRoles = orgRoles;
            return this.self();
        }

        @JsonProperty("source_system_identifiers")
        public B sourceSystemIdentifiers(final Set<SourceSystemIdentifier> sourceSystemIdentifiers) {
            this.sourceSystemIdentifiers = sourceSystemIdentifiers;
            return this.self();
        }

        public String toString() {
            String var10000 = super.toString();
            return "UserBase.UserBaseBuilder(super=" + var10000 + ", email=" + this.email + ", givenName=" + this.givenName + ", middleName=" + this.middleName + ", familyName=" + this.familyName + ", type=" + this.type + ", gender=" + this.gender + ", dob=" + this.dob + ", username=" + this.username + ", password=" + this.password + ", grade=" + this.grade + ", orgRoles=" + this.orgRoles + ", sourceSystemIdentifiers=" + this.sourceSystemIdentifiers + ")";
        }
    }

    private static final class UserBaseBuilderImpl extends UserBaseBuilder<UserBase, UserBaseBuilderImpl> {
        private UserBaseBuilderImpl() {
        }

        protected UserBaseBuilderImpl self() {
            return this;
        }

        public UserBase build() {
            return new UserBase(this);
        }
    }
}