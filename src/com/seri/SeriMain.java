package com.seri;

import java.util.Scanner;

public class SeriMain {

	public static void main(String[] args) {
		
		Seri ob = new Seri();
		Scanner sc = new Scanner(System.in);
		
		int n;
		while(true){
			
			do{
				System.out.print("1.�Է� 2.��� 3.����: ");
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
1.�Է� 2.��� 3.����:1
�̸�? ȫ�浿
����? 2000-10-10
����? 60

1.�Է� 2.��� 3.����:2
ȫ�浿 2000-10-10  60

1.�Է� 2.��� 3.����:3		//��������� ����
---------------------------������ �����
1.�Է� 2.��� 3.����:2
ȫ�浿 2000-10-10  60	-old

1.�Է� 2.��� 3.����:1
�̸�? �����
����? 1994-10-10
����? 90

1.�Է� 2.��� 3.����:2
ȫ�浿 2000-10-10  60	--old
����� 1994-10-10  90	--new

����:
D:\java\work\demo\data\score.txt

*/




