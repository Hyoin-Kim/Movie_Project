package movieproject;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Map<String, User> userManager = new HashMap<String, User>();
		ShowInfo showinfo = new ShowInfo();
	
		showinfo.start(userManager);
	}

}
