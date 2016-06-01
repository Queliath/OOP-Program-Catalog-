package by.epam.jaxb.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Владислав on 28.05.2016.
 */
public class Request {
    private Map<String, Object> attributes = new HashMap<>();

    public Request() {
    }

    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }
}
