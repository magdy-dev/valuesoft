package com.valuesoft.client;


import com.valuesoft.model.Event;
import com.valuesoft.parser.EventParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class OvertimeClient {

    private static final String SITE_URL = "https://www.overtimemarkets.xyz/";

    private final OkHttpClient client = new OkHttpClient();
    private final EventParser parser = new EventParser();

    public List<Event> fetchEvents() throws Exception {

        Request request = new Request.Builder()
                .url(SITE_URL)
                .get()
                .header("User-Agent", "Mozilla/5.0")
                .build();

        try (Response response = client.newCall(request).execute()) {

            if (!response.isSuccessful()) {
                throw new RuntimeException("HTTP error: " + response.code());
            }

            String html = response.body().string();

            Document doc = Jsoup.parse(html);

            return parser.parseHtml(doc);
        }
    }
}
