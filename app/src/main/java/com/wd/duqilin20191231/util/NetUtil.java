package com.wd.duqilin20191231.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogRecord;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * date:2019/12/31
 * author:贺少伟(盗)
 * function:
 */
public class NetUtil {

    private final OkHttpClient okHttpClient;
    private final Handler handler;
    //方法
    private NetUtil() {
        //日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addNetworkInterceptor(httpLoggingInterceptor)
                .build();
        handler = new Handler();
    }

    public static NetUtil netUtil;
    //双重校验所
    public static NetUtil getInstance() {
        if (netUtil == null){
            synchronized (NetUtil.class){
                if (netUtil == null){
                    netUtil = new NetUtil();
                }
            }
        }
        return netUtil;
    }

////    使用get方法请求网咯
//    public void getJson(String httpUrl,MyCallBack myCallBack){
//
//        Call call = okHttpClient.newCall();
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        myCallBack.onError(e);
//                    }
//                });
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if (response != null && response.isSuccessful()) {
//                    String string = response.body().string();
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            myCallBack.onGetJson(string);
//                        }
//                    });
//                }else {
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            myCallBack.onError(new Exception("失败"));
//                        }
//                    });
//                }
//            }
//        });
//    }
    //判断是否有网
    public boolean haxNet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            return true;
        }else {
            return false;
        }
    }

    //定义一个借口
    public interface MyCallBack{
        void onGetJson(String json);
        void onError(Throwable throwable);
    }
}
