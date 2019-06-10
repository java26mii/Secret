/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

/**
 *
 * @author Sekar Ayu Safitri
 */
import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Sekar Ayu Safitri
 */
public class SendMail {

    public static void send(String email, String msg, final String user, final String pass) {
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setText(msg);

//            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView());
//            j.showSaveDialog(null);
//            File file = j.getSelectedFile();
//            String dir = file.getAbsolutePath();
//
//            message.setText(dir);

//            DataSource source = new FileDataSource("C:/Users/Sekar Ayu Safitri/Documents/jenius.jpeg");
//            message.setDataHandler(new DataHandler(source));
//            message.setFileName("hayo"); 
            Transport.send(message);

            JOptionPane.showMessageDialog(null, "Email sended!");

        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Something happened!");

            throw new RuntimeException(e);
        }
    }
}
