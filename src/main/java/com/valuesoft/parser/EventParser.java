package com.valuesoft.parser;

import com.valuesoft.model.Event;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EventParser {

    public List<Event> parseHtml(Document doc) {

        List<Event> events = new ArrayList<>();

        // Each event card
        Elements cards = doc.select(".event-card");

        for (Element card : cards) {

            String teams = card.select(".event-title").text();
            String league = card.select(".event-league").text();
            String startTime = card.select(".event-time").text();

            String odds = "";
            Elements oddsElements = card.select(".market-odd");
            if (!oddsElements.isEmpty()) {
                odds = oddsElements.get(0).text();
            }

            events.add(new Event(teams, league, startTime, odds));
        }

        return events;
    }
}
