package user;

import javax.swing.ImageIcon;

public class Hobbyist extends User {
	public Hobbyist(String nickname, String password, String name, String surname, int age, String mail, ImageIcon pp) {
		super(nickname, password, name, surname, age, mail, pp);
	}
	public String getStringClass() {
		return "Hobbyist User";
	}
}
