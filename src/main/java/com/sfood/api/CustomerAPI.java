package com.sfood.api;

import com.sfood.dto.CustomerDTO;
import com.sfood.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CustomerAPI {
    @Autowired
    private CustomerService customerService;
    @PutMapping("/update-customer-info")
    public ResponseEntity<Map<String, Object>> updateCustomer(@RequestBody CustomerDTO updateCustomer,
                                                              HttpSession session) {
        Map<String, Object> response = new HashMap<>();

        try {
            CustomerDTO customerDTO = (CustomerDTO) session.getAttribute("user");

            customerDTO = customerService.updateCustomer(customerDTO.getId(), updateCustomer);

            session.setAttribute("user", customerDTO);
            response.put("success", true);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            response.put("success", false);
            response.put("message", "Error updating customer: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/update-customer-info")
    public ResponseEntity<Map<String, Object>> updateCustomerInfo(@RequestParam("avatar") MultipartFile avatar,
                                                                  HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        CustomerDTO customerDTO = (CustomerDTO) session.getAttribute("user");

        try {
            String fileName = null;
            if(avatar != null && !avatar.isEmpty()) {
                fileName = UUID.randomUUID().toString() + getFileExtension(avatar.getOriginalFilename());

                String uploadDir = "D:\\File rac\\Menu S-Food\\";
                File destinationFile = new File(uploadDir + fileName);
                avatar.transferTo(destinationFile);
                customerService.changeAvatar(customerDTO.getId(), fileName);
            }

            response.put("success", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(response);
    }

    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex);
    }
}
