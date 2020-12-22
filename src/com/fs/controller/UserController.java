package com.fs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fs.entity.User;
import com.fs.service.UserService;
import com.fs.util.GlobalVariables;

@Controller("usercontroller")
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping("/reg")
	public String userReg(@RequestParam("op1") String phone, @RequestParam("op2") String password,
			@RequestParam("tname") String tname, @RequestParam("sex") Integer sex) {
		// 组装数据 User 然后将 user 交给 管家
		User u = new User();
		u.setPcode(password);
		u.setPhone(phone);
		u.setSex(sex);
		u.setUname(tname);

		if (this.service.addUser(u)) {
			System.out.println("regist success");
			return "redirect:login.html";
		} else {
			System.out.println("regist failed");
			return "redirect:error.html";
		}
	}

	@RequestMapping("/lgi")
	public String login(@RequestParam("op1") String phone, @RequestParam("op2") String password, HttpSession session) {

		User u = this.service.findByPhone(phone, password);

		if (u == null) {
			System.out.println("没能找到这个用户");
			return "redirect:error.html";
		} else {
			System.out.println("已经找到并且是合法的");

			session.setAttribute(GlobalVariables.USERINFO, u);
			

			return "redirect:index2.html";
		}
	}

	@RequestMapping("/getuser")
	@ResponseBody
	public User getUserinfo(HttpSession session) {
		User u = (User) session.getAttribute(GlobalVariables.USERINFO);
		return u == null ? new User() : u;
	}
/*退出登录*/
	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:login.html";
	}
}
