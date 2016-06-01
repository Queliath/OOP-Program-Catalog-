package by.epam.jaxb.command.impl;

import by.epam.jaxb.command.Command;
import by.epam.jaxb.controller.Request;
import by.epam.jaxb.controller.Response;
import by.epam.jaxb.service.INewsPortalService;
import by.epam.jaxb.service.exception.ServiceException;
import by.epam.jaxb.service.factory.NewsPortalServiceFactory;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

/**
 * Created by Владислав on 28.05.2016.
 */
public class AddNewsCommand implements Command {
    @Override
    public Response execute(Request request) {
        int id = (int) request.getAttribute("id");
        String name = (String) request.getAttribute("name");
        List<String> provider = (List<String>) request.getAttribute("provider");
        XMLGregorianCalendar dateOfIssue = (XMLGregorianCalendar) request.getAttribute("dateOfIssue");
        String body = (String) request.getAttribute("body");
        int subcategoryId = (int) request.getAttribute("subcategoryId");
        int categoryId = (int) request.getAttribute("categoryId");

        NewsPortalServiceFactory newsPortalServiceFactory = NewsPortalServiceFactory.getInstance();
        INewsPortalService iNewsPortalService = newsPortalServiceFactory.getNewsPortalService();

        Response response = new Response();
        try {
            iNewsPortalService.addNews(id, name, dateOfIssue, provider, body, subcategoryId, categoryId);
            response.setAttribute("status", true);
        } catch (ServiceException e) {
            e.printStackTrace();
            response.setAttribute("status", false);
        }
        return response;
    }
}
