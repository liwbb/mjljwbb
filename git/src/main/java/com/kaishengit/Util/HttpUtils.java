package com.kaishengit.Util;


import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HttpUtils {
    public static void getRequestStream(String url, String savePath) {
        CloseableHttpClient httpClient=HttpClients.createDefault();
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

            }
            httpClient.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw  new RuntimeException(e);
            }
        }
    }


}
