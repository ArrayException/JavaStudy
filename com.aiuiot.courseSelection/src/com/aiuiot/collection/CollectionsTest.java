package com.aiuiot.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * 将要完成：
 * 1、通过collections.sort()方法，对integer泛型的list进行排序
 * 2、对string泛型的List进行排序
 * 3、对其他类型泛型的List进行排序，以Student为例
 * @author aiuiot
 *
 */
public class CollectionsTest {

	public static void main(String[] args) {
		CollectionsTest ct = new CollectionsTest();
//		ct.testSort1();
//		ct.testSort2();
//		ct.testSort3();
		ct.testSort4();

	}
	
	/**
	 *1、通过collections.sort()方法，对integer泛型的list进行排序
	 *创建一个
	 */
	public void testSort1() {
		List<Integer> integerList = new ArrayList<Integer>();
		//插入十个100以内的不重复的随机整数
		Random random = new Random();
		Integer k;
		for(int i = 0;i < 10;i++) {
			do {
			k = random.nextInt(100);
			}while(integerList.contains(k));
			integerList.add(k);
			System.out.println("成功添加整数:"+k);
		}
		System.out.println("------排序前------");
		for (Integer integer : integerList) {
			System.out.println("元素："+integer);
		}
		Collections.sort(integerList);
		System.out.println("------排序后------");
		for (Integer integer : integerList) {
			System.out.println("元素："+integer);
		}
	}
	
	/**
	 * 对String泛型的List进行排序
	 * 步骤：创建String泛型的List,添加三个乱序的String元素
	 * 调用sort方法，再次输出排序后的顺序
	 */
	public void testSort2() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("microsoft");
		stringList.add("google");
		stringList.add("lenovo");
		System.out.println("------排序前------");
		for (String string : stringList) {
			System.out.println("排序前："+string);
		}
		Collections.sort(stringList);
		System.out.println("------排序后------");
		for (String string : stringList) {
			System.out.println("排序后："+string);
		}
		
	}
	
	/**
	 * 对其他类型泛型的List进行排序，以Student为例
	 * 目前有误
	 */
	public void testSort3() {
		List<String> radomStringList = new ArrayList<String>();
		String str = "0123456789qwertyuiopasdfghjklzxcvbnm";
		Random ran = new Random();
		for(int i = 0;i<10;i++) {
			StringBuilder sb = new StringBuilder();
			do {
				int ss = ran.nextInt(10);
				for(int j = 0;j<ss;j++) {
					int sbint = ran.nextInt(62);
					sb.append(str.charAt(sbint));
				}
			}while(str.contains(sb));
			radomStringList.add(sb.toString());
		}
		System.out.println("---排序前---");
		for (String string : radomStringList) {
			System.out.println("元素："+string);
		}
		//使用Collections进行排序
		Collections.sort(radomStringList);
		System.out.println("---排序后---");
		for (String string : radomStringList) {
			System.out.println("元素："+string);
		}
	}
	
	public void testSort4() {
		List<Student> stuList = new ArrayList<Student>();
		Random ran = new Random();
		stuList.add(new Student(ran.nextInt(1000)+" ", "Mike"));
		stuList.add(new Student(ran.nextInt(1000)+" ", "Angela"));
		stuList.add(new Student(ran.nextInt(1000)+" ", "Lucy"));
		stuList.add(new Student(10000+" ", "Tom"));
		System.out.println("---排序前---");
		for (Student student : stuList) {
			System.out.println("姓名："+student.id+" "+student.name);
		}
	Collections.sort(stuList);
		System.out.println("---排序后---");
		for (Student student : stuList) {
			System.out.println("姓名："+student.id+" "+student.name);
		}
		Collections.sort(stuList,new StudentComparator());
		System.out.println("------按照姓名排序后------");
		for (Student student : stuList) {
			System.out.println("姓名："+student.id+" "+student.name);
		}
	}
	
}
