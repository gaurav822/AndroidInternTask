package com.example.task9recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    int myImages[];
    String mycodeNames[];
    String myVersionNumber[];
    String myapiLevels[];
    String myreleaseDate[];
    Context ct;

    public MyAdapter(MainActivity mainActivity, int[] images, String[] codename, String[] versionNumber, String[] apiLevels, String[] releaseDate) {

        myImages=images;
        mycodeNames=codename;
        myVersionNumber=versionNumber;
        myapiLevels=apiLevels;
        myreleaseDate=releaseDate;

        ct=mainActivity;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct).inflate(R.layout.myitem,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.iv.setImageResource(myImages[position]);
        holder.tv1.setText(mycodeNames[position]);
        holder.tv2.setText(myVersionNumber[position]);
        holder.tv3.setText(myapiLevels[position]);
        holder.tv4.setText(myreleaseDate[position]);

    }

    @Override
    public int getItemCount() {
        return myImages.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.poster);
            tv1= itemView.findViewById(R.id.codeName);
            tv2= itemView.findViewById(R.id.versionNumber);
            tv3= itemView.findViewById(R.id.apiLevel);
            tv4= itemView.findViewById(R.id.releaseDate);
        }
    }
}
