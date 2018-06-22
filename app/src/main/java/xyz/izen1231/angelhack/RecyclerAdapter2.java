package xyz.izen1231.angelhack;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import xyz.izen1231.angelhack.pojo.User;

/**
 * Created by jeong-woochang on 2018. 6. 16..
 */

public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.ViewHolder> {

    ArrayList<Data2> list=new ArrayList<>();

    public RecyclerAdapter2(ArrayList<Data2> data) {
        list = data;
    }

    @NonNull
    @Override
    public RecyclerAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())

                .inflate(R.layout.item_tour, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter2.ViewHolder holder, int position) {

        Data2 tmp=list.get(position);
        holder.textView1.setText(tmp.getTourtext());
        holder.imageView.setImageResource(Integer.parseInt(tmp.getImgUri()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View mView;
        public ImageView imageView;
        public TextView textView1;

        public ViewHolder(View view) {
            super(view);
            mView=view;
            imageView=(ImageView)mView.findViewById(R.id.tourimage);
            textView1 = (TextView) mView.findViewById(R.id.tourtext);
        }
    }
}
