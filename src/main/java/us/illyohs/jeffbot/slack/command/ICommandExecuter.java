package us.illyohs.jeffbot.slack.command;

public interface ICommandExecuter {

    void addCommand(ICommand command);
    void execute(String command) throws CommandNotFoundException;
}
