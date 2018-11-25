package com.fh.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import sun.misc.BASE64Encoder;

public class DownExcel {

	
	public static void excelDownload(XSSFWorkbook wirthExcelWB, HttpServletResponse response, String filename) {
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			// 让浏览器识别是什么类型的文件
			response.reset(); // 重点突出
			response.setCharacterEncoding("UTF-8"); // 重点突出
			response.setContentType("application/x-msdownload");// 不同类型的文件对应不同的MIME类型
			// // 重点突出
			// inline在浏览器中直接显示，不提示用户下载
			// attachment弹出对话框，提示用户进行下载保存本地
			// 默认为inline方式
			response.setHeader("Content-Disposition", "attachment;filename=" + filename);
			wirthExcelWB.write(out);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != out) {
				try {
					out.close();
					out = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	//转换图片
	   public static String getPhoto(String photourl) {
	       String str ="";
	       FileInputStream input = null;
	       try {
	           input = new FileInputStream(photourl);
	           byte[] photourlarr = new byte[input.available()];
	            input.read(photourlarr);
	            str = new BASE64Encoder().encode(photourlarr);
	       } catch (FileNotFoundException e) {
	           e.printStackTrace();
	       } catch (IOException e) {
	           e.printStackTrace();
	       } finally {
	           if (input != null) {
	               try {
	                   input.close();
	               } catch (IOException e) {
	                   e.printStackTrace();
	               }
	           }
	       }
	       return str;
	   }
	
	
}
