package com.example.kafka_learn.dto.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Sherif.Abdulraheem 13/08/2024 - 17:15
 **/
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@EqualsAndHashCode(callSuper = true)
public class UserV2 extends UserBase implements Serializable {
    private static final long serialVersionUID = -1698261986587389078L;
    @JsonProperty("user_metadata")
    private Set<Metadata> userMetadata;

    protected UserV2(final UserV2Builder<?, ?> b) {
        super(b);
        this.userMetadata = b.userMetadata;
    }

    public static UserV2Builder<?, ?> builder() {
        return new UserV2BuilderImpl();
    }

    public Set<Metadata> getUserMetadata() {
        return this.userMetadata;
    }

    @JsonProperty("user_metadata")
    public void setUserMetadata(final Set<Metadata> userMetadata) {
        this.userMetadata = userMetadata;
    }

    public UserV2() {
    }

    public abstract static class UserV2Builder<C extends UserV2, B extends UserV2Builder<C, B>> extends UserBase.UserBaseBuilder<C, B> {
        private Set<Metadata> userMetadata;

        public UserV2Builder() {
        }

        protected abstract B self();

        public abstract C build();

        @JsonProperty("user_metadata")
        public B userMetadata(final Set<Metadata> userMetadata) {
            this.userMetadata = userMetadata;
            return this.self();
        }

        public String toString() {
            String var10000 = super.toString();
            return "UserV2.UserV2Builder(super=" + var10000 + ", userMetadata=" + this.userMetadata + ")";
        }
    }

    private static final class UserV2BuilderImpl extends UserV2Builder<UserV2, UserV2BuilderImpl> {
        private UserV2BuilderImpl() {
        }

        protected UserV2BuilderImpl self() {
            return this;
        }

        public UserV2 build() {
            return new UserV2(this);
        }
    }
}
