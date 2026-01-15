package com.valuesoft.client;

import com.valuesoft.model.Event;
import com.valuesoft.model.Odd;

import java.util.ArrayList;
import java.util.List;



import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OvertimeClient {

    public List<Event> fetchEvents() {
        List<Event> events = new ArrayList<>();

        // Mock Event 1
        List<Odd> odds1 = new ArrayList<>();
        odds1.add(new Odd("Team A", 1.8));
        odds1.add(new Odd("Team B", 2.1));
        events.add(new Event("Team A vs Team B", "Premier League",
                Instant.now().toString(), odds1));

        // Mock Event 2
        List<Odd> odds2 = new ArrayList<>();
        odds2.add(new Odd("Team C", 1.5));
        odds2.add(new Odd("Team D", 2.5));
        events.add(new Event("Team C vs Team D", "La Liga",
                Instant.now().plusSeconds(3600).toString(), odds2));

        return events;
    }
}
