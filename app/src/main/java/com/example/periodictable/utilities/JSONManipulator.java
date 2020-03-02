package com.example.periodictable.utilities;

import com.example.periodictable.model.Element;
import com.example.periodictable.model.ElementBag;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public final class JSONManipulator {
    private JSONManipulator() {
        throw new IllegalStateException("Do not instantiate");
    }

    private static String convertFromStreamToString(InputStream asset) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(asset));
        StringBuilder json = new StringBuilder();
        for (String line; (line = bufferedReader.readLine()) != null; ) {
            json.append(line);
        }
        return json.toString();
    }

    private static ElementBag parseJSON(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        ElementBag elementBag = null;
        try {
            elementBag = objectMapper.readValue(json, ElementBag.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return elementBag;
    }

    public static List<Element> getListOfElements(InputStream asset) throws IOException {
        String json = convertFromStreamToString(asset);
        ElementBag elementBag = parseJSON(json);
        return elementBag.getElements();
    }
}
