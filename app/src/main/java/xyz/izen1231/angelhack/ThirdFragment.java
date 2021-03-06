package xyz.izen1231.angelhack;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import xyz.izen1231.angelhack.pojo.Data;
import xyz.izen1231.angelhack.pojo.Data2;

/**
 * Created by jeong-woochang on 2018. 6. 16..
 */

public class ThirdFragment extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tour);

        ArrayList<Data2> data=new ArrayList<Data2>();
        for(int i=0;i<100;i++){
            Data2 tmp=new Data2();
            tmp.setImgUri("");
            tmp.setTourtext(String.valueOf(i));
            data.add(tmp);
        }

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView3);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        RecyclerAdapter2 mAdapter = new RecyclerAdapter2(data);
        recyclerView.setAdapter(mAdapter);
    }
}
