package com.journaldev.spring.utility;

import java.util.Base64;

public class Utility {

				
	
    public static String encodeBase64(String key) {
    	Base64.Encoder enc = Base64.getEncoder();
        byte[] encbytes = enc.encode(key.getBytes());
        return new String(encbytes);
    }
    
    public static String decodeBase64(String encKey) {
    	Base64.Decoder dec = Base64.getDecoder();
        byte[] decbytes = dec.decode(encKey);
        return new String(decbytes);	
    }
	
    
	
}
