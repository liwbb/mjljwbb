package com.kaoishengit.test;

import com.kaishengit.Util.HttpUtil;
import com.kaishengit.Util.HttpUtils;


import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestUploadcases {
    @Test
    public void TestCase() throws IOException {
        for(int i=15;i<16;i++){
            String url="http://www.topit.me/pop?p=";
            Document document=Jsoup.connect(url+i).cookie("is_click","1").get();
            Elements elements=document.select("#content .catalog .e>a");
            System.out.println(elements);
            for(Element element:elements){
                String href=element.attr("href");
                Document imgDocument=Jsoup.connect(href).cookie("is_click","1").get();
                Element imgElement=imgDocument.select("#content>a").first();
                String imgSrc=imgElement.attr("href");
                String filename=imgSrc.substring(imgSrc.lastIndexOf("/")+1);
                get(imgSrc,"F:/upload/sss/"+filename);
            }


        }




    }
    public static void get(String url,String savePath){
        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpGet httpGet=new HttpGet(url);
        try {
            HttpResponse httpResponse=httpClient.execute(httpGet);
            int httpCode=httpResponse.getStatusLine().getStatusCode();
            if(httpCode==200){
                InputStream inputStream=httpResponse.getEntity().getContent();
                FileOutputStream fileOutputStream=new FileOutputStream(savePath);
                IOUtils.copy(inputStream,fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                inputStream.close();

            }else{
                throw new RuntimeException("连接服务器异常"+httpCode);
            }
            httpClient.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
