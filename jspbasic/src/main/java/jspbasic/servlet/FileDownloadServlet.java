package jspbasic.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FileDownloadServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 다운로드할 파일명
		String filename = request.getParameter("filename");
		System.out.println(filename);
		
		// 인코딩한 파일명 (한글파일명 처리하려면 필수!)
		String encodedFilename = URLEncoder.encode(filename, "UTF-8").replace("\\", "%20");
			
		// 서버에 있는 파일에 대한 객체
		File file = new File("D:/embededk/uploadfiles/" + filename);

		// 서버에 있는 파일에서 바이트 입력 스트림
		FileInputStream fis = new FileInputStream(file);
		
		// 클라이언트에 보내줄 바이트 출력 스트림
		OutputStream os = response.getOutputStream();
		
		if(file.exists()) {
			response.setHeader("Content-Disposition", "attachment; filename=\""+encodedFilename+"\"");
			response.setContentType("application/octet-stream");
			
			byte[] buffer = new byte[1024];
			int bytesRead = 0;
			while((bytesRead=fis.read(buffer)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.flush();
		}
		
	} // doGet

} // class
