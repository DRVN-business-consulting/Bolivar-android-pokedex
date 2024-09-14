package com.bolivar.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView loginStatusTextView;


    private static final String UsernameH = "user";
    private static final String PasswordH = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        usernameEditText = findViewById(R.id.UsernameH);
        passwordEditText = findViewById(R.id.PasswordH);
        loginButton = findViewById(R.id.login_button);
        loginStatusTextView = findViewById(R.id.login_status);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (UsernameH.equals(username) && PasswordH.equals(password)) {
                    Intent intent = new Intent(MainActivity.this, Pokedex.class);
                    startActivity(intent);
                    finish();
                } else {
                    loginStatusTextView.setText("Invalid Username or Password");
                }
            }
        });
    }
}
