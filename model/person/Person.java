package model.person;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {
    private final int id;
    private final String fullName;
    private String address;
    private String phone;
    private String email;
    private final LocalDate dateOfBirth;

            protected Person(int id, String fullName, String address, String phone, String email, LocalDate dateOfBirth) {
            
            if (id < 0){
                throw new IllegalArgumentException("Id should be positive number");
            }
            this.id = id;
            if (dateOfBirth == LocalDate.now()){
                throw new IllegalArgumentException("Invalid date of birth");

            }
            this.dateOfBirth = dateOfBirth;
            
            if (!fullName.matches("^[A-Za-z ]+$")){
                throw new IllegalArgumentException("Fullname must contain only letters and space.");
            }
            this.fullName = fullName;
            if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
                throw new IllegalArgumentException("Invalid email adress.");
            }
            this.email = email;
            this.address = address;
            if (!phone.matches("^\\+?[1-9]\\d{1,14}$")){
                throw new IllegalArgumentException("The phone numbers too short or contains leading zeros or contains letters.");
            }
            this.phone = phone;
        }
    protected Person(int id, String fullName, LocalDate dateOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters
    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public int getAge() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(this.dateOfBirth, today);
        return period.getYears();
    }
    // Setters
    public void setAddress(String address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false; // for subclasses
        Person person = (Person) o;
        return id == person.id; // id is unique
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{");
        sb.append("id=").append(id);
        sb.append(", fullName='").append(fullName).append("'");
        sb.append(", address='").append(address).append("'");
        sb.append(", phone='").append(phone).append("'");
        sb.append(", email='").append(email).append("'");
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append("}");
        return sb.toString();
    }
}    
