package com.fh.service.dept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.bean.dept.DeptBean;
import com.fh.bean.user.UserBean;
import com.fh.dao.dept.IDeptDao;



@Service("deptService")
public class DeptServiceImpl implements IDeptService{

	@Autowired
	private IDeptDao deptDao;
	
	
	
	@Override
	public List<Map<String, Object>> queryDeptZtree() {
		List<DeptBean> list = deptDao.queryDeptZtree();
		return getMenuTree(list,"0");
	}
	
	private static List<Map<String, Object>> getMenuTree(List<DeptBean> list, String pid){
		List<Map<String, Object>> menulist = new ArrayList<Map<String, Object>>();
		for (DeptBean dept : list) {
			Map<String,Object> map = null;
			if(pid.equals(dept.getCpid())){
				map = new HashMap<String,Object>();
				map.put("id", dept.getCdeptid());
				map.put("name", dept.getCdeptname());
				map.put("pid", dept.getCpid());
				map.put("children", getMenuTree(list,dept.getCdeptid()));
			}
			if(map!=null){
				menulist.add(map);
			}
		}
		return menulist;
	}

	@Override
	public int addDept(List<DeptBean> deptList) {
		
		return deptDao.addDept(deptList);
	}

	@Override
	public int deleteDept(String[] ids) {
		
		return deptDao.deleteDept(ids);
	}

	@Override
	public int updateDept(DeptBean dept) {
		
		return deptDao.updateDept(dept);
	}

	@Override
	public List<UserBean> querydept() {
		
		return deptDao.querydept();
	}

}
