package repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
@Repository
public interface UserRepository 
extends JpaRepository<UsersEntity, String> {
		
	public List<UsersEntity> findByUidAndPwd(String u,String p)	;	
	
}
