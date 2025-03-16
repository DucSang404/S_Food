package com.sfood.config;

import com.sfood.util.VNPayUtil;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

@Configuration
@Getter
@PropertySource("classpath:vnpay.properties")
public class VNPayConfig {
    @Value("${payment.vnPay.url}")
    private String vnPay_Url;
    @Value("${payment.vnPay.tmnCode}")
    private String vnPay_tmnCode;
    @Value("${payment.vnPay.secretKey}")
    private String vnPay_secretKey;
    @Value("${payment.vnPay.returnUrl}")
    private String vnPay_returnUrl;
    @Value("${payment.vnPay.version}")
    private String vnPay_version;
    @Value("${payment.vnPay.command}")
    private String vnPay_command;
    @Value("${payment.vnPay.orderType}")
    private String vnPay_orderType;

    public Map<String, String> getVNPayConfig() {
        Map<String, String> vnPayParam = new HashMap<>();
        vnPayParam.put("vnp_Version", this.vnPay_version);
        vnPayParam.put("vnp_Command", this.vnPay_command);
        vnPayParam.put("vnp_TmnCode", this.vnPay_tmnCode);
        vnPayParam.put("vnp_CurrCode", "VND");
        vnPayParam.put("vnp_TxnRef",  VNPayUtil.getRandomNumber(8));
        vnPayParam.put("vnp_OrderInfo", "Payment for order:" +  VNPayUtil.getRandomNumber(8));
        vnPayParam.put("vnp_OrderType", this.vnPay_orderType);
        vnPayParam.put("vnp_Locale", "vn");
        vnPayParam.put("vnp_ReturnUrl", this.vnPay_returnUrl);
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnpCreateDate = formatter.format(calendar.getTime());
        vnPayParam.put("vnp_CreateDate", vnpCreateDate);
        calendar.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(calendar.getTime());
        vnPayParam.put("vnp_ExpireDate", vnp_ExpireDate);
        return vnPayParam;
    }
}
