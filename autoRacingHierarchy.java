import org.example.xmlEntitySerialization;

import java.io.IOException;

public class autoRacingHierarchy {
    public static void main(String[] args) {
        formula1Car formula1Car = new formula1Car("Mercedes", 2022, 1000, 500);
        StreetCar streetCar = new StreetCar("Toyota", 2022, 200, true);

        jsonEntitySerialization jsonSerialization = new jsonEntitySerialization();
        try {
            jsonSerialization.serialize(formula1Car, "formula1car.json");
            formula1Car deserializedFormula1Car = jsonSerialization.deserialize("formula1car.json", formula1Car.class);
            System.out.println("Deserialized Formula 1 Car: " + deserializedFormula1Car.getBrand());
        } catch (IOException e) {
            e.printStackTrace();
        }

        xmlEntitySerialization xmlSerialization = new xmlEntitySerialization();
        try {
            xmlSerialization.serialize(streetCar, "streetcar.xml");
            StreetCar deserializedStreetCar = xmlSerialization.deserialize("streetcar.xml", StreetCar.class);
            System.out.println("Deserialized Street Car: " + deserializedStreetCar.getBrand());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
