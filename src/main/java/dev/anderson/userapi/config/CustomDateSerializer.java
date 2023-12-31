package dev.anderson.userapi.config;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CustomDateSerializer extends StdSerializer<LocalDate> {

  private static final long serialVersionUID = 1L;

  private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public CustomDateSerializer() {
    this(null);
  }

  public CustomDateSerializer(Class<LocalDate> t) {
    super(t);
  }

  @Override
  public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
    gen.writeString(formatter.format(value));

  }

}
