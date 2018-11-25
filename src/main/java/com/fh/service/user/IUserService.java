package com.fh.service.user;

import java.util.List;

import com.fh.bean.user.UserBean;
import com.fh.util.PageBean;

public interface IUserService {

	List<UserBean> queryEmpPageList(UserBean user, PageBean<UserBean> page);

	int deleteUser(String cuserid);

	int addUser(UserBean user);

	int updateUser(UserBean user);

	UserBean queryEmpById(String cuserid);

	List<UserBean> queryAllUser(UserBean user);

}
