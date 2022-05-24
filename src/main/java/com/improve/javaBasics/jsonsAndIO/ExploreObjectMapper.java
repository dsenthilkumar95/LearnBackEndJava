package com.improve.javaBasics.jsonsAndIO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.improve.javaBasics.Child;

public class ExploreObjectMapper {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Child child = objectMapper.readValue("", Child.class);
        System.out.println(child);
    }
}
