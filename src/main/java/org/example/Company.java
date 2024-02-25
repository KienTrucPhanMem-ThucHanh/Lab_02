package org.example;

public class Company {
    private long comp_id;
    private String comp_name;
    private String address;

    public Company() {
    }

    public Company(long comp_id, String comp_name, String address) {
        this.comp_id = comp_id;
        this.comp_name = comp_name;
        this.address = address;
    }

    public long getComp_id() {
        return comp_id;
    }

    public void setComp_id(long comp_id) {
        this.comp_id = comp_id;
    }

    public String getComp_name() {
        return comp_name;
    }

    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "comp_id=" + comp_id +
                ", comp_name='" + comp_name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
