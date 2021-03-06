package xyz.izen1231.angelhack;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import xyz.izen1231.angelhack.pojo.Data;
import xyz.izen1231.angelhack.pojo.Data2;
import xyz.izen1231.angelhack.pojo.Data3;
import xyz.izen1231.angelhack.pojo.User;

/**
 * Created by jeong-woochang on 2018. 6. 16..
 */

public class RecyclerAdapter3 extends RecyclerView.Adapter<RecyclerAdapter3.ViewHolder> {

    List<Data3> list;

    public RecyclerAdapter3(List<Data3> data) {
        list = data;
    }

    @NonNull
    @Override
    public RecyclerAdapter3.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())

                .inflate(R.layout.item_score, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter3.ViewHolder holder, int position) {

        Data3 tmp=list.get(position);
        holder.textView2.setText(tmp.getRank());
        holder.textView1.setText(tmp.getScorename());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View mView;
        public TextView textView1, textView2;

        public ViewHolder(View view) {
            super(view);
            mView=view;
            textView2=(TextView) mView.findViewById(R.id.rank);
            textView1 = (TextView) mView.findViewById(R.id.scoretext);
        }
    }
}
