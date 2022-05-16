package com.jelastic.http.test;

import okhttp3.*;

import java.io.IOException;

public class OkhttpTestClass {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "Message=Hello");
        Request request = new Request.Builder()
                .url("https://qredab.eu.auth0.com")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Response:\n" + response.toString());
        System.out.println("\n Response headers:\n" + response.headers().toString());
        if (response.body() != null) {
            try {
                System.out.println("\n\n Response body:\n" + response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("\n Response body is empty!\n");
        }
    }
}