package com.fh.dao.dept;

import java.util.List;

import com.fh.bean.dept.DeptBean;
import com.fh.bean.user.UserBean;

public interface IDeptDao {

	List<DeptBean> queryDeptZtree();

	int addDept(List<DeptBean> deptList);

	int deleteDept(String[] ids);

	int updateDept(DeptBean dept);

	List<UserBean> querydept();

}
