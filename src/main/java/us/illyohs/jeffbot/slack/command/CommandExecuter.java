package us.illyohs.jeffbot.slack.command;

import java.util.Arrays;
import java.util.HashMap;

public class CommandExecuter implements ICommandExecuter {

    private static CommandExecuter instance;

    public static CommandExecuter getInstance() {
        if (instance == null) {
            instance = new CommandExecuter();
        }
        return instance;
    }

    private HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

    @Override
    public void addCommand(ICommand command) {
        System.out.println("Adding: " + command.name());
        commands.put(command.name(), command);
    }

    @Override
    public void execute(String command) throws CommandNotFoundException {
        System.out.println("CommandExecutor:");
        String[] splitCommand = command.split(" ");

        String commandName = splitCommand[0];
        String [] args = new String[]{};
        if(splitCommand.length>0) {
            args = Arrays.copyOfRange(splitCommand, 1, splitCommand.length);
        }


        System.out.println("Executing: " + commandName);

        if (!commands.containsKey(commandName)) {
            throw new CommandNotFoundException();
        }

        commands.get(commandName).execute(args);
    }
}
