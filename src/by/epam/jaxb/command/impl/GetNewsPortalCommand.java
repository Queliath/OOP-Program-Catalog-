package by.epam.jaxb.command.impl;

import by.epam.jaxb.command.Command;
import by.epam.jaxb.controller.Request;
import by.epam.jaxb.controller.Response;
import by.epam.jaxb.domain.NewsPortal;
import by.epam.jaxb.service.INewsPortalService;
import by.epam.jaxb.service.exception.ServiceException;
import by.epam.jaxb.service.factory.NewsPortalServiceFactory;

/**
 * Created by Владислав on 28.05.2016.
 */
public class GetNewsPortalCommand implements Command {
    @Override
    public Response execute(Request request) {

        NewsPortalServiceFactory newsPortalServiceFactory = NewsPortalServiceFactory.getInstance();
        INewsPortalService iNewsPortalService = newsPortalServiceFactory.getNewsPortalService();

        Response response = new Response();
        try {
            NewsPortal newsPortal = iNewsPortalService.getNewsPortal();
            response.setAttribute("newsPortal", newsPortal);
            response.setAttribute("status", true);
        } catch (ServiceException e) {
            e.printStackTrace();
            response.setAttribute("status", false);
        }

        return response;
    }
}
