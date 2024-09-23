package com.example.travellearn2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.travellearn2.Domain.ItemDomain;
import com.example.travellearn2.databinding.ViewholderRecommenedBinding;

import java.util.ArrayList;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.RecommendedViewholder> {
    private ArrayList<ItemDomain> items = new ArrayList<>();
    private Context context;
    private ViewholderRecommenedBinding binding;

    public RecommendedAdapter(ArrayList<ItemDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecommendedAdapter.RecommendedViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        binding = ViewholderRecommenedBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new RecommendedViewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedAdapter.RecommendedViewholder holder, int position) {
        binding.titleTxt.setText(items.get(position).getTitle());
        binding.addressTxt.setText(items.get(position).getAddress());
        binding.priceTxt.setText("$"+items.get(position).getPrice());
        binding.scoreTxt.setText(items.get(position).getScore()+"");

        Glide.with(context).load(items.get(position).getPic()).into(binding.pic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class RecommendedViewholder extends RecyclerView.ViewHolder {
        public RecommendedViewholder(ViewholderRecommenedBinding binding) {
            super(binding.getRoot());
        }
    }
}
