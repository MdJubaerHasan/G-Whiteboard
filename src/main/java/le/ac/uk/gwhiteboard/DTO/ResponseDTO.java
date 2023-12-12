package le.ac.uk.gwhiteboard.DTO;

public class ResponseDTO {
    private final boolean success;
    private final String message;

    public ResponseDTO(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
}
