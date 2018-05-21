package com.example.liangxiao.staggeredgridtest;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class WaterFallAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<PersonCard> mData; //定义数据源

    public WaterFallAdapter(Context context, List<PersonCard> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.image_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        PersonCard personCard = mData.get(position);
        Uri uri = Uri.parse(personCard.avatarUrl);
        myViewHolder.mDraweeView.setImageURI(uri);
        myViewHolder.mDraweeView.getLayoutParams().height = personCard.imgHeight;
        myViewHolder.mDescription.setText(personCard.name);
    }

    @Override
    public int getItemCount() {
        if (mData != null){
            return mData.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView mDraweeView;
        public TextView mDescription;

        public MyViewHolder(View itemView) {
            super(itemView);
            mDraweeView = itemView.findViewById(R.id.image_item);
            mDescription = itemView.findViewById(R.id.image_description);
        }
    }
}
