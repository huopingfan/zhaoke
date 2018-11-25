package com.fh.dao.zw;

import java.util.List;

import com.fh.bean.user.UserBean;

public interface IZwDao {

	List<UserBean> querytype();

	List<UserBean> queryzw();

}
