package us.illyohs.jeffbot.slack;

import com.ullink.slack.simpleslackapi.SlackSession;

public interface ISlack {

    SlackSession getSession();

    void connect();

    void sendMessage(String channel, String message);

    void sendMessage(String message);
}
