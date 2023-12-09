public class StreetCar extends car1 {
    private boolean hasAirConditioning;

    public StreetCar(String brand, int year, double horsepower, boolean hasAirConditioning) {
        super(brand, year, horsepower);
        this.hasAirConditioning = hasAirConditioning;
    }

    public boolean hasAirConditioning() {
        return hasAirConditioning;
    }

    @Override
    public void accelerate() {
        System.out.println("Street car is accelerating on regular roads.");
    }

    public void honkHorn() {
        System.out.println("Street car is honking the horn.");
    }

    public String getBrand() {
        return null;
    }
}
