package com.fh.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils;
import com.fh.bean.user.UserBean;
import com.fh.service.user.IUserService;
import com.fh.util.CommonUtil;
import com.fh.util.DownExcel;
import com.fh.util.ExportExcelByRef;
import com.fh.util.FtpUploadFile;
import com.fh.util.PageBean;

@Controller
@RequestMapping("UserController")
public class UserController 
{
	@Autowired
	private IUserService userService;
	
	
	
	
	/**
	 * <pre>queryEmpPageList(查询)   
	 * 创建人：javaBossHPF 1069108221@qq.com   
	 * 创建时间：2018年9月20日 下午5:43:06    
	 * 修改人：javaBossHPF 1069108221@qq.com      
	 * 修改时间：2018年9月20日 下午5:43:06    
	 * 修改备注： 
	 * @param emp
	 * @param draw
	 * @param start
	 * @param length
	 * @return</pre>
	 */
	@RequestMapping("queryEmpPageList")
	@ResponseBody
	public Map queryEmpPageList(UserBean user, Integer  draw  , Integer start, Integer  length){
		Map<String,Object> map = new HashMap<String,Object>();
		PageBean<UserBean> page = new PageBean<UserBean>();
		page.setPagesize(length);
		page.setStartindex(start);
		List<UserBean> list = userService.queryEmpPageList(user,page);
		map.put("draw",draw);
		map.put("recordsTotal",  page.getTotalcount());
		map.put("recordsFiltered",  page.getTotalcount());   
		map.put("data", list);
		return map;
	}
	
	@RequestMapping("deleteUser")
	@ResponseBody
	public Map deleteUser(String cuserid){
		Map<String,Object> map = new HashMap<String,Object>();
		int  flag = userService.deleteUser(cuserid);
		if(flag>0){
			map.put("success", true);
		}else{
			map.put("success", false);
		}
		return map;
	}
	
	@RequestMapping("addUser")
	@ResponseBody
	public Map addUser(UserBean user){
		Map<String,Object> map = new HashMap<String,Object>();
		int flag = userService.addUser(user);
		if(flag==0){
			map.put("success", false);
		}else{
			map.put("success", true);
		}
		return map;
	}
	
	@RequestMapping("queryEmpById")
	@ResponseBody
	public Map queryEmpById(String cuserid){
		Map<String,Object> map = new HashMap<String,Object>();
		UserBean user = userService.queryEmpById(cuserid);
		if(user==null){
			map.put("success", false);
		}else{
			map.put("success", true);
			map.put("data", user);
		}
		return map;
	}
	
	@RequestMapping("updateUser")
	@ResponseBody
	public Map updateUser(UserBean user){
		Map<String,Object> map = new HashMap<String,Object>();
		int flag = userService.updateUser(user);
		if(flag >0 ){
			map.put("success", true);
		}else{
			map.put("success", false);
		}
		return map;
	}
	/**
	 * <pre>exportExcel(导出excel)   
	 * 创建人：LiShaoYu 1335050347@qq.com   
	 * 创建时间：2018年10月8日 上午11:18:40    
	 * 修改人：LiShaoYu 1335050347@qq.com     
	 * 修改时间：2018年10月8日 上午11:18:40    
	 * 修改备注： 
	 * @param emp
	 * @param response</pre>
	 */
	@RequestMapping("exportExcel")
	@ResponseBody
	public void exportExcel(UserBean user,HttpServletResponse response){
		List<UserBean> empList = userService.queryAllUser(user);
		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet sheet = workBook.createSheet("用户信息表");
		String[] heads = {"姓名","性别","生日","邮箱","部门","职务"};
		String[] columns = {"cusername","usersex","dbirthday","cemail","cdeptname","czwname"};
		sheet.setColumnWidth(0, 40*100);
		sheet.setColumnWidth(1, 40*80);
		sheet.setColumnWidth(2, 40*200);
		sheet.setColumnWidth(3, 40*100);
		sheet.setColumnWidth(4, 40*200);
		ExportExcelByRef.exportExcel(empList, heads, "用户信息", columns, workBook, UserBean.class, sheet);
		DownExcel.excelDownload(workBook, response, CommonUtil.getDateTime()+".xlsx");

	}
	
	
	@RequestMapping("fileload")
	@ResponseBody
	public Map fileload(@RequestParam CommonsMultipartFile userphoto){
		if (StringUtils.isNotBlank(userphoto.getOriginalFilename())) {
			
			return FtpUploadFile.uploadFile("emppadmin/empphoto", userphoto);
		}
		return null;
	}
	
	
	
}
