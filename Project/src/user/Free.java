package user;

import javax.swing.ImageIcon;

//EN SONDA EDİTİNG TOOLLARINI FREE PROF VE HOBBY E İZİN OLAYINI EKLE
public class Free extends User {
	public Free(String nickname, String password, String name, String surname, int age, String mail, ImageIcon pp) {
		super(nickname, password, name, surname, age, mail, pp);
	}
	public String getStringClass() {
		return "Free User";
	}
}
