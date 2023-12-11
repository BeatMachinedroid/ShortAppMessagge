package com.example.shortappmessagge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button = findViewById(R.id.kirim);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS();
            }
        });
    }

    private void sendSMS() {
        EditText editTextPhone = findViewById(R.id.nomer);
        EditText editTextMessage = findViewById(R.id.pesan);

        String phoneNumber = editTextPhone.getText().toString();
        String message = editTextMessage.getText().toString();

        if (!phoneNumber.isEmpty() && !message.isEmpty()) {
            SmsManager smsManager = SmsManager.getDefault();
            Intent sentIntent = new Intent("SMS_SENT");
            PendingIntent sentPI = PendingIntent.getBroadcast(this, 0, sentIntent, PendingIntent.FLAG_IMMUTABLE);
            smsManager.sendTextMessage(phoneNumber, null, message, sentPI, null);
        } else {
            Toast.makeText(this, "Isi nomor telepon dan pesan terlebih dahulu", Toast.LENGTH_SHORT).show();
        }
    }
}