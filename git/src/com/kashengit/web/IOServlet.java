package com.kashengit.web;

import com.kashengit.service.DocumentService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet("/IOServlet")
@MultipartConfig
public class IOServlet extends HttpServlet {

    private Logger logger= LoggerFactory.getLogger(IOServlet.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String fileDesc=request.getParameter("desc");
        logger.debug("文件描述为{}",fileDesc);
        Part part=request.getPart("doc");
        logger.debug("{}",part.getSize());
        InputStream inputStream=part.getInputStream();

        DocumentService documentService=new DocumentService();
        documentService.UpFile(getFileName(part),inputStream,part.getSize());
//        File file=new File("D:/upload");
//        if(!file.exists()){
//            file.mkdir();
//
//        }
//        String filename=getFileName(part);
//        InputStream inputStream=part.getInputStream();
//        FileOutputStream fileOutputStream=new FileOutputStream(new File(file,filename));
//        IOUtils.copy(inputStream,fileOutputStream);

//        BufferedInputStream bufferedInputStream=new BufferedInputStream(inputStream);
//        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
//        byte[] buffer=new byte[1024];
//        int len=-1;
//        while((len=bufferedInputStream.read(buffer))!=-1){
//            bufferedOutputStream.write(buffer,0,len);
//
//        }

//        inputStream.close();
//        fileOutputStream.close();







    }

    private String getFileName(Part part){
        String headValue=part.getHeader("Content-Disposition");
        headValue=headValue.substring(headValue.indexOf("filename=\""));
        logger.debug("这是2{}",headValue);
        headValue=headValue.substring(headValue.indexOf("\"")+1,headValue.length()-1);

        logger.debug("这是1{}",headValue);
        return headValue;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/io.jsp").forward(request,response);
    }
}
