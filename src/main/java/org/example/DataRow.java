package org.example;

public class DataRow {
    private String first_name;
    private String last_name;
    private String phone;
    private String email;

    public DataRow(String fname, String lname, String phone,String email) {
        this.first_name = fname;
        this.last_name = lname;
        this.phone = phone;
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String fname) {
        this.first_name = fname;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String lname) {
        this.last_name = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
