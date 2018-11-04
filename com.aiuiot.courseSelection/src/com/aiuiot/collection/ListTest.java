package com.aiuiot.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 被选课程类
 * @author aiuiot
 *
 */
public class ListTest {
	/**
	 * 用于存放被选课程的List
	 */
	public List courseToSelect;
	
	//构造方法，并初始化courseToSelect属性
	public ListTest() {
		this.courseToSelect = new ArrayList();
	}
	
	/**
	 * 用于往courseToSelect中添加课程
	 */
	public void testAdd(){
		//创建一个课程对象，并通过调用add()方法，添加到被选课程List中
		Course cr1 = new Course("1", "《数据结构》");
		courseToSelect.add(cr1);
		
		//打印输出，提示打印课程，通过get()方法将元素取出来
		Course temp  = (Course) courseToSelect.get(0);
		System.out.println("添加了课程:"+temp.id+":"+temp.name);	
		
		Course cr2 = new Course("2", "《Java编程思想》");
		courseToSelect.add(0, cr2);
		Course temp2 = (Course)courseToSelect.get(0);
		System.out.println("添加了课程:"+temp2.id+":"+temp2.name);
		
		courseToSelect.add(cr1);
		Course temp0 = (Course)courseToSelect.get(2);
		System.out.println("添加了课程:"+temp0.id+":"+temp0.name);
		
		//以下方法1会抛出数组下标越界异常
//		Course cr3 = new Course("3", "《从你的全世界路过》");
//		courseToSelect.add(,cr3);
		
		Course[] course = {new Course("3", "《离散数学》"),new Course("4", "《汇编语言》")};
		courseToSelect.addAll(Arrays.asList(course));
		Course temp3 = (Course)courseToSelect.get(3);
		Course temp4 = (Course)courseToSelect.get(4);
		System.out.println("添加了两门课程:"+temp3.id+":"+temp3.name+";"+temp4.id+":"+temp4.name);

		Course[] course2 = {new Course("5", "《史记》"),new Course("6", "《资治通鉴》")};
		courseToSelect.addAll(2, Arrays.asList(course2));
		Course temp5 = (Course)courseToSelect.get(2);
		Course temp6 = (Course)courseToSelect.get(3);
		System.out.println("添加了两门课程:"+temp5.id+":"+temp5.name+";"+temp6.id+":"+temp6.name);
		
	}
	/**
	 * 取得List的元素的方法，方式一：通过for循环遍历
	 */
	public void testGet() {
		int size = courseToSelect.size();
		System.out.println("有如下课程待选：");
		for(int i = 0;i < size;i++) {
			Course cr= (Course)courseToSelect.get(i);
			System.out.println("课程："+cr.id+"："+cr.name);
		}
	}
	/**
	 * 方式二：通过迭代器遍历List
	 * @param args
	 */
	public void testIterator() {
		//通过集合的迭代器（iteartor）方法，取得迭代器的实例
		Iterator it = courseToSelect.iterator();
		System.out.println("有如下课程待选：（迭代器）");
		while(it.hasNext()) {
			Course cr = (Course)it.next();
			System.out.println("课程："+cr.id+"："+cr.name);
		}
	}
	
	/**
	 * 方式二：迭代器的第二种写法
	 * 通过for each方法访问集合元素
	 * @param args
	 */
	public void testForEach() {
		System.out.println("有如下课程待选：（迭代器 for each）");
		for(Object obj:courseToSelect) {
			Course cr = (Course)obj;
			System.out.println("课程："+cr.id+"："+cr.name);
		}
	}
	
	/**
	 * 修改List中的元素
	 * @param args
	 */
	public void testModify() {
		courseToSelect.set(4, new Course("7", "《毛概》"));
	}
	
	/**
	 * 删除List中元素
	 * @param args
	 */
	public void testRemove() {
//		Course cr = (Course)courseToSelect.get(4);
//		System.out.println("我是课程："+cr.id+":"+cr.name+"我即将被删除");
//		System.out.println("即将删除4位置伤的课程");
//		courseToSelect.remove(4);
		Course[] course = {(Course) courseToSelect.get(4),(Course) courseToSelect.get(5)};
		courseToSelect.removeAll(Arrays.asList(course));
		System.out.println("成功删除课程！");
		testForEach();
	}
	
	public static void main(String[] args) {
		ListTest lt = new ListTest();
		lt.testAdd();
		lt.testGet();
		lt.testIterator();
		lt.testForEach();
		lt.testModify();
		lt.testForEach();
		lt.testRemove();
	}

}
