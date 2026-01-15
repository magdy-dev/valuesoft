package com.valuesoft.parser;

import com.valuesoft.model.Event;

import java.util.ArrayList;
import java.util.List;

import com.valuesoft.model.Odd;
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

            List<Odd> oddList = new ArrayList<>();
            if (!odds.isEmpty()) {
                String[] parts = odds.split(" ");
                for (String part : parts) {
                    String[] sideAndPrice = part.split("=");
                    if (sideAndPrice.length == 2) {
                        oddList.add(new Odd(sideAndPrice[0].trim(), Double.parseDouble(sideAndPrice[1].trim())));
                    }
                }
            }

            events.add(new Event(teams, league, startTime, oddList));
        }
        return events;
    }
}
