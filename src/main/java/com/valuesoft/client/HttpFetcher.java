package com.valuesoft.client;

import java.io.IOException;

public interface HttpFetcher {
    String fetch(String url) throws IOException, InterruptedException;
}

