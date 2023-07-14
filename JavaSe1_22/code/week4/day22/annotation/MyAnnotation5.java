package org.example.week4.day22.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//添加@Target，指定修饰目标为TYPE，即类、接口、枚举等声明可用；
@Target(value=ElementType.TYPE)
//指定生命周期为RUNTIME
//表示该注解被JVM保留,所以能在运行时被JVM或其他使用反射机制的代码所读取和使用.
@Retention(value=RetentionPolicy.RUNTIME)
//声明注解类型MyAnnotation5.java
public @interface MyAnnotation5 {
	public String urlpattern() ;
	public boolean onload() default false;
}
