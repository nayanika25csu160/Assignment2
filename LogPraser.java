import java.util.Map;

public class LogParser {

    public DeviceRecord parseFromCsvLine(String line)
            throws InvalidRecordException {

        if (line == null || line.trim().isEmpty()) {
            throw new InvalidRecordException("Record is empty.");
        }

        String[] parts = line.split(",", 4);

        if (parts.length != 4) {
            throw new InvalidRecordException(
                    "Record must contain 4 fields.");
        }

        String deviceId = parts[0].trim();
        String timestamp = parts[1].trim();
        String statusText = parts[2].trim();
        String message = parts[3].trim();

        int statusCode;

        try {
            statusCode = Integer.parseInt(statusText);
        } catch (NumberFormatException e) {
            throw new InvalidRecordException(
                    "Status code must be a number.");
        }

        return new DeviceRecord(
                deviceId,
                timestamp,
                statusCode,
                message
        );
    }

    public DeviceRecord parseFromMap(Map<String, String> data)
            throws InvalidRecordException {

        if (data == null) {
            throw new InvalidRecordException("Map cannot be null.");
        }

        String deviceId = data.get("deviceId");
        String timestamp = data.get("timestamp");
        String statusText = data.get("statusCode");
        String message = data.get("message");

        if (deviceId == null ||
            timestamp == null ||
            statusText == null ||
            message == null) {

            throw new InvalidRecordException(
                    "Map is missing required fields.");
        }

        int statusCode;

        try {
            statusCode = Integer.parseInt(statusText);
        } catch (NumberFormatException e) {
            throw new InvalidRecordException(
                    "Status code must be a number.");
        }

        return new DeviceRecord(
                deviceId,
                timestamp,
                statusCode,
                message
        );
    }
}
