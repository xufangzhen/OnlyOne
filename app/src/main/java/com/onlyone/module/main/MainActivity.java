package com.onlyone.module.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.onlyone.R;
import com.onlyone.common.base.BaseActivity;
import com.onlyone.module.launch.ActivityA;
import com.onlyone.module.main.demo.DrawerLayoutActivity;
import com.onlyone.module.main.demo.FlowLayoutActivity;
import com.onlyone.module.main.demo.IndexBarActivity;
import com.onlyone.module.measure.MeasureActivity;
import com.onlyone.module.touch.TouchEventActivity;

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
        String s1 = "ab";
        String s2 = "abc";
        String s3 = s1 + "c";

        Log.e("xfz", "" + (s2 == s3));
        Log.e("xfz", "" + (s2.equals(s3)));


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
                        startActivity(new Intent(MainActivity.this, ActivityA.class));
                        break;
                    default:
                        break;
                }
            }
        });


    }
}
