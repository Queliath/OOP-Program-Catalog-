package by.epam.jaxb.service.impl;

import by.epam.jaxb.dao.INewsPortalDAO;
import by.epam.jaxb.dao.exception.DAOException;
import by.epam.jaxb.dao.factory.NewsPortalDAOFactory;
import by.epam.jaxb.domain.Category;
import by.epam.jaxb.domain.News;
import by.epam.jaxb.domain.NewsPortal;
import by.epam.jaxb.domain.Subcategory;
import by.epam.jaxb.service.INewsPortalService;
import by.epam.jaxb.service.exception.ServiceException;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 28.05.2016.
 */
public class NewsPortalServiceImpl implements INewsPortalService {
    @Override
    public void addNews(int id, String name, XMLGregorianCalendar dateOfIssue,
                        List<String> provider, String body, int subcategoryId, int categoryId) throws ServiceException {
        if(id < 0 || provider.isEmpty())
            throw new ServiceException("Некорректный ввод");

        News news = new News();
        news.setId(id);
        news.setName(name);
        news.setDateOfIssue(dateOfIssue);
        news.setProvider(provider);
        news.setBody(body);

        NewsPortalDAOFactory newsPortalDAOFactory = NewsPortalDAOFactory.getInstance();
        INewsPortalDAO iNewsPortalDAO = newsPortalDAOFactory.getNewsPortalDAO();
        try{
            iNewsPortalDAO.saveNews(news, subcategoryId, categoryId);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException("Ошибка добавления новости");
        }

    }

    @Override
    public News getNewsById(int id) throws ServiceException {
        News searchingNews = null;

        NewsPortalDAOFactory newsPortalDAOFactory = NewsPortalDAOFactory.getInstance();
        INewsPortalDAO iNewsPortalDAO = newsPortalDAOFactory.getNewsPortalDAO();
        try {
            NewsPortal newsPortal = iNewsPortalDAO.getNewsPortal();
            for(Category category : newsPortal.getCategories()) {
                for(Subcategory subcategory : category.getSubcategories()) {
                    for(News news : subcategory.getNewses()) {
                        if(news.getId() == id) {
                            searchingNews = news;
                            return searchingNews;
                        }
                    }
                }
            }
            return searchingNews;
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public News getNewsByCriteria(String name) throws ServiceException {
        News searchingNews = null;

        NewsPortalDAOFactory newsPortalDAOFactory = NewsPortalDAOFactory.getInstance();
        INewsPortalDAO iNewsPortalDAO = newsPortalDAOFactory.getNewsPortalDAO();
        try {
            NewsPortal newsPortal = iNewsPortalDAO.getNewsPortal();
            for(Category category : newsPortal.getCategories()) {
                for(Subcategory subcategory : category.getSubcategories()) {
                    for(News news : subcategory.getNewses()) {
                        if(news.getName().equals(name)) {
                            searchingNews = news;
                            return searchingNews;
                        }
                    }
                }
            }
            return searchingNews;
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<News> getNewsesByCriteria(String author) throws ServiceException {
        List<News> searchingNewses = new ArrayList<>();

        NewsPortalDAOFactory newsPortalDAOFactory = NewsPortalDAOFactory.getInstance();
        INewsPortalDAO iNewsPortalDAO = newsPortalDAOFactory.getNewsPortalDAO();
        try {
            NewsPortal newsPortal = iNewsPortalDAO.getNewsPortal();
            for(Category category : newsPortal.getCategories()) {
                for(Subcategory subcategory : category.getSubcategories()) {
                    for(News news : subcategory.getNewses()) {
                        for(String oneOfAuthors : news.getProvider()) {
                            if(oneOfAuthors.equals(author))
                                searchingNewses.add(news);
                        }
                    }
                }
            }
            return searchingNewses;
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public NewsPortal getNewsPortal() throws ServiceException {
        NewsPortalDAOFactory newsPortalDAOFactory = NewsPortalDAOFactory.getInstance();
        INewsPortalDAO iNewsPortalDAO = newsPortalDAOFactory.getNewsPortalDAO();
        try{
            NewsPortal newsPortal = iNewsPortalDAO.getNewsPortal();
            return newsPortal;
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException("Ошибка получения каталога новостей");
        }
    }
}
