package com.sfood.api;

import com.sfood.service.impl.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AddressAPI {
    @Autowired
    private AddressService addressService;

    @GetMapping("/provinces")
    public List<Map<String, Object>> getProvinces() {
        return addressService.getProvinces();
    }

    @GetMapping("/districts")
    public List<Map<String, Object>> getDistricts(@RequestParam int provinceId) {
        return addressService.getDistricts(provinceId);
    }

    @GetMapping("/wards")
    public List<Map<String, Object>> getWards(@RequestParam int districtId) {
        return addressService.getWards(districtId);
    }

}
