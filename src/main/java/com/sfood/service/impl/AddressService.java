package com.sfood.service.impl;

import com.sfood.dto.address_api.request.District;
import com.sfood.dto.address_api.request.Province;
import com.sfood.dto.address_api.request.Ward;
import com.sfood.dto.address_api.response.DistrictResponse;
import com.sfood.dto.address_api.response.ProvinceResponse;
import com.sfood.dto.address_api.response.WardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class AddressService {
    @Autowired
    private RestTemplate restTemplate;
    private final String TOKEN = "c6c00d0d-eed7-11ef-a268-9e63d516feb9";
    private final String PROVINCE_API_URL = "https://online-gateway.ghn.vn/shiip/public-api/master-data/province";
    private final String DISTRICT_API_URL = "https://online-gateway.ghn.vn/shiip/public-api/master-data/district";
    private final String WARD_API_URL = "https://online-gateway.ghn.vn/shiip/public-api/master-data/ward?district_id";

    public List<Map<String, Object>> getProvinces() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Token", TOKEN);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(PROVINCE_API_URL, HttpMethod.GET, entity, Map.class);

        if(response.getStatusCode().equals(HttpStatus.OK)) {
            return (List<Map<String, Object>>) response.getBody().get("data");
        }
        return List.of();
    }

    public List<Map<String, Object>> getDistricts(int provinceId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Token", TOKEN);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Integer>> entity = new HttpEntity<>(Map.of("province_id", provinceId), headers);
        ResponseEntity<Map> response = restTemplate.exchange(DISTRICT_API_URL, HttpMethod.POST, entity, Map.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return (List<Map<String, Object>>) response.getBody().get("data");
        }
        return List.of();
    }

    public List<Map<String, Object>> getWards(int districtId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Token", TOKEN);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Integer>> entity = new HttpEntity<>(Map.of("district_id", districtId), headers);
        ResponseEntity<Map> response = restTemplate.exchange( WARD_API_URL, HttpMethod.POST, entity, Map.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return (List<Map<String, Object>>) response.getBody().get("data");
        }
        return List.of();
    }
}
