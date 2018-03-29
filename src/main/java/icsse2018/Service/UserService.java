package icsse2018.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import icsse2018.dao.UserRepository;
import icsse2018.model.User;

@Service
@Transactional
public class UserService {
	private final UserRepository userRepository;
	public UserService (UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	public User findUser(String username,String password)
	{
		if(userRepository.findByUsernameAndPassword(username, password) != null)
		{
			return userRepository.findByUsernameAndPassword(username, password);
		}
		return null;
	}
}
