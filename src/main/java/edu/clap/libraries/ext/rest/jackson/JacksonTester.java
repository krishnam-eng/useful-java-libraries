package edu.clap.libraries.ext.rest.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JacksonTester {
  public static void main(String[] args) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();

    Student student = new Student("bala", 25);
    String valueAsString = objectWriter.writeValueAsString(student);
    System.out.println("valueAsString = " + valueAsString);

    // JsonInclude ---ignore null
    Student studentImmortal = new Student("bala", null);
    String studentImmortalAsString = objectWriter.writeValueAsString(studentImmortal);
    System.out.println("studentImmortalAsString = " + studentImmortalAsString);
  }
}
