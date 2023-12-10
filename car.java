import java.io.Serializable;

public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    private String brand;
    private int year;
    private double horsepower;

    public Car(String brand, int year, double horsepower) {
        this.brand = brand;
        this.year = year;
        this.horsepower = horsepower;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public double getHorsepower() {
        return horsepower;
    }

    public void startEngine() {
        System.out.println("Engine started for " + brand + " car.");
    }

    public void accelerate() {
        System.out.println("Car is accelerating.");
    }
}
