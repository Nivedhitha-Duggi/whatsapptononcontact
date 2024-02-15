package com.example.whatsapptononcontacts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText phoneNumberEditText;
    private Button openWhatsAppButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumberEditText = findViewById(R.id.phone_number_edit_text);
        openWhatsAppButton = findViewById(R.id.open_whatsapp_button);

        openWhatsAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneNumberEditText.getText().toString().trim();
                if (!phoneNumber.isEmpty()) {
                    openWhatsAppChat(phoneNumber);
                }
            }
        });
    }

    private void openWhatsAppChat(String phoneNumber) {
        Uri uri = Uri.parse("whatsapp://send?phone=" + phoneNumber);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        try {
            startActivity(intent);
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
}

