package com.northcoders.recordshop.ui.bindings;

import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.northcoders.recordshop.R;

public class GlideBindingAdapter {
        @BindingAdapter(value = {"coverArtUrl"}, requireAll = false)
        public static void getCoverArtUrl(ImageView view, @Nullable String url) {
            if (url != null && !url.trim().isEmpty()) {
                Glide.with(view.getContext())
                        .load(url)
                        .into(view);
            } else {
                view.setImageResource(R.drawable.default_album_cover);
            }
        }
}
