package lab_2;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JournalEntry implements Serializable {
    private String surname;
    private String name;
    private LocalDate birthDate;
    private String phone;
    private String address;
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public JournalEntry(String surname, String name, LocalDate birthDate, String phone, String address) {
        this.surname = surname;
        this.name = name;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return String.format("Student: %s %s, Date of birth: %s, Phone: %s, Address: %s",
                surname, name, birthDate.format(dateFormatter), phone, address);
    }
}
