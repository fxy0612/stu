package cn.tedu.service;

import java.util.List;

import cn.tedu.pojo.User;

public interface UserService {

	public List<User> find();
	public User get(Integer id);
	public void insert(User user);
	public void update(User user);
	public void delete(Integer id);
}
