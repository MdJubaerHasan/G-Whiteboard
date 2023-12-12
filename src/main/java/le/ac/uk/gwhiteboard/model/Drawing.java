package le.ac.uk.gwhiteboard.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document
public class Drawing {
    @Id
    private String id; // MongoDB ID

    private Long canvasId; // ID of the canvas this drawing belongs to
    private String data; // The drawing data (could be a JSON string, base64 image data, etc.)
    private LocalDateTime timestamp; // Time when the drawing was saved

    public Drawing() {
        // Default constructor
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCanvasId() {
        return canvasId;
    }

    public void setCanvasId(Long canvasId) {
        this.canvasId = canvasId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
