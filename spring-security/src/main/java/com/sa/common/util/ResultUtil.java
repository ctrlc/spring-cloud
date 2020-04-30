package com.sa.common.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import static com.sa.comm.constant.ErrorCodeEnum.ERROR_B0001;
import static com.sa.comm.constant.ErrorCodeEnum.SUCCESS_00000;


/**
 * 返回结果工具类
 *
 * @Author Sans
 * @CreateTime 2019/9/28 10:50
 */
@Slf4j
public class ResultUtil {

    /**
     * 私有化构造器
     */
    private ResultUtil() {
    }

    /**
     * 使用response输出JSON
     *
     * @Author Sans
     * @CreateTime 2019/9/28 11:23
     * @Param resultMap 数据
     * @Return void
     */
    public static void responseJson(ServletResponse response, Map<String, Object> resultMap) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(JSON.toJSONString(resultMap));
        } catch (Exception e) {
            log.error("【JSON输出异常】" + e);
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }

    /**
     * 返回成功示例
     *
     * @Author Sans
     * @CreateTime 2019/9/28 11:29
     * @Param resultMap  返回数据MAP
     * @Return Map<String, Object> 返回数据MAP
     */
    public static Map<String, Object> resultSuccess(Map<String, Object> resultMap) {
        resultMap.put("message", SUCCESS_00000.getMessage());
        resultMap.put("code", SUCCESS_00000.getCode());
        return resultMap;
    }

    /**
     * 返回失败示例
     *
     * @Author Sans
     * @CreateTime 2019/9/28 11:31
     * @Param resultMap  返回数据MAP
     * @Return Map<String, Object> 返回数据MAP
     */
    public static Map<String, Object> resultError(Map<String, Object> resultMap) {
        resultMap.put("message", ERROR_B0001.getMessage());
        resultMap.put("code", ERROR_B0001.getCode());
        return resultMap;
    }

    /**
     * 通用示例
     *
     * @Author Sans
     * @CreateTime 2019/9/28 11:35
     * @Param code 信息码
     * @Param msg  信息
     * @Return Map<String, Object> 返回数据MAP
     */
    public static Map<String, Object> resultCode(String code, String msg) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("message", msg);
        resultMap.put("code", code);
        return resultMap;
    }

}
