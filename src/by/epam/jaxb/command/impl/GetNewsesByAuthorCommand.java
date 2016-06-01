package by.epam.jaxb.command.impl;

import by.epam.jaxb.command.Command;
import by.epam.jaxb.controller.Request;
import by.epam.jaxb.controller.Response;
import by.epam.jaxb.domain.News;
import by.epam.jaxb.service.INewsPortalService;
import by.epam.jaxb.service.exception.ServiceException;
import by.epam.jaxb.service.factory.NewsPortalServiceFactory;

import java.util.List;

/**
 * Created by Владислав on 28.05.2016.
 */
public class GetNewsesByAuthorCommand implements Command {
    @Override
    public Response execute(Request request) {
        String author = (String) request.getAttribute("author");

        NewsPortalServiceFactory newsPortalServiceFactory = NewsPortalServiceFactory.getInstance();
        INewsPortalService iNewsPortalService = newsPortalServiceFactory.getNewsPortalService();

        Response response = new Response();
        try {
            List<News> newses = iNewsPortalService.getNewsesByCriteria(author);
            response.setAttribute("newses", newses);
            response.setAttribute("status", true);
        } catch (ServiceException e) {
            e.printStackTrace();
            response.setAttribute("status", false);
        }
        return response;
    }
}
