import java.util.regex.Pattern;

class val {
    private String brand;
    private int year;
    private double horsepower;

    private val(Builder builder) {
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
        private static final double MAX_HORSEPOWER = 1000;
        private static final Pattern BRAND_PATTERN = Pattern.compile("[A-Za-z0-9]+");

        private String brand;
        private int year;
        private double horsepower;

        public Builder brand(String brand) {
            if (brand == null || !BRAND_PATTERN.matcher(brand).matches()) {
                throw new IllegalArgumentException("Invalid brand: " + brand);
            }
            this.brand = brand;
            return this;
        }

        public Builder year(int year) {
            if (year < MIN_YEAR || year > MAX_YEAR) {
                throw new IllegalArgumentException("Invalid year: " + year + ". Must be between " + MIN_YEAR + " and " + MAX_YEAR);
            }
            this.year = year;
            return this;
        }

        public Builder horsepower(double horsepower) {
            if (horsepower < MIN_HORSEPOWER || horsepower > MAX_HORSEPOWER) {
                throw new IllegalArgumentException("Invalid horsepower: " + horsepower + ". Must be between " + MIN_HORSEPOWER + " and " + MAX_HORSEPOWER);
            }
            this.horsepower = horsepower;
            return this;
        }

        public val build() {
            validate();
            return new val(this);
        }

        private void validate() {
            if (brand == null || !BRAND_PATTERN.matcher(brand).matches()) {
                throw new IllegalArgumentException("Invalid brand: " + brand);
            }
            if (year < MIN_YEAR || year > MAX_YEAR) {
                throw new IllegalArgumentException("Invalid year: " + year + ". Must be between " + MIN_YEAR + " and " + MAX_YEAR);
            }
            if (horsepower < MIN_HORSEPOWER || horsepower > MAX_HORSEPOWER) {
                throw new IllegalArgumentException("Invalid horsepower: " + horsepower + ". Must be between " + MIN_HORSEPOWER + " and " + MAX_HORSEPOWER);
            }
        }
    }

    public static void main(String[] args) {

        try {
            val car = new val.Builder()
                    .brand("Toyota")
                    .year(2022)
                    .horsepower(200)
                    .build();

            System.out.println("Car details: Brand=" + car.getBrand() +
                    ", Year=" + car.getYear() +
                    ", Horsepower=" + car.getHorsepower());
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating car: " + e.getMessage());
        }
    }
}
