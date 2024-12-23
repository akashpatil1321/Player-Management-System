package com.PlayerManagement;

	import java.util.ArrayList;
	import java.util.Comparator;
	import java.util.Scanner;

	public class PlayerManager {
	    private ArrayList<Player> players = new ArrayList<>();
	    private Scanner scanner = new Scanner(System.in);

	    public PlayerManager() {
	        // Preloaded players
	        players.add(new Player("Rohit Sharma", 45, 200, 3, 13));
	        players.add(new Player("Virat Kohli", 18, 120, 1, 12));
	        players.add(new Player("Suryakumar Yadav", 63, 1500, 5, 50));
	        players.add(new Player("MS Dhoni", 7, 50, 8, 15));
	        players.add(new Player("Jasprit Bumrah", 93, 25, 130, 20));
	        players.add(new Player("KL Rahul", 11, 85, 6, 8));
	        players.add(new Player("Rishabh Pant", 17, 75, 3, 11));
	        players.add(new Player("Hardik Pandya", 33, 550, 45, 18));
	        players.add(new Player("Shubman Gill", 77, 60, 2, 9));
	        players.add(new Player("Yuzvendra Chahal", 3, 11, 120, 22));
	    }

	    public void addPlayer() {
	        System.out.print("Enter Player Name: ");
	        String name = scanner.nextLine();
	        System.out.print("Enter Jersey Number: ");
	        int jersey = scanner.nextInt();
	        System.out.print("Enter Runs: ");
	        int runs = scanner.nextInt();
	        System.out.print("Enter Wickets: ");
	        int wickets = scanner.nextInt();
	        System.out.print("Enter Matches Played: ");
	        int matches = scanner.nextInt();
	        scanner.nextLine(); // consume newline

	        players.add(new Player(name, jersey, runs, wickets, matches));
	        System.out.println("PLAYER ADDED SUCCESSFULLY!");
	    }

	    public void removePlayer() {
	        System.out.println("1. By Name\n2. By Jersey Number");
	        System.out.print("Enter your choice: ");
	        int choice = scanner.nextInt();
	        scanner.nextLine(); // consume newline

	        if (choice == 1) {
	            System.out.print("Enter Player Name: ");
	            String name = scanner.nextLine();
	            players.removeIf(player -> player.getPlayerName().equalsIgnoreCase(name));
	        } else if (choice == 2) {
	            System.out.print("Enter Jersey Number: ");
	            int jersey = scanner.nextInt();
	            players.removeIf(player -> player.getJerseyNumber() == jersey);
	        } else {
	            System.out.println("Invalid Choice");
	        }
	        System.out.println("PLAYER REMOVED SUCCESSFULLY!");
	    }

	    public void searchPlayerByName() {
	        System.out.print("Enter Player Name: ");
	        String name = scanner.nextLine();
	        players.stream()
	                .filter(player -> player.getPlayerName().equalsIgnoreCase(name))
	                .forEach(System.out::println);
	    }

	    public void searchPlayerByJerseyNumber() {
	        System.out.print("Enter Jersey Number: ");
	        int jersey = scanner.nextInt();
	        players.stream()
	                .filter(player -> player.getJerseyNumber() == jersey)
	                .forEach(System.out::println);
	    }

	    public void updatePlayer() {
	        System.out.println("1. By Name\n2. By Jersey Number");
	        System.out.print("Enter your choice: ");
	        int choice = scanner.nextInt();
	        scanner.nextLine(); // consume newline

	        Player playerToUpdate = null;
	        if (choice == 1) {
	            System.out.print("Enter Player Name: ");
	            String name = scanner.nextLine();
	            playerToUpdate = players.stream()
	                    .filter(player -> player.getPlayerName().equalsIgnoreCase(name))
	                    .findFirst()
	                    .orElse(null);
	        } else if (choice == 2) {
	            System.out.print("Enter Jersey Number: ");
	            int jersey = scanner.nextInt();
	            playerToUpdate = players.stream()
	                    .filter(player -> player.getJerseyNumber() == jersey)
	                    .findFirst()
	                    .orElse(null);
	        }

	        if (playerToUpdate != null) {
	            System.out.println("1. Update Runs\n2. Update Wickets\n3. Update Matches Played");
	            System.out.print("Enter your choice: ");
	            int updateChoice = scanner.nextInt();
	            switch (updateChoice) {
	                case 1 -> {
	                    System.out.print("Enter New Runs: ");
	                    playerToUpdate.setRuns(scanner.nextInt());
	                }
	                case 2 -> {
	                    System.out.print("Enter New Wickets: ");
	                    playerToUpdate.setWickets(scanner.nextInt());
	                }
	                case 3 -> {
	                    System.out.print("Enter New Matches Played: ");
	                    playerToUpdate.setMatchesPlayed(scanner.nextInt());
	                }
	                default -> System.out.println("Invalid Choice");
	            }
	            System.out.println("PLAYER UPDATED SUCCESSFULLY!");
	        } else {
	            System.out.println("PLAYER NOT FOUND!");
	        }
	    }

	    public void displaySortedPlayers() {
	        System.out.println("1. By Runs\n2. By Wickets");
	        System.out.print("Enter your choice: ");
	        int choice = scanner.nextInt();

	        Comparator<Player> comparator = switch (choice) {
	            case 1 -> Comparator.comparingInt(Player::getRuns).reversed();
	            case 2 -> Comparator.comparingInt(Player::getWickets).reversed();
	            default -> null;
	        };

	        if (comparator != null) {
	            players.stream()
	                    .sorted(comparator)
	                    .limit(3)
	                    .forEach(System.out::println);
	        } else {
	            System.out.println("Invalid Choice");
	        }
	    }

	    public void displayAllPlayers() {
	        players.forEach(System.out::println);
	    }
	}



