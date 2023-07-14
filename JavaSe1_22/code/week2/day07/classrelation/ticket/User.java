package org.example.week2.day07.classrelation.ticket;

//用户类
public class User {
    private String name;
    private String sex;
    //	private Ticket ticket; // 一个用户一次只能买一张票  关联关系
    private Ticket[] tickets;   //一个用户一次可以购买多张车票   一对多   

    public User() {
    }

    //有两个参数的构造
    public User(String name, String sex) {
        super();
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    //以下是一对一的方法
//	public Ticket getTicket() {
//		return ticket;
//	}
    //给用户设置票的信息---- 购买票
    //参数：购买票的信息    把传递过来要购买的票的信息 赋值给当前的成员变量
//	public void buyTicket(Ticket ticket) {
//		//只能购买设置开发的票
//		if(ticket.isState() == true) {   
//		   this.ticket = ticket;  //把传递过来要购买的票的信息 赋值给当前的成员变量
//		}
//	}

    //显示购买信息   购票成功的信息
//	public void viewInfo() {
//		if(ticket == null) {
//			System.out.println("无法购买此票，票未开放");
//		}else {
//			System.out.println("姓名："+name + " \t 性别"+sex +"\t 车次："+ticket.getId()+""
//					+ "\t 车票价格"+ticket.getPrice());
//		}
//	}

    //以下是一对多的测试
    public Ticket[] getTickets() {
        return tickets;
    }

    //购买多张车票  最多购买两张
    public void buyTicket(Ticket[] tickets) {
        Ticket[] t = new Ticket[2];   //筛选购买的车票
        //遍历要购买的车票
        for (int i = 0; i < tickets.length; i++) {
            Ticket ticket = tickets[i];  //当前车票
            if (ticket.isState() == true) {  //当前车票是否可以购买
                t[i] = ticket;  //筛选通过，放在t的数组中
            }
        }
        this.tickets = t;  //筛选购买的车票的数组 赋值给成员变量
    }

    // 显示购买信息 购票成功的信息
    public void viewInfo() {
        if (tickets != null) { // 数组不为空的情况下
            for (int i = 0; i < tickets.length; i++) { // 遍历数组
                Ticket ticket = tickets[i]; // 获取当前的车票信息
                if (ticket != null) { // 判断是否为空 不为空---此张车票购买成功
                    System.out.println("姓名：" + name + " \t 性别" + sex + "\t 车次：" + ticket.getId() + "" + "\t 车票价格"
                            + ticket.getPrice());
                } else { // 为空---当前车票未开放
                    System.out.println("无法购买此票，票未开放");
                }
            }
        }
    }
}
