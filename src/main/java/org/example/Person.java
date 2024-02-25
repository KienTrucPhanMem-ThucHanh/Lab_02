package org.example;

public class Person {
    private long id;
    private String name;
    private  String phone;

    private Company company;

    public Person() {
    }

    public Person(long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Person(long id, String name, String phone, Company company) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", company=" + company +
                '}';
    }
}
