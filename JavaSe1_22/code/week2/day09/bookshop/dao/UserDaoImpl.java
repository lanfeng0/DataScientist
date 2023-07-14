package org.example.week2.day09.bookshop.dao;

import org.example.week2.day09.bookshop.entity.UserEntity;

//数据层接口暂时不写，先写一个实现类
//写登入和修改密码的方法  模拟数据库的增删改查
//技术：方法返回值是引用数据类型+ 方法的参数是引用数据类型+流程控制+数组+运算符+继承
public class UserDaoImpl extends BaseData {
    /*
     * 登入方法
     * 返回值？ UserEntity
     * 参数？usernName  pwd   --控制台输入传参
     * 做什么？ 遍历 ----寻找和输入的密码和输入的一致数组元素
     *         找到---把数据存储到UserEnity对象中--成功
     */

    public UserEntity login(String userName, String pwd) {
        // 声明一个实体类对象UserEnity ,遍历数组 找到--把所有数据赋值到user对象中 没找到---null
        UserEntity user = null;
        // 继承 可以调用父类非私有的成员 ，调用父类返回值所有用户的数组 users--所有的用户信息的数组对象
        UserEntity[] users = getUsers();
        // 遍历数组
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {  //判断当前元素是否为空
                // 寻找和输入的密码和输入的一致数组元素 一致 ，把找到的数据，存储到user对象中
                if (userName.equals(users[i].getUserName()) && pwd.equals(users[i].getPwd())) {
                    user = new UserEntity(users[i].getUserId(), users[i].getUserName(), users[i].getPwd());
                    break;
                }
            }
        }
        return user;
    }


    /*
     * 修改密码方法
     * 返回值：boolean
     * 参数： UserEnity(当前登入成功的用户)   newPwd1,  newPwd2
     * 做什么？ 先验证密码是否一致  遍历数组  --- 找到登入的账户  --- 修改密码
     *
     */

    public boolean updatePwd(UserEntity user, String newPwd1, String newPwd2) {
        boolean result = false;   //修改成功或者失败的标识
        //判断两次密码是否一致
        if (newPwd1.equals(newPwd2)) {
            // 继承 可以调用父类非私有的成员 ，调用父类返回值所有用户的数组 users--所有的用户信息的数组对象
            UserEntity[] users = getUsers();
//			  遍历数据
            for (int i = 0; i < users.length; i++) {
                //找到当前用户，user.getUserId()--登入成功的用户的userid
                if (user.getUserId() == users[i].getUserId()) {
                    users[i].setPwd(newPwd1);  //修改密码
                    result = true; //标识为rtrue
                    break;
                }
            }
        }
        return result;
    }
}
