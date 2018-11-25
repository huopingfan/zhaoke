package com.fh.controller.log;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fh.bean.user.UserBean;
import com.fh.service.log.ILogService;



@Controller
@RequestMapping("LogController")
public class LogController 
{
	@Autowired
	private ILogService loginService;
	
	
	
	@RequestMapping("queryUser")
	@ResponseBody
	public Map queryUser(UserBean userbean,HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
		//验证用户名是否存在
		//以用户名为条件，查询用户是否存在
		UserBean	user= loginService.queryUser(userbean.getCusername());
		if(user==null){
			map.put("success", false);
			map.put("message", "用户名不存在,请注册");
			return map;
		}
		//判断该账户是否被锁定
		if(user.getNvalid() == 1){
			map.put("success",false);
			map.put("message","该用户已经被锁定，请明天在试");
			return map;
		}
		if(!userbean.getCuserpwd().equals(user.getCuserpwd())){
			
			//如何记录密码输入错误，必须记录错误的次数，和时间
			loginService.updateerrorCount(user.getCuserid());
			//账号锁定
			//跟据查询的结果，如果错误的次数等于  2 的时候，代表这次已经是第三次输入错误，我们
						    //  就要把该账号锁定
			if(user.getErrorcount()==2){
				loginService.updateUserLock(user.getCuserid());
			}
			map.put("success", false);
			map.put("message", "密码错误,请重新输入");
			return map;
		}
		map.put("success", true);
		map.put("message", "登录成功");
		request.getSession().setAttribute("user",user);
		//登陆成功之后要记录登陆成功的次数、登陆的时间、修改错误的时间、错误的时间清零
		loginService.updateUserMessage(user.getCuserid());
		return map;
	}
}
