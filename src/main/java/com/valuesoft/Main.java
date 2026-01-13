package com.valuesoft;

import com.valuesoft.client.OvertimeClient;
import com.valuesoft.model.Event;
import com.valuesoft.parser.EventParser;
import com.valuesoft.util.Sleeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        OvertimeClient client = new OvertimeClient();
        EventParser parser = new EventParser();

        while (true) {
            try {
                // Fetch HTML from the site
                String html = client.loadPage();

                // Parse HTML to get list of events
                List<Event> events = parser.parse(html);

                System.out.println("====================================");
                System.out.println("Events found: " + events.size());

                for (Event event : events) {
                    System.out.println(event.prettyPrint());
                }

            } catch (Exception e) {
                log.error("Error during iteration", e);
            }

            // Wait 5 seconds before next iteration
            Sleeper.sleepSeconds(5);
        }
    }
}
