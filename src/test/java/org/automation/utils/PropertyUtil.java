package org.automation.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class PropertyUtil {
    private static final Properties PROPERTIES = new Properties();
    private static final String SOURCE_FILE = "application.properties";

    private PropertyUtil() {
    }

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (InputStream input = PropertyUtil.class.getClassLoader().getResourceAsStream(SOURCE_FILE)) {

            if (input == null)
                throw new RuntimeException("File application.properties wasn't found " + SOURCE_FILE);

            PROPERTIES.load(input);
            log.info("Properties successfully loaded");
        } catch (IOException ex) {
            log.error("An error occurs during reading properties, {}", ex.getMessage());
        }
    }

    public static String get(String key) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException(String.format("Key cannot be empty or null: %s", key));
        }
        String value = PROPERTIES.getProperty(key);

        if (value == null) {
            throw new IllegalArgumentException(String.format("Key wasn't found -> key: %s", key));
        }
        return value;
    }
}
