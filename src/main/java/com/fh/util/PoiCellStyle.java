package com.fh.util;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * 
 * <pre>项目名称：movie_pro    
 * 类名称：PoiCellStyle    
 * 类描述：    poi导出Excel的样式封装类
 * 创建人：LiuPeng 766740710@qq.com    
 * 创建时间：2018年8月29日 上午11:42:29    
 * 修改人：LiuPeng 766740710@qq.com     
 * 修改时间：2018年8月29日 上午11:42:29    
 * 修改备注：       
 * @version </pre>
 */
public class PoiCellStyle {
	
	/**
	 * <pre>titleCellStyle(Excel表标题样式)   
	 * 创建人：LiuPeng 766740710@qq.com   
	 * 创建时间：2018年8月29日 上午11:42:16    
	 * 修改人：LiuPeng 766740710@qq.com     
	 * 修改时间：2018年8月29日 上午11:42:16    
	 * 修改备注： 
	 * @param workbook
	 * @return</pre>
	 */
    public static XSSFCellStyle titleCellStyle(XSSFWorkbook workbook) {

        XSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 水平居中
        style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 垂直居中
        
        // 设置行高
        // row.setHeight((short) 30);
        // 设置字体
        XSSFFont font = workbook.createFont();
        //设置字体颜色
        font.setColor(HSSFColor.RED.index);
        font.setFontHeight(24);
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        style.setFont(font);

        return style;
    }
    
    /**
     * <pre>headCellStyle(Excel表头样式)   
     * 创建人：LiuPeng 766740710@qq.com   
     * 创建时间：2018年8月29日 上午11:41:58    
     * 修改人：LiuPeng 766740710@qq.com     
     * 修改时间：2018年8月29日 上午11:41:58    
     * 修改备注： 
     * @param workbook
     * @return</pre>
     */
    public static XSSFCellStyle headCellStyle(XSSFWorkbook workbook) {
        XSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 水平居中
        style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 垂直居中
        // 设置行高
        // row.setHeight((short) 15);
        // 设置字体
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        //font.setColor(HSSFColor.RED.index);
        style.setFont(font);
        style.setBorderBottom((short) 1);// 下边框
        style.setBorderTop((short) 1);// 上边框
        style.setBorderLeft((short) 1);// 左边框
        style.setBorderRight((short) 1); // 有边框
        // 设置单元格的背景色
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);// 设置前景填充样式
        style.setFillForegroundColor(HSSFColor.ORANGE.index);// 前景填充色
        return style;

    }

    /**
     * <pre>dataCellStyle(Excel表内容样式)   
     * 创建人：LiuPeng 766740710@qq.com   
     * 创建时间：2018年8月29日 上午11:43:12    
     * 修改人：LiuPeng 766740710@qq.com     
     * 修改时间：2018年8月29日 上午11:43:12    
     * 修改备注： 
     * @param workbook
     * @return</pre>
     */
    public static XSSFCellStyle dataCellStyle(XSSFWorkbook workbook) {
        XSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 水平居中
        style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 垂直居中
        // 设置行高
        // row.setHeight((short) 12);
        // 设置字体
        XSSFFont font = workbook.createFont();
        font.setFontHeight(12);
        style.setFont(font);

        style.setBorderBottom((short) 1);// 下边框
        style.setBorderTop((short) 1);// 上边框
        style.setBorderLeft((short) 1);// 左边框
        style.setBorderRight((short) 1); // 有边框
        return style;
    }
}
