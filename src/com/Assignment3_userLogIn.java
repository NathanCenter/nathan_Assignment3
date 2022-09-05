package com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Assignment3_userLogIn {

	public static void main(String[] args) throws IOException {
		BufferedReader fileReader = null;
		UserProfile[] userArray = new UserProfile[4];

		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			String line = "";
			int i = 0;
			while ((line = fileReader.readLine()) != null) {
				String[] userDataArray = line.split(",");
				UserProfile userProfile = new UserProfile(userDataArray[0], userDataArray[1], userDataArray[2]);
				userArray[i] = userProfile;
				i++;

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// boolean varable
		boolean checkTrueOrFalse = false;
		int d = 0;
		while (d <= 4) {
			// userName
			d++;
			System.out.println("please enter your username");

			Scanner userName = new Scanner(System.in);
			String showUserName = userName.nextLine();
			// password
			System.out.println("please enter your password");
			Scanner userPassword = new Scanner(System.in);
			String showUserPassword = userPassword.nextLine();

			for (UserProfile passwordAndUserName : userArray) {

				if (passwordAndUserName.getUserName().equalsIgnoreCase(showUserName)
						&& passwordAndUserName.getPassword().equals(showUserPassword)) {
					System.out.println("Welcome " + " " + passwordAndUserName.getName());
					checkTrueOrFalse = true;
					break;

				} else if (!passwordAndUserName.getUserName().equalsIgnoreCase(showUserName)
						&& !passwordAndUserName.getPassword().equals(showUserPassword)) {

					checkTrueOrFalse = false;
				}

			}
			if (checkTrueOrFalse == true) {
				break;
			} else if (checkTrueOrFalse == false) {
				System.out.println("wrong username please try again");

			}

		}
		if (d == 5 && checkTrueOrFalse == false) {
			System.out.println("Too many failed login attempts, you are now locked out.");
		}

	}

}
