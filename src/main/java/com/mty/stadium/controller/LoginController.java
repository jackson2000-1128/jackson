package com.mty.stadium.controller;


import com.mty.stadium.model.Admin;
import com.mty.stadium.model.User;
import com.mty.stadium.service.AdminService;
import com.mty.stadium.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 系统操作控制器
 */
@Controller
public class LoginController {

	// 依赖注入
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;

	/**
	 * 去登录
	 */
	@GetMapping(value = "/login")
	public String gologin() {
		return "login";
	}

	/**
	 * 去登录
	 */
	@GetMapping(value = "/")
	public String toIndex() {
		return "redirect:/front/";
	}

	/**
	 * 进入工作台
	 */
	@RequestMapping(value = "/workdest")
	public String workdest() {
		return "workdest";
	}

	/**
	 * 进入首页
	 */
	@RequestMapping(value = "/index")
	public String index(HttpSession session) {
		return "index";
	}

	/**
	 * 进入个人中心
	 */
	@RequestMapping(value = "/profile")
	public String profile() {
		return "profile";
	}


	/**
	 * 登录
	 * 将提交数据(username,password)写入Admin对象
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public String login(String username, String password, String type, Model model, HttpSession session) {
		Map mp = new HashMap();
		if(username.equals("") || password.equals("")){
			return "202";
		}
		if(type.equals("01")){
			mp.put("username",username);
			mp.put("password",password);
			List<Admin> admins = adminService.queryFilter(mp);
			if(admins!=null && admins.size()==1){
				session.setAttribute("userInfo", admins.get(0));
				session.setAttribute("type", "01");
			}else{
				return "201";
			}
		}else{
			mp.put("username",username);
			mp.put("password",password);
			mp.put("type",type);
			List<User> users = userService.queryFilter(mp);
			if(users!=null && users.size()==1){
				session.setAttribute("userInfo", users.get(0));
				session.setAttribute("type", type);
				return "203";
			}else{
				return "201";
			}
		}
		return "200";
	}

	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/logout")
	public String loginOut(HttpSession session) {
		session.invalidate();
		return "logout";
	}

	/**
	 * 前往注册
	 */
	@GetMapping(value = "/register")
	public String register() {
		return "register";
	}



	/**
	 * 提交注册
	 */
	@PostMapping(value = "/register")
	@ResponseBody
	public String register(String username, String password,String type, String repassword) {
		if(username.equals("") || password.equals("") || repassword.equals("")){
			return "201";
		}
		if(!password.equals(repassword)){
			return "202";
		}
		List<User> all = userService.findAll();
		for(int i=0;i<all.size();i++){
			if(all.get(i).getUsername().equals(username)){
				return "204";
			}
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setType(type);
		Date date = new Date();
		user.setCreateTime(date);
		int num = userService.addByCondition(user);
		if(num > 0){
			return "200";
		}else {
			return "203";
		}
	}


	/**
	 * 判断是否是手机号
	 *
	 * @param mobile
	 * @return
	 */
	public static boolean isMobile(String mobile) {
		String regex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(mobile);
		return m.matches();
	}


}
