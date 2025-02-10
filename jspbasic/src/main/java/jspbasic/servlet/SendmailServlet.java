package jspbasic.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
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
		
try {
			// 이메일 메시지 작성
			Message message = new MimeMessage(session);
			
			// 발신자 이메일
			message.setFrom(new InternetAddress(request.getParameter("sender")));
			
			// 수신자 이메일
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(request.getParameter("receiver"))); // 받는 사람 이메일
			
			// 이메일 제목
			message.setSubject(request.getParameter("subject"));
			
			MimeBodyPart textPart = new MimeBodyPart();
			
			// 이메일 내용
			textPart.setText(request.getParameter("content"));
			
			MimeBodyPart filePart = new MimeBodyPart();
			String fileName = request.getParameter("file");
			
			if(fileName !=null && !fileName.isEmpty()) {
				File file = new File(getServletContext().getRealPath("/")+fileName);
				try {
					filePart.attachFile(file);
				} catch(Exception e) {
					e.printStackTrace();
					System.out.println("오류");
				}
			}else {
				response.getWriter().println("파일없음");
			} 
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(textPart);
			if(fileName != null && !fileName.isEmpty()) {
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
