package by.epam.jaxb.view.impl;

import by.epam.jaxb.controller.Request;
import by.epam.jaxb.controller.Response;
import by.epam.jaxb.domain.News;
import by.epam.jaxb.view.IView;

/**
 * Created by Владислав on 28.05.2016.
 */
public class SingleNewsView implements IView {
    @Override
    public Request doUserAction() {
        Request request = new Request();
        request.setAttribute("commandName", "GET_NEWS_BY_CRITERIA");
        request.setAttribute("name", "Тестовая новость");
        return request;
    }

    @Override
    public void printAnswer(Response response) {
        boolean status = (boolean) response.getAttribute("status");
        if(!status) {
            System.out.println("Ошибка");
            return;
        }

        News news = (News) response.getAttribute("news");
        System.out.println("Новость №" + news.getId());
        System.out.println("Название: " + news.getName());
        System.out.println("Автор: " + news.getProvider());
        System.out.println("Дата публикации: " + news.getDateOfIssue());
        System.out.println("Содержимое: " + news.getBody());
    }
}
