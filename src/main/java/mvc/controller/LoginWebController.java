package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.LoginBusiness;

@Controller
public class LoginWebController {
	
	@Autowired
	LoginBusiness lb;
	
	// http://localhost/login
	@RequestMapping("/login")
	public String auth(@RequestParam String userid,@RequestParam String password) {
		System.out.println("i am inside controller");
		boolean res=lb.loginCheck(userid, password);
		if(res==true)
			return "forward:/good"; // http://localhost/success
		else
			return "forward:/bad";// http://localhost/failure
	}
	
	@RequestMapping("/registerController")
	public String reg(@RequestParam String userid,@RequestParam String password) {
		boolean res=lb.register(userid, password);
		if(res==true)
			return "forward:/good"; // http://localhost/success
		else
			return "forward:/bad";// http://localhost/failure
	}

	@RequestMapping("/updateController")
	public String changePwd(@RequestParam String userid,@RequestParam String password) {
		boolean res=lb.changePwd(userid, password);
		if(res==true)
			return "forward:/good"; // http://localhost/success
		else
			return "forward:/bad";// http://localhost/failure
	}
	
	@RequestMapping("/deleteController")
	public String unsubcsribe(@RequestParam String userid) {
		boolean res=lb.del(userid);
		if(res==true)
			return "forward:/good"; // http://localhost/success
		else
			return "forward:/bad";// http://localhost/failure
	}
	// http://localhost/success
	@RequestMapping("/good")
	public String welcome() {
		return "welcome";
	}	
	// http://localhost<prefix>welcome<suffix>
	// http://localhost/view/welcome.jsp
	
	//spring.mvc.view.prefix: /view/
	//spring.mvc.view.suffix: .jsp
	
	
	// http://localhost/failure
	@RequestMapping("/bad")
	public String error() {
		return "failure";
	}
	// http://localhost<prefix>welcome<suffix>
	// http://localhost/view/error.jsp
		


}
