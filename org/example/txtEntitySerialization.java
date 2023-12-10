package org.example;

import java.io.*;

public class TxtEntitySerialization implements EntitySerialization {

    @Override
    public void serialize(Object entity, String fileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(entity);
        }
    }

    @Override
    public <T> T deserialize(String fileName, Class<T> entityType) throws IOException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return entityType.cast(inputStream.readObject());
        } catch (ClassNotFoundException e) {
            throw new IOException("Error during deserialization", e);
        }
    }
}
