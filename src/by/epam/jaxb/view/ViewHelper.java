package by.epam.jaxb.view;

import by.epam.jaxb.view.impl.AddNewsView;
import by.epam.jaxb.view.impl.NewsPortalView;
import by.epam.jaxb.view.impl.NewsesView;
import by.epam.jaxb.view.impl.SingleNewsView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Владислав on 28.05.2016.
 */
public class ViewHelper {

    private Map<ViewName, IView> views = new HashMap<>();

    public ViewHelper() {
        views.put(ViewName.NEWS_PORTAL, new NewsPortalView());
        views.put(ViewName.ADD_NEWS, new AddNewsView());
        views.put(ViewName.SINGLE_NEWS, new SingleNewsView());
        views.put(ViewName.NEWSES, new NewsesView());
    }

    public IView getView(String name) {
        ViewName viewName = ViewName.valueOf(name);
        IView view = views.get(viewName);
        return view;
    }

}
