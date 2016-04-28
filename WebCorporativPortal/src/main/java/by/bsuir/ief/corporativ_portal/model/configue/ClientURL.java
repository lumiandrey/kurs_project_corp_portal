package by.bsuir.ief.corporativ_portal.model.configue;

import java.util.ResourceBundle;

public class ClientURL {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config.urlclient");
    private ClientURL() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
