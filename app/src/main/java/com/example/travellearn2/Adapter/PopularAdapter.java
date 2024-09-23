package com.example.travellearn2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.travellearn2.Activity.DetailActivity;
import com.example.travellearn2.Domain.ItemDomain;
import com.example.travellearn2.databinding.ViewholderPopularBinding;
import com.example.travellearn2.databinding.ViewholderRecommenedBinding;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewholder> {
    private ArrayList<ItemDomain> items = new ArrayList<>();
    private Context context;
    private ViewholderPopularBinding binding;

    public PopularAdapter(ArrayList<ItemDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public PopularAdapter.PopularViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        binding = ViewholderPopularBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PopularViewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.PopularViewholder holder, int position) {
        binding.titleTxt.setText(items.get(position).getTitle());
        binding.addressTxt.setText(items.get(position).getAddress());
        binding.priceTxt.setText("$"+items.get(position).getPrice());
        binding.scoreTxt.setText(items.get(position).getScore()+"");

        Glide.with(context).load(items.get(position).getPic()).into(binding.pic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("object",items.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class PopularViewholder extends RecyclerView.ViewHolder {
        public PopularViewholder(ViewholderPopularBinding binding) {
            super(binding.getRoot());
        }
    }
}
