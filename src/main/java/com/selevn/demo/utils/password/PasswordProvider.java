package com.selevn.demo.utils.password;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class PasswordProvider {

    static String hashPassword( final char[] password, final byte[] salt, final int iterations, final int keyLength ) {

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA512" );
            PBEKeySpec spec = new PBEKeySpec( password, salt, iterations, keyLength );
            SecretKey key = skf.generateSecret( spec );
            var res = Hex.encodeHexString(key.getEncoded( ));
            return res;
        } catch ( NoSuchAlgorithmException | InvalidKeySpecException e ) {
            throw new RuntimeException( e );
        }
    }

    public static boolean checkPassword(String password, String hash, String salt){
        return hash.equals(genHash(password,salt));
    }
    static String genHash(String password, String salt){
        return hashPassword(password.toCharArray(),salt.getBytes(StandardCharsets.US_ASCII),10000,64*8);
    }
}
