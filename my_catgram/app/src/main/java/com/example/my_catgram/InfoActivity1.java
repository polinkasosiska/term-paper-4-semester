package com.example.my_catgram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoActivity1 extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info1);
        button = findViewById(R.id.button);
        /*
    public void onClick(View view) {
        Intent intent = new Intent(this, EmailPasswordActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);

    }

         */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoActivity1.this, InfoActivity2.class);
                startActivity(intent);
            }
        });
    }
}