package com.kashengit.test;

import com.kashengit.dao.UpLoadDAO;
import com.kashengit.entity.Document;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class TestUploadDAO {
    @Test
    public void TestUploadDAOA(){
        Document document=new Document();
        document.setName("2");
        document.setSavename("2");
        document.setExtname("2");
        document.setMd5("2");
        document.setSize(3243243l);
        document.setDisplaysize("2");
        UpLoadDAO upLoadDAO=new UpLoadDAO();
        upLoadDAO.save(document);



    }
    @Test
    public void Testall(){
        UpLoadDAO upLoadDAO=new UpLoadDAO();
        List<Document> list=upLoadDAO.QueryAll();

        Assert.assertEquals(list.size() ,4);




    }


    @Test
    public void testfindByMd5() {
        UpLoadDAO upLoadDAO=new UpLoadDAO();
        Document docment=upLoadDAO.findByMd5("2");
       Logger logger=LoggerFactory.getLogger(TestUploadDAO.class);
        logger.debug("docment{}",docment);
    }
}