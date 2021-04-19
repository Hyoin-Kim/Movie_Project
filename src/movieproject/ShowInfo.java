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
		System.out.println("==========ȿ�ι��� ��ȭ����==========");
		System.out.println("1.��ȭ �����ϱ�  2.��ȸ�ϱ� 3.����ϱ�  3.�����ϱ�");
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
			System.out.println("�ý����� �����մϴ�.");
			break;
		}else {
			System.out.println("�߸��Է��Ͽ����ϴ�.");
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
			System.out.println("�̸��� �Է��ϼ���.");
			for(int i=0;i<name.length;i++) {
				name[i]=sc.next();*/
			System.out.print("�̸� : ");
			name=sc.next();
			System.out.print("�н����� : ");
			password=sc.next();
			
			
				System.out.println(userManager.get(name).getName()+userManager.get(name).getPassword());
			//for(int i=0;i<count;i++) {
				if(userManager.get(name).getName().equals(name)&&userManager.get(name).getPassword().equals(password)) {
					if(!(userManager.get(name).getMovie().getMovieName().isEmpty())) {
						System.out.println(userManager.get(name).getName()+"���� ��ȭ "+userManager.get(name).getMovie().getMovieName()+"(��)�� "+userManager.get(name).getMovie().getPrice()+"���� ���� �Ǿ��ֽ��ϴ�.");
						start(userManager);
					
					}/*else if(movie.getMovieName().isEmpty()||user.getName().isEmpty()) {
						System.out.println("���ŵ� ��ȭ�� ������ �����ϴ�.");
						start(user,movie);
					}
				}else{
					System.out.println("������ ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���. ");
					check(user,movie);*/
					}
			}catch(NullPointerException e) {
				System.out.println("���ŵ� ��ȭ�� ������ �����ϴ�.");
				start(userManager);
			}
	}

		
		
		

	
	public void cancel(Map<String, User> userManager) {
		int j;
		String name="";
		String password="";
		System.out.print("�̸� : ");
		name=sc.next();
		System.out.print("�н����� : ");
		password=sc.next();
		//for(int i=0;i<count;i++) {
		
		if(userManager.get(name).getName().equals(name)&&userManager.get(name).getPassword().contentEquals(password)) {
			System.out.println(userManager.get(name).getName()+"���� ��ȭ "+userManager.get(name).getMovie().getMovieName()+"�� ����Ͻðڽ��ϱ� ? Yes=1, No=2");
			j=sc.nextInt();
			if(j==1) {
				System.out.println(userManager.get(name).getName()+"���� ��ȭ "+userManager.get(name).getMovie().getMovieName()+"(��)�� ��ҿϷ�Ǿ����ϴ�.");
				System.out.println(userManager.get(name).getMovie().getPrice()+"���� ȯ�� �Ϸ�Ǿ����ϴ�.");
				count--;
				userManager.get(name).getMovie().setPrice(userManager.get(name).getMovie().getPrice()-userManager.get(name).getMovie().getPrice());
				userManager.remove(name);
				start(userManager);
			}else if(j==2) {
				System.out.println("���� ȭ������ ���ư��ϴ�.");
				start(userManager);
			}else {
				System.out.println("�߸��Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				cancel(userManager);
			}
	//}
	}
}
}
