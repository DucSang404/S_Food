package com.sfood.config;

public class VNPayConfig {
    public static final String VNP_URL = "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html";

    public static final String VNP_TMN_CODE = "T02G7RFL";
    public static final String VNP_HASH_SECRET = "96W86R8BXTGUS8LDYCQ3MY876NOQNP4J";
    public static final String VNP_VERSION = "2.1.0";
    public static final String VNP_COMMAND = "pay";
    public static final String VNP_CURR_CODE = "VND";

    public static final String VNP_RETURN_URL = "http://localhost:8080/payment/return";
    public static final String VNP_BANK_CODE = "VCB";
}
