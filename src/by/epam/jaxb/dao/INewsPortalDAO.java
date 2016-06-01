package by.epam.jaxb.dao;

import by.epam.jaxb.dao.exception.DAOException;
import by.epam.jaxb.domain.News;
import by.epam.jaxb.domain.NewsPortal;

/**
 * Created by Владислав on 28.05.2016.
 */
public interface INewsPortalDAO {
    void saveNews(News news, int subcategoryId, int categoryId) throws DAOException;
    NewsPortal getNewsPortal() throws DAOException;
}
