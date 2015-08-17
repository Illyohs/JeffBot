package us.illyohs.jeffbot.slack.command;

import us.illyohs.jeffbot.slack.SlackService;

public abstract class BaseCommand implements ICommand {

    public void execute(String[] args) {
        if (args.length < paramNumber()) {
            SlackService.getInstance().sendMessage(desctiption());
        }
        dotask(args);
    }
}
