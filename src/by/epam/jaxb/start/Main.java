package by.epam.jaxb.start;

import by.epam.jaxb.controller.Controller;
import by.epam.jaxb.controller.Request;
import by.epam.jaxb.controller.Response;
import by.epam.jaxb.view.IView;
import by.epam.jaxb.view.ViewHelper;

/**
 * Created by Владислав on 26.05.2016.
 */
public class Main {

    private static String[] viewRequests = {"NEWS_PORTAL", "SINGLE_NEWS", "NEWSES"};

    private static ViewHelper viewHelper = new ViewHelper();

    public static void main(String[] args) {
        Controller controller = new Controller();

        for(int i = 0; i < viewRequests.length; i++){
            String viewName = viewRequests[i];
            IView view = viewHelper.getView(viewName);
            Request request = view.doUserAction();
            Response response = controller.doAction(request);
            view.printAnswer(response);
        }
    }

}
