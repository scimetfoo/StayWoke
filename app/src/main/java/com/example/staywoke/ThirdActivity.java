package com.example.staywoke;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.murtaza0xff.staywoke.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ThirdActivity extends AppCompatActivity {

    @BindView(com.example.staywoke.R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.staywoke.R.layout.activity_main);
        ButterKnife.bind(this);
        button.setText("That's all, folks!");
    }
}

