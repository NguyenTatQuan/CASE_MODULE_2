package model;

public class Staff {
    private double salary;
    private String name;
    private int id;

    public Staff() {
    }

    public Staff(double salary, String name, int id) {
        this.salary = salary;
        this.name = name;
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
