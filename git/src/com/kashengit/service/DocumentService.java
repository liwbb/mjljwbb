package com.kashengit.service;

import ch.qos.logback.core.util.FileUtil;
import com.kashengit.dao.UpLoadDAO;
import com.kashengit.entity.Document;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.*;
import java.util.UUID;

public class DocumentService {
    private UpLoadDAO upLoadDAO=new UpLoadDAO();

    public void UpFile(String filename,InputStream inputStream,long size)throws IOException{
        ByteArrayInputStream byteArrayInputStream=
             new ByteArrayInputStream(IOUtils.toByteArray(inputStream));
        String md5= DigestUtils.md5Hex(byteArrayInputStream);
        Document document=upLoadDAO.findByMd5(md5);
        if(document==null){
            String savefile=saveFile(filename,byteArrayInputStream);
            document=new Document();
            document.setName(filename);
            document.setSavename(savefile);
            document.setExtname(filename.substring(filename.indexOf(".")));
            document.setMd5(md5);
            document.setSize(size);
            document.setDisplaysize(FileUtils.byteCountToDisplaySize(size));
            upLoadDAO.save(document);


        }


    }

    private String saveFile(String filename, InputStream inputStream) throws IOException {
        inputStream.reset();
        File file=new File("D:/upload");
        if(!file.exists()){
            file.mkdir();

        }
        String extname=filename.substring(filename.indexOf("."));
        String uuid= UUID.randomUUID().toString();
        filename=uuid+extname;

        FileOutputStream fileOutputStream=new FileOutputStream(new File(file,filename));
        IOUtils.copy(inputStream,fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        inputStream.close();


        return filename;

    }
}
