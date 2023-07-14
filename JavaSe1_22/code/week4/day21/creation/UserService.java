package org.example.week4.day21.creation;

import java.util.ArrayList;
import java.util.List;

//用户服务类--测试创建线程方式三，实现callable接口
public class UserService {
	public List<User> selectList() {
		List<User> list = new ArrayList<>();
		User user = new User("tom", 20);
		list.add(user);
		return list;
	}
}
