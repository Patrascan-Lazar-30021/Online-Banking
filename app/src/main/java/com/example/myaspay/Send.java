package com.example.myaspay;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

public class Send extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);

        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar == null) {
            Log.e("SendActivity", "Toolbar not found in layout file");
        } else {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        ImageView addNumberForTransferButton = findViewById(R.id.addNumberForTransferButton);
        addNumberForTransferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddNumberForTransfer = new Intent(getApplicationContext(), AddNumberForTransfer.class);
                startActivity(intentAddNumberForTransfer);
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
