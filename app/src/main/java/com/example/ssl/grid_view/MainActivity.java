package com.example.ssl.grid_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private GridView gridview;
    private List<Map<String,Object>> datalist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridview = (GridView)findViewById(R.id.Grid_View);

        initdata();
//        SimpleAdapter adapter = new SimpleAdapter(this,datalist,R.layout.grid_item,
//                new String[]{"imgs","price","content"},new int[]{R.id.Images,R.id.Price,R.id.Content});
        MyAdapter adapter = new MyAdapter(this,datalist);

        gridview.setAdapter(adapter);


    }

    private void initdata() {
        int[] images = {R.drawable.gongbaojiding,R.drawable.shuizhuroupian,R.drawable.suanlajidantang};
        String[] prices = {"$12.5","$45.2","$25.2"};
        String[] contents = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
        "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc",
        "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"};
        datalist = new ArrayList<>();
        for(int i=0;i<images.length;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("imgs",images[i]);
            map.put("price",prices[i]);
            map.put("content",contents[i]);
            datalist.add(map);
        }

    }
}
