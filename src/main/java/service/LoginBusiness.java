package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.UserRepository;
import repository.UsersEntity;

// SENSITIVE
// COPYRIGHT
// CONFIEDENTAL CODE
@Service
public class LoginBusiness {
	
	@Autowired
	UserRepository ur;

	public boolean loginCheck(String userid, String pwd) {
		System.out.println("i am inside business");
		List<UsersEntity> records=ur.findByUidAndPwd(userid, pwd);
		if(records.size() > 0)
			return true; // http://localhost/success
		else
			return false;
	}
	

	public boolean register(String userid, String pwd) {
		UsersEntity ue=new UsersEntity();
		ue.setUid(userid);
		ue.setPwd(pwd);
		ur.save(ue);
		return true;
	}
	public boolean changePwd(String userid, String pwd) {
		UsersEntity ue=new UsersEntity();
		ue.setUid(userid);
		ue.setPwd(pwd);
		ur.save(ue);
		return true;
	}
	public boolean del(String userid) {
		UsersEntity ue=new UsersEntity();
		ue.setUid(userid);
		ur.delete(ue);
		return true;
	}
}
