package com.example.tempraturecricket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView tvRes;
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextNumber);
        button = findViewById(R.id.btnCal);
        tvRes = findViewById(R.id.textResult);

        tvRes.setVisibility(View.GONE);

        formatter = new DecimalFormat("#0.00");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int chirps = Integer.parseInt(editText.getText().toString().trim());
                    double temp = (chirps / 3.0) + 4;

                    String results = "The approximate temperature outside is " +formatter.format(temp) +" degrees Celsius";
                    tvRes.setText(results);
                    tvRes.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}