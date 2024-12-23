package com.PlayerManagement;
	public class Player {
	    private String playerName;
	    private int jerseyNumber;
	    private int runs;
	    private int wickets;
	    private int matchesPlayed;

	    public Player(String playerName, int jerseyNumber, int runs, int wickets, int matchesPlayed) {
	        this.playerName = playerName;
	        this.jerseyNumber = jerseyNumber;
	        this.runs = runs;
	        this.wickets = wickets;
	        this.matchesPlayed = matchesPlayed;
	    }

	    public String getPlayerName() {
	        return playerName;
	    }

	    public int getJerseyNumber() {
	        return jerseyNumber;
	    }

	    public int getRuns() {
	        return runs;
	    }

	    public void setRuns(int runs) {
	        this.runs = runs;
	    }

	    public int getWickets() {
	        return wickets;
	    }

	    public void setWickets(int wickets) {
	        this.wickets = wickets;
	    }

	    public int getMatchesPlayed() {
	        return matchesPlayed;
	    }

	    public void setMatchesPlayed(int matchesPlayed) {
	        this.matchesPlayed = matchesPlayed;
	    }

	    @Override
	    public String toString() {
	        return String.format(
	                "PLAYER NAME   : %s\nJERSEY NUMBER : %d\nRUNS          : %d\nWICKETS       : %d\nMATCHES PLAYED: %d\n",
	                playerName, jerseyNumber, runs, wickets, matchesPlayed
	        );
	    }
	}



