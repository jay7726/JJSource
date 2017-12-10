package com.seri;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Seri {
	
	private List<SeriVO> lists = null;							// ����� �÷��� ����Ʈ�� ����(Ŭ������ ����Ʈ���� Null��)
	private String path = System.getProperty("user.dir");		// System.getProperty �� ���� �ý����� ��θ� �ҷ����� ��.
	private File f = new File(path,"/data/score.txt");			// f�� ������ ����Ǵ� ��θ� �������ذ�.
	
	public Seri(){												// �⺻�����ڰ� ����ɶ� ����üũ�� ���ش�.
		
		try {
			
			if(!f.getParentFile().exists()){					// ������ �θ������� �������� �ʴ´ٸ�,
				f.getParentFile().mkdirs();						// �θ������� ���丮�� ������ش�.
			}
			
			if(f.exists()){										// ������ �����Ѵٸ�
				
				FileInputStream fis = 							
						new FileInputStream(f); 				// ������ FileInputStreamŬ���� �������� ���� �о���� ��!
				ObjectInputStream ois = 						
						new ObjectInputStream(fis);				// ����ȭ �ϱ����� ObjectInputStream�� �̿��� ois �������� �־�д�.
				
				lists = (ArrayList<SeriVO>)ois.readObject();	// ois ������Ʈ��Ʈ���� �о� ������ƮŸ���� lists�� ArrayList<SeriVO>���·� ����ȯ�� lists�� ����ش�. 
																// �̷��� �Ǹ� ������ ����� lists������ �о�鿩����.
				fis.close();
				ois.close();
				
			}		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
				
	}
	
	public void input(){
		
		Scanner sc = new Scanner(System.in);
		
		SeriVO vo = new SeriVO();
		
		System.out.print("�̸�?");
		vo.setName(sc.next());
		
		System.out.print("����?");
		vo.setBirth(sc.next());
		
		System.out.print("����?");
		vo.setScore(sc.nextInt());
		
		if(lists==null)											//lists������ ������, ����Ʈ ��ü�� �����Ѵ�.
			lists = new ArrayList<SeriVO>();
		
		lists.add(vo);											//lists������ �������� �� ����Ʈ��ü�� ������ ���, ������쿣, �� lists�� �����ش�.
		
		
	}
		
	public void writeFile(){
		
		try {
			
			if(lists!=null){									//lists������ ���� ��� 
				
				FileOutputStream fos =							
						new FileOutputStream(f);				//FileOutputStream �������� ���� f�� �о���� �� 
				ObjectOutputStream oos = 
						new ObjectOutputStream(fos);			//����ȭ �ϱ����� ObjectOutputStream �������� ���� �о���δ�.
				
				oos.writeObject(lists);							//lists��ü�� oos �������� ���� �����Ѵ�.
				fos.close();
				oos.close();
				
				System.out.println("�������� ����!");
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void print(){
		
		Iterator<SeriVO> it = lists.iterator();
		while(it.hasNext()){
			SeriVO vo = it.next();
			System.out.println(vo.toString());
		}
		
		
	}	

}

