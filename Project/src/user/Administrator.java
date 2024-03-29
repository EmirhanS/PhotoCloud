package user;

import javax.swing.ImageIcon;

public class Administrator extends User {

	public Administrator(String nickname, String password, String name, String surname, int age, String mail, ImageIcon pp) {
		super(nickname, password, name, surname, age, mail, pp);
		// TODO Auto-generated constructor stub
	}

	public String getStringClass() {
		// TODO Auto-generated method stub
		return "Admin User";
	}

	
}
