package com.kaoishengit.test;

import com.kaishengit.Util.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;


import java.io.IOException;

public class TestUpload {

    @Test
    public void TestUploadImage() throws IOException {

        for(int i=10;i<20;i++){

            String url="http://www.topit.me/pop?p=";
            Document document= Jsoup.connect(url+i).cookie("is_click","1").get();
            Elements elements=document.select("#content .catalog .e>a");
            for(Element element:elements){
                String href=element.attr("href");
                System.out.println("href:" + href);
                Document bigImageDoc=Jsoup.connect(href).cookie("is_click","1").get();

                Element imgElement = bigImageDoc.select("#content>a").first();

                String imgSrc=imgElement.attr("href");
                System.out.println(imgSrc);

                String fileName=imgSrc.substring(imgSrc.lastIndexOf("/")+1);

                HttpUtil.getRequestStream(imgSrc,"F:/upload/"+fileName);
//
//                String href = element.attr("href");
//                System.out.println("href:" + href);
//
//                Document bigImageDoc = Jsoup.connect(href).cookie("is_click", "1").get();
//                Element imgElement = bigImageDoc.select("#content>a").first();
//                String imgSrc = imgElement.attr("href");
//
//                System.out.println(imgSrc);
//                String fileName = imgSrc.substring(imgSrc.lastIndexOf("/") + 1);
//                HttpUtil.getRequestStream(imgSrc, "F:/upload/" + fileName);

            }
        }

    }
}
