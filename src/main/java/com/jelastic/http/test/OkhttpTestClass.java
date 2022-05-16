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
                .addHeader("Cookie", "docsSession=7df032ed5b812b334dd906fd473d5e53d3dc801cbd25aa54ac8350fe917deccac6eda73ebd277021923a44c42585c68e7b3b393a98260cbd53ecba17162492d898f75895c649fc5651cdb6874782da75781c13d35b5f6dc8c5670c796a29c6791134ef5019922398ab119c1982a26223%24358a896a453073ce092303ba753030bc%2418ad94744b19cf4ff015e69763355a5f")
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