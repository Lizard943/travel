package com.example.travellearn2.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.travellearn2.Domain.ItemDomain;
import com.example.travellearn2.R;
import com.example.travellearn2.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    public ItemDomain object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        setValuable();
    }

    private void setValuable() {
        binding.titleTxt.setText(object.getTitle());
        binding.priceTxt.setText(object.getPrice());
        binding.backBtn.setOnClickListener(v->finish());
        binding.bedTxt.setText(object.getBed());
        binding.addressTxt.setText(object.getAddress());
        binding.distanceTxt.setText(object.getDistance());
        binding.durationTxt.setText(object.getDuration());
        binding.ratingTxt.setText(object.getScore()+ " Rating");
        binding.ratingBar.setRating((float) object.getScore());

        Glide.with(this).load(object.getPic()).into(binding.pic);

        binding.addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(this,)
            }
        });
    }

    private void getIntentExtra() {
        object = (ItemDomain) getIntent().getSerializableExtra("object");
    }
}