package by.epam.jaxb.view.impl;

import by.epam.jaxb.controller.Request;
import by.epam.jaxb.controller.Response;
import by.epam.jaxb.domain.News;
import by.epam.jaxb.view.IView;

import java.util.List;

/**
 * Created by Владислав on 28.05.2016.
 */
public class NewsesView implements IView{
    @Override
    public Request doUserAction() {
        Request request = new Request();
        request.setAttribute("commandName", "GET_NEWSES_BY_AUTHOR");
        request.setAttribute("author", "Александр Митрофанов");
        return request;
    }

    @Override
    public void printAnswer(Response response) {
        boolean status = (boolean) response.getAttribute("status");
        if(!status){
            System.out.println("Ошибка!");
            return;
        }

        List<News> newses = (List<News>) response.getAttribute("newses");
        for (News news : newses) {
            System.out.println("Новость №" + news.getId());
            System.out.println("Название: " + news.getName());
            System.out.println("Автор: " + news.getProvider());
            System.out.println("Дата публикации: " + news.getDateOfIssue());
            System.out.println("Содержимое: " + news.getBody());
        }
    }
}
