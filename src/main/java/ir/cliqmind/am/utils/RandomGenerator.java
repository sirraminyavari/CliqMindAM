package ir.cliqmind.am.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class RandomGenerator {

    private SecureRandom random;
    private final char[] alphaNumeric;

    public RandomGenerator(){
        try {
            random = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if(random == null){
            random = new SecureRandom();
        }
        random.setSeed(System.currentTimeMillis());
        alphaNumeric = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    }

    public String generateAlphaNumeric(int len) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){
            sb.append(alphaNumeric[random.nextInt(alphaNumeric.length)]);
        }
        return sb.toString();
    }
}
