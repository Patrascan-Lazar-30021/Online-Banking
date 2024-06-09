package com.example.myaspay;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class TransferActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transfer);

        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar == null) {
            Log.e("SendActivity", "Toolbar not found in layout file");
        } else {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Button sendButton = findViewById(R.id.send);
        Button askButton = findViewById(R.id.ask);
        Button shareTheCostButton = findViewById(R.id.shere_the_cost);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSend = new Intent(TransferActivity.this, Send.class);
                startActivity(intentSend);
            }
        });
        askButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAsk = new Intent(TransferActivity.this, Ask.class);
                startActivity(intentAsk);
            }
        });
        shareTheCostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentShareTheCost = new Intent(TransferActivity.this, ShareTheCost.class);
                startActivity(intentShareTheCost);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
