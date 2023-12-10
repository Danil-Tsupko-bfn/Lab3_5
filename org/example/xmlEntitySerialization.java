package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XmlEntitySerialization implements EntitySerialization {

    private final XmlMapper xmlMapper = new XmlMapper();

    @Override
    public void serialize(Object entity, String fileName) throws IOException {
        xmlMapper.writeValue(new File(fileName), entity);
    }

    @Override
    public <T> T deserialize(String fileName, Class<T> entityType) throws IOException {
        return xmlMapper.readValue(new File(fileName), entityType);
    }
}

