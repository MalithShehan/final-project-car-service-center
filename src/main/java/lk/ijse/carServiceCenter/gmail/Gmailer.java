package lk.ijse.carServiceCenter.gmail;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.IDateTimeValueType;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Label;
import com.google.api.services.gmail.model.Message;
import javafx.scene.control.SelectionMode;
import lk.ijse.carServiceCenter.dto.tm.DetailsTm;
import org.apache.commons.codec.binary.Base64;

import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Set;

import static com.google.api.services.gmail.GmailScopes.GMAIL_SEND;
import static javax.mail.Message.RecipientType.TO;

public class Gmailer {
    private static  final String EMAIL = "hashinsavindu@gmail.com";
    private final Gmail service;

    private LocalDate date = LocalDate.now();

    public String name;
    public String id;
    public String RDetails;
    public double RPrice;
    public String itemDetails;
    public double itemPrice;
    public double total;
    public Gmailer() throws Exception{
        NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        GsonFactory jsonFactory = GsonFactory.getDefaultInstance();
        service = new Gmail.Builder(httpTransport, jsonFactory, getCredentials(httpTransport, jsonFactory))
                .setApplicationName("Test Mailer")
                .build();

    }
    private static Credential getCredentials(final NetHttpTransport httpTransport, GsonFactory jsonFactory)
            throws IOException {
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, new InputStreamReader(Gmailer.class.getResourceAsStream("/gmailApi/client_secret_634129604262-lqduv6l6b91ttt0bf83nugq1gbuusl5b.apps.googleusercontent.com.json")));

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, jsonFactory, clientSecrets,  Set.of(GMAIL_SEND))
                .setDataStoreFactory(new FileDataStoreFactory(Paths.get("tokens").toFile()))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public static boolean setEmailCom(String email, String string) throws Exception {
        boolean b = new Gmailer().sendMail("Auto Car Service Center", "<!DOCTYPE html>\n" +
                "\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"utf-8\">\n" +
                "\t\t<title>Invoice</title>\n" +
                "\t\t<link rel=\"stylesheet\" href=\"style.css\">\n" +
                "\t\t<link rel=\"license\" href=\"https://www.opensource.org/licenses/mit-license/\">\n" +
                "\t\t<script src=\"script.js\"></script>\n" +
                "\t</head>\n" +
                "\t<body>\n" +
                "\t\t<article>\n" +
                "\t\t\t<h1>Recipient</h1>\n" +
                "\t\t\t<address contenteditable>\n" +
                "\t\t\t\t<p>Car Service Center<br>Malith Shehan</p>\n" +
                "\t\t\t</address>\n" +
                "\t\t\t<table class=\"meta\">\n" +
                "<tr>\n" +
                "<th><span contenteditable>Date - </span></th>\n" +
                "<td><span contenteditable>"+ LocalDate.now() +"</span></td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t\t<tr>\n" +
                "\t\t\t\t\t<th><span contenteditable>Amount Due</span></th>\n" +
                "\t\t\t\t\t<td><span id=\"prefix\" contenteditable>$</span><span>600.00</span></td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</table>\n" +
                "\t\t\t<table class=\"inventory\">\n" +
                "\t\t\t\t<thead>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<th><span contenteditable>Item</span></th>\n" +
                "\t\t\t\t\t\t<th><span contenteditable>Description</span></th>\n" +
                "\t\t\t\t" +
                "\t\t<th><span contenteditable>Rate</span></th>\n" +
                "\t\t\t\t\t\t<th><span contenteditable>Quantity</span></th>\n" +
                "\t\t\t\t\t\t<th><span contenteditable>Price</span></th>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</thead>\n" +
                "\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td><a class=\"cut\">-</a><span contenteditable>Front End Consultation</span></td>\n" +
                "\t\t\t\t\t\t<td><span contenteditable>Experience Review</span></td>\n" +
                "\t\t\t\t\t\t<td><span data-prefix>$</span><span contenteditable>150.00</span></td>\n" +
                "\t\t\t\t\t\t<td><span contenteditable>4</span></td>\n" +
                "\t\t\t\t\t\t<td><span data-prefix>$</span><span>600.00</span></td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</tbody>\n" +
                "\t\t\t</table>\n" +
                "\t\t\t<a class=\"add\">+</a>\n" +
                "\t\t\t<table class=\"balance\">\n" +
                "\t\t\t\t<tr>\n" +
                "\t\t\t\t\t<th><span contenteditable>Total</span></th>\n" +
                "\t\t\t\t\t<td><span data-prefix>$</span><span>600.00</span></td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t\t<tr>\n" +
                "\t\t\t\t\t<th><span contenteditable>Amount Paid</span></th>\n" +
                "\t\t\t\t\t<td><span data-prefix>$</span><span contenteditable>0.00</span></td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t\t<tr>\n" +
                "\t\t\t\t\t<th><span contenteditable>Balance Due</span></th>\n" +
                "\t\t\t\t\t<td><span data-prefix>$</span><span>600.00</span></td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</table>\n" +
                "\t\t</article>\n" +
                "\t\t<aside>\n" +
                "\t\t</aside>\n" +
                "\t</body>\n" +
                "</html>", email);
        return b;
    }

    public boolean sendMail(String subject, String message,String gmail) throws Exception {
        boolean b = false;
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage email = new MimeMessage(session);
        email.setFrom(new InternetAddress(EMAIL));
        email.addRecipient(TO, new InternetAddress(gmail));
        email.setSubject(subject);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(message, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        email.setContent(multipart);

        // Encode and wrap the MIME message into a gmail message
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        email.writeTo(buffer);
        byte[] rawMessageBytes = buffer.toByteArray();
        String encodedEmail = Base64.encodeBase64URLSafeString(rawMessageBytes);
        Message msg = new Message();
        msg.setRaw(encodedEmail);

        try {
            b = true;
            msg = service.users().messages().send("me", msg).execute();
            System.out.println("Message id: " + msg.getId());
            System.out.println(msg.toPrettyString());

        } catch (GoogleJsonResponseException e) {
            b = false;
        }
        return b;
    }
}