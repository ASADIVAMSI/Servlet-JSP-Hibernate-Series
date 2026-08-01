package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File("D:\\CODEGNAN\\Python Full Stack Course Projects.pdf");		
		//File file = new File("D:\\CODEGNAN\\GitHub Accounts - CDG-HYD-JFS-050.xlsx");
		//File file = new File("D:\\CODEGNAN\\1734599164_JD.docx");
		
		response.setContentType("application/pdf");
		//response.setContentType("application/vnd.ms-excel");
		//response.setContentType("application/msword");
		
		
		response.setContentLengthLong(file.length());
		response.addHeader("Content-Disposition", "attachment; filename=" + file.getName());
		//response.addHeader("Content-Disposition", "inline; filename=" + file.getName());
		
		ServletOutputStream out = response.getOutputStream();
		FileInputStream fileInputStream = null;
		
		try {
			fileInputStream = new FileInputStream(file);
			
			int data = 0;
			do {
				data = fileInputStream.read();
				if (data != -1) {
					out.write(data);
				}
			} while (data != -1);
		} catch (FileNotFoundException fnfEx) {
			fnfEx.printStackTrace();
		}  catch (IOException ioEx) {
			ioEx.printStackTrace();
		} finally {
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}
			} catch (IOException ioEx) {
				ioEx.printStackTrace();
			}
		}
		
		out.close();
	}
}