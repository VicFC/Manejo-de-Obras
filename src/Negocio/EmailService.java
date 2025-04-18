/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Modelo.EntradaBitacora;
import java.util.ArrayList;
import java.util.List;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * Clase para gestionar el envío de correos 
 */

public class EmailService {

    private final String usuario = "proyectopoo52@gmail.com";
    private final String password = "rbpu fxmt mgpg feds"; 
    private Obra obra;

    public void enviarCorreo(String emailCliente, Obra obra) {
        this.obra = obra;
        ArrayList<EntradaBitacora> bitacora = obra.getBitacora();
         
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Sesión para autenticar con las credenciales de tu correo
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, password);
            }
        });

        try {
            // Crear el mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuario)); // Remitente
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailCliente)); // Destinatario
            message.setSubject("Entradas de la bitácora");

            // Convertir los entregables a un formato HTML
            String contenidoHtml = generarContenidoHtml(bitacora);

            // Establecer el contenido del correo
            message.setContent(contenidoHtml, "text/html");

            // Enviar el correo
            Transport.send(message);

            System.out.println("Correo enviado exitosamente a: " + emailCliente);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    // Método para generar el cuerpo del correo en formato HTML
   private String generarContenidoHtml(ArrayList<EntradaBitacora> bitacora) {
        StringBuilder html = new StringBuilder();

        // Estilo básico para la tabla
        html.append("<html><head><style>")
            .append("table { width: 100%; border-collapse: collapse; }")
            .append("th, td { border: 1px solid black; padding: 8px; text-align: left; }")
            .append("th { background-color: #f2f2f2; }")
            .append("tr:nth-child(even) { background-color: #f9f9f9; }")
            .append("</style></head><body>");

        // Saludo formal
        html.append("<h3>Buenos días,</h3>")
        .append("<p>Esperamos que este mensaje le encuentre bien. A continuación, le enviamos la bitácora correspondiente a su solicitud:</p>");
    
        html.append("<h2>Resultados de la inspección:</h2>");
        html.append("<table>")
            .append("<tr>")
            .append("<th>Inspector</th>")
            .append("<th>Fecha</th>")
            .append("<th>Empleado</th>")
            .append("<th>Puesto</th>")
            .append("<th>Cumplidas</th>")
            .append("<th>Faltas</th>")
            .append("<th>Observaciones</th>")
            .append("</tr>");

        // Agregar filas para cada entrada de la bitácora
        for (EntradaBitacora entrada : bitacora) {
            html.append("<tr>")
                .append("<td>").append(entrada.getInspector()).append("</td>")
                .append("<td>").append(entrada.getFechaHHMM()).append("</td>")
                .append("<td>").append(entrada.getEmpleado().getNombre()).append("</td>")
                .append("<td>").append(entrada.getEmpleado().getPuesto().getNombre()).append("</td>")
                .append("<td>").append(formatHtmlParagraphs(entrada.getCumplidas())).append("</td>")
                .append("<td>").append(formatHtmlParagraphs(entrada.getFaltas())).append("</td>")
                .append("<td>").append(formatHtmlParagraphs(entrada.getObservaciones())).append("</td>")
                .append("</tr>");
        }

        html.append("</table>");
        // Mensaje de despedida
        html.append("<p>Quedamos a su disposición para cualquier consulta adicional o información que pueda necesitar.</p>")
        .append("<p>Atentamente,</p>")
        .append("<p><b>Equipo de Inspección de Obra</b></p>");
    
        html.append("</body></html>");

        return html.toString();
}

// Método auxiliar para convertir texto con saltos de línea en párrafos HTML
private String formatHtmlParagraphs(String text) {
    if (text == null || text.trim().isEmpty()) {
        return "No disponible";
    }
    return "<p>" + text.replace("\n", "<br>") + "</p>";
}

}


