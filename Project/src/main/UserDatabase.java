package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class UserDatabase {
    private ArrayList<user.User> userList = new ArrayList<>();
    public UserDatabase() {
	try {
		File file = new File("./users.txt");
		Scanner input = new Scanner(file);
		while(input.hasNextLine()) {
			String user = input.nextLine();
			String[] splitUser = user.split(";");
			String path = "./src/userInfo/"+splitUser[3]+"/profilePhoto.png";
			javax.swing.ImageIcon profilePhoto = new javax.swing.ImageIcon(path);
			if(splitUser[6].equals("Free User")) {
				userList.add(new user.Free(splitUser[3],splitUser[5],splitUser[0],splitUser[1],Integer.parseInt(splitUser[2]),splitUser[4],profilePhoto));
			}else if(splitUser[6].equals("Hobbyist User")) {
				userList.add(new user.Hobbyist(splitUser[3],splitUser[5],splitUser[0],splitUser[1],Integer.parseInt(splitUser[2]),splitUser[4],profilePhoto));
			}else if(splitUser[6].equals("Professional User")) {
				userList.add(new user.Professional(splitUser[3],splitUser[5],splitUser[0],splitUser[1],Integer.parseInt(splitUser[2]),splitUser[4],profilePhoto));
			}
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
    }
    public ArrayList<user.User> getUserList() {
		return userList;
	}
}
