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

		// read the file
		BufferedReader fileReader = null;
		UserProfile[] userArray = new UserProfile[4];

		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));

			String line;
			int i = 0;
			while ((line = fileReader.readLine()) != null) {

				String[] userDataArray = line.split(",");
				UserProfile userProfile = new UserProfile(userDataArray[0], userDataArray[1], userDataArray[2]);
				userArray[i] = userProfile;
				i++;

				// inner while loop
				int d = 0;
				while (d <= 4) {
					d++;
					// username
					// TODO Auto-generated method stub

					System.out.println("please enter your username");

					Scanner userName = new Scanner(System.in);
					String ShowUserName = userName.nextLine();
					// password

					System.out.println("please enter your password");
					Scanner userPassword = new Scanner(System.in);
					String showUserPassword = userPassword.nextLine();
					if (userProfile.getUserName().equals(ShowUserName)
							&& userProfile.getPassword().equals(showUserPassword)) {
						System.out.println("Welcome:" + " " + ShowUserName);
						break;
					}

					else if (!userProfile.getUserName().equals(ShowUserName)
							&& !userProfile.getPassword().equals(showUserPassword)) {
						System.out.println("Invalid login, please try again.");
						System.out.println(d);
						
					} 

				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
