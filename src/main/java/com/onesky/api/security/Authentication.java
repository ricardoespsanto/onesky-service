package com.onesky.api.security;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import lombok.extern.java.Log;

/**
 * An authentication class that implements the authentication mechanism required by the OneSky API.
 */
@Log
public class Authentication {

    private Authentication() {
        // Preventing Instantiation
    }

    /**
     * Create a Map which will contain the required authentication parameters to perform an authentication.
     *
     * @param apiSecret the api secret
     * @param apiKey    the api key
     * @return the authentication
     */
    public static Map<String, String> getAuthentication(String apiSecret, String apiKey) {
        Map<String, String> authenticationMap = new HashMap<>(3);
        authenticationMap.put("api_key", apiKey);
        authenticationMap.put("timestamp", getTimestamp());
        try {
            authenticationMap.put("dev_hash", generateDevHash(apiSecret));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            log.log(Level.WARNING, "Failed to generate authentication", e);
        }
        return authenticationMap;
    }

    private static String generateDevHash(String apiSecret) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String timestampAndSecret = getTimestamp() + apiSecret;
        return Hex.encodeHexString(DigestUtils.md5(timestampAndSecret));
    }

    private static String getTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000L);
    }
}
