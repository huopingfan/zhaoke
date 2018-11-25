package com.fh.service.log;

import com.fh.bean.log.LogBean;
import com.fh.bean.user.UserBean;

public interface ILogService {

	UserBean queryUser(String cusername);

	void updateerrorCount(String cuserid);

	void updateUserLock(String cuserid);

	void updateUserMessage(String cuserid);

	void updateLoginReset();

	void addLog(LogBean log);

}
