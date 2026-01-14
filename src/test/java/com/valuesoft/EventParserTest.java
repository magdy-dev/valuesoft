package com.valuesoft;

import com.valuesoft.model.Event;
import com.valuesoft.parser.EventParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventParserTest {

    @Test
    void shouldParseEventsFromHtml() throws Exception {

        // Load sample HTML from resources
        InputStream is = getClass().getClassLoader().getResourceAsStream("eventTest.html");
        assertNotNull(is, "eventTest.html not found in test resources");

        String html = new String(is.readAllBytes(), StandardCharsets.UTF_8);
        Document doc = Jsoup.parse(html);

        EventParser parser = new EventParser();
        List<Event> events = parser.parseHtml(doc);

        assertEquals(2, events.size());

        Event first = events.get(0);
        assertTrue(first.pretty().contains("Team A vs Team B"));
        assertTrue(first.pretty().contains("NBA"));
        assertTrue(first.pretty().contains("2026-01-14"));
        assertTrue(first.pretty().contains("1.85"));
    }
}
