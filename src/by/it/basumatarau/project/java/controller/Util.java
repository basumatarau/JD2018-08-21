package by.it.basumatarau.project.java.controller;

import by.it.basumatarau.project.java.beans.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Util {

    public static User getUser(HttpServletRequest request){
        HttpSession session = request.getSession(false);

        if(session!=null) {
            return (User) session.getAttribute("user");
        }else{
            return null;
        }
    }

    public static String getPwdHash(String pwd, String saltSeed){
        return get_SHA_512_SecurePassword(pwd, getSalt(saltSeed));
    }

    private static String get_SHA_512_SecurePassword(String passwordToHash, byte[] salt)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    private static byte[] getSalt(String saltStr)
    {
        saltStr+="qwertasdfgzxcv";
        return Arrays.copyOf(saltStr.getBytes(), 16);
        //SecureRandom salt should've been generated for each user and stored in DB, but...
    }
}
