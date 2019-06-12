package com.alexleo.gfq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alexleo.partialrefreshdemo.R;

import java.util.ArrayList;
import java.util.List;

public class Act extends AppCompatActivity {

    private RecyclerView rvActRv;
    private List<TestBean> list;
    private RvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
        rvActRv = (RecyclerView) findViewById(R.id.rvActRv);

        list = new ArrayList<>();
        //模拟数据
        for (int i = 0; i < 40; i++) {
            list.add(new TestBean().setName("test>>"+i).setContent("content<<>>"+i));
        }

        adapter = new RvAdapter(this,list);

        rvActRv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvActRv.setAdapter(adapter);

    }


}
