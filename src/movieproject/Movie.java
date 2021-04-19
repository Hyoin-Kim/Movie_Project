package movieproject;

import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;


public class Movie {
	private String MovieName;
	private int price;
	private int seat;
	private int MoviePick;
	private int count=0;
	Scanner sc= new Scanner(System.in);
	ShowInfo showinfo =new ShowInfo();
	
	
	public String getMovieName() {
		return MovieName;
	}
	public void setMovieName(String MovieName) {
		this.MovieName=MovieName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public int getMoviePick() {
		return MoviePick;
	}
	public void setMoviePick(int moviePick) {
		MoviePick = moviePick;
	}
	public Movie() {
		
	}

	public void movie(Map<String, User> userManager, String name) {
		//User user= new User();	
		System.out.println(userManager.get(name).getName() +"님의 관람하실 영화를 선택해주세요.");
		System.out.println("======================================================================================");
		System.out.println("1.타이타닉[7000원]  2.인터스텔라[8000원]  3.너의이름은[6000원]  4.어바웃타임[7500원]  5.라라랜드[8500원]");
		System.out.println("======================================================================================");
		MoviePick=sc.nextInt();	
			if(MoviePick==1) {
				userManager.get(name).getMovie().setMovieName("타이타닉");
				userManager.get(name).getMovie().setMoviePick(MoviePick);
				seat(userManager, name);
			}else if(MoviePick==2) {
				userManager.get(name).getMovie().setMovieName("인터스텔라");
				userManager.get(name).getMovie().setMoviePick(MoviePick);
				seat(userManager, name);
			}else if(MoviePick==3) {
				userManager.get(name).getMovie().setMovieName("너의이름은");
				userManager.get(name).getMovie().setMoviePick(MoviePick);
				seat(userManager, name);
			}else if(MoviePick==4) {
				userManager.get(name).getMovie().setMovieName("어바웃타임");
				userManager.get(name).getMovie().setMoviePick(MoviePick);
				seat(userManager, name);
			}else if(MoviePick==5) {
				userManager.get(name).getMovie().setMovieName("라라랜드");
				userManager.get(name).getMovie().setMoviePick(MoviePick);
				seat(userManager, name);
			}else {
				System.out.println("잘못선택하였습니다. 다시 선택해주세요.");
				movie(userManager, name);
			}
				}
	
	public void seat(Map<String, User> userManager, String name) {
		int j;
		System.out.println(userManager.get(name).getMovie().getMovieName()+"영화의 원하시는 좌석을 선택해주세요.");
		System.out.println("===============스크린===============");
		System.out.println("  1 ||  2 ||  3 ||  4 ||  5 || 6 ");
		System.out.println("  7 ||  8 ||  9 || 10 || 11 || 12 ");
		System.out.println(" 13 || 14 || 15 || 16 || 17 || 18 ");
		while(true) {
			j=sc.nextInt();
			Iterator<String> keys =userManager.keySet().iterator();
			boolean is_duplicated = false;
			
			//반복문을 돌면서 중복체크를햇어
		
			//중복이되었어 is_duplicated = true;
			for(String key:userManager.keySet()) {
				//System.out.println("name : " + name);
				//System.out.println("key : " + key);
				if((!name.equals(key)) && userManager.get(name).getMovie().getMoviePick()==userManager.get(key).getMovie().getMoviePick()) {
					//System.out.println("ifinner?");
					if(j==userManager.get(key).getMovie().getSeat()) {
						//System.out.println("ifinner2?");
						is_duplicated=true;
						
					}
				}
			}
				
			
			if(j>18||j<1) {
				System.out.println("존재하지 않는 좌석입니다. 다시 선택해주세요.");
				is_duplicated = false;
				seat(userManager, name);
			}
			else if(is_duplicated) {
				System.out.println("이미 선택된 좌석입니다. 다시 선택해주세요.");
				is_duplicated = false;
				seat(userManager,name);
			}
			else {
				is_duplicated = false;
				switch(MoviePick) {
				case 1:
					userManager.get(name).getMovie().setPrice(7000);
					userManager.get(name).getMovie().setSeat(j);
					reserve(userManager, name);
				case 2:
					userManager.get(name).getMovie().setPrice(8000);
					userManager.get(name).getMovie().setSeat(j);
					reserve(userManager, name);
				case 3:
					userManager.get(name).getMovie().setPrice(6000);
					userManager.get(name).getMovie().setSeat(j);
					reserve(userManager, name);
				case 4:
					userManager.get(name).getMovie().setPrice(7500);
					userManager.get(name).getMovie().setSeat(j);
					reserve(userManager, name);
				case 5:
					userManager.get(name).getMovie().setPrice(8500);
					userManager.get(name).getMovie().setSeat(j);
					reserve(userManager, name);
				}
			}
		}
		
		
	}
	public void reserve(Map<String, User> userManager, String name) {
		int i=0;
		
		System.out.println(userManager.get(name).getMovie().getMovieName()+" 영화의 "+userManager.get(name).getMovie().getSeat()+"번 좌석이 맞으십니까 ? Yes=1, No=2");
		i=sc.nextInt();
		if(i==1) {
			coin(userManager, name);
		}else if(i==2) {
			System.out.println("다시 선택해주세요.");
			movie(userManager, name);
		}
		
	}
	public void coin(Map<String, User> userManager, String name) {
		
		int inMoney;
		System.out.print("금액을 입력해주세요 : ");
		inMoney=sc.nextInt();
		if(inMoney<userManager.get(name).getMovie().getPrice()) {
			System.out.println((userManager.get(name).getMovie().getPrice()-inMoney)+"원 부족합니다. 다시 넣어주세요");
			coin(userManager, name);
		}else if(inMoney==userManager.get(name).getMovie().getPrice()) {
			System.out.println("거스름돈은 0원 입니다.");
		}else if(inMoney>userManager.get(name).getMovie().getPrice()) {
			System.out.println("거스름돈은 "+(inMoney-userManager.get(name).getMovie().getPrice())+"원 입니다.");
		}
		System.out.println(userManager.get(name).getName()+"님의 영화 "+userManager.get(name).getMovie().getMovieName()+"(이)가 "+userManager.get(name).getMovie().getSeat()+"번 좌석에 "+userManager.get(name).getMovie().getPrice()+"원에 1매 예매되었습니다.");
		
		userManager.get(name).setName(userManager.get(name).getName());
		userManager.get(name).setPassword(userManager.get(name).getPassword());
		
		System.out.println("처음 화면으로 돌아갑니다.");
		showinfo.start(userManager);
		
	}
			
		}


