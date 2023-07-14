package org.example.week3.day19;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableTest {
	public static void main(String[] args) throws Exception {
		example1();
		example2();
	}

	/**
	 * 把对象序列化写入硬盘方式，在反序列化出来
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static  void example1() throws IOException, ClassNotFoundException {
		// 对象的序列化
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\person.obj"));
		Person person = new Person("Tom", 40, "China");
		oos.writeObject(person);
		oos.close();
		// 对象的反序列化
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\person.obj"));
		Person person1 = (Person) ois.readObject();
		System.out.println(person1);
		System.out.println(person);
		System.out.println(person == person1);
	}
	/**
	 * 把对象序列化写入数组方式，在反序列化出来
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void example2() throws IOException, ClassNotFoundException {
		// 对象的序列化
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		Person person = new Person("Jerry", 30, "Beijing");
		oos.writeObject(person);
		byte[] buffer = baos.toByteArray();
		oos.close();
		baos.close();
		// 对象的反序列化
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(
				buffer));
		Person person1 = (Person) ois.readObject();
		System.out.println("反序列化="+person1);
		System.out.println("序列化="+person);
		System.out.println(person == person1);
	}

}
