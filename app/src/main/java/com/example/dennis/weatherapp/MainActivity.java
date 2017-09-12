package com.example.dennis.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    //This is the binds. I bind all my components here at the top
    @Bind(R.id.myEditText) EditText mEditText;
    @Bind(R.id.myButton) Button mButton;

//This is where the app will run from
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Implement my Butter knife for the binds above
        ButterKnife.bind(this);
//This is the action for clicking of the button
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Defines what happens when the button is clicked
                String location = mEditText.getText().toString();
                Intent intent = new Intent(MainActivity.class, Weather.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });
    }
}
