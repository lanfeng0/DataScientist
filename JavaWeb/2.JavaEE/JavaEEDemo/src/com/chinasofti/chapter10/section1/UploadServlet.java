package com.chinasofti.chapter10.section1;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
    	
    	req.setCharacterEncoding("utf-8");
    	res.setContentType("text/html;charset=utf-8");
    	
    	String name = req.getParameter("userName");
    	Part file = req.getPart("file");
    	
    	String path = req.getServletContext().getRealPath("/upload/");
    	System.out.println("path==="+path);
    	
    	System.out.println(file.getSubmittedFileName());
    	System.out.println(file.getSize());
    	System.out.println(file.getName());
    	
    	File f = new File(path);
    	if(!f.exists()) {
    		f.mkdirs();
    	}
    	
    	String fn = file.getSubmittedFileName();
    	if(fn.toLowerCase().endsWith(".jpg")||fn.toLowerCase().endsWith(".png")){
    		file.write(path+"/"+file.getSubmittedFileName());
    		
    		String nfn = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+fn.substring(fn.lastIndexOf("."));
    		file.write(path+"/"+nfn);
    		
    		req.setAttribute("file", file.getSubmittedFileName());
    	
    	}else {
    		req.setAttribute("file", "文件上传失败，必须是jpg或png格式的文件");
    	}
    	
    	req.setAttribute("user", name);
    	req.getRequestDispatcher("uploadsuccess.jsp").forward(req, res);
    }

}
