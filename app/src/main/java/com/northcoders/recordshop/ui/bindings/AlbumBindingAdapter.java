package com.northcoders.recordshop.ui.bindings;

import android.widget.EditText;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;

public class AlbumBindingAdapter {
    @BindingAdapter("android:text")
    public static void setInteger(EditText view, Integer value) {
        String currentText = view.getText().toString();
        String newText = value == null ? "" : String.valueOf(value);

        if (!currentText.equals(newText)) {
            view.setText(newText);
        }
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static Integer getInteger(EditText view) {
        String value = view.getText().toString();

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
