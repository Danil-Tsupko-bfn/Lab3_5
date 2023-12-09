import java.util.*;
import java.util.stream.Collectors;

class car1 implements Comparable<car1> {
    private String brand;
    private int year;
    private double horsepower;

    public car1(String brand, int year, double horsepower) {
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

    @Override
    public int compareTo(car1 otherCar) {
        return Integer.compare(this.year, otherCar.year);
    }
}

public class carService {

    public static void sortByYear(List<car1> cars) {
        cars.sort(Comparator.comparingInt(car1::getYear));
    }

    public static void sortByHorsepower(List<car1> cars) {
        cars.sort(Comparator.comparingDouble(car1::getHorsepower));
    }

    public static void sortByBrandDesc(List<car1> cars) {
        cars.sort(Comparator.comparing(car1::getBrand).reversed());
    }

    public static void main(String[] args) {
        List<car1> cars = new ArrayList<>();
        cars.add(new car1("Toyota", 2022, 200));
        cars.add(new car1("Honda", 2020, 180));
        cars.add(new car1("Ford", 2021, 250));
/**API*/
        sortByYear(cars);
        System.out.println("Sorted by year: " + cars);

        sortByHorsepower(cars);
        System.out.println("Sorted by horsepower: " + cars);

        sortByBrandDesc(cars);
        System.out.println("Sorted by brand (descending): " + cars);


        List<car1> sortedByYear = cars.stream()
                .sorted(Comparator.comparingInt(car1::getYear))
                .collect(Collectors.toList());
        System.out.println("Sorted by year using Stream API: " + sortedByYear);

        List<car1> sortedByHorsepower = cars.stream()
                .sorted(Comparator.comparingDouble(car1::getHorsepower))
                .collect(Collectors.toList());
        System.out.println("Sorted by horsepower using Stream API: " + sortedByHorsepower);

        List<car1> sortedByBrandDesc = cars.stream()
                .sorted(Comparator.comparing(car1::getBrand).reversed())
                .collect(Collectors.toList());
        System.out.println("Sorted by brand (descending) using Stream API: " + sortedByBrandDesc);
    }
}
