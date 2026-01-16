package com.valuesoft;

import com.valuesoft.client.OvertimeClient;
import com.valuesoft.client.JavaHttpFetcher;
import com.valuesoft.model.Event;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        OvertimeClient client = new OvertimeClient(new JavaHttpFetcher());

        System.out.println("Overtime Markets Parser started...");

        while (true) {
            try {
                List<Event> events = client.fetchEvents();

                System.out.println("\n========= EVENTS =========");
                for (Event e : events) {
                    System.out.println(e.prettyPrint());
                }

            } catch (Exception e) {
                log.error("Iteration failed", e);
            }

            try {
                // Sleep to avoid busy-waiting; this is intentional for polling every 5 seconds.
                Thread.sleep(5000);
            } catch (InterruptedException ignored) {}
        }
    }
}
