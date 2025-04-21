package FuncionesDeCorreo;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class FuncionesDeCorreo {

    private static String correoRemitente = "andrevelezg42@gmail.com";
    private static String correoDestinatario;
    private static String codigoDeCorreo;
    private static String asuntoCorreo = "codigo de verificacion" ;


    public FuncionesDeCorreo(String correoDestinatario) {
        FuncionesDeCorreo.correoDestinatario = correoDestinatario;
        codigoDeCorreo = String.valueOf((int)(Math.random()*9000)+1000);
        asuntoCorreo = "Codigo de verificacion";
        enviarConGMail(correoDestinatario,asuntoCorreo,codigoDeCorreo);
    }

    public static void enviarConGMail(String correoDestinatario, String asuntoCorreo, String codigoDeCorreo) {
        String remitente = correoRemitente;
        String clave = "wkii txds uoza kdkq";
        // Propiedades de la conexión que se va a establecer con el servidor de correo SMTP
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // Servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);
        props.put("mail.smtp.auth", "true"); // Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); // Conectar de manera segura
        props.put("mail.smtp.port", "587"); // Puerto SMTP seguro de Google
        // Se obtiene la sesión en el servidor de correo
        Session session = Session.getDefaultInstance(props);
        try {
            // Creación del mensaje a enviar
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(correoDestinatario));
            message.setSubject(asuntoCorreo);
            //message.setText(cuerpo); // Para enviar texto plano
            message.setContent(codigoDeCorreo, "text/html; charset=utf-8"); // Para enviar html
            // Definición de los parámetros del protocolo de transporte
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (Exception me) {
            me.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String destinatario = correoDestinatario; // Destinatario del mensaje
        String asunto = asuntoCorreo;
        String cuerpo = String.valueOf(codigoDeCorreo);
        enviarConGMail(destinatario, asunto, cuerpo);
    }

    public String getCodigoDeCorreo() {
        return codigoDeCorreo;
    }
}


