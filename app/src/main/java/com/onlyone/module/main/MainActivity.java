package com.onlyone.module.main;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSONObject;
import com.onlyone.R;
import com.onlyone.algorithm.leecode.Zconvert;
import com.onlyone.algorithm.singlelink.Entity;
import com.onlyone.algorithm.singlelink.SingleLinkedList;
import com.onlyone.algorithm.sort.insert.InsertSort;
import com.onlyone.algorithm.test.StringDemo;
import com.onlyone.algorithm.tree.TreeNode;
import com.onlyone.algorithm.tree.TreeTraverse;
import com.onlyone.common.base.BaseActivity;
import com.onlyone.common.util.DexUtils;
import com.onlyone.lifecycle.LifeActivity1;
import com.onlyone.module.main.demo.DrawerLayoutActivity;
import com.onlyone.module.main.demo.FlowLayoutActivity;
import com.onlyone.module.main.demo.IndexBarActivity;
import com.onlyone.module.measure.MeasureActivity;
import com.onlyone.module.touch.TouchEventActivity;
import com.onlyone.plugin.container.OnlyFlutterActivity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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

//        OkHttpClient okHttpClient = new OkHttpClient();
//
//        Request request = new Request().body().
//
//        okHttpClient.newCall(request.e)


    }

    private static void out(Object[] data) {
        System.out.println(Arrays.toString(data));
    }

    @Override
    public void initData() {

        List<? extends View> Views = new ArrayList<>();

        String s = "我和你心连心";
        Log.e("Zconvert", new Zconvert().convert2("PAYPALISHIRING", 3));


        new StringDemo().print();

        TreeTraverse.traverse5(TreeNode.buildTree());


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
        int[] keys = {81, 49, 19, 38, 97, 76, 13};


//        HeapSort.sort(keys);
//
//
        InsertSort.sort(keys);
        Log.e("BubbleSort", Arrays.toString(keys));

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
                    case 6:
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("oneThing", "video");
                        OnlyFlutterActivity.launch(MainActivity.this, "onePage", jsonObject, 10);
                        break;
                    default:
                        break;
                }
            }
        });


    }


    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    class IAsyncTask extends AsyncTask<String, Integer, String> {
        protected String doInBackground(String... args1) {

            try {
                int times = 4;

                Log.i("doInBackground", "currentThread = " + Thread.currentThread().getName()); //这个doInBackground就打印一个Log，然后sleep 20 毫秒
                Thread.sleep(20);

            } catch (Exception e) {

            }
            return "over";
        }
    }


    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println("Hello World!");

        Scanner in = new Scanner(System.in);
        List<Integer> inList = new ArrayList();
        while (in.hasNext()) {
            inList.add(in.nextInt());
        }
        out((Integer[]) inList.toArray());
    }

    private static void out(Integer[] data) {
        int min = data[0];
        for (int i = 1; i < data.length; i++) {
            if (min > data[i]) {
                min = data[i];
            }
        }

        System.out.println(String.valueOf(min));


    }

}
