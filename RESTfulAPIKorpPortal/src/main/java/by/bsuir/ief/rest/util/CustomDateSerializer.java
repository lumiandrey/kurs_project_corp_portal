package by.bsuir.ief.rest.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

/**
 * Created by Vladislav on 08.05.2016.
 */
public class CustomDateSerializer extends JsonSerializer<DateTime> {

    private static DateTimeFormatter formatter =
            DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss");

    @Override
    public void serialize(DateTime value, JsonGenerator gen,
                          SerializerProvider arg2)
            throws IOException, JsonProcessingException {

        gen.writeString(formatter.print(value));
    }
}