package inheritance;

public class Main {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

        MessageService msg = null;
        if(args.length>0 && args[0].equalsIgnoreCase("Email")){
            msg = new EmailService();
        }
        else  if(args.length>0 && args[0].equalsIgnoreCase("SMS")){
            msg = new SMSMessage();
        }
        NotificationService n1= new NotificationService(msg);
        n1.alert(" server is down");
    }
}
