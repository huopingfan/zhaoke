package com.fh.dao.user;

import java.util.List;
import java.util.Map;

import com.fh.bean.user.UserBean;

public interface IUserDao {

	UserBean queryUser(String cusername);

	void updateerrorCount(String cuserid);

	void updateUserLock(String cuserid);

	void updateUserMessage(String cuserid);

	Long querycount(UserBean user);

	List<UserBean> queryEmpPageList(Map<String, Object> map);

	int deleteUser(String cuserid);

	int addUser(UserBean user);

	int updateUser(UserBean user);

	UserBean queryEmpById(String cuserid);

	List<UserBean> queryAllUser(UserBean user);

}
