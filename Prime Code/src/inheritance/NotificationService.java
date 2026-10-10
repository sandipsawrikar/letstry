package inheritance;

public class NotificationService {

    MessageService messageService;

    NotificationService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void alert(String message) {
        messageService.sendMessage(message);
    }


}
