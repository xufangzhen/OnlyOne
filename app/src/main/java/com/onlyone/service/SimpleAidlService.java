package com.onlyone.service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.onlyone.MyAIDLService;


public class SimpleAidlService extends Service {

    private int count;
    private boolean quit;


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("xfz", "onCreate");
        new Thread(() -> {
            while (!quit) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    count++;
                }
            }
        }).start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("xfz", "onBind");
        return new MyBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("xfz", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        Log.e("xfz", "bindService");
        return super.bindService(service, conn, flags);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("xfz", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.e("xfz", "onRebind");
        super.onRebind(intent);
    }

    @Override
    public void onDestroy() {
        Log.e("xfz", "onDestroy");
        this.quit = true;
        super.onDestroy();
    }

    class MyBinder extends MyAIDLService.Stub {

        public int getCount() {
            return count++;
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String getString() throws RemoteException {
            return "服务器获取 ：" + getCount();
        }
    }
}
