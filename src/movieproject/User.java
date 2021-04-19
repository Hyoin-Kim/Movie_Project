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
		System.out.println("본인의 이름과 패스워드를 입력하세요");
		System.out.print("이름 : ");
		name=sc.next();
		//setName(name);
		//this.name=name;
		System.out.print("패스워드 : ");
		password=sc.next();
		//setPassword(password);
		//this.password=password;
		
		userManager.put(name, user);

		if(!userManager.isEmpty() && userManager.get(name).getName().equals(name)) {
			System.out.println("이름 또는 패스워드가 중복됩니다. 다시 입력해주세요.");
			userManager.remove(name);
			nickname(user, userManager);
		}else {
		System.out.println("입력하신 값으로 하시겠습니까 ? Yes=1, No=2");
		j=sc.nextInt();
		if(j==1) {
			System.out.println("이름은 "+getName()+", 패스워드는 "+getPassword()+" 로 설정되었습니다.");
			setName(name);
			setPassword(password);
			this.movie.movie(userManager, name);
		}else if(j==2) {
			System.out.println("다시 입력하세요.");
			userManager.remove(name);
			nickname(user, userManager);
			
		}else {
			System.out.println("잘못입력하셨습니다.");
			userManager.remove(name);
			nickname(user, userManager);
		}
		
		}
	}
}


