package com.fh.controller.dept;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils;
import com.fh.bean.dept.DeptBean;
import com.fh.bean.user.UserBean;
import com.fh.service.dept.IDeptService;
import com.fh.util.JsonUtil;

@Controller
@RequestMapping("DeptController")
public class DeptController 
{
	@Autowired
	private IDeptService deptService;
	
	@RequestMapping("queryDeptZtree")
	public void queryDeptZtree(HttpServletResponse response){
		List<Map<String, Object>> list = deptService.queryDeptZtree();
		JsonUtil.returnStr(list,response);
	}
	
	@RequestMapping("queryZtree")
	public  ModelAndView queryZtree(){
		ModelAndView mav = new ModelAndView("WEB-INF/dept/DeptZtree");
		return mav;
	}
	
	@RequestMapping("addDept")
	@ResponseBody  
	public Map addDept(String deptArr){
		List<DeptBean> deptList = JSON.parseArray(deptArr, DeptBean.class);

		
		int  flag = deptService.addDept(deptList);
		Map<String , Object> map = new HashMap<String , Object>();
		if(flag > 0){
			map.put("success",true);
		}else{
			map.put("success",false);
		}
		return map;
	} 
	
	
	@RequestMapping("deletedept")
	@ResponseBody
	public Map deletedept(String deptid)
	{
		Map<String , Object> map = new HashMap<String , Object>();
		if(StringUtils.isNotBlank(deptid))
		{
			String ids[] = deptid.substring(1).split(";");
			int  flag = deptService.deleteDept(ids);
			if(flag > 0)
			{
				map.put("success",true);
			}else{
					map.put("success",false);
				}
		}
		return map;
	}
	
	@RequestMapping("updateDept")
	@ResponseBody
	public Map updateDept(DeptBean dept){
		Map<String , Object> map = new HashMap<String , Object>();
		
			int  flag = deptService.updateDept(dept);
			if(flag > 0)
			{
				map.put("success",true);
			}else{
					map.put("success",false);
				}
		
		return map;
		
	}
	
	@RequestMapping("querydept")
	@ResponseBody
    public List querydept() {
    	    List<UserBean> list = deptService.querydept();
        return list;
    }
	
	
	
}
