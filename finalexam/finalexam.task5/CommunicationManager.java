package finalexam.task5;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class CommunicationManager {

    private String endpoint;
    private final HttpClient httpClient;
    private boolean mockMode = false;

    public CommunicationManager(String endpoint) {
        this.endpoint = endpoint;
        this.httpClient = HttpClient.newHttpClient();
    }

    public String sendUserMessage(String message) {
        if (mockMode) {
            return "Mock response: Hello, I'm a chatbot!";
        }

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(createJsonPayload(message)))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return response.body();
            } else {
                return "Error: HTTP " + response.statusCode() + " - " + response.body();
            }
        } catch (Exception e) {
            return "Error: " + (e.getMessage() != null ? e.getMessage() : e.getClass().getName());
        }
    }

    private String createJsonPayload(String message) {
        return String.format("{\"message\": \"%s\"}", escapeJson(message));
    }

    private String escapeJson(String input) {
        return input.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\b", "\\b")
                .replace("\f", "\\f")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setMockMode(boolean mockMode) {
        this.mockMode = mockMode;
    }
}
