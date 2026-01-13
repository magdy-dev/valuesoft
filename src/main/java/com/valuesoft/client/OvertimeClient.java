package com.valuesoft.client;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

;

public class OvertimeClient {

    private static final String JSON_URL = "https://www.overtimemarkets.xyz/api/events"; // example

    private final OkHttpClient client = new OkHttpClient();

    public String loadJson() throws Exception {

        Request request = new Request.Builder()
                .url(JSON_URL)
                .header("User-Agent", "Mozilla/5.0")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("HTTP error: " + response.code());
            }
            return response.body().string();
        }
    }

    public String loadPage() {
        Request request = new Request.Builder()
                .url("https://www.overtimemarkets.xyz/")
                .header("User-Agent", "Mozilla/5.0")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("HTTP error: " + response.code());
            }
            return response.body().string();
        } catch (Exception e) {
            throw new RuntimeException("Error loading page", e);
        }
    }
}
