package org.al.adsystem.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class UserHashHandleUtility {

    public static String generateSalt() {
        return RandomStringUtils.random(64);
    }

    public static String getHash(String source, String salt) {
        String target = shift(source, salt);
        return DigestUtils.sha256Hex(target);
    }

    private static String shift(String message, String salt) {
        byte[] out = new byte[64];
        byte[] saltBytes = salt.getBytes();
        byte[] sourceBytes = message.getBytes();

        for (int i = 0; i < saltBytes.length; i++) {
            if (i < sourceBytes.length) {
                out[i] = (byte) (sourceBytes[i] ^ saltBytes[i]);
            } else {
                out[i] = saltBytes[i];
            }
        }
        return new String(out);
    }
}
