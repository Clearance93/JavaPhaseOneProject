package app;


import java.io.*;
import java.util.Scanner;

public class MenuConsole {
	static void displayAppDetails() {
		System.out.println("----------Application Name : Key<>:: Phase one Project");
		System.out.println("This application was made by Clearane Morumudi !");
		System.out.println("*************************************************");
	}

	static void displayMainMenuOptions() {
		System.out.println("Press 1 To View All Files In The Directory");
		System.out.println("Press 2 To View More Options");
		System.out.println("Press 3 To Quit The Application");
	}

	static void showMoreOptions() {
		System.out.println("Press 1 To Add A File In The Directory");
		System.out.println("Press 2 To Delete A Specific File");
		System.out.println("Press 3 To Search For A Specific File");
		System.out.println("Press 4 To Return To Main Menu");
	}

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			int mainMenuOption = 0;
			int innerOption = 0;
			String[] filenames;
			boolean result;
			String filename;
			File theDir = new File("C:\\Files");

			if (!theDir.exists()) {
				theDir.mkdir();
			}

			displayAppDetails();
			do {
				displayMainMenuOptions();
				try {
					mainMenuOption = Integer.parseInt(input.next());
					if (mainMenuOption == 1) {

						filenames = theDir.list();
						System.out.println("******Files in the directory********");
						for (int i = 0; i < filenames.length; i++) {
							System.out.println(filenames[i]);
						}
						System.out.println(" ");
						System.out.println("***********************************************************");

						System.out.println("Enter 1 to go back to main menu or 4 to quit the application");
						innerOption = Integer.parseInt(input.next());

						if (innerOption == 1) {
							continue;
						} else {
							System.out.println("Application Closing");
							System.exit(0);
						}
					} else if (mainMenuOption == 2) {
						showMoreOptions();
						innerOption = Integer.parseInt(input.next());
						if (innerOption == 1) {
							System.out.println("Enter A File Name");
							filename = input.next();
							File newFile = new File("C:\\Files\\"+filename);
							
							try {
								result = newFile.createNewFile();
								if(!result) {
									System.out.println("File Not Created");
								}else {
									System.out.println("File Successfully Created");
								}
							} catch (IOException e) {
								System.out.println(e.getMessage());
							}
							
							System.out.println("************************************************************");

							System.out.println("Enter 1 to go back to main menu or 4 to quit the application");
							innerOption = Integer.parseInt(input.next());

							if (innerOption == 1) {
								continue;
							} else {
								System.out.println("Application Closing");
								System.exit(0);
							}
						} else if (innerOption == 2) {
							System.out.println("Enter File Name");
							String  strFileName = input.next();
							
							File delFile = new File(theDir+"\\"+strFileName) ;
							
							if(!delFile.exists()) {
								System.err.println("File Not Found");
							}else {
								delFile.delete();
								System.out.println("File Deleted");
							}
							
							
							System.out.println(" ");
							System.out.println("*************************");
							System.out.println("Enter 1 to go back to main menu or 4 to quit the application");

							innerOption = Integer.parseInt(input.next());
							if (innerOption == 1) {
								continue;
							} else {
								System.out.println("Application Closing");
								System.exit(0);
							}
						} else if (innerOption == 3) {
							System.out.println("Search file here");
							System.out.println("Enter the File You want To Search for ");
							String file_name = input.next();
							File searchedFile = new File(theDir+"\\"+file_name);
							
							if(searchedFile.exists()) {
								System.out.println("File Found");
							}else {
								System.out.println("Sorry File is Not Present In The Directory");
							}
									
							
							System.out.println("*************************");
							System.out.println("Enter 1 to go back to main menu or 4 to quit the application");
							innerOption = Integer.parseInt(input.next());

							if (innerOption == 1) {
								continue;
							} else {
								System.out.println("Application Closing");
								System.exit(0);
							}
						} else {
							continue;
						}
					} else {
						System.out.println("Application closing");
						System.exit(0);
					}
				} catch (NumberFormatException e) {
					System.err.println("Enter a number no letters allowed");
				}

			} while (mainMenuOption != 4);
		}

	}

}
