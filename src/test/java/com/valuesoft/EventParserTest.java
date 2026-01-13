package com.valuesoft;



import com.valuesoft.model.Event;
import com.valuesoft.parser.EventParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EventParserTest {

    @Test
    void shouldParseEventsFromHtml() {

        String html = """
            <html>
                <body>
                    <div class="event-card">
                        <div class="title">Team A vs Team B</div>
                        <div class="league">Premier League</div>
                        <div class="start-time">18:00</div>
                        <div class="odd">1.85</div>
                        <div class="odd">2.10</div>
                    </div>
                </body>
            </html>
        """;

        EventParser parser = new EventParser();
        List<Event> events = parser.parse(html);

        assertEquals(1, events.size());

        Event event = events.get(0);
        assertEquals("Team A vs Team B", event.getTitle());
        assertEquals("Premier League", event.getLeague());
        assertEquals("18:00", event.getStartTime());
    }
}
