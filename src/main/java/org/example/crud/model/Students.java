package org.example.crud.model;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Students {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY
    )

    private int id;
    private String name;
    private String address;
    private String age;


    public Students(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                '}';
    }


}





