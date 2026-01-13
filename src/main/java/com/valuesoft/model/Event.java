package com.valuesoft.model;


public class Event {

    private final String title;
    private final String league;
    private final String startTime;
    private final String odd1;
    private final String odd2;

    public Event(String title, String league, String startTime, String odd1, String odd2) {
        this.title = title;
        this.league = league;
        this.startTime = startTime;
        this.odd1 = odd1;
        this.odd2 = odd2;
    }

    public String prettyPrint() {
        return String.format(
                "Событие: %s\nЛига: %s\nНачало: %s\nКоэффициенты: %s | %s\n",
                title, league, startTime, odd1, odd2
        );
    }

    public String getTitle() {
        return title;
    }

    public String getLeague() {
        return league;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getOdd1() {
        return odd1;
    }

    public String getOdd2() {
        return odd2;
    }

}
