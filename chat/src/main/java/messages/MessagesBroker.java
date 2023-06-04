package messages;

import messages.Message;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MessagesBroker {

    HashMap listeners = new HashMap();
    Queue<Message> messagesQueue = new LinkedList<>();

    public void push(String unparsedMsg) {
        Message msg = new Message();
    }

    public void broadcast(String msgIn) {

        Message msg;
        while ((msg = messagesQueue.poll()) != null) {
            System.out.println(msg);
        }
    }

}
