package 练习;

public class 数的位数 {

	public static void main(String[] args) {
		int num = 999;
		int count = 0;
		if(num>=0 && num<=999999999){
			while(num !=0){
				num = num /10;
				count ++;
			}
			System.out.println("位数为"+count);
		}else{
			System.out.println("输入错误");
		}

	}

}
