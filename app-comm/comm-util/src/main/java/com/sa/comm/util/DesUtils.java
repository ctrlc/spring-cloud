package com.sa.comm.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class DesUtils {
    public static final int KEY_LENGTH_BYTES = 24;

    /**
     * triple_des 加密算法
     *
     * @param key     密钥字节数组
     * @param iv      时间撮字节数组
     * @param message 待加密信息字节数组
     * @return
     */
    static byte[] encrypt(byte[] key, byte[] iv, byte[] message) {
        byte[] result = null;
        try {
            Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DESede");
            SecretKey secretKey = skf.generateSecret(new DESedeKeySpec(key));
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

            result = cipher.doFinal(message);
        } catch (Exception e) {
            throw new SecurityException(e);
        }

        return result;
    }

    /**
     * @param key
     * @param iv
     * @param message
     * @return
     */
    static byte[] decrypt(byte[] key, byte[] iv, byte[] message) {
        byte[] result = null;
        try {
            Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DESede");
            SecretKey secretKey = skf.generateSecret(new DESedeKeySpec(key));
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

            result = cipher.doFinal(message);
        } catch (Exception e) {
            throw new SecurityException(e);
        }

        return result;
    }

    /**
     * 根据指定密钥加密数据信息
     *
     * @param appsecret 密钥
     * @param iv        时间撮
     * @param message   待加密内容
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String dxEncryptV3(String appsecret, long iv, String message)
            throws UnsupportedEncodingException {
        byte[] ivBytes = longToBytes(iv); // 8 bytes
        byte[] cipherData = encrypt(appsecret.getBytes("utf-8"), ivBytes,
                message.getBytes("utf-8"));
        return Base64.encodeBase64String(cipherData);
    }

    /**
     * @param appsecret 密钥
     * @param iv        时间撮
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String dxDecryptV3(String appsecret, long iv, String date)
            throws UnsupportedEncodingException {
        byte[] ivBytes = longToBytes(iv); // 8 bytes
        byte[] cryptText = Base64.decodeBase64(date);
        byte[] plaintext = decrypt(appsecret.getBytes("utf-8"), ivBytes,
                cryptText);
        return new String(plaintext, "utf-8");
    }

    /**
     * 长整型数据转换成8位字节
     *
     * @param v
     * @return
     */
    static byte[] longToBytes(long v) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        byteBuffer.putLong(v);
        return byteBuffer.array();
    }
}
