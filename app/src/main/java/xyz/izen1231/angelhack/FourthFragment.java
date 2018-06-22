package xyz.izen1231.angelhack;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import xyz.izen1231.angelhack.pojo.Data3;

/**
 * Created by jeong-woochang on 2018. 6. 16..
 */

public class FourthFragment extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_fragment);

        ArrayList<Data3> data = new ArrayList<Data3>();
        //ArrayList<Data3> data2 = new ArrayList<Data3>();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fourth_recyclerView);
        //RecyclerView recyclerView1=(RecyclerView)findViewById(R.id.fourth_recyclerView2);
        recyclerView.setHasFixedSize(true);
        //recyclerView1.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false);
        //RecyclerView.LayoutManager mLayoutManager2 = new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView1.setLayoutManager(mLayoutManager2);
        RecyclerAdapter3 mAdapter = new RecyclerAdapter3(data);
        //RecyclerAdapter3_2 mAdapter2 = new RecyclerAdapter3_2(data);
        recyclerView.setAdapter(mAdapter);
        //recyclerView1.setAdapter(mAdapter2);

        for (int i = 1; i < 100; i++) {
            Data3 tmp = new Data3();
            tmp.setRank(String.valueOf(i));
            tmp.setScorename(String.valueOf(i));
            data.add(tmp);
        }
    }

}
