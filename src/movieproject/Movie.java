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
		System.out.println(userManager.get(name).getName() +"���� �����Ͻ� ��ȭ�� �������ּ���.");
		System.out.println("======================================================================================");
		System.out.println("1.Ÿ��Ÿ��[7000��]  2.���ͽ��ڶ�[8000��]  3.�����̸���[6000��]  4.��ٿ�Ÿ��[7500��]  5.��󷣵�[8500��]");
		System.out.println("======================================================================================");
		MoviePick=sc.nextInt();	
			if(MoviePick==1) {
				userManager.get(name).getMovie().setMovieName("Ÿ��Ÿ��");
				userManager.get(name).getMovie().setMoviePick(MoviePick);
				seat(userManager, name);
			}else if(MoviePick==2) {
				userManager.get(name).getMovie().setMovieName("���ͽ��ڶ�");
				userManager.get(name).getMovie().setMoviePick(MoviePick);
				seat(userManager, name);
			}else if(MoviePick==3) {
				userManager.get(name).getMovie().setMovieName("�����̸���");
				userManager.get(name).getMovie().setMoviePick(MoviePick);
				seat(userManager, name);
			}else if(MoviePick==4) {
				userManager.get(name).getMovie().setMovieName("��ٿ�Ÿ��");
				userManager.get(name).getMovie().setMoviePick(MoviePick);
				seat(userManager, name);
			}else if(MoviePick==5) {
				userManager.get(name).getMovie().setMovieName("��󷣵�");
				userManager.get(name).getMovie().setMoviePick(MoviePick);
				seat(userManager, name);
			}else {
				System.out.println("�߸������Ͽ����ϴ�. �ٽ� �������ּ���.");
				movie(userManager, name);
			}
				}
	
	public void seat(Map<String, User> userManager, String name) {
		int j;
		System.out.println(userManager.get(name).getMovie().getMovieName()+"��ȭ�� ���Ͻô� �¼��� �������ּ���.");
		System.out.println("===============��ũ��===============");
		System.out.println("  1 ||  2 ||  3 ||  4 ||  5 || 6 ");
		System.out.println("  7 ||  8 ||  9 || 10 || 11 || 12 ");
		System.out.println(" 13 || 14 || 15 || 16 || 17 || 18 ");
		while(true) {
			j=sc.nextInt();
			Iterator<String> keys =userManager.keySet().iterator();
			boolean is_duplicated = false;
			
			//�ݺ����� ���鼭 �ߺ�üũ���޾�
		
			//�ߺ��̵Ǿ��� is_duplicated = true;
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
				System.out.println("�������� �ʴ� �¼��Դϴ�. �ٽ� �������ּ���.");
				is_duplicated = false;
				seat(userManager, name);
			}
			else if(is_duplicated) {
				System.out.println("�̹� ���õ� �¼��Դϴ�. �ٽ� �������ּ���.");
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
		
		System.out.println(userManager.get(name).getMovie().getMovieName()+" ��ȭ�� "+userManager.get(name).getMovie().getSeat()+"�� �¼��� �����ʴϱ� ? Yes=1, No=2");
		i=sc.nextInt();
		if(i==1) {
			coin(userManager, name);
		}else if(i==2) {
			System.out.println("�ٽ� �������ּ���.");
			movie(userManager, name);
		}
		
	}
	public void coin(Map<String, User> userManager, String name) {
		
		int inMoney;
		System.out.print("�ݾ��� �Է����ּ��� : ");
		inMoney=sc.nextInt();
		if(inMoney<userManager.get(name).getMovie().getPrice()) {
			System.out.println((userManager.get(name).getMovie().getPrice()-inMoney)+"�� �����մϴ�. �ٽ� �־��ּ���");
			coin(userManager, name);
		}else if(inMoney==userManager.get(name).getMovie().getPrice()) {
			System.out.println("�Ž������� 0�� �Դϴ�.");
		}else if(inMoney>userManager.get(name).getMovie().getPrice()) {
			System.out.println("�Ž������� "+(inMoney-userManager.get(name).getMovie().getPrice())+"�� �Դϴ�.");
		}
		System.out.println(userManager.get(name).getName()+"���� ��ȭ "+userManager.get(name).getMovie().getMovieName()+"(��)�� "+userManager.get(name).getMovie().getSeat()+"�� �¼��� "+userManager.get(name).getMovie().getPrice()+"���� 1�� ���ŵǾ����ϴ�.");
		
		userManager.get(name).setName(userManager.get(name).getName());
		userManager.get(name).setPassword(userManager.get(name).getPassword());
		
		System.out.println("ó�� ȭ������ ���ư��ϴ�.");
		showinfo.start(userManager);
		
	}
			
		}


