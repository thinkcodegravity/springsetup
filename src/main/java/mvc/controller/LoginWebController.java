package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginWebController {
	
	
	// http://localhost/login
	@RequestMapping("/login")
	public String auth(@RequestParam String userid,@RequestParam String password) {
		if(userid.equals("john") && password.equals("john123"))
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
