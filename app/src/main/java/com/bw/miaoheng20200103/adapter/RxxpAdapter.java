package com.bw.miaoheng20200103.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.miaoheng20200103.R;
import com.bw.miaoheng20200103.entity.DataEntity;
import com.bw.miaoheng20200103.util.Utils;

import java.util.List;

/**
 * 时间 :2020/1/3  8:58
 * 作者 :苗恒
 * 功能 :
 */
public class RxxpAdapter extends RecyclerView.Adapter<RxxpAdapter.MyViewHolder> {
    Context context;
    List<DataEntity.ResultBean.RxxpBean.CommodityListBean> commodityListBeanList;
    public RxxpAdapter(Context context, List<DataEntity.ResultBean.RxxpBean.CommodityListBean> commodityListBeanList) {
        this.context=context;
        this.commodityListBeanList=commodityListBeanList;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.item,null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(commodityListBeanList.get(position).getCommodityName());
        holder.tv_price.setText("$"+commodityListBeanList.get(position).getPrice());
        Glide.with(context).load(commodityListBeanList.get(position).getMasterPic()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return  commodityListBeanList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView imageView;
        private final TextView tv_name;
        private final TextView tv_price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
        }
    }
}
