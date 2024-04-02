package model;

public class Animal {
    private String name;
    private String type;
    private int id;
    private int area;

    public Animal() {
    }

    public Animal(String name, String type, int id, int area) {
        this.name = name;
        this.type = type;
        this.id = id;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", area=" + area +
                '}';
    }
}