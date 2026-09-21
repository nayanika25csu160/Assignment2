public class DeviceRecord {
    private String deviceId;
    private String timestamp;
    private int statusCode;
    private String message;

    public DeviceRecord(String deviceId, String timestamp,
                        int statusCode, String message)
            throws InvalidRecordException {

        if (deviceId == null || deviceId.trim().isEmpty()) {
            throw new InvalidRecordException("Device ID cannot be empty.");
        }
        if timestamp == null || timestamp.trim().isEmpty()) {
            throw new InvalidRecordException("Timestamp cannot be empty.");
        }

        if (message == null || message.trim().isEmpty()) {
            throw new InvalidRecordException("Message cannot be empty.");
        }
        if (statusCode < 100 || statusCode > 599) {
            throw new InvalidRecordException(
                    "Status code must be between 100 and 599.");
        }
        this.deviceId = deviceId;
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return deviceId + " | " + timestamp + " | "
                + statusCode + " | " + message;
    }
}
