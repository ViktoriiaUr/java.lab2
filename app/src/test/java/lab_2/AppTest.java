package lab_2;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Test
    public void testAddEntry() {
        JournalService service = new JournalService();
        JournalEntry entry = new JournalEntry("Bates", "Evan", LocalDate.of(2000, 7, 10), "+380123456789",
                "Black Street, 12, 5");
        service.addEntry(entry);

        assertEquals(1, service.getAllEntries().size());
        assertEquals(entry, service.getAllEntries().get(0));

        String expectedDate = entry.getBirthDate().format(DATE_FORMATTER);
        assertTrue(service.getAllEntries().get(0).toString().contains(expectedDate));
    }

    @Test
    public void testPhoneValidation() {
        JournalService service = new JournalService();
        assertTrue(service.isValidPhone("+380123456789"));
        assertFalse(service.isValidPhone("123456789"));
        assertFalse(service.isValidPhone("+38012345"));
        assertFalse(service.isValidPhone("+12345678901"));
    }

    @Test
    public void testDateValidation() {
        JournalService service = new JournalService();
        assertTrue(service.isValidDate(LocalDate.of(2020, 1, 1)));
        assertFalse(service.isValidDate(null));
    }

    @Test
    public void testMultipleEntries() {
        JournalService service = new JournalService();

        JournalEntry entry1 = new JournalEntry("Chock", "Medison", LocalDate.of(1999, 12, 12), "+380664589231",
                "Bees St, 1, 45");
        JournalEntry entry2 = new JournalEntry("Gilles", "Piper", LocalDate.of(2000, 7, 5), "+380504526917",
                "Selon street, 5, 96");

        service.addEntry(entry1);
        service.addEntry(entry2);

        assertEquals(2, service.getAllEntries().size());
        assertEquals(entry1, service.getAllEntries().get(0));
        assertEquals(entry2, service.getAllEntries().get(1));
    }

}
