package org.example.week4.day22.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//反射案例
public class ReflectTest {

    public static void main(String[] args) throws Exception {
        // classTest01(); // Class类的测试
        // classTest02(); //
        // Class类案例--使用三种方式获得java.lang.String类的Class实例，并打印输出String类的所有方法名字
        // constructor01(); // Constructor类---案例
        // constructor02(); // Constructor类测试方法
        // method01(); // Method类测试
        // method02();// Method类测试
        // field01(); // Field类测试
    }

    // 使用三种方式获得java.lang.String类的Class实例，并打印输出String类的所有方法名字
    private static void classTest02() {
        String s = "hello";
        // 使用对象名获得Class实例
        Class clazz1 = s.getClass();
        // 使用类名获得Class实例，类名必须是常量
        Class clazz2 = String.class;
        try {
            // 使用类名获得Class实例，类名可以是变量
            Class clazz3 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Method[] methods = clazz1.getMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }

    }

    // Class类的使用
    private static void classTest01() throws ClassNotFoundException {

        // 方式一：通过对象名.getClass()获取Class类
        // String str = "zhansgan";
        // Class c1 = str.getClass(); //获取的是String类的Class对象
        Person p = new Person();
        Class c1 = p.getClass(); // 获取Person类的Class对象

        // 方式二：通过对象名.getSuperClass()方法获得Class类----获取父类的Class对象
        Person p1 = new Person();
        Class c2 = p1.getClass(); // 获取Person类的Class对象
        Class c22 = c2.getSuperclass(); // 获取Person类的父类的Class对象

        // 方式三：通过Class.forName("") 获取Class对象
        // Class c3 = Class.forName("java.lang.String"); //获取的是String类的Class对象
        Class c3 = Class.forName("com.icss.javasechapter.reflect.Person"); // 获取的是Person类的Class对象

        // 方式四：通过类名.class来获取Class对象
        // Class c4 = String.class;
        // Class c4 = Person.class;
        Class c4 = int.class;

        // 获取类所有的公有属性
        // Field[] fields = c4.getFields();
        // for (Field field : fields) {
        // System.out.println(field);
        // }

        // 获取类的所有属性
        // Field[] fields = c4.getDeclaredFields();
        // for (Field field : fields) {
        // System.out.println(field);
        // }

        // 获取类中所有的公有方法
        // Method[] m = c4.getMethods();
        // for (Method method : m) {
        // System.out.println(method);
        // }

        // 获取类中所有的公有的构造方法
        // Constructor[] constructors = c4.getConstructors();
        // for (Constructor constructor : constructors) {
        // System.out.println(constructor);
        // }

    }

    // 测试属性方法
    private static void field01() throws Exception {
        // 1.获取Class类对象
        Class c = Person.class;

        // 2.通过Class对象获得无参的构造方法
        Constructor constructor = c.getConstructor(null);
        // 3.通过无参的构造方法对象来创建Person对象
        Person p = (Person) constructor.newInstance(null);

        // 4.通过Class类对象获取所有属性
        // 获取的是被public修饰的属性
        Field[] fields1 = c.getFields();
        for (Field field : fields1) {
            // 获取属性名字
            System.out.println("---------------" + field.getName());
        }
        // 获取所有的属性，包括私有成员变量
        Field[] fields2 = c.getDeclaredFields();
        for (Field field : fields2) {
            // 获取属性名字
            System.out.println("********************" + field.getName());
            if (field.getType() == int.class) {
                // field.set(p, 12);
                field.setInt(p, 12); // 给int类型的属性赋值
            }
            if (field.getType() == String.class) {
                field.set(p, "aaa"); // 给属性赋值
            }

            System.out.println(field.get(p)); // 获取属性的值
        }

        // 通过制定的Field名字，返回一个Field实例
        Field f1 = c.getField("publicStr");
        System.out.println(f1.getName());
        System.out.println(p);

    }

    // 测试方法
    private static void method02() throws Exception {
        // 1.获取Class类对象
        Class c = Class.forName("com.icss.javaseday23.test.Person");
        // 2.通过Class对象获得无参的构造方法
        Constructor constructor = c.getConstructor(null);
        // 3.通过无参的构造方法对象来创建Person对象
        Person p = (Person) constructor.newInstance(null);
        // 4.获取所有方法
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println("方法的名字:" + method.getName());
            System.out.println("方法的参数的类型有：");
            Class[] paramTypes = method.getParameterTypes(); // 获取所有方法的参数的类型
            for (Class paramtype : paramTypes) {
                System.out.println(paramtype);
            }

            Class returnType = method.getReturnType(); // 获取方法返回值
            System.out.println("方法的返回值类型:" + returnType);

        }

        // 根据指定方法名，参数类型，返回一个Method实例。
        Method m = c.getMethod("setName", String.class);
        m.invoke(p, "alice");
        System.out.println(p);
    }

    // 调用set方法为Person对象赋值
    private static void method01() throws Exception {
        // 1.获取Class类对象
        Class c = Class.forName("com.icss.javaseday23.test.Person");
        // 2.通过Class对象获得无参的构造方法
        Constructor constructor = c.getConstructor(null);
        // 3.通过无参的构造方法对象来创建Person对象
        Person p = (Person) constructor.newInstance(null);
        // 4.通过Class对象获得所有方法的对象
        Method[] methods = c.getMethods();
        // 5.遍历方法的数组
        for (Method method : methods) {
            // 6.判断方法名是以setName开头的
            if (method.getName().startsWith("setName")) {
                // 7.通当前方法的对象来调用方法赋值。
                method.invoke(p, "alice");
            }

            // 8.判断方法名是以setAge开头的
            if (method.getName().startsWith("setAge")) {
                // 9.通当前方法的对象来调用方法赋值。
                method.invoke(p, 12);
            }
        }
        // 10.打印并输出person对象
        System.out.println(p);
    }

    // 调用构造方法 Person(String,Integer)
    private static void constructor02()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // 1.获取Class类对象
        Class<Person> c = Person.class;
        // 2.获取所有构造方法 实例
        Constructor[] constructors = c.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("构造方法的名字:" + constructor.getName());
            // 获取每个构造方法的所有参数类型
            System.out.println("构造方法的参数有:");
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class paramC : parameterTypes) {
                System.out.println(paramC);
            }
            // 获取每个构造方法的参数个数
            int len = parameterTypes.length;
            System.out.println("构造方法参数的个数是:" + len);

            // 判断构造方法的参数是否是2个
            if (len == 2) {
                // 3. 通过指定参数类型，返回构造方法实例，因为当前已经拿到了需要构造方法的对象，所以此步骤就不需要写了
                // 4.创建实例
                Person p = (Person) constructor.newInstance("zhangsan", 18);
                System.out.println(p);
                break;
            }
        }

    }

    // 创建类Person.java，该类中有构造方法 Person(String)
    // 使用Class类的实例获得Person类的构造方法实例
    // 使用构造方法的实例创建Person对象
    private static void constructor01() throws Exception {
        // (1)获取Class类对象 --- 类名.class获取其它方式
        Class<Person> c = Person.class;
        // (2)获取类的构造方法实例 ---getConstructor 该类中有构造方法 Person(String)
        Constructor constructor = c.getConstructor(String.class);
        // (3)创建实例 --- newInstance
        Person p = (Person) constructor.newInstance("gx");
        // Person p = new Person("gx"); = （1）（2）(3)等于创建对象

        // (4)打印输出
        System.out.println(p);
    }
}
