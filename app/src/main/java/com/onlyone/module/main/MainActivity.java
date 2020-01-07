package com.onlyone.module.main;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.onlyone.R;
import com.onlyone.algorithm.singlelink.Entity;
import com.onlyone.algorithm.singlelink.SingleLinkedList;
import com.onlyone.algorithm.sort.HeapSort;
import com.onlyone.common.base.BaseActivity;
import com.onlyone.common.util.DexUtils;
import com.onlyone.lifecycle.LifeActivity1;
import com.onlyone.module.main.demo.DrawerLayoutActivity;
import com.onlyone.module.main.demo.FlowLayoutActivity;
import com.onlyone.module.main.demo.IndexBarActivity;
import com.onlyone.module.measure.MeasureActivity;
import com.onlyone.module.touch.TouchEventActivity;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * mainActivity
 */
public class MainActivity extends BaseActivity {

    private ListView mListView;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public int getContentViewID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mListView = (ListView) findViewById(R.id.main_list_view);
    }

    @Override
    public void initData() {

        Entity entity1 = new Entity("张一", 31);
        Entity entity2 = new Entity("张二", 32);
        Entity entity3 = new Entity("张三", 33);
        Entity entity4 = new Entity("张四", 34);
        Entity entity5 = new Entity("张五", 35);

        SingleLinkedList<Entity> singleLinkedList = new SingleLinkedList<>(entity1);
        singleLinkedList.add(entity2);
        singleLinkedList.add(entity3);
        singleLinkedList.add(entity4);

        //单链表
        Log.e("singleLinkedList", "getByIndex(2) = " + singleLinkedList.getByIndex(2).getName());
        Log.e("singleLinkedList", "size = " + singleLinkedList.size());
        Log.e("singleLinkedList", "traverse = " + singleLinkedList.traverse());
        singleLinkedList.deleteByIndex(2);
        Log.e("singleLinkedList", "getByIndex(2) = " + singleLinkedList.getByIndex(2).getName());
        Log.e("singleLinkedList", "size = " + singleLinkedList.size());
        Log.e("singleLinkedList", "traverse = " + singleLinkedList.traverse());
        singleLinkedList.addByIndex(entity5, 2);
        Log.e("singleLinkedList", "getByIndex(2) = " + singleLinkedList.getByIndex(2).getName());
        Log.e("singleLinkedList", "size = " + singleLinkedList.size());
        Log.e("singleLinkedList", "traverse = " + singleLinkedList.traverse());

        //堆排序
        int[] keys = {81, 49, 19, 38, 97, 76, 13, 19};
        HeapSort.sort(keys);
        Log.e("Main HeapSort", Arrays.toString(keys));

        //LinkedHashMap
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(0, 0.75f, true);

        Log.e("LinkedHashMap", "0 put  = " + map.put(0, "0"));
        Log.e("LinkedHashMap", "1 put  = " + map.put(1, "1"));
        Log.e("LinkedHashMap", "2 put  = " + map.put(2, "2"));
        Log.e("LinkedHashMap", "3 put  = " + map.put(3, "3"));
        Log.e("LinkedHashMap", "4 put  = " + map.put(4, "4"));
        Log.e("LinkedHashMap", "5 put  = " + map.put(5, "5"));
        Log.e("LinkedHashMap", "6 put  = " + map.put(6, "6"));
        Log.e("LinkedHashMap", "4 put  = " + map.put(4, "4.1"));
        Log.e("LinkedHashMap", "3 get  = " + map.get(3));
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Log.e("LinkedHashMap", " previous   " + entry.getKey() + ":" + entry.getValue());
        }


        //okhttp
        new Thread(new Runnable() {
            @Override
            public void run() {
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
            }
        }).start();


        String url = "http://wwww.baidu.com";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
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


        String s1 = "ab";
        String s2 = "abc";
        String s3 = s1 + "c";


        Log.e("xfz", "" + (s2 == s3));
        Log.e("xfz", "" + (s2.equals(s3)));


        DexUtils.load2(this);


        try {
            Class myDexUtilsClazz = Class.forName("com.xfz.myapplication.MyDexUtils");
            Method method = myDexUtilsClazz.getMethod("print");
            method.invoke(null);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, FlowLayoutActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, IndexBarActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, DrawerLayoutActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, TouchEventActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, MeasureActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, LifeActivity1.class));
                        break;
                    default:
                        break;
                }
            }
        });


    }
}
