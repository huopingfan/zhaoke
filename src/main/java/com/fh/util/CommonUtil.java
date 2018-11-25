
package com.fh.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class CommonUtil {

	
	/*
	 * 计算文件大小
	 */
	  public static String countFileSize(Long size) {
	        DecimalFormat dft = new DecimalFormat("0.00");
	        if (size < 1024) {
	            return size + "B";
	        } else if (size < 1024 * 1024) {
	            double dsize = size;
	            return dft.format(dsize / 1024) + "KB";
	        } else if (size < 1024 * 1024 * 1024) {
	            double dsize = size;
	            return dft.format(dsize / (1024 * 1024)) + "M";
	        } else {
	            return size + "";
	        }

	    }
	  
	/**
	 * <pre>getRemoteAddr(计算方法)   
	 * 创建人：LiShaoYu 1335050347@qq.com   
	 * 创建时间：2018年9月26日 下午9:12:03    
	 * 修改人：LiShaoYu 1335050347@qq.com     
	 * 修改时间：2018年9月26日 下午9:12:03    
	 * 修改备注： 
	 * @param request
	 * @return</pre>
	 */
		 public static String getRemoteAddr(HttpServletRequest request) {
		        String ip = request.getHeader("X-Forwarded-For");
		        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		            ip = request.getHeader("Proxy-Client-IP");
		        }
		        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		            ip = request.getHeader("WL-Proxy-Client-IP");
		        }
		        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		            ip = request.getHeader("HTTP_CLIENT_IP");
		        }
		        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		        }
		        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		            ip = request.getRemoteAddr();
		        }
		        return ip;
		    }
		 
		 
		 public static String getDateTime(){
			 SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss"); 
			 return sdf.format(new Date());
		 }
		 
		 
		 /**
		  * <pre>dateToString(日期转字符串)   
		  * 创建人：LiuPeng 766740710@qq.com   
		  * 创建时间：2018年8月27日 下午6:45:18    
		  * 修改人：LiuPeng 766740710@qq.com     
		  * 修改时间：2018年8月27日 下午6:45:18    
		  * 修改备注： 
		  * @param date
		  * @return</pre>
		  */
		 public static String dateToString(Date date){
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			 return sdf.format(date);
		 }
		 
		 public static Date stringToDate(String date) throws ParseException{
			 DateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
			 return sdf.parse(date);
		 }

		public static String getDateNYR(Date date) {
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(date);
		}

}
