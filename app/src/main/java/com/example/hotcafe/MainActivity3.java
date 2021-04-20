package com.example.hotcafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Integer> integerArrayList;
    ArrayList<String > stringArrayList;
    MyAdapter myAdapter;
    RecyclerView recyclerView2;
    ArrayList<Integer> integerArrayList2;
    ArrayList<String > stringArrayList2;
    MyAdapter2 myAdapter2;
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        recyclerView=findViewById(R.id.recyclerview1);
        recyclerView2=findViewById(R.id.recyclerview2);

        textView=findViewById(R.id.textviewprice);
        imageView=findViewById(R.id.backet);
        textView.setVisibility(View.INVISIBLE);

        integerArrayList=new ArrayList<>();
        stringArrayList=new ArrayList<>();

        integerArrayList.add(R.drawable.cate1);
        integerArrayList.add(R.drawable.cate2);
        integerArrayList.add(R.drawable.cate3);
        integerArrayList.add(R.drawable.cate4);
        integerArrayList.add(R.drawable.cate5);
        stringArrayList.add("Lag'mon");
        stringArrayList.add("sho'rva");
        stringArrayList.add("Tovuq");
        stringArrayList.add("Shashlik");
        stringArrayList.add("Shirinlik");

        integerArrayList2=new ArrayList<>();
        stringArrayList2=new ArrayList<>();

        integerArrayList2.add(R.drawable.cate4);
        integerArrayList2.add(R.drawable.cate5);
        integerArrayList2.add(R.drawable.cate2);
        integerArrayList2.add(R.drawable.cate1);
        integerArrayList2.add(R.drawable.cate3);
        stringArrayList2.add("Shashlik");
        stringArrayList2.add("Shirinlik");
        stringArrayList2.add("Sho'rva");
        stringArrayList2.add("Lag'mon");
        stringArrayList2.add("Tovuq");


        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        myAdapter=new MyAdapter(MainActivity3.this,integerArrayList,stringArrayList);
        recyclerView.setAdapter(myAdapter);



        recyclerView2.setHasFixedSize(true);

        recyclerView2.setLayoutManager(new LinearLayoutManager(MainActivity3.this));
        myAdapter2=new MyAdapter2(MainActivity3.this,integerArrayList2,stringArrayList2);
        recyclerView2.setAdapter(myAdapter2);
    }
}