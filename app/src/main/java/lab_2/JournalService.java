package lab_2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JournalService {
    private final List<JournalEntry> entries = new ArrayList<>();

    public void addEntry(JournalEntry entry) {
        entries.add(entry);
    }

    public List<JournalEntry> getAllEntries() {
        return new ArrayList<>(entries);
    }

    // Checking date format (dd.mm.yyyy)
    public boolean isValidDate(LocalDate date) {
        return date != null;
    }

    // Checking phone format (+380XXXXXXXXX)
    public boolean isValidPhone(String phone) {
        return phone.matches("\\+380\\d{9}");
    }
}
