package com.valuesoft.client;

import com.valuesoft.model.Event;
import com.valuesoft.model.Odd;

import java.util.ArrayList;
import java.util.List;


public class OvertimeClient {

    // MOCK fetchEvents for testing
    public List<Event> fetchEvents() {
        List<Event> events = new ArrayList<>();

        // Event 1
        List<Odd> odds1 = new ArrayList<>();
        odds1.add(new Odd("Home Win", 1.5));
        odds1.add(new Odd("Draw", 3.2));
        events.add(new Event("Team A vs Team B", "Premier League", "2026-01-15T18:00", odds1));

        // Event 2
        List<Odd> odds2 = new ArrayList<>();
        odds2.add(new Odd("Home Win", 2.1));
        odds2.add(new Odd("Away Win", 2.8));
        events.add(new Event("Team C vs Team D", "La Liga", "2026-01-15T20:00", odds2));

        return events;
    }
}
