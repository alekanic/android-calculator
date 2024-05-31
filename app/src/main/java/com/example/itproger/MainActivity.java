package com.example.itproger;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private EditText numOne;
    private EditText numTwo;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        numOne = findViewById(R.id.editTextNumber);
        numTwo = findViewById(R.id.editTextNumber2);
        button = findViewById(R.id.button);
        resultTextView = findViewById(R.id.text_important);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1 = Float.parseFloat(numOne.getText().toString());
                float num2 = Float.parseFloat(numTwo.getText().toString());
                float res = num1 + num2;
                resultTextView.setText(String.valueOf(res));
            }
        });
    }
}