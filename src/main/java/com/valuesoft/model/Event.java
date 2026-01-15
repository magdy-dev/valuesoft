package com.valuesoft.model;

import java.util.List;

public class Event {
    private final String name;
    private final String league;
    private final String startTime;
    private final List<Odd> odds;

    public Event(String name, String league, String startTime, List<Odd> odds) {
        this.name = name;
        this.league = league;
        this.startTime = startTime;
        this.odds = odds;
    }

    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append("Event: ").append(name).append("\n");
        sb.append("League: ").append(league).append("\n");
        sb.append("Start: ").append(startTime).append("\n");
        if (odds != null && !odds.isEmpty()) {
            sb.append("Odds:\n");
            for (Odd odd : odds) {
                sb.append("  ").append(odd.getSide()).append(" = ").append(odd.getPrice()).append("\n");
            }
        }
        return sb.toString();
    }
}
