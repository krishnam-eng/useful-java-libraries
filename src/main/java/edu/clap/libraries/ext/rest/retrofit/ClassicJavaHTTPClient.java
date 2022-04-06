package edu.clap.libraries.ext.rest.retrofit;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.stream.Collectors;

public class ClassicJavaHTTPClient {
    @SneakyThrows
    public static void main(String[] args) {
        usingURL();
    }

    private static void usingURL() throws IOException {
        URL url = new URL("https://gorest.co.in/public/v2/users");
        URLConnection urlConnection = url.openConnection();
        
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String objString = bufferedReader.lines().collect(Collectors.joining());
        System.out.println("objString = " + objString);

        Gson gson = new Gson();
//        Response response = gson.fromJson(objString, Response.class);
//        System.out.println("response = " + response);

    }

    public class ResponseItem{

        @SerializedName("gender")
        private String gender;

        @SerializedName("name")
        private String name;

        @SerializedName("id")
        private int id;

        @SerializedName("email")
        private String email;

        @SerializedName("status")
        private String status;

        public String getGender(){
            return gender;
        }

        public String getName(){
            return name;
        }

        public int getId(){
            return id;
        }

        public String getEmail(){
            return email;
        }

        public String getStatus(){
            return status;
        }
    }

    public class Response{

        @SerializedName("Response")
        private List<ResponseItem> response;

        public List<ResponseItem> getResponse(){
            return response;
        }
    }
}
