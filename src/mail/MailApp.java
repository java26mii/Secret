///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package mail;
//
///**
// *
// * @author Sekar Ayu Safitri
// */
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//
///**
// *
// * @author Sekar Ayu Safitri
// */
//public class MailApp extends JFrame {
//
//    /**
//     * @param args the command line arguments
//     */
//    Container cp;
//    GridLayout gl;
//    JPanel pl;
//
//    JLabel mail_label;
//    JTextField mail_text;
//
//    JLabel sub_label;
//    JTextField sub_text;
//
//    JLabel msg_label;
//    JTextArea msg_text;
//
//    JButton send_button;
//
//    public static void main(String[] args) {
//        MailApp app = new MailApp();
//        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        app.setSize(900, 400);
//        app.setVisible(true);
//    }
//
//    public MailApp() {
//        super("TechWorld3g - Send email using java");
//
//        ButtonHandler handler_button = new ButtonHandler();
//
//        cp = getContentPane();
//        gl = new GridLayout(0, 1);
//        cp.setLayout(gl);
//        pl = new JPanel();
//
//        mail_label = new JLabel("Send to : ");
//        mail_label.setPreferredSize(new Dimension(100, 20));
//
//        mail_text = new JTextField("arief.fridasari@gmail.com");
//        mail_text.setPreferredSize(new Dimension(150, 20));
//
//        sub_label = new JLabel("Subject : ");
//        sub_label.setPreferredSize(new Dimension(100, 20));
//
//        sub_text = new JTextField("File Laporan");
//        sub_text.setPreferredSize(new Dimension(150, 20));
//
//        msg_label = new JLabel("Message : ");
//        msg_label.setPreferredSize(new Dimension(100, 20));
//        
//        
//
//        JScrollPane scroll = new JScrollPane(msg_text);
//        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//
//        msg_text = new JTextArea(" ", 10, 15);
//
//        scroll.setViewportView(msg_text);
//
//        send_button = new JButton("Send");
//        send_button.setPreferredSize(new Dimension(150, 30));
//        send_button.addActionListener(handler_button);
//
//        pl.add(mail_label);
//        pl.add(mail_text);
//        pl.add(sub_label);
//        pl.add(sub_text);
//        pl.add(msg_label);
//        pl.add(scroll);
//        pl.add(send_button);
//
//        cp.add(pl);
//    }
//
//    class ButtonHandler implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if (e.getSource() == send_button) {
//                String to = mail_text.getText();
//                String subject = sub_text.getText();
//                String message = msg_text.getText();
//
//                String user = "sekarkyouya@gmail.com";
//                String pass = "10021997";
//
//                 //password isi sendiri
//                // https://myaccount.google.com/u/0/lesssecureapps
//
//                SendMail.send(to, subject, message, user, pass);
//            }
//        }
//    }
//}
//
