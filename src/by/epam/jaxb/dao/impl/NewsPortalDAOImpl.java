package by.epam.jaxb.dao.impl;

import by.epam.jaxb.dao.INewsPortalDAO;
import by.epam.jaxb.dao.exception.DAOException;
import by.epam.jaxb.domain.Category;
import by.epam.jaxb.domain.News;
import by.epam.jaxb.domain.NewsPortal;
import by.epam.jaxb.domain.Subcategory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Владислав on 28.05.2016.
 */
public class NewsPortalDAOImpl implements INewsPortalDAO {

    private static final String xmlFileURI = "resources/newsPortal.xml";

    @Override
    public void saveNews(News news, int subcategoryId, int categoryId) throws DAOException{
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(NewsPortal.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            NewsPortal newsPortal = (NewsPortal) unmarshaller.unmarshal(new FileInputStream(new File(xmlFileURI)));
            boolean saveSuccess = false;
            for(Category category: newsPortal.getCategories()) {
                if(category.getId() == categoryId) {
                    for(Subcategory subcategory : category.getSubcategories()) {
                        if(subcategory.getId() == subcategoryId) {
                            subcategory.addNews(news);
                            saveSuccess = true;
                            break;
                        }
                    }
                    break;
                }
            }
            if(!saveSuccess)
                throw new DAOException("Неверные ID категории или подкатегории");
            marshaller.marshal(newsPortal, new FileOutputStream(new File(xmlFileURI)));
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
            throw new DAOException("Ошибка сохранения новости");
        }
    }

    @Override
    public NewsPortal getNewsPortal() throws DAOException{
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(NewsPortal.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            NewsPortal newsPortal = (NewsPortal) unmarshaller.unmarshal(new FileInputStream(new File(xmlFileURI)));
            return newsPortal;
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
            throw new DAOException("Ошибка выборки всех новостей");
        }
    }
}
