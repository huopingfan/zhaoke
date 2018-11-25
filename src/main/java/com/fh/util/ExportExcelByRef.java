package com.fh.util;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExportExcelByRef {

	public static void exportExcel(List objList,String[] heads,String title,String[] columns,XSSFWorkbook wb,
			Class clazz,XSSFSheet sheet){
		//创建sheet页
		
		//声明标题行 ,合并  赋值  加样式
		XSSFRow titleRow = sheet.createRow(0);
		CellRangeAddress range = new CellRangeAddress(0,0,0,heads.length-1);
		sheet.addMergedRegion(range);
		XSSFCell titleCell = titleRow.createCell(0);
		titleCell.setCellValue(title);
		titleCell.setCellStyle(PoiCellStyle.titleCellStyle(wb));
		
		//生成表头行  赋值 加样式
		XSSFRow rowhead = sheet.createRow(1);
		for (int i = 0; i < heads.length; i++) {
			XSSFCell cellbody = rowhead.createCell(i);
			cellbody.setCellValue(heads[i]);
			cellbody.setCellStyle(PoiCellStyle.headCellStyle(wb));
		}
		
		//循环objList集合 取出对象
		for (int i = 0; i < objList.size(); i++) {
			Object object = objList.get(i);
			XSSFRow dataRow = sheet.createRow(i+2);
			
			for (int j = 0; j < heads.length; j++) {
				String column = columns[j];
				String methodName = bulidGetMethod(column);
				try {
					Method method = clazz.getMethod(methodName);
					Object result = method.invoke(object);
					
					XSSFCell dataCell = dataRow.createCell(j);
					if(result instanceof Date){
						dataCell.setCellValue(CommonUtil.dateToString((Date) result));
					}else if(result instanceof Integer){
						dataCell.setCellValue((Integer) result);
					}else if(result instanceof Double){
						dataCell.setCellValue((Double) result);
					}else{
						dataCell.setCellValue((String) result);
					}
					dataCell.setCellStyle(PoiCellStyle.dataCellStyle(wb));
							
				} catch (Exception e) {
					e.printStackTrace();
				} 
			
			}
			
		}
		
	}
	
	private static String bulidGetMethod(String column){
		
		return "get" + column.substring(0,1).toUpperCase() + column.substring(1);
	}
	
}
