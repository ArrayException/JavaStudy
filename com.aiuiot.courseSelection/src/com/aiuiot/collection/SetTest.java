package com.aiuiot.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class SetTest {
	
	public List<Course> coursesToSelect;
	
	public SetTest() {
		coursesToSelect = new ArrayList<Course>();
	}
	
	public void testAdd(){
		//创建一个课程对象，并通过调用add()方法，添加到被选课程List中
		Course cr1 = new Course("1", "《数据结构》");
		coursesToSelect.add(cr1);
		
		Course cr2 = new Course("2", "《Java编程思想》");
		coursesToSelect.add(cr2);
		
		Course[] course = {new Course("3", "《离散数学》"),new Course("4", "《汇编语言》")};
		coursesToSelect.addAll(Arrays.asList(course));
		
	}
	
	public void testForEach() {
		System.out.println("有如下课程待选:");
		for(Object obj:coursesToSelect) {
			Course cr = (Course)obj;
			System.out.println("课程："+cr.id+"："+cr.name);
		}
	}
	
	public void testForEachForSet(Student stu) {
		//打印输出学生所选课程
		System.out.println("共选择了"+stu.courses.size()+"门课程");
		for (Course cr : stu.courses) {
			System.out.println("选择了课程"+cr.id+" "+cr.name);
		}
		
	}
	
	public static void main(String[] args) {
		SetTest st = new SetTest();
		st.testAdd();
		st.testForEach();
		
		//创建一个学生对象
		Student stu = new Student("1", "小王");
		System.out.println("欢迎学生"+stu.name+"选课");
		
		//创建一个scanner对象，用于接收键盘输入的课程ID
		Scanner input = new Scanner(System.in);
		
		for(int i = 0;i < 3; i++) {
			System.out.println("请输入课程ID：");
			String courseId = input.next();
			for (Course cr : st.coursesToSelect) {
				if(cr.id.equals(courseId)) {
					stu.courses.add(cr);
					/**
					 * set中，添加某个对象，无论添加多少次，
					 * 最终只会保留一个该对象（的引用）
					 * 并且，保留的是第一次添加的那个
					 */
					stu.courses.add(null);
					//stu.courses.add(cr);
				}
			}
		}
	
		st.testForEachForSet(stu);
	}

}
