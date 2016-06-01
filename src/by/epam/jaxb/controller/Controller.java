package by.epam.jaxb.controller;

import by.epam.jaxb.command.Command;
import by.epam.jaxb.command.CommandHelper;

/**
 * Created by Владислав on 28.05.2016.
 */
public class Controller {

    private CommandHelper commandHelper = new CommandHelper();

    public Response doAction(Request request) {
        String commandName = (String) request.getAttribute("commandName");
        Command command = commandHelper.getCommand(commandName);
        Response response = command.execute(request);
        return response;
    }
}
