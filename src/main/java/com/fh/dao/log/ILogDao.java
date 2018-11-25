package com.fh.dao.log;

import com.fh.bean.log.LogBean;

public interface ILogDao {

	void updateLoginReset();

	void addLog(LogBean log);


}
