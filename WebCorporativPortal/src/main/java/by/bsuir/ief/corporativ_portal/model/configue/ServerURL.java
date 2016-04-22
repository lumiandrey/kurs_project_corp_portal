package by.bsuir.ief.corporativ_portal.model.configue;

import java.util.ResourceBundle;

public class ServerURL {
        private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.config.urlrest");
        private ServerURL() { }
        public static String getProperty(String key) {
            return resourceBundle.getString(key);
        }
}
