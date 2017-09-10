package com.situ.servlet.day34;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

public class UploadServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.创建磁盘文件项工厂DiskFileItemFactory:一些和配置相关的设置（缓存大小和临时目录的位置）
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//单位是字节   1M=1024KB  1KB=1024B
		factory.setSizeThreshold(1024 * 1024);
		String tempPath = getServletContext().getRealPath("temp");
		factory.setRepository(new File(tempPath));
		
		//2.ServletFileUpload:文件上传的核心类
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
	    //设置上传文件名的编码方式
		servletFileUpload.setHeaderEncoding("UTF-8");
		
		//判断这个表单是不是文件上传的表单
		if (servletFileUpload.isMultipartContent(req)) {
			List<FileItem> list = null;
			try {
				list = servletFileUpload.parseRequest(req);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			if (list != null) {
				for (FileItem fileItem : list) {
					//判断是不是普通表单项
					if (fileItem.isFormField()) {
						String fieldName = fileItem.getFieldName();
						String fieldValue = fileItem.getString("UTF-8");
						System.out.println("fileName: " + fieldName + " : fieldValue:" + fieldValue);
					} else {
						//文件上传表单项
						//得到文件的名字
						String fileName = fileItem.getName();
						String uploadPath = getServletContext().getRealPath("upload");
						InputStream inputStream = fileItem.getInputStream();
						OutputStream outputStream = new FileOutputStream(new File(uploadPath + "/" +fileName));
						IOUtils.copy(inputStream, outputStream);
						outputStream.close();
						inputStream.close();
					}
				}
			}
		}
	}
}
