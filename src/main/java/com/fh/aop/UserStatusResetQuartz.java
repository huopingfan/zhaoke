package com.fh.aop;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import com.fh.service.log.ILogService;

@Component
public class UserStatusResetQuartz 
{
	 //spring 的标志性注解
	@Scheduled(cron = "0 0 0  * * ? ")
	public void updateUserReset(){
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		ILogService loginService = (ILogService) wac.getBean("loginService");
		loginService.updateLoginReset();
	}
}
