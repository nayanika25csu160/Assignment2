import java.util.ArrayList;
import java.util.List;

public class Analyzer {

    private List<DeviceRecord> records;

    public Analyzer(List<DeviceRecord> records) {
        this.records = records;
    }

    // Option 1: Enhanced-for loop
    public void listRecords() {

        System.out.println("\n--- All Records ---");

        if (records.isEmpty()) {
            System.out.println("No valid records available.");
            return;
        }

        for (DeviceRecord record : records) {
            System.out.println(record);
        }
    }

    // Option 2: Traditional for loop
    public void countByStatus() {

        System.out.println("\n--- Count By Status Code ---");

        if (records.isEmpty()) {
            System.out.println("No records available.");
            return;
        }

        ArrayList<Integer> statusCodes = new ArrayList<>();

        for (int i = 0; i < records.size(); i++) {

            int code = records.get(i).getStatusCode();

            if (!statusCodes.contains(code)) {
                statusCodes.add(code);
            }
        }

        for (int i = 0; i < statusCodes.size(); i++) {

            int code = statusCodes.get(i);
            int count = 0;

            for (int j = 0; j < records.size(); j++) {

                if (records.get(j).getStatusCode() == code) {
                    count++;
                }
            }

            System.out.println(code + " : " + count + " record(s)");
        }
    }

    // Option 3: while loop
    public void findByDevice(String deviceId) {

        System.out.println("\n--- Records For Device: "
                + deviceId + " ---");

        int i = 0;
        boolean found = false;

        while (i < records.size()) {

            DeviceRecord record = records.get(i);

            if (record.getDeviceId().equalsIgnoreCase(deviceId)) {
                System.out.println(record);
                found = true;
            }

            i++;
        }

        if (!found) {
            System.out.println("No records found.");
        }
    }

    // Option 4: while loop for statistics
    public void showStatistics() {

        System.out.println("\n--- Statistics ---");

        if (records.isEmpty()) {
            System.out.println("No records available.");
            return;
        }

        String earliest = records.get(0).getTimestamp();
        String latest = records.get(0).getTimestamp();

        int i = 1;

        while (i < records.size()) {

            String current = records.get(i).getTimestamp();

            if (current.compareTo(earliest) < 0) {
                earliest = current;
            }

            if (current.compareTo(latest) > 0) {
                latest = current;
            }

            i++;
        }

        System.out.println("Earliest timestamp: " + earliest);
        System.out.println("Latest timestamp: " + latest);
    }
}
