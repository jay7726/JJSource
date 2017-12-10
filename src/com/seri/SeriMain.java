package com.seri;

import java.util.Scanner;

public class SeriMain {

	public static void main(String[] args) {
		
		Seri ob = new Seri();
		Scanner sc = new Scanner(System.in);
		
		int n;
		while(true){
			
			do{
				System.out.print("1.입력 2.출력 3.종료: ");
				n = sc.nextInt();
			}while(n<1||n>3);
			
			switch(n){
			
			case 1:
				ob.input();break;
			case 2:
				ob.print();break;
			case 3:
				ob.writeFile();
				System.exit(0);
			
			}
		}
		
	}

}

/*
1.입력 2.출력 3.종료:1
이름? 홍길동
생일? 2000-10-10
점수? 60

1.입력 2.출력 3.종료:2
홍길동 2000-10-10  60

1.입력 2.출력 3.종료:3		//종료시점에 저장
---------------------------종료후 재실행
1.입력 2.출력 3.종료:2
홍길동 2000-10-10  60	-old

1.입력 2.출력 3.종료:1
이름? 배수지
생일? 1994-10-10
점수? 90

1.입력 2.출력 3.종료:2
홍길동 2000-10-10  60	--old
배수지 1994-10-10  90	--new

조건:
D:\java\work\demo\data\score.txt

*/




