package com.onlyone.module.main;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.onlyone.R;
import com.onlyone.common.base.BaseActivity;
import com.onlyone.common.util.LogUtils;
import com.onlyone.common.widget.flowlayout.JustifyFlowLayout;
import com.onlyone.module.main.demo.FlowLayoutActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * mainActivity
 */
public class MainActivity extends BaseActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void initView() {
        mListView = (ListView) findViewById(R.id.main_list_view);
    }

    @Override
    public void initData() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, FlowLayoutActivity.class));
                        break;
                }
            }
        });
    }
}
