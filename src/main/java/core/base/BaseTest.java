package core.base;

import java.io.IOException;
import java.io.InputStream;
import java.lang.module.Configuration;
import java.util.Properties;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    protected static String baseUrl;

    @BeforeEach
    public void setup() throws IOException {
        baseUrl = determineBaseUrl();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920х1080";
    }

    private static String determineBaseUrl() throws IOException {
        String environment = System.getProperty("env", "test");
        String configFileName = "application-" + environment + ".properties";

        Properties properties = new Properties();
        try (InputStream input = BaseTest.class.getClassLoader().getResourceAsStream(configFileName)) {
            if (input == null) {
                throw new IllegalStateException("Configuration file not found:" + configFileName);
            }
            properties.load(input);
        }catch(Exception e) {
            throw new IllegalStateException("Unable to load configuration file: " + configFileName,e);
        }
        return properties.getProperty("baseUrl");
    }

    public String getBaseUrl(){
    return baseUrl;
    }

    @AfterEach
    public void tearDown(){
        closeWebDriver();
    }

}
