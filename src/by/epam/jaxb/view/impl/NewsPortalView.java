package by.epam.jaxb.view.impl;

import by.epam.jaxb.controller.Request;
import by.epam.jaxb.controller.Response;
import by.epam.jaxb.domain.Category;
import by.epam.jaxb.domain.News;
import by.epam.jaxb.domain.NewsPortal;
import by.epam.jaxb.domain.Subcategory;
import by.epam.jaxb.view.IView;

import java.util.List;

/**
 * Created by Владислав on 28.05.2016.
 */
public class NewsPortalView implements IView {

    @Override
    public Request doUserAction() {
        Request request = new Request();
        request.setAttribute("commandName", "GET_NEWS_PORTAL");
        return request;
    }

    @Override
    public void printAnswer(Response response) {
        boolean status = (boolean) response.getAttribute("status");
        if(!status) {
            System.out.println("Ошибка!");
            return;
        }

        NewsPortal newsPortal = (NewsPortal) response.getAttribute("newsPortal");
        for(Category category : newsPortal.getCategories()) {
            for(Subcategory subcategory : category.getSubcategories()) {
                for(News news : subcategory.getNewses()) {
                    System.out.println("Новость №" + news.getId());
                    System.out.println("Название: " + news.getName());
                    System.out.println("Автор: " + news.getProvider());
                    System.out.println("Дата публикации: " + news.getDateOfIssue());
                    System.out.println("Содержимое: " + news.getBody());
                }
            }
        }

    }

}
