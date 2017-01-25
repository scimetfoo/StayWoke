package com.example.staywoke;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.murtaza0xff.staywoke.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by murtaza on 21/1/17.
 */

public class SecondActivity extends AppCompatActivity {

    @BindView(com.example.staywoke.R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.staywoke.R.layout.activity_main);
        ButterKnife.bind(this);
        final Context context = this;
        button.setText("Go to third activity");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, ThirdActivity.class));
            }
        });
    }
}
