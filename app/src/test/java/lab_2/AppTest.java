package lab_2;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    public void testAddEntry() {
        JournalService service = new JournalService();
        JournalEntry entry = new JournalEntry("Bates", "Evan", LocalDate.of(2000, 5, 10), "+380123456789",
                "Black Street, 12");
        service.addEntry(entry);

        assertEquals(1, service.getAllEntries().size());
        assertEquals(entry, service.getAllEntries().get(0));
    }

    @Test
    public void testPhoneValidation() {
        JournalService service = new JournalService();
        assertTrue(service.isValidPhone("+380123456789"));
        assertFalse(service.isValidPhone("123456789"));
        assertFalse(service.isValidPhone("+38012345"));
    }

    @Test
    public void testDateValidation() {
        JournalService service = new JournalService();
        assertTrue(service.isValidDate(LocalDate.of(2020, 1, 1)));
        assertFalse(service.isValidDate(null));
    }
}
