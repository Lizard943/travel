package com.example.travellearn2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.travellearn2.Domain.Category;
import com.example.travellearn2.R;
import com.example.travellearn2.databinding.ViewholderCategoryBinding;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewholder> {
    private final List<Category> items;
    private Context context;
    private int selectedPos = -1;
    private int lastSelectedPos = -1;

    public CategoryAdapter(List<Category> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewholderCategoryBinding viewholderCategoryBinding = ViewholderCategoryBinding.inflate(inflater,parent,false);
        return new CategoryViewholder(viewholderCategoryBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewholder holder, int position) {
        Category item = items.get(position);
        holder.binding.title.setText(item.getName());
        Glide.with(holder.itemView.getContext()).load(item.getImagePath()).into(holder.binding.pic);

        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lastSelectedPos = selectedPos;
                selectedPos = position;
                notifyItemChanged(lastSelectedPos);
                notifyItemChanged(selectedPos);
            }

        });
        holder.binding.title.setTextColor(context.getResources().getColor(R.color.white));
        if (position == selectedPos){
            holder.binding.pic.setBackgroundResource(0);
            holder.binding.mainLayout.setBackgroundResource(R.drawable.blue_bg);
            holder.binding.title.setVisibility(View.VISIBLE);
        }
        else {
            holder.binding.pic.setBackgroundResource(R.drawable.gray_bg);
            holder.binding.mainLayout.setBackgroundResource(0);
            holder.binding.title.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CategoryViewholder extends RecyclerView.ViewHolder {
        private ViewholderCategoryBinding binding;
        public CategoryViewholder(@NonNull ViewholderCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
