package com.fh.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;


import com.alibaba.fastjson.JSON;


public class JsonUtil {

    /**
     * 
     * @Title: returnStr
     * @Description: 处理要返回的数据结果集
     * @param obj
     *            设定文件
     * @return void 返回类型
     * @throws
     */
    public static void returnStr(Object obj,HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        String json = JSON.toJSONString(obj);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
