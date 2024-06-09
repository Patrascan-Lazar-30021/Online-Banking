package com.example.myaspay;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.concurrent.atomic.AtomicBoolean;

public class TransferIBAN extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transfer_iban);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView circleIBAN = findViewById(R.id.point_IBAN);
        ImageView circleAliasPay = findViewById(R.id.point_Alias_Pay);

        final AtomicBoolean isFilled = new AtomicBoolean(false);

        circleIBAN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFilled.get()) {
                    circleIBAN.setImageResource(R.drawable.circle_243);
                } else {
                    circleIBAN.setImageResource(R.drawable.circle_24);
                }
                isFilled.set(!isFilled.get());
            }
        });

        circleAliasPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFilled.get()) {
                    circleAliasPay.setImageResource(R.drawable.circle_243);
                } else {
                    circleAliasPay.setImageResource(R.drawable.circle_24);
                }
                isFilled.set(!isFilled.get());
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
