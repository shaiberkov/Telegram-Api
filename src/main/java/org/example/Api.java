package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;



public class Api {


    private CloseableHttpClient client;

    public Api(){
        client= HttpClients.createDefault();

    }


    public String sendMessage(String message){
        try {
            URI uri = new URIBuilder("https://app.seker.live/fm1/send-message")
                    .setParameter("id","325256022")
                    .setParameter("text", message)
                    .build();


            HttpGet request = new HttpGet(uri);
            CloseableHttpResponse response=  client.execute(request);
            String json = EntityUtils.toString(response.getEntity());
            Responce responce =new ObjectMapper().readValue(json, Responce.class);
            return responce.getExtra();



        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }

//    public  boolean registerId(String id){
//        try {
//            URI uri = new URIBuilder(REGISTER_ID_URI)
//                    .setParameter("id", id)
//                    .build();
//            HttpGet request = new HttpGet(uri);
//            CloseableHttpResponse response=  client.execute(request);
//            String json = EntityUtils.toString(response.getEntity());
//            ResponseParser responseParser = new ObjectMapper().readValue(json, ResponseParser.class);
//            if(responseParser.isSuccess()){
//                System.out.println("registerd succsefuly ");
//
//            }
//            else{
//                System.out.println("user taken");
//            }
//
//        } catch (IOException | URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//        return true;
//    }
//
//
//    public  void addTask(String id, String text){
//        //CloseableHttpClient client = HttpClients.createDefault();
//        try {
//            URI uri = new URIBuilder(ADD_TASK_URI)
//                    .setParameter("id", id)
//                    .setParameter("text", text)
//                    .build();
//            //HttpGet request = new HttpGet(uri);
//            HttpPost request = new HttpPost(uri);
//
//            CloseableHttpResponse response=  client.execute(request);
//            String json = EntityUtils.toString( response.getEntity());
//            ResponseParser responseParser = new ObjectMapper().readValue(json, ResponseParser.class);
//            if(responseParser.isSuccess()){
//                System.out.println("task added");
//            }
//            else{
//                switch (responseParser.getErrorCode()){
//                    case 1002:
//                        System.out.println( "no id added");
//                        break;
//                    case 1004 :
//                        System.out.println( "no titel to your task");
//                        break;
//                    case 1001:
//                        System.out.println( "incorrect id");
//                        break;
//                    case 1005:
//                        System.out.println( "task allready exists");
//                        break;
//                }
//            }
//        } catch (IOException | URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public  void compeleteTask(String id, String text){
//        //CloseableHttpClient client = HttpClients.createDefault();
//        try {
//            URI uri = new URIBuilder(COMPELETE_TASK_URI)
//                    .setParameter("id", id)
//                    .setParameter("text", text)
//                    .build();
//            //HttpGet request = new HttpGet(uri);
//            HttpPost request = new HttpPost(uri);
//            CloseableHttpResponse response=  client.execute(request);
//            String json = EntityUtils.toString( response.getEntity());
//            ResponseParser responseParser = new ObjectMapper().readValue(json, ResponseParser.class);
//            if(responseParser.isSuccess()){
//                System.out.println("task was succsefuly switched to done");
//            }
//            else{
//                switch (responseParser.getErrorCode()){
//                    case 1002:
//                        System.out.println( "no id added");
//                        break;
//                    case 1004 :
//                        System.out.println( "no titel to your task");
//                        break;
//                    case 1001:
//                        System.out.println( "incorrect id");
//                        break;
//                    case 1006:
//                        System.out.println( "unknown task");
//                        break;
//                    case 1007:
//                        System.out.println( "task allready done");
//                        break;
//                }
//            }
//        } catch (IOException | URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//    }

}