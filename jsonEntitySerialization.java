import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entitySerialization;

import java.io.File;
import java.io.IOException;

public class jsonEntitySerialization implements entitySerialization {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void serialize(Object entity, String fileName) throws IOException {
        objectMapper.writeValue(new File(fileName), entity);
    }

    @Override
    public <T> T deserialize(String fileName, Class<T> entityType) throws IOException {
        return objectMapper.readValue(new File(fileName), entityType);
    }
}
