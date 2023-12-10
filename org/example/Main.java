package org.example;

class Car2 {
    private String brand;
    private int year;
    private double horsepower;

    private Car2(Builder builder) {
        this.brand = builder.brand;
        this.year = builder.year;
        this.horsepower = builder.horsepower;
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

    public static class Builder {
        private static final int MIN_YEAR = 1900;
        private static final int MAX_YEAR = 2100;
        private static final double MIN_HORSEPOWER = 0;

        private String brand;
        private int year;
        private double horsepower;

        public Builder brand(String brand) {
            if (brand == null || brand.isEmpty()) {
                throw new IllegalArgumentException("Brand cannot be null or empty.");
            }
            this.brand = brand;
            return this;
        }

        public Builder year(int year) {
            if (year < MIN_YEAR || year > MAX_YEAR) {
                throw new IllegalArgumentException("Invalid year. Must be between " + MIN_YEAR + " and " + MAX_YEAR);
            }
            this.year = year;
            return this;
        }

        public Builder horsepower(double horsepower) {
            if (horsepower < MIN_HORSEPOWER) {
                throw new IllegalArgumentException("Invalid horsepower. Must be greater than or equal to " + MIN_HORSEPOWER);
            }
            this.horsepower = horsepower;
            return this;
        }

        public Car2 build() {
            validate(); 
            return new Car2(this);
        }

        private void validate() {

            if (brand == null || brand.isEmpty()) {
                throw new IllegalArgumentException("Brand cannot be null or empty.");
            }
        }
    }

    public static void main(String[] args) {

        Car2 car = new Car2.Builder()
                .brand("Toyota")
                .year(2022)
                .horsepower(200)
                .build();

        System.out.println("Car details: Brand=" + car.getBrand() +
                ", Year=" + car.getYear() +
                ", Horsepower=" + car.getHorsepower());
    }
}
