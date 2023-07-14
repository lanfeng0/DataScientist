package org.example.week2.day09.petdemo;


//主人类
public class Master {
	//给宠物看病    引用数据类型是方法的参数   对象 是父类的类型
   public void cure(Pet pet) {  //对外表现一种形态(父类宠物)，内在有多种具体实现(传的Dog的对象，pet = dog)
	   if(pet.getHealth()<60) {  //如果此条狗狗的健康值小于60
	       pet.toHospital();   //去看病 
	   }
   }
   
   //娱乐
   public void play(Pet pet) {   //pet 多态参数  虽然是父类类型Pet ，实际传的是子类对象（Dog、Penguin）
	   //instanceof pets是否属于Dog类型
	   if(pet instanceof Dog) {
		//调用子类特有的方法
		   Dog dog = (Dog) pet;//向下造型   可以调用子类特有的方法
		   dog.catchingFlyDics();  
	  }
	  if(pet instanceof Penguin) {
	   Penguin penguin = (Penguin)pet;//向下造型   可以调用子类特有的方法
	   penguin.swimming();
	  }
   }
   
   //喂食
   public void feed(Pet pet) {
//	   pet.eat();   // 所有子类重写父类eat方法的时候，没有问题，如果没重写  就报错
       if(pet instanceof Dog) {
    	   Dog dog = (Dog)pet;  //向下造型，才能调用子类特有的方法  否则报错
    	   dog.eat();
       }
       
       if(pet instanceof Penguin) {
    	   Penguin penguin = (Penguin)pet;
    	   penguin.eat();  
       }
   
   }
   
   
}
