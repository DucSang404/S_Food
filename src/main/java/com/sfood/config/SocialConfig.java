package com.sfood.config;

import java.io.IOException;
import java.util.Properties;

public class SocialConfig {
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(SocialConfig.class.getResourceAsStream("/facebook.properties"));
            properties.load(SocialConfig.class.getResourceAsStream("/google.properties"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
