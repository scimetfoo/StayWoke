package com.example.staywoke;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.murtaza0xff.staywoke.StayWoke;
import com.murtaza0xff.staywoke.WakeUp;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        WakeUp.init(this);
        StayWoke.init(getApplication(), MainActivity.class, SecondActivity.class);
        final Context context = this;
        button.setText("Go to second activity");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, SecondActivity.class));
            }
        });
    }
}
