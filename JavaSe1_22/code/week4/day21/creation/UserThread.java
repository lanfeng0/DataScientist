package org.example.week4.day21.creation;

import java.util.List;
import java.util.concurrent.Callable;

public class UserThread implements Callable {
	private UserService userService;

	public UserThread(UserService userService) {
		this.userService = userService;
	}

	@Override
	public List<User> call() throws Exception {
		//模拟具体业务逻辑
		List<User> list = userService.selectList();
		System.out.println("线程结束");
		return list;
	}

}
