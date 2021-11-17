package ru.stepanov.core.patterns;

import java.util.HashMap;
import java.util.Map;


public class OrderDataUpdate {

    private Map<String, String> fields;
    private String bankOrderId;

    private OrderDataUpdate(Builder builder) {
        this.fields = builder.fields;
        this.bankOrderId = builder.bankOrderId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public String getBankOrderId() {
        return bankOrderId;
    }

    public static class Builder {
        private String bankOrderId;
        private Map<String, String> fields;

        public Builder() {
            this.fields = new HashMap<>();
            this.fields.put("key2","val2");
        }

        public OrderDataUpdate build() {
            return new OrderDataUpdate(this);
        }

        public Builder bankOrderHiddenId(String bankOrderId) {
            this.bankOrderId = bankOrderId;
            return this;
        }

        public Builder fields(Map<String, String> fields) {
            if (fields == null) {
                return this;
            }
            this.fields.putAll(fields);
            return this;
        }

    }
}
