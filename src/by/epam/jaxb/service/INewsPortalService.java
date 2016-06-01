package by.epam.jaxb.service;

import by.epam.jaxb.domain.News;
import by.epam.jaxb.domain.NewsPortal;
import by.epam.jaxb.service.exception.ServiceException;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

/**
 * Created by Владислав on 28.05.2016.
 */
public interface INewsPortalService {
    void addNews(int id, String name, XMLGregorianCalendar dateOfIssue,
                 List<String> provider, String body, int subcategoryId, int categoryId) throws ServiceException;
    News getNewsById(int id) throws ServiceException;
    News getNewsByCriteria(String name) throws ServiceException;
    List<News> getNewsesByCriteria(String author) throws ServiceException;
    NewsPortal getNewsPortal() throws ServiceException;
}
