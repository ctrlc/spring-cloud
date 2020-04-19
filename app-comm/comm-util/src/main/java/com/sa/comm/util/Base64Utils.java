package com.sa.comm.util;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;

import java.io.*;

public class Base64Utils {
    private static Logger logger = LoggerFactory.getLogger(Base64Utils.class);

    /**
     * 将图片转成Base64位编码
     *
     * @param imgFile 待编码图片路径
     * @return
     */
    public static String codeImageToBase64(String imgFile) {
        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return new String(Base64.encodeBase64(data));
    }


    /**
     * 将Base64位编码的图片进行解码，并保存到指定目录
     *
     * @param base64 base64编码的图片信息
     * @return
     */
    public static void decodeBase64ToImage(String base64, String path, String imgName) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            CreateFileUtil.createFile(path + imgName);
            FileOutputStream write = new FileOutputStream(new File(path + imgName));
            byte[] decoderBytes = decoder.decodeBuffer(base64);
            write.write(decoderBytes);
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
    }


    // 字符串编码
    private static final String UTF_8 = "UTF-8";

    /**
     * 解码（解密）
     *
     * @param inputData
     * @return
     */
    public static String decodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.decodeBase64(inputData.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
            logger.error(inputData, e);
        }
        return null;
    }

    /**
     * 编码（加密）
     *
     * @param inputData
     * @return
     */
    public static String encodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.encodeBase64(inputData.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
            logger.error(inputData, e);
        }
        return null;
    }


    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("3413020006231115113000800221801皖A88833LGKG42G93B9J08140CD7AA5378黑12008031720190808201908082019080801742279015651560178013902007112112341112033119323F1,C1,DC,B1,B2,R1,R201F12019-08-08 15:30:391yincheyuanwaijianyuan动态检验员底盘检验员车辆品牌SY7162VS杨光伟01521.5J21412728198909043223412728198909043223412728198909043223412728198909043223412728198909043223011liyan4127281989090432234");
        String mdgMsg = Base64Utils.encodeData(buffer.toString());
        System.out.println("md5Msg: " + mdgMsg);
        String enStr = Base64Utils.decodeData(mdgMsg);
        System.out.println(enStr);
    }

}
