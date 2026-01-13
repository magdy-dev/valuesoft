package com.valuesoft.parser;



import com.valuesoft.model.Event;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public class EventParser {

    public List<Event> parse(String html) {
        List<Event> events = new ArrayList<>();

        Document doc = Jsoup.parse(html);

        // Update these selectors according to the real site structure
        for (Element card : doc.select(".event-card")) {
            String title = card.select(".title").text();      // Event name / participants
            String league = card.select(".league").text();    // League / sport
            String startTime = card.select(".start-time").text(); // Start time
            List<Element> oddsElements = card.select(".odd");
            String odd1 = oddsElements.size() > 0 ? oddsElements.get(0).text() : "";
            String odd2 = oddsElements.size() > 1 ? oddsElements.get(1).text() : "";

            events.add(new Event(title, league, startTime, odd1, odd2));
        }

        return events;
    }
}
