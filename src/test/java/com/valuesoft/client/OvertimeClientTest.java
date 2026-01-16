package com.valuesoft.client;

import com.valuesoft.model.Event;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Integration test for OvertimeClient using a mocked HttpFetcher.
 */
class OvertimeClientTest {
    @Test
    void fetchEvents_parsesMockedHtml() throws Exception {
        // Arrange: mock HttpFetcher and response
        String html = "<div class='event-card'><div class='event-title'>Mock Team</div><div class='event-league'>Mock League</div><div class='event-time'>2026-01-20</div><div class='market-odd'>Mock=2.0</div></div>";
        HttpFetcher mockFetcher = mock(HttpFetcher.class);
        when(mockFetcher.fetch(anyString())).thenReturn(html);

        OvertimeClient client = new OvertimeClient(mockFetcher);

        // Act
        List<Event> events = client.fetchEvents();

        // Assert
        assertEquals(1, events.size());
        assertEquals("Mock Team", events.get(0).prettyPrint().split("\n")[0].replace("Event: ", ""));
    }
}
