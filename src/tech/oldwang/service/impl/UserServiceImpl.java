package tech.oldwang.service.impl;

import java.util.List;

import tech.oldwang.domain.User;
import tech.oldwang.service.UserService;

public class UserServiceImpl implements UserService{

	public User login(List<User> listUser, User user) {
		// TODO Auto-generated method stub
		for(User u : listUser) {
			if(user.getUserName().equals(u.getUserName()) && user.getPassword().equals(u.getPassword())) {
				return u;
			}
		}
		return null;
	}

}
