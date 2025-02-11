package jspbasic.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(
	    maxFileSize = 1024 * 1024 * 100, // 100mb, 파일당 최대 업로드 용량
	    maxRequestSize = 1024 * 1024 * 500 // 500mb, 한번 요청에 업로드 가능한 최대 용량
	)
public class SendmailServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Google 계정 정보
		String username = "koosk4213@gmail.com"; // 구글 계정명
		String password = "pnsd jpau kpei dcqp"; // 앱 비밀번호
		
		// SMTP 서버 설정
		Properties props = new Properties(); // 설정정보 저장하기 좋은 Map
		props.put("mail.smtp.auth", "true"); // SMTP서버 인증 여부
		props.put("mail.smtp.starttls.enable", "true"); // TLS서비스 사용 여부
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP 서버
		props.put("mail.smtp.port", "587"); // SMTP 서버 포트번호
		
		// 메일세션(연결) 생성
		Session session = Session.getInstance(props, new Authenticator() {
			// 사용자 계정명, 앱 비밀번호로 사용자 인증
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username, password);
				}
		});
		
		Part file =request.getPart("file");  
		
		String sender = request.getParameter("sender");
		String receiver = request.getParameter("receiver");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver)); // 받는 사람 이메일
			message.setSubject(subject);
			
			MimeBodyPart textPart = new MimeBodyPart();  // MimeBodyPart는 이메일 본문이나 첨부 파일을 표현하는 객체
			textPart.setText(content); // 이메일의 본문 내용(텍스트)을 설정
			
			Multipart multipart = new MimeMultipart(); // 여러 개의 파트를 하나로 묶어서 이메일 메시지를 구성하는 객체
			multipart.addBodyPart(textPart); // 본문을 multipart에 추가
			
			if(file !=null && file.getSize() >0) {
				MimeBodyPart filePart = new MimeBodyPart();
				
				InputStream fileContent = file.getInputStream(); // 첨부파일의 데이터가 담긴 InputStream
				String fileName = file.getSubmittedFileName();
				
				// InputStream과 MIME 타입을 사용하여 첨부파일의 데이터를 DataSource 객체로 변환하는 클래스
				// ByteArrayDataSource: 파일 데이터를 이메일에 포함할 수 있도록 DataSource 형태로 변환하는 클래스
				// file.getContentType() : 첨부파일의 MIME 타입을 가져옴(ex. image/jpeg)
				DataSource source = new ByteArrayDataSource(fileContent, file.getContentType());
				
				// DataHandler는 데이터를 처리하는 객체, DataSource를 설정하여, 첨부파일의 실제 데이터를 전달 시
				// 그 데이터에 대한 메타 정보를 제공하여 클라이언트가 올바르게 해석 및 처리 할 수 있도록 함
				filePart.setDataHandler(new DataHandler(source));
				filePart.setFileName(fileName); // MimeBodyPart에 파일 이름을 설정
				multipart.addBodyPart(filePart);
			}
			message.setContent(multipart);
			
			// 이메일 발송
			Transport.send(message);
			System.out.println("이메일 발송 완료!");
			
		} catch (MessagingException me) {
			me.printStackTrace();
		}
		
	} // doPost
	
} // class