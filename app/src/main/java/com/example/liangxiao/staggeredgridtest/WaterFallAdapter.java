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

public class WaterFallAdapter extends RecyclerView.Adapter<WaterFallAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> mData; //定义数据源

    public WaterFallAdapter(Context context, List<String> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String url = mData.get(position);
        Uri uri = Uri.parse(url);
        holder.mDraweeView.setImageURI(uri);
        //如果竖向滑动，高度变化，横向滑动，宽度变化
        holder.mDraweeView.getLayoutParams().width = (position % 2) * 100 + 300 + (int) (Math.random() * 300);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView mDraweeView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mDraweeView = itemView.findViewById(R.id.image_item);
        }
    }
}
