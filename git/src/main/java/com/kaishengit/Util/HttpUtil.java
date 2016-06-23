package com.kaishengit.Util;


import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HttpUtil {

    public static String getResquestText(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();


        try {
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            int httpcode = httpResponse.getStatusLine().getStatusCode();
            if (httpcode == 200) {
                InputStream inputStream = httpResponse.getEntity().getContent();
                String html = IOUtils.toString(inputStream);
                return html;

            } else {
                throw new RuntimeException("连接服务器异常" + httpcode);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);

        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }


    }


    public static void getRequestStream(String url,String savePath) {
        CloseableHttpClient httpClient = HttpClients.createDefault();


        try {

            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            int httpcode = httpResponse.getStatusLine().getStatusCode();
            if (httpcode == 200) {
                InputStream inputStream = httpResponse.getEntity().getContent();
                FileOutputStream fileOutputStream=new FileOutputStream(savePath);
                IOUtils.copy(inputStream,fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                inputStream.close();

            } else {
                throw new RuntimeException("连接服务器异常" + httpcode);

            }
            httpClient.close();

        } catch (IOException e) {
            throw new RuntimeException(e);

        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }


    }

}
