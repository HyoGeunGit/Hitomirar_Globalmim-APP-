package xyz.izen1231.angelhack;

import android.content.Context;
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
import xyz.izen1231.angelhack.pojo.User;

/**
 * Created by jeong-woochang on 2018. 6. 16..
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<Data> list;

    public RecyclerAdapter(List<Data> data) {
        list = data;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())

                .inflate(R.layout.item_c2c, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        Data tmp=list.get(position);
        holder.textView1.setText(tmp.getWriter());
        holder.textView2.setText(tmp.getDate());
        holder.textView3.setText(tmp.getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View mView;
        public ImageView imageView;
        public TextView textView1, textView2, textView3;

        public ViewHolder(View view) {
            super(view);
            mView=view;
            imageView=(ImageView)mView.findViewById(R.id.imageIcon);
            textView1 = (TextView) mView.findViewById(R.id.writeTv);
            textView2 = (TextView) mView.findViewById(R.id.dateTv);
            textView3 = (TextView) mView.findViewById(R.id.contentTv);
        }
    }
}
