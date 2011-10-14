package org.karpukhin.springmvcdemo.controller;

import org.karpukhin.springmvcdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Karpukhin
 */
@Controller
public class UserController {

	@RequestMapping("/users")
	public ModelAndView userList() {
		List<User> users = new ArrayList<User>();
		users.add(new User("Vasya", "Pupkin", "test@test.ru"));
		users.add(new User("Eugeney", "Fedorov", "test@test.ru"));
		users.add(new User("Vanya", "Zaycev", "test@test.ru"));
		return new ModelAndView("users/list", "users", users);
	}
}
