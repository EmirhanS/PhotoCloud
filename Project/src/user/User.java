package user;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class User {
	protected String nickname;
	protected String password;
	protected String name;
	protected String surname;
	protected int age;
	protected String mail;
	protected ImageIcon profilePhoto;
	public User(String nickname, String password, String name, String surname, int age, String mail, ImageIcon profilePhoto) {
		this.nickname = nickname;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.mail = mail;
		this.profilePhoto = profilePhoto;
		// This is the constructor of User Class
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public int getAge() {
		return age;
	}
	public String getMail() {
		return mail;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNickname() {
		return nickname;
	}
	public abstract String getStringClass();
}
