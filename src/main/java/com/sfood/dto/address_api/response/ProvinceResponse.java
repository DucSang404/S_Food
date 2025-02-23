package com.sfood.dto.address_api.response;

import com.sfood.dto.address_api.request.District;
import com.sfood.dto.address_api.request.Province;
import com.sfood.dto.address_api.request.Ward;
import lombok.Data;

import java.util.List;
@Data
public class ProvinceResponse {
    private int code;
    private String message;
    private List<Province> data;

}

