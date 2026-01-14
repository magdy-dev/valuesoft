package com.valuesoft.model;


public class Event {

    private final String teams;
    private final String league;
    private final String startTime;
    private final String odds;

    public Event(String teams, String league, String startTime, String odds) {
        this.teams = teams;
        this.league = league;
        this.startTime = startTime;
        this.odds = odds;
    }

    public String pretty() {
        return """
                ------------------------------
                Match: %s
                League: %s
                Start Time: %s
                Odds: %s
                ------------------------------
                """.formatted(teams, league, startTime, odds);
    }
}
