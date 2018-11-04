package com.aiuiot.collection;

import java.util.HashSet;
import java.util.Set;
/**
 * 学生类
 * @author aiuiot
 *
 */
public class Student {
	public String id;
	public String name;
	// 把课程信息存放在Set类型的属性里
	public Set<Course> courses;
	
	public Student(String id,String name) {
		this.id = id;
		this.name = name;
		//给courses属性初始化，通过new HashSet()初始化
		this.courses = new HashSet<Course>();
	}
}
