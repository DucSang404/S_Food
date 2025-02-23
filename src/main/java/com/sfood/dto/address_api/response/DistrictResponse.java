package com.sfood.dto.address_api.response;

import com.sfood.dto.address_api.request.District;
import lombok.Data;

import java.util.List;
@Data
public class DistrictResponse {
    private int code;
    private String message;
    private List<District> data;

}
