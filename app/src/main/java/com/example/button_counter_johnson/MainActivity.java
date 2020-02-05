package com.example.button_counter_johnson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button increaseButton, decreaseButton, clearButton;
    public TextView counterDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        increaseButton = findViewById(R.id.increaseButton);
        decreaseButton = findViewById(R.id.decreaseButton);
        counterDisplay = findViewById(R.id.counterDisplay);
        clearButton = findViewById(R.id.clearButton);


        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer temp = Integer.parseInt(counterDisplay.getText().toString());
                temp++;
                String result = temp.toString();
                counterDisplay.setText(result);
            }
        });

        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer temp = Integer.parseInt(counterDisplay.getText().toString());
                temp--;
                String result = temp.toString();
                counterDisplay.setText(result);
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterDisplay.setText("0");
            }
        });
    }
        @Override
        public void onSaveInstanceState(Bundle outState){
            super.onSaveInstanceState(outState);
            outState.putString("counter", counterDisplay.getText().toString());

        }

        @Override
        protected void onRestoreInstanceState(Bundle inState)
        {
            super.onRestoreInstanceState(inState);
            String counter = inState.getString("counter");
            counterDisplay.setText(counter);
        }
}
