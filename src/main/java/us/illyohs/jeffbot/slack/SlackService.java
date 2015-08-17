package us.illyohs.jeffbot.slack;

import com.ullink.slack.simpleslackapi.SlackSession;
import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory;

import java.io.IOException;

public class SlackService implements ISlack{

    private static  SlackService instance;
    private         SlackSession session;

    public static SlackService getInstance() {
        if (instance == null) {
            instance = getInstance();
        }
        return instance;
    }

    private SlackSession InitSlack() throws IOException {
        session = SlackSessionFactory.createWebSocketSlackSession("");
        return  session;
    }

    @Override
    public SlackSession getSession() {
        return session;
    }

    @Override
    public void connect() {
        try {
            session.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void sendMessage(String channel, String message) {
        session.sendMessage(session.findChannelByName(channel), message, null);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }
}
