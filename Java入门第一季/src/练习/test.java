package 练习;

import java.util.Arrays;

/***
 * 编程练习:
 * 1.考试成绩已保存在数组 scores 中，
 * 	 数组元素依次为 89 , -23 , 64 , 91 , 119 , 52 , 73
 * 2.要求通过自定义方法来实现成绩排名并输出操作，将成绩数组作为参数传入
 * 	
 * 3. 要求判断成绩的有效性（ 0—100 ），如果成绩无效，则忽略此成绩
 * @author code
 *
 */
public class test {

	//main方法
	public static void main(String[] args) {
		//创建scores数组,保持成绩
		int[] scores = {89,-23,64,91,119,52,73};
		//创建对象
		test t1 = new test();
		//调用calcScore方法
		t1.calcScore(scores);
	}
	public int calcScore(int[] scores){
		int num = 0;//保存有效成绩数量
		Arrays.sort(scores);
		for(int i = scores.length-1;i>=0;i--){
			if(scores[i]<0 || scores[i]>100){
				continue;
			}
			num++;
			if(num > 3){
				break;
			}
			System.out.println(scores[i]);
		}
		
		return 0;
	}
	
	

}
