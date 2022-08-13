package com.example.tellme1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView name1 = findViewById(R.id.textView3);
        TextView age1 = findViewById(R.id.textView4);
        TextView job1 = findViewById(R.id.textView5);
        TextView gender1 = findViewById(R.id.textView6);
        ImageView image2 =  (ImageView)  findViewById(R.id.imageView2);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
       name1.setText(name);
      int age =bundle.getInt("age");
       age1.setText(String.valueOf(age));
       String job = bundle.getString("job");
       job1.setText(job);
        String gender = bundle.getString("gender");
        gender1.setText(gender);

    }
}