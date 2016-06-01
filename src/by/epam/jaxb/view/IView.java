package by.epam.jaxb.view;

import by.epam.jaxb.controller.Request;
import by.epam.jaxb.controller.Response;

/**
 * Created by Владислав on 28.05.2016.
 */
public interface IView {
    Request doUserAction();
    void printAnswer(Response response);
}
