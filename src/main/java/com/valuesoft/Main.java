package com.valuesoft;

import com.valuesoft.client.OvertimeClient;
import com.valuesoft.model.Event;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        OvertimeClient client = new OvertimeClient();

        System.out.println("Overtime Markets Parser started...");

        while (true) {
            try {
                List<Event> events = client.fetchEvents();

                System.out.println("\n========= EVENTS =========");

                for (Event e : events) {
                    System.out.println(e.pretty());
                }

            } catch (Exception e) {
                System.err.println("ERROR: " + e.getMessage());
                e.printStackTrace();
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted, shutting down.");
                return;
            }
        }
    }
}
