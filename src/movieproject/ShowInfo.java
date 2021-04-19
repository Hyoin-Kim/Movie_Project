package movieproject;

import java.util.Map;
import java.util.Scanner;

public class ShowInfo {
	Scanner sc=new Scanner(System.in);
	private int count=0;
	
	public ShowInfo() {
		
	}

	public void start(Map<String, User> userManager) {
		int i;
		System.out.println("==========효인무비 영화예매==========");
		System.out.println("1.영화 예매하기  2.조회하기 3.취소하기  3.종료하기");
		i=sc.nextInt();
		while(i!=5) {
			if(i==1) {
			User user = new User();
			user.nickname(user, userManager);
			count++;
		}else if(i==2) {
			check(userManager);
		}else if(i==3) {
			cancel(userManager);
		}		
		else if(i==4) {
			System.out.println("시스템을 종료합니다.");
			break;
		}else {
			System.out.println("잘못입력하였습니다.");
			}
		}
	}
	

	public void reserve() {

	}
	
	public void check(Map<String, User> userManager) {
		try {
			String name="";
			String password="";
			
			/*String[] name=new String [10];
			System.out.println("이름을 입력하세요.");
			for(int i=0;i<name.length;i++) {
				name[i]=sc.next();*/
			System.out.print("이름 : ");
			name=sc.next();
			System.out.print("패스워드 : ");
			password=sc.next();
			
			
				System.out.println(userManager.get(name).getName()+userManager.get(name).getPassword());
			//for(int i=0;i<count;i++) {
				if(userManager.get(name).getName().equals(name)&&userManager.get(name).getPassword().equals(password)) {
					if(!(userManager.get(name).getMovie().getMovieName().isEmpty())) {
						System.out.println(userManager.get(name).getName()+"님의 영화 "+userManager.get(name).getMovie().getMovieName()+"(이)가 "+userManager.get(name).getMovie().getPrice()+"원에 예매 되어있습니다.");
						start(userManager);
					
					}/*else if(movie.getMovieName().isEmpty()||user.getName().isEmpty()) {
						System.out.println("예매된 영화의 내역이 없습니다.");
						start(user,movie);
					}
				}else{
					System.out.println("정보가 일치하지 않습니다. 다시 입력해주세요. ");
					check(user,movie);*/
					}
			}catch(NullPointerException e) {
				System.out.println("예매된 영화의 내역이 없습니다.");
				start(userManager);
			}
	}

		
		
		

	
	public void cancel(Map<String, User> userManager) {
		int j;
		String name="";
		String password="";
		System.out.print("이름 : ");
		name=sc.next();
		System.out.print("패스워드 : ");
		password=sc.next();
		//for(int i=0;i<count;i++) {
		
		if(userManager.get(name).getName().equals(name)&&userManager.get(name).getPassword().contentEquals(password)) {
			System.out.println(userManager.get(name).getName()+"님의 영화 "+userManager.get(name).getMovie().getMovieName()+"를 취소하시겠습니까 ? Yes=1, No=2");
			j=sc.nextInt();
			if(j==1) {
				System.out.println(userManager.get(name).getName()+"님의 영화 "+userManager.get(name).getMovie().getMovieName()+"(이)가 취소완료되었습니다.");
				System.out.println(userManager.get(name).getMovie().getPrice()+"원이 환불 완료되었습니다.");
				count--;
				userManager.get(name).getMovie().setPrice(userManager.get(name).getMovie().getPrice()-userManager.get(name).getMovie().getPrice());
				userManager.remove(name);
				start(userManager);
			}else if(j==2) {
				System.out.println("메인 화면으로 돌아갑니다.");
				start(userManager);
			}else {
				System.out.println("잘못입력하였습니다. 다시 입력해주세요.");
				cancel(userManager);
			}
	//}
	}
}
}
