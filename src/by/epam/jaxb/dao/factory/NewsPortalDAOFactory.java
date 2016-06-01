package by.epam.jaxb.dao.factory;

import by.epam.jaxb.dao.INewsPortalDAO;
import by.epam.jaxb.dao.impl.NewsPortalDAOImpl;

/**
 * Created by Владислав on 28.05.2016.
 */
public class NewsPortalDAOFactory {

    private static final NewsPortalDAOFactory newsPortalDAOFactory = new NewsPortalDAOFactory();

    private final INewsPortalDAO iNewsPortalDAO = new NewsPortalDAOImpl();

    private NewsPortalDAOFactory(){
    }

    public static NewsPortalDAOFactory getInstance() {
        return newsPortalDAOFactory;
    }

    public INewsPortalDAO getNewsPortalDAO() {
        return iNewsPortalDAO;
    }
}
