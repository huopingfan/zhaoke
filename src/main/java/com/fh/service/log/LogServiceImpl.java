package com.fh.service.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.bean.log.LogBean;
import com.fh.bean.user.UserBean;
import com.fh.dao.log.ILogDao;
import com.fh.dao.user.IUserDao;




@Service("loginService")
public class LogServiceImpl implements ILogService
{
	@Autowired
	private IUserDao userDao;
	@Autowired
	private ILogDao logDao;
	
	
	
	@Override
	public UserBean queryUser(String cusername) {
		
		return userDao.queryUser(cusername);
	}

	@Override
	public void updateerrorCount(String cuserid) {
		userDao.updateerrorCount(cuserid);
		
	}

	@Override
	public void updateUserLock(String cuserid) {
		userDao.updateUserLock(cuserid);
	}

	@Override
	public void updateUserMessage(String cuserid) {
		userDao.updateUserMessage(cuserid);		
	}

	@Override
	public void updateLoginReset() {
		logDao.updateLoginReset();
	}

	@Override
	public void addLog(LogBean log) {
		logDao.addLog(log);
	}

}
