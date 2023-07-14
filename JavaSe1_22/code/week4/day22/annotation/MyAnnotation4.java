package org.example.week4.day22.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target(value=ElementType.TYPE)
@Retention(value=RetentionPolicy.RUNTIME)

public @interface MyAnnotation4 {
	public String urlpattern();
	public boolean onload();
}
