package com.fh.service.dept;

import java.util.List;
import java.util.Map;

import com.fh.bean.dept.DeptBean;
import com.fh.bean.user.UserBean;

public interface IDeptService {

	List<Map<String, Object>> queryDeptZtree();

	int addDept(List<DeptBean> deptList);

	int deleteDept(String[] ids);

	int updateDept(DeptBean dept);

	List<UserBean> querydept();

}
