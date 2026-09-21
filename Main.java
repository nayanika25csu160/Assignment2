import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = null;

        try {

            scanner = new Scanner(System.in);

            List<DeviceRecord> records = new ArrayList<>();

            LogParser parser = new LogParser();

            loadRecords(parser, records);

            Analyzer analyzer = new Analyzer(records);

            int choice;

            do {

                System.out.println("\n===== DEVICE LOG ANALYZER =====");
                System.out.println("1. List all records");
                System.out.println("2. Count records by status code");
                System.out.println("3. Find records for a device");
                System.out.println("4. Show statistics");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");

                try {

                    choice = scanner.nextInt();
                    scanner.nextLine();

                } catch (Exception e) {

                    System.out.println("Please enter a valid number.");
                    scanner.nextLine();
                    choice = 0;
                    continue;
                }

                // Switch statement
                switch (choice) {

                    case 1:
                        analyzer.listRecords();
                        break;

                    case 2:
                        analyzer.countByStatus();
                        break;

                    case 3:

                        System.out.print("Enter device ID: ");
                        String deviceId = scanner.nextLine();

                        analyzer.findByDevice(deviceId);
                        break;

                    case 4:
                        analyzer.showStatistics();
                        break;

                    case 5:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } while (choice != 5);

        } catch (FileNotFoundException e) {

            System.out.println("Log file not found: "
                    + e.getMessage());

        } finally {

            if (scanner != null) {
                scanner.close();
            }

            System.out.println("Resources cleaned up.");
        }
    }

    public static void loadRecords(
            LogParser parser,
            List<DeviceRecord> records)
            throws FileNotFoundException {

        File file = new File("data/logs.txt");

        Scanner fileScanner = new Scanner(file);

        try {

            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();

                try {

                    DeviceRecord record =
                            parser.parseFromCsvLine(line);

                    records.add(record);

                } catch (InvalidRecordException e) {

                    System.out.println(
                            "Skipping invalid record: "
                            + e.getMessage());
                }
            }

        } finally {

            fileScanner.close();
        }
    }
}
