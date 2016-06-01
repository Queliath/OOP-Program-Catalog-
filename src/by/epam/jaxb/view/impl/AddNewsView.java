package by.epam.jaxb.view.impl;

import by.epam.jaxb.controller.Request;
import by.epam.jaxb.controller.Response;
import by.epam.jaxb.util.XMLCalendarToDate;
import by.epam.jaxb.view.IView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Владислав on 28.05.2016.
 */
public class AddNewsView implements IView {
    @Override
    public Request doUserAction() {
        Request request = new Request();
        request.setAttribute("commandName", "ADD_NEWS");
        request.setAttribute("id", 10);
        request.setAttribute("name", "Тестовая новость");
        request.setAttribute("dateOfIssue", XMLCalendarToDate.toXMLGregorianCalendar(new Date()));
        List<String> provider = new ArrayList<>();
        provider.add("Тестовый автор");
        request.setAttribute("provider", provider);
        request.setAttribute("body", "Содержимое тестовой новости");
        request.setAttribute("subcategoryId", 4);
        request.setAttribute("categoryId", 2);
        return request;
    }

    @Override
    public void printAnswer(Response response) {
        boolean status = (boolean) response.getAttribute("status");
        if(!status) {
            System.out.println("Ошибка!");
            return;
        }

        System.out.println("Добавление новости прошло успешно!");
    }
}
