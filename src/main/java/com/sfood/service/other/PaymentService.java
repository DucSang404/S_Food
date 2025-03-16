package com.sfood.service.other;

import com.sfood.config.VNPayConfig;
import com.sfood.dto.other_dto.PaymentDTO;
import com.sfood.util.VNPayUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final VNPayConfig vnPayConfig;

    public PaymentDTO.VNPayResponse creatVNPayPayment(HttpServletRequest request) {
        long amount = Integer.parseInt(request.getParameter("amount")) * 100L;
        String bankCode = request.getParameter("bankCode");
        Map<String, String> vnpParamsMap = vnPayConfig.getVNPayConfig();
        vnpParamsMap.put("vnp_Amount", String.valueOf(amount));
        if(bankCode != null && !bankCode.isEmpty()) {
            vnpParamsMap.put("vnp_BankCode", bankCode);
        }
        vnpParamsMap.put("vnp_IpAddr", VNPayUtil.getIpAddress(request));

        String queryUrl = VNPayUtil.getPaymentUrl(vnpParamsMap, true);
        String hashData = VNPayUtil.getPaymentUrl(vnpParamsMap, false);
        String vnpSecureHash = VNPayUtil.hmacSHA512(vnPayConfig.getVnPay_secretKey(), hashData);
        queryUrl += "&vnp_SecureHash=" + vnpSecureHash;
        String paymentUrl = vnPayConfig.getVnPay_Url() + "?" + queryUrl;
        return PaymentDTO.VNPayResponse.builder()
                .code("ok")
                .message("success")
                .paymentUrl(paymentUrl)
                .build();
    }
}
