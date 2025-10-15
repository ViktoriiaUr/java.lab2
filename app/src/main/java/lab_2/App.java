package lab_2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) {
        JournalService service = new JournalService();

        while (true) {
            System.out.println("\n~~~~~ Menu ~~~~~");
            System.out.println("1. Add record");
            System.out.println("2. Show all records");
            System.out.println("3. Exit");
            System.out.print("Choose the option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    JournalEntry entry = createEntry();
                    service.addEntry(entry);
                    System.out.println("Record is added.");
                    break;
                case "2":
                    if (service.getAllEntries().isEmpty()) {
                        System.out.println("Journal is empty.");
                    } else {
                        System.out.println("\n~~~~~ Journal records ~~~~~");
                        service.getAllEntries().forEach(System.out::println);
                    }
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Incorrect option. Try again.");
            }
        }
    }

    private static JournalEntry createEntry() {
        String surname = inputNonEmpty("Student's surname: ");
        String name = inputNonEmpty("Student's name: ");
        LocalDate birthDate = inputDate("Student's date of birth (dd.mm.yyyy): ");
        String phone = inputPhone("Student's phone number (+380XXXXXXXXX): ");
        String address = inputNonEmpty("Student's home address (street, house, apartment): ");

        return new JournalEntry(surname, name, birthDate, phone, address);
    }

    private static String inputNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty())
                return input;
            System.out.println("Empty input. Please enter a value.");
        }
    }

    private static LocalDate inputDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                String[] parts = input.split("\\.");
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                if (isValidDate(day, month, year)) {
                    return LocalDate.of(year, month, day);
                } else {
                    System.out.println("Incorrect input. Such a date does not exist.");
                }
            } else {
                System.out.println("Incorrect input. Date should be in the format dd.mm.yyyy");
            }
        }
    }

    private static boolean isValidDate(int day, int month, int year) {
        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static String inputPhone(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.matches("\\+380\\d{9}"))
                return input;
            System.out.println("Incorrect input. Phone number should be in the format +380XXXXXXXXX");
        }
    }
}
