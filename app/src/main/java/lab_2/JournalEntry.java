package lab_2;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class JournalEntry implements Serializable {
    private String surname;
    private String name;
    private LocalDate birthDate;
    private String phone;
    private String address;

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
                surname, name, birthDate, phone, address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof JournalEntry))
            return false;
        JournalEntry that = (JournalEntry) o;
        return Objects.equals(surname, that.surname) &&
                Objects.equals(name, that.name) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, birthDate, phone, address);
    }
}
