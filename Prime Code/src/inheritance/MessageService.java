package inheritance;

public interface MessageService {
    void sendMessage(String message);
}

class SMSMessage implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS " + message);
    }
}

class EmailService implements MessageService {

    @Override
    public void sendMessage(String message) {
        System.out.println("Email " + message);
    }
}