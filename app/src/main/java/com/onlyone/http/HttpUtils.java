package com.onlyone.http;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtils {


    public static final void asynHttpUtils() {

        String url = "http://wwww.baidu.com";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            }
        });

    }


    public static final void synHttpUtils() {
        new Thread(() -> {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url("http://www.baidu.com").build();
            try {
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    System.out.println("成功");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
