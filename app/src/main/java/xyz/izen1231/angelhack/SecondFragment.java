package xyz.izen1231.angelhack;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import xyz.izen1231.angelhack.pojo.Data;

/**
 * Created by jeong-woochang on 2018. 6. 16..
 */

@SuppressLint("ValidFragment")
public class SecondFragment extends android.support.v4.app.Fragment {
    public SecondFragment()
    {
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ArrayList<Data> data=new ArrayList<Data>();
        for(int i=100;i>-1;i--){
            Data tmp=new Data();
            tmp.setWriter(String.valueOf(i));
            tmp.setDate(String.valueOf(i));
            tmp.setContent(String.valueOf(i));
            tmp.setId(String.valueOf(i));
            data.add(tmp);
        }
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_c2c, container, false);

        RecyclerView recyclerView=(RecyclerView)layout.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        RecyclerAdapter mAdapter = new RecyclerAdapter(data);
        recyclerView.setAdapter(mAdapter);
        return layout;
    }

}
