package by.epam.jaxb.command;

import by.epam.jaxb.command.impl.AddNewsCommand;
import by.epam.jaxb.command.impl.GetNewsPortalCommand;
import by.epam.jaxb.command.impl.GetNewsByCriteriaCommand;
import by.epam.jaxb.command.impl.GetNewsesByAuthorCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Владислав on 28.05.2016.
 */
public class CommandHelper {

    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandHelper() {
        commands.put(CommandName.ADD_NEWS, new AddNewsCommand());
        commands.put(CommandName.GET_NEWS_PORTAL, new GetNewsPortalCommand());
        commands.put(CommandName.GET_NEWS_BY_CRITERIA, new GetNewsByCriteriaCommand());
        commands.put(CommandName.GET_NEWSES_BY_AUTHOR, new GetNewsesByAuthorCommand());
    }

    public Command getCommand(String name) {
        CommandName commandName = CommandName.valueOf(name);
        Command command = commands.get(commandName);
        return command;
    }

}
