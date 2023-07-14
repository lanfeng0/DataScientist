package org.example.week2.day07.polymorphic.peysystem;

//主人类
public class Master {
	//给宠物看病  旧方案
	// public void cure(Dog dog) {
	// if (dog.getHealth() < 50) {
	// dog.setHealth(60);
	// System.out.println("打针、吃药");
	// }
	// }
	//
	// public void cure(Penguin penguin) {
	// if (penguin.getHealth() < 50)
	// penguin.setHealth(70);
	// System.out.println("吃药、疗养");
	// }

	// 给宠物看病 引用数据类型是方法的参数 对象 是父类的类型
	public void cure(Pet pet) { // 对外表现一种形态(父类宠物)，内在有多种具体实现(传的Dog的对象，pet = dog)
		if (pet.getHealth() < 60) { // 如果此条狗狗的健康值小于60
			pet.toHospital(); // 去看病
		}
	}

	// 娱乐
	public void play(Pet pet) { // pet 多态参数 虽然是父类类型Pet ，实际传的是子类对象（Dog、Penguin）
		// instanceof pets是否属于Dog类型
		if (pet instanceof Dog) {
			// 调用子类特有的方法
			Dog dog = (Dog) pet;// 向下造型 可以调用子类特有的方法
			dog.catchingFlyDics();
		}
		if (pet instanceof Penguin) {
			Penguin penguin = (Penguin) pet;// 向下造型 可以调用子类特有的方法
			penguin.swimming();
		}
	}
}
