package tech.oldwang.service;

import java.util.List;

import tech.oldwang.domain.User;

public interface UserService {
	public User login(List<User> listUser, User user);
}
