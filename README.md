# Overtime Markets Event Parser

Java console application that continuously fetches sports events from https://www.overtimemarkets.xyz/ using a pure HTTP client and parses the response without browser automation or paid APIs.

## Features
- Pure HTTP client (no Selenium, no browser automation)
- No API tokens or paid subscriptions
- HTML parsing using Jsoup
- Continuous polling every 5 seconds
- Console output in human-readable format
- Exception-safe infinite loop (application never crashes)
- Logging with SLF4J + Logback
- Maven-based build with fat JAR

## Technology Stack
- Java 17
- Maven
- OkHttp (HTTP client)
- Jsoup (HTML parsing)
- Jackson (optional JSON parsing)
- SLF4J + Logback (logging)
- JUnit 5 (testing)

## Project Structure
- `src/main/java/com/valuesoft/` - Main application source code
  - `Main.java` - Entry point, runs the polling loop
  - `client/OvertimeClient.java` - Fetches event data from overtimemarkets.xyz
  - `parser/EventParser.java` - Parses HTML into Event objects
  - `model/Event.java`, `model/Odd.java` - Data models
- `src/test/java/com/valuesoft/EventParserTest.java` - Unit test for event parsing
- `src/test/resources/eventTest.html` - Sample HTML for tests

## Runtime Behavior
1. Sends HTTP request to https://www.overtimemarkets.xyz/
2. Parses the response HTML
3. Extracts:
   - event title / teams
   - league / sport (if available)
   - start time
   - odds / markets
4. Prints result to console
5. Waits 5 seconds
6. Repeats

If any error occurs:
- Error is logged (message + stacktrace)
- Application continues working

## Error Handling
All network and parsing logic is wrapped in a try/catch block inside the main loop. If an exception occurs:
- Stacktrace is logged
- Application does NOT terminate
- Next iteration continues normally

## LLM Usage
This project does **not** use any Large Language Model (LLM) for its core functionality. All event parsing and data extraction is performed using rule-based HTML parsing with Jsoup. If LLM integration is added in the future, this section will be updated accordingly.

## How to Build and Run
1. Ensure you have Java 17+ and Maven installed.
2. Build the project:
   ```sh
   mvn clean package
   ```
3. Run the application:
   ```sh
   java -jar target/overtime-1.0-SNAPSHOT.jar
   ```

## How to Test
1. Ensure you have Java 17+ and Maven installed.
2. Run tests:
   ```sh
   mvn test
   ```

## Notes
- The application uses Java's built-in HttpClient for HTTP requests.
- Jsoup is used for HTML parsing.
- The test resource `eventTest.html` must be present in `src/test/resources/` for tests to pass.
- If you encounter issues with Maven not being recognized, ensure it is installed and added to your system PATH.
