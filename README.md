Overtime Markets Event Parser

Java console application that continuously fetches sports events from
https://www.overtimemarkets.xyz/
using a pure HTTP client and parses the response without browser automation or paid APIs.

The application runs in an infinite loop, prints available events to the console and refreshes data every 5 seconds.

Features

Pure HTTP client (no Selenium, no browser automation)

No API tokens or paid subscriptions

HTML parsing using Jsoup

Continuous polling every 5 seconds

Console output in human-readable format

Exception-safe infinite loop (application never crashes)

Logging with SLF4J + Logback

Maven-based build with fat JAR

Technology Stack

Java 17

Maven

OkHttp (HTTP client)

Jsoup (HTML parsing)

Jackson (optional JSON parsing)

SLF4J + Logback (logging)

JUnit 5 (testing)

Project Structure


Runtime Behavior

Sends HTTP request to https://www.overtimemarkets.xyz/

Parses the response HTML

Extracts:

event title / teams

league / sport (if available)

start time

example odds / markets

Prints result to console

Waits 5 seconds

Repeats

If any error occurs:

error is logged (message + stacktrace)

application continues working

Error Handling

All network and parsing logic is wrapped in a try/catch block inside the main loop.

If an exception occurs:

stacktrace is logged

application does NOT terminate

next iteration continues normally