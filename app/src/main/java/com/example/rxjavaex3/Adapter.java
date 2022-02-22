package com.example.rxjavaex3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ArrayList courseImg,courseName;
    ArrayList<CoinsData> coinsDataArrayList;
    Context context;

    public Adapter(ArrayList<CoinsData> coinsDataArrayList, Context context) {
        this.coinsDataArrayList = coinsDataArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);

        Adapter.ViewHolder viewHolder=new Adapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        CoinsData coinsData = coinsDataArrayList.get(position);
        holder.tvCoinName.setText(coinsData.getName());
        holder.tvCoinPrice.setText(String.valueOf(coinsData.getPrice()));
        Glide.with(context).load(coinsData.getCoinImage()).into(holder.coinImage);


    }

    @Override
    public int getItemCount() {
        return coinsDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView coinImage;
        TextView tvCoinName,tvCoinPrice;

        public ViewHolder(@NonNull View view) {
            super(view);
            coinImage = (CircleImageView) view.findViewById(R.id.img_coin);
            tvCoinName = (TextView) view.findViewById(R.id.tv_coin_name);
            tvCoinPrice = (TextView) view.findViewById(R.id.tv_coin_price);
        }
    }
    }
