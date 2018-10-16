package cn.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.pojo.User;
import cn.tedu.service.UserService;

@RestController	//RESTFul形式+json返回
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/find")
	public List<User> find() {
		return userService.find();
	}
	
	@RequestMapping("/get/{id}")
	public User get(@PathVariable Integer id){
		return userService.get(id);
	}
	
	//注意:如果对象接收RESTFul参数时,不用@PathVariable
	@RequestMapping("/insert/{name}/{birthday}/{address}")
	public String insert(User user){
		try{
			userService.insert(user);
			return "success";
		}catch(Exception e){
			return "insert error";
		}
	}
	
	@RequestMapping("/update/{name}/{birthday}/{address}/{id}")
	public String update(User user){
		try{
			userService.update(user);
			return "success";
		}catch(Exception e){
			return "update error";
		}
	}    
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		try{
			userService.delete(id);
			return "success";
		}catch(Exception e){
			return "delete error";
		}
	}
}
