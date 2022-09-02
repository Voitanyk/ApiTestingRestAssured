import java.io.FileInputStream;
import java.io.IOException;

public class Properties {
    public String getValue(String propertyKey) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/application.properties");
        java.util.Properties properties = new java.util.Properties();
        properties.load(fileInputStream);
        return properties.getProperty(propertyKey);

    }

}
