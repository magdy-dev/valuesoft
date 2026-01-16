package com.valuesoft.client;

import com.valuesoft.model.Event;
import com.valuesoft.parser.EventParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

/**
 * Client for fetching and parsing events from overtimemarkets.xyz.
 */
public class OvertimeClient {
    private final HttpFetcher fetcher;

    public OvertimeClient(HttpFetcher fetcher) {
        this.fetcher = fetcher;
    }

    /**
     * Fetches events from overtimemarkets.xyz and parses them.
     * @return List of Event objects parsed from the site
     * @throws IOException if network or parsing fails
     * @throws InterruptedException if the request is interrupted
     */
    public List<Event> fetchEvents() throws IOException, InterruptedException {
        String html = fetcher.fetch("https://www.overtimemarkets.xyz/");
        Document doc = Jsoup.parse(html);
        EventParser parser = new EventParser();
        return parser.parseHtml(doc);
    }
}
