package by.epam.jaxb.command;

import by.epam.jaxb.controller.Request;
import by.epam.jaxb.controller.Response;

/**
 * Created by Владислав on 28.05.2016.
 */
public interface Command {
    Response execute(Request request);
}
