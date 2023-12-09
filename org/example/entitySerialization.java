package org.example;

import java.io.IOException;

public interface entitySerialization {

    void serialize(Object entity, String fileName) throws IOException;

    <T> T deserialize(String fileName, Class<T> entityType) throws IOException;

}
