import org.example.XmlEntitySerialization;

import java.io.IOException;

public class AutoRacingHierarchy {
    public static void main(String[] args) {
        Formula1Car formula1Car = new Formula1Car("Mercedes", 2022, 1000, 500);
        StreetCar streetCar = new StreetCar("Toyota", 2022, 200, true);

        JsonEntitySerialization jsonSerialization = new JsonEntitySerialization();
        try {
            jsonSerialization.serialize(formula1Car, "formula1car.json");
            Formula1Car deserializedFormula1Car = jsonSerialization.deserialize("formula1car.json", Formula1Car.class);
            System.out.println("Deserialized Formula 1 Car: " + deserializedFormula1Car.getBrand());
        } catch (IOException e) {
            e.printStackTrace();
        }

        XmlEntitySerialization xmlSerialization = new XmlEntitySerialization();
        try {
            xmlSerialization.serialize(streetCar, "streetcar.xml");
            StreetCar deserializedStreetCar = xmlSerialization.deserialize("streetcar.xml", StreetCar.class);
            System.out.println("Deserialized Street Car: " + deserializedStreetCar.getBrand());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
