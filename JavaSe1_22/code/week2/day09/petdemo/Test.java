package org.example.week2.day09.petdemo;

public class Test {
    public static void main(String[] args) {
//	  Dog dog1 = new Dog("小七", 90, 90, "金毛");
//	  Dog dog2 = new Dog("大黄", 80, 80, "拉布拉多");

//	  dog1.printInfo();
//	  dog2.printInfo();
//	  Penguin penguin = new Penguin("q仔",50,80,"男");
//	  
//	  Master master = new Master();  //创建主人类
//	  master.cure(dog1);  //给小七看病
//	  master.cure(penguin);//给q仔看病
//	  
//	  dog1.printInfo();
//	  penguin.printInfo();

        //思考  如果又需要给XXX看病  怎么办？？

//	  Pet pet = new Dog();  //对象的向上造型(父类引用指向子类对象)  编译期类型和运行期类型不同
//	  pet.toHospital();  //编译看左  运行看右
        //就调用子类方法
//	  Dog dog =(Dog)pet;    //向下造型
//	  dog.getStrain();

//	  System.out.println(pet.i);

        Master master = new Master();  //创建主人类
        Pet dog1 = new Dog("小七", 90, 90, "金毛");
        Pet penguin = new Penguin("q仔", 50, 80, "男");
//	  master.play(dog1);
//	  master.play(penguin);

//	  dog1.printInfo();
//	  penguin.printInfo();

//	  master.feed(dog1);
//	  master.feed(penguin);

//	  Pet pet1 = new Pet();   //无法实例化抽象类对象  但是它可以被继承  她有构造方法


        dog1.printInfo();
        penguin.printInfo();
    }
}
