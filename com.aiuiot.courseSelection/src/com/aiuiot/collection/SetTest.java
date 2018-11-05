package com.aiuiot.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class SetTest {
	
	public List<Course> coursesToSelect;
	private Scanner input;
	public Student stu;
	
	public SetTest() {
		coursesToSelect = new ArrayList<Course>();
		input = new Scanner(System.in);
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
	
	/**
	 * 测试List的contains方法
	 * @param args
	 */
	public void testListContains() {
		//取得备选课程序列的第0个元素
		Course course = coursesToSelect.get(0);
		//打印输出coursesToSelect是否包含course对象
		System.out.println("取得课程"+course.name);
		System.out.println("备选课程是否包含课程："+course.name+""+coursesToSelect.contains(course));
	
		//提示输入课程名称
		System.out.println("请输入课程名称：");
		String name = input.next();
		//创建一个新的课程对象，ID和名称，与course对象完全一样
		Course course2 = new Course();
		course2.name = name;
		System.out.println("新创建课程："+course2.name);
		System.out.println("备选课程中是否包含课程："+course2.name+","+coursesToSelect.contains(course2));
		//通过indexOf方法来取得某元素的索引位置
		if(coursesToSelect.contains(course2)) {
			System.out.println("课程："+course2.name+"的索引位置为："+coursesToSelect.indexOf(course2));
		}
	}
	
	//创建学生对象并且选课的方法
	public void createStudentAndSelectCours() {
		//创建一个学生对象
		stu = new Student("1", "小王");
		System.out.println("欢迎学生"+stu.name+"选课");
		
		//创建一个scanner对象，用于接收键盘输入的课程ID
		Scanner input = new Scanner(System.in);
		
		for(int i = 0;i < 3; i++) {
			System.out.println("请输入课程ID：");
			String courseId = input.next();
			for (Course cr : coursesToSelect) {
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
	}
	
	/**
	 * 测试Set的contains方法
	 * @param args
	 */
	public void testSetContains() {
		//提示输入课程名称
		System.out.println("请输入学生已选的课程名称：");
		String name = input.next();
		//创建一个新的对象，ID和名称，与course对象完全一样
		Course course2 = new Course();
		course2.name = name;
		System.out.println("新创建课程："+course2.name);
		System.out.println("备选课程中是否包含课程："+course2.name+","+stu.courses.contains(course2));
	}
	
	public static void main(String[] args) {
		SetTest st = new SetTest();
		st.testAdd();
		st.testListContains();
		st.testForEach();
		
//		st.createStudentAndSelectCours();
//		st.testSetContains();
		
	}

}
