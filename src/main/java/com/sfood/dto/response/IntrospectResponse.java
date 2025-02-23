package com.sfood.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
@Builder
public class IntrospectResponse {
    private boolean valid;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
