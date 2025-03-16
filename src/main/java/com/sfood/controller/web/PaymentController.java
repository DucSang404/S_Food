package com.sfood.controller.web;

import com.sfood.util.VNPayUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "*")
public class PaymentController {

    // Xử lý yêu cầu POST tạo QR Code
    @PostMapping("/create")
    public Map<String, Object> createPayment(@RequestParam(value = "orderId", required = false) String orderId,
                                             @RequestParam("amount") long amount) {
        Map<String, Object> response = new HashMap<>();
        try {
            String paymentUrl = VNPayUtil.generatePaymentUrl(orderId, amount);

            response.put("status", "success");
            response.put("paymentUrl", paymentUrl);
            response.put("amount", amount);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", e.getMessage());
        }
        return response;
    }

    @GetMapping("/return")
    public Map<String, Object> paymentReturn(@RequestParam Map<String, String> params) {
        Map<String, Object> response = new HashMap<>();
        String responseCode = params.get("vnp_ResponseCode");

        if ("00".equals(responseCode)) {
            response.put("status", "success");
            response.put("message", "Thanh toán thành công!");
        } else {
            response.put("status", "failed");
            response.put("message", "Thanh toán thất bại hoặc bị hủy!");
        }
        return response;
    }
}
