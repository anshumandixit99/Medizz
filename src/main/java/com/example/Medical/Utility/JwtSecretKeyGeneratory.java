package com.example.Medical.Utility;

import java.security.SecureRandom;
import java.util.Base64;

public class JwtSecretKeyGeneratory {
    public static void main(String args[]){
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[64];
        secureRandom.nextBytes(key);
        String securityKey = Base64.getEncoder().encodeToString(key);
        System.out.println("Generated key : "+securityKey);
    }
}
