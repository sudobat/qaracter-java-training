package introduction.interfaceSegregation;

public class MailingService {

    public void sendWelcomeEmail(CanReceiveEmails receiver) {
        sendEmail(receiver.getEmail(), "Welcome " + receiver.getName() + " !");
    }

    public void sendNewsletter(CanReceiveEmails receiver) {
        sendEmail(receiver.getEmail(), receiver.getName() + " this month newsletter is super interesting.");
    }

    private void sendEmail(String email, String message) {
        // Send email
    }
}
