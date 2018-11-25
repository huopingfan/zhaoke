package com.fh.controller.zw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fh.bean.user.UserBean;
import com.fh.service.zw.IZwService;

@Controller
@RequestMapping("ZwController")
public class ZwController {
	
	
	@Autowired
	private IZwService zwService;
	
	@RequestMapping("queryzw")
	@ResponseBody
    public List queryzw() {
    	    List<UserBean> list = zwService.queryzw();
        return list;
    }
	
	
	
	
}
