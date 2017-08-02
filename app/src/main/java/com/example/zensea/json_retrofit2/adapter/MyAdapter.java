package com.example.zensea.json_retrofit2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zensea.json_retrofit2.R;
import com.example.zensea.json_retrofit2.model.Food;

import java.util.List;

/**
 * Created by Zensea on 01-Aug-17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    List<Food.FoodsBean> foodList;
    private Context context;

    public MyAdapter(Context context, List<Food.FoodsBean> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Food.FoodsBean foods = foodList.get(position);
        holder.name.setText(foods.getMenu());
        holder.color.setText(foods.getDirections());
        String imgUrl = foods.getFood_img();
        Glide.with(context)
                .load(imgUrl)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView name, color, price;
        ImageView image;

        public MyHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.productimage);
            name = (TextView) itemView.findViewById(R.id.name);
            color = (TextView) itemView.findViewById(R.id.color);
        }
    }
}
