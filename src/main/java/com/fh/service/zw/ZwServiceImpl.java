package com.fh.service.zw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.bean.user.UserBean;
import com.fh.dao.zw.IZwDao;



@Service("zeService")
public class ZwServiceImpl implements IZwService{

	
	@Autowired
	private IZwDao zwDao;
	@Override
	public List<UserBean> queryzw() {
		
		return zwDao.queryzw();
	}

}
