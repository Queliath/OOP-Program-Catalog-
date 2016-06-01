package by.epam.jaxb.service.factory;

import by.epam.jaxb.service.INewsPortalService;
import by.epam.jaxb.service.impl.NewsPortalServiceImpl;

/**
 * Created by Владислав on 28.05.2016.
 */
public class NewsPortalServiceFactory {

    private static final NewsPortalServiceFactory newsPortalServiceFactory = new NewsPortalServiceFactory();

    private final INewsPortalService iNewsPortalService = new NewsPortalServiceImpl();

    private NewsPortalServiceFactory(){
    }

    public static NewsPortalServiceFactory getInstance() {
        return newsPortalServiceFactory;
    }

    public INewsPortalService getNewsPortalService() {
        return iNewsPortalService;
    }
}
