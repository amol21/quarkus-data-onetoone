package org.data.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Laptop extends PanacheEntity {
    String name;
    String brand;
    String ram;
    String externalStorage;

    public Laptop() {
    }

    public Laptop(String name, String brand, String ram, String externalStorage) {
        this.name = name;
        this.brand = brand;
        this.ram = ram;
        this.externalStorage = externalStorage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getExternalStorage() {
        return externalStorage;
    }

    public void setExternalStorage(String externalStorage) {
        this.externalStorage = externalStorage;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", ram='" + ram + '\'' +
                ", externalStorage='" + externalStorage + '\'' +
                '}';
    }
}
