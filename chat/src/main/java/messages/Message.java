package messages;

import java.util.Date;

public class Message {
    private int id;
    private int chatId;
    private int senderId;
    private int recipientId;
    private String senderName;
    private String recipientName;
    private String content;
    private Date timestamp;
    private MessageStatus status;
}
