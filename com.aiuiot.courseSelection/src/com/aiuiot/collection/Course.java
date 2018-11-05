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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Course))
			return false;
		Course other = (Course) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
