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
	
	private List<SeriVO> lists = null;							// 사용할 컬렉션 리스트를 선언(클래스의 디폴트값은 Null임)
	private String path = System.getProperty("user.dir");		// System.getProperty 는 현재 시스템의 경로를 불러오는 것.
	private File f = new File(path,"/data/score.txt");			// f는 파일의 저장되는 경로를 지정해준것.
	
	public Seri(){												// 기본생성자가 실행될때 파일체크를 해준다.
		
		try {
			
			if(!f.getParentFile().exists()){					// 파일의 부모폴더가 존재하지 않는다면,
				f.getParentFile().mkdirs();						// 부모폴더의 디렉토리를 만들어준다.
			}
			
			if(f.exists()){										// 파일이 존재한다면
				
				FileInputStream fis = 							
						new FileInputStream(f); 				// 파일을 FileInputStream클래스 파이프를 통해 읽어들인 후!
				ObjectInputStream ois = 						
						new ObjectInputStream(fis);				// 직렬화 하기위해 ObjectInputStream을 이용해 ois 파이프에 넣어둔다.
				
				lists = (ArrayList<SeriVO>)ois.readObject();	// ois 오브젝트스트림을 읽어 오브젝트타입인 lists를 ArrayList<SeriVO>형태로 형변환해 lists에 담아준다. 
																// 이렇게 되면 기존에 저장된 lists파일이 읽어들여진다.
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
		
		System.out.print("이름?");
		vo.setName(sc.next());
		
		System.out.print("생일?");
		vo.setBirth(sc.next());
		
		System.out.print("점수?");
		vo.setScore(sc.nextInt());
		
		if(lists==null)											//lists파일이 없을때, 리스트 객체를 생성한다.
			lists = new ArrayList<SeriVO>();
		
		lists.add(vo);											//lists파일이 없을때는 새 리스트객체에 값들을 담고, 있을경우엔, 그 lists에 더해준다.
		
		
	}
		
	public void writeFile(){
		
		try {
			
			if(lists!=null){									//lists파일이 있을 경우 
				
				FileOutputStream fos =							
						new FileOutputStream(f);				//FileOutputStream 파이프를 통해 f를 읽어들인 후 
				ObjectOutputStream oos = 
						new ObjectOutputStream(fos);			//직렬화 하기위해 ObjectOutputStream 파이프를 통해 읽어들인다.
				
				oos.writeObject(lists);							//lists객체를 oos 파이프를 통해 저장한다.
				fos.close();
				oos.close();
				
				System.out.println("파일저장 성공!");
				
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

