package com.aiuiot.collection;
/**
 * 课程类
 * @author aiuiot
 *
 */
public class Course {
	public String id; 	//课程id属性
	public String name;	//课程name属性
	
	//为方便使用，添加含参数的构造器
	public Course(String id,String name) {
		this.id = id;
		this.name = name;
	}
	
	//添加无参的构造器
	public Course() {
		
	}

}
