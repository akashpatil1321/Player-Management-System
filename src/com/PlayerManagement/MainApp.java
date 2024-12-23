package com.PlayerManagement;

import java.util.Scanner;
public class MainApp {


	    public static void main(String[] args) {
	        PlayerManager manager = new PlayerManager();
	        Scanner scanner = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("\n1. Add Player");
	            System.out.println("2. Remove Player");
	            System.out.println("3. Search Player by Name");
	            System.out.println("4. Search Player by Jersey Number");
	            System.out.println("5. Update Player");
	            System.out.println("6. Display Sorted Players");
	            System.out.println("7. Display All Players");
	            System.out.println("0. EXIT");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine(); // consume newline

	            switch (choice) {
	                case 1 -> manager.addPlayer();
	                case 2 -> manager.removePlayer();
	                case 3 -> manager.searchPlayerByName();
	                case 4 -> manager.searchPlayerByJerseyNumber();
	                case 5 -> manager.updatePlayer();
	                case 6 -> manager.displaySortedPlayers();
	                case 7 -> manager.displayAllPlayers();
	                case 0 -> System.out.println("Exiting...");
	                default -> System.out.println("Invalid Choice!");
	            }
	        } while (choice != 0);

	        scanner.close();
	    }
	}


