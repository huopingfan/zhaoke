package com.fh.service.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.bean.user.UserBean;
import com.fh.dao.user.IUserDao;
import com.fh.util.PageBean;



@Service("userService")
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	
	
	
	@Override
	public List<UserBean> queryEmpPageList(UserBean user, PageBean<UserBean> page) {
		Map<String,Object> map = new HashMap<String,Object>();
		/*if(StringUtils.isNoneBlank(user.getCdeptids())){
			List<String> list = new ArrayList<String>();
			String []strs = user.getCdeptids().substring(1).split(";");
			for(String  id:strs){
				list.add(id);
			}		
			user.setDeptidlist(list);
		}*/
		Long count = userDao.querycount(user);
		page.setTotalcount(Integer.valueOf(String.valueOf(count)));
		map.put("user", user);
		map.put("page", page);
		return userDao.queryEmpPageList(map);
	}




	@Override
	public int deleteUser(String cuserid) {
		
		return userDao.deleteUser(cuserid);
	}




	@Override
	public int addUser(UserBean user) {
		
		return userDao.addUser(user);
	}




	@Override
	public int updateUser(UserBean user) {
		
		return userDao.updateUser(user);
	}




	@Override
	public UserBean queryEmpById(String cuserid) {
		
		return userDao.queryEmpById(cuserid);
	}




	@Override
	public List<UserBean> queryAllUser(UserBean user) {
		
		return userDao.queryAllUser(user);
	}

}
