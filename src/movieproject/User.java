package movieproject;

import java.util.Map;
import java.util.Scanner;

public class User {
	
	Scanner sc=new Scanner(System.in);
	Movie movie=new Movie();
	private String name = "";
	private String password;
	private int coin;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public Movie getMovie() {
		return this.movie;
	}
	
	
	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}

	public void nickname(User user, Map<String, User> userManager) {
		
		//User user= new User();
		String name="";
		int j = 0;
		//String[] name = new String[2];
		//int size=name.length;
		System.out.println("������ �̸��� �н����带 �Է��ϼ���");
		System.out.print("�̸� : ");
		name=sc.next();
		//setName(name);
		//this.name=name;
		System.out.print("�н����� : ");
		password=sc.next();
		//setPassword(password);
		//this.password=password;
		
		userManager.put(name, user);

		if(!userManager.isEmpty() && userManager.get(name).getName().equals(name)) {
			System.out.println("�̸� �Ǵ� �н����尡 �ߺ��˴ϴ�. �ٽ� �Է����ּ���.");
			userManager.remove(name);
			nickname(user, userManager);
		}else {
		System.out.println("�Է��Ͻ� ������ �Ͻðڽ��ϱ� ? Yes=1, No=2");
		j=sc.nextInt();
		if(j==1) {
			System.out.println("�̸��� "+getName()+", �н������ "+getPassword()+" �� �����Ǿ����ϴ�.");
			setName(name);
			setPassword(password);
			this.movie.movie(userManager, name);
		}else if(j==2) {
			System.out.println("�ٽ� �Է��ϼ���.");
			userManager.remove(name);
			nickname(user, userManager);
			
		}else {
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
			userManager.remove(name);
			nickname(user, userManager);
		}
		
		}
	}
}


