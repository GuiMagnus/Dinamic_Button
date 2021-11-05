package com.example.dinamicbutton;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.text.SimpleDateFormat;

import java.util.Date;


public class MainActivity extends AppCompatActivity {
    private RelativeLayout layout;
    private Button dinamicBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.parent);
        dinamicBtn = new Button(MainActivity.this);
    }


    public void generateButton(View view) {
        if(dinamicBtn.getId() == View.NO_ID) {
            LinearLayout.LayoutParams linearLayoutParams =
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
            dinamicBtn.setText("Dinamic button ");
            dinamicBtn.setId(Integer.parseInt("1"));
            layout.addView(dinamicBtn, linearLayoutParams);
        }
        dinamicBtn.setVisibility(View.VISIBLE);

        dinamicBtn.setOnClickListener(v -> v.setVisibility(View.INVISIBLE));

        dinamicBtn.setOnLongClickListener(v -> {
            //....
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
            Date d = new Date();
            String dayOfTheWeek = sdf.format(d);
            Toast.makeText(MainActivity.this, dayOfTheWeek, Toast.LENGTH_SHORT).show();
            return true;
        });

    }
}