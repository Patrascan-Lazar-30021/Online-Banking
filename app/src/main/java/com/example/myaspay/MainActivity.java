package com.example.myaspay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button transferButton = findViewById(R.id.transfer);
        Button transferIbanButton = findViewById(R.id.transfer_IBAN);
        Button showDataButton = findViewById(R.id.show_data);
        Button transactionHistoryButton = findViewById(R.id.transaction_history);
        Button roundUpButton = findViewById(R.id.round_up);
        Button cashWithdrawalButton = findViewById(R.id.cash_withdrawal);
        Button cardSettingsButton = findViewById(R.id.card_settings);

        transferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTransfer = new Intent(MainActivity.this, TransferActivity.class);
                startActivity(intentTransfer);
            }
        });
        transferIbanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTransferIban = new Intent(MainActivity.this, TransferIBAN.class);
                startActivity(intentTransferIban);
            }
        });
        showDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentShowData = new Intent(MainActivity.this, ShowData.class);
                startActivity(intentShowData);
            }
        });
        transactionHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTransactionHistory = new Intent(MainActivity.this, TransactionHistory.class);
                startActivity(intentTransactionHistory);
            }
        });
        roundUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRoundUp = new Intent(MainActivity.this, RoundUp.class);
                startActivity(intentRoundUp);
            }
        });
        cashWithdrawalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCashWithdrawal = new Intent(MainActivity.this, CashWithdrawal.class);
                startActivity(intentCashWithdrawal);
            }
        });
        cardSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCardSettings = new Intent(MainActivity.this, CardSettings.class);
                startActivity(intentCardSettings);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
