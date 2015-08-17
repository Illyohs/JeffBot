package us.illyohs.jeffbot.slack.command;

public interface ICommand {
    String name();

    String desctiption();

    int paramNumber();

    void execute(String[] args);

    void dotask(String[] args);
}
