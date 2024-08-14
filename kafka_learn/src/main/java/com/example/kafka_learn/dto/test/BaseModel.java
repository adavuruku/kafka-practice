package com.example.kafka_learn.dto.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Sherif.Abdulraheem 13/08/2024 - 17:04
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@EqualsAndHashCode
public class BaseModel implements Serializable {
    private static final long serialVersionUID = 3831156352716664344L;
    private UUID id;

    protected BaseModel(final BaseModelBuilder<?, ?> b) {
        this.id = b.id;
    }

    public static BaseModelBuilder<?, ?> builder() {
        return new BaseModelBuilderImpl();
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public BaseModel() {
    }

    public abstract static class BaseModelBuilder<C extends BaseModel, B extends BaseModelBuilder<C, B>> {
        private UUID id;

        public BaseModelBuilder() {
        }

        protected abstract B self();

        public abstract C build();

        public B id(final UUID id) {
            this.id = id;
            return this.self();
        }

        public String toString() {
            return "BaseModel.BaseModelBuilder(id=" + this.id + ")";
        }
    }

    private static final class BaseModelBuilderImpl extends BaseModelBuilder<BaseModel, BaseModelBuilderImpl> {
        private BaseModelBuilderImpl() {
        }

        protected BaseModelBuilderImpl self() {
            return this;
        }

        public BaseModel build() {
            return new BaseModel(this);
        }
    }
}

