package icsse2018.dao;

import org.springframework.data.repository.CrudRepository;
import icsse2018.model.User;

public interface UserRepository extends CrudRepository<User,Integer>{
	User findByUsernameAndPassword(String username, String password);
}
