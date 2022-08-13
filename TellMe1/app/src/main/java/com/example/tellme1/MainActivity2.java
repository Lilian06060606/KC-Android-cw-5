package com.example.tellme1;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button select;
    ImageView photo1;

    ActivityResultLauncher<String> galleryLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tell = findViewById(R.id.textView);
        Button select = (Button) findViewById(R.id.button2);
        ImageView photo1 = (ImageView) findViewById(R.id.imageView);

        galleryLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri uri) {
                photo1.setImageURI(uri);


            }
        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                galleryLauncher.launch("image/*");
            }
        });
        EditText nameEdt = findViewById(R.id.editTextTextPersonName);
        EditText ageEdt = findViewById(R.id.editTextTextPersonName8);
        EditText jobEdt = findViewById(R.id.editTextTextPersonName11);
        EditText genderEdt = findViewById(R.id.editTextTextPersonName9);
        Button submit = findViewById(R.id.button3);
        TextView error = findViewById(R.id.textView7);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameEdt.getText().toString().equals("")) {
                    Toast.makeText(MainActivity2.this, "Plz make sure to fill the space", Toast.LENGTH_SHORT).show();

                } else if (jobEdt.getText().toString().equals("")) {
                    Toast.makeText(MainActivity2.this, "Plz make sure to fill the space", Toast.LENGTH_SHORT).show();
                } else if (genderEdt.getText().toString().equals("")) {
                    Toast.makeText(MainActivity2.this, "Plz make sure to fill the space", Toast.LENGTH_SHORT).show();

                } else if (ageEdt.getText().toString().equals("")) {
                    Toast.makeText(MainActivity2.this, "Plz make sure to fill the space", Toast.LENGTH_SHORT).show();

                }else{
                    String name = nameEdt.getText().toString();
                    int age = Integer.parseInt(ageEdt.getText().toString());
                    String job = jobEdt.getText().toString();
                    String gender = genderEdt.getText().toString();

                    Intent intent3 = new Intent(MainActivity2.this, MainActivity3.class);
                    intent3.putExtra("name", name);
                    intent3.putExtra("age", age);
                    intent3.putExtra("job", job);
                    intent3.putExtra("gender", gender);
                    startActivity(intent3);}

            }


        });


    }
}