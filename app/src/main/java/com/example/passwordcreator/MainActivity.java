package com.example.passwordcreator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText_length, editText_password;
    CheckBox checkBox_capitals, checkBox_lowercase, checkBox_numbers, checkBox_symbols;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button_password);
        editText_length = findViewById(R.id.edittext_length);
        editText_password = findViewById(R.id.edittext_password);
        checkBox_capitals = findViewById(R.id.checkbox_capital_letters);
        checkBox_lowercase = findViewById(R.id.checkbox_lower_case_letters);
        checkBox_numbers = findViewById(R.id.checkbox_numbers);
        checkBox_symbols = findViewById(R.id.checkbox_symbols);
    }

    @Override
    protected void onResume() {
        super.onResume();
        button.setOnClickListener(v -> {
            String s1 = editText_length.getText().toString();
            int i = Integer.parseInt(s1);

            String s2 = getCharacters(checkBox_capitals.isChecked(), checkBox_lowercase.isChecked(), checkBox_numbers.isChecked(), checkBox_symbols.isChecked());
            editText_password.setText(recRandom(i,null,s2));
        });
    }

    private String getCharacters(boolean capitals, boolean lowercase, boolean numbers, boolean symbols){
        String s1 = "", s2, s3, s4;
        if (capitals) {
            s2 = s1.concat("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        } else {
            s2 = s1;
        }
        if (lowercase) {
            s3 = s2.concat("abcdefghijklmnopqrstuvwxyz");
        } else {
            s3 = s2;
        }
        if (numbers) {
            s4 = s3.concat("1234567890");
        } else {
            s4 = s3;
        }
        if (symbols) {
            return s4.concat(".,-!%&/()=?#+*");
        }
        return s4;
    }

    private static String recRandom(int leftCharacters, String password, String availableCharacters) {

        if (password == null){
            // password initialisation
            String newPassword = "";
            return recRandom(leftCharacters, newPassword, availableCharacters);

        } else if (leftCharacters > 0) {
            /* Recursive Part.
             * This part adds an random character every time it is called.
             */
            leftCharacters--;
            Random random = new Random();
            int number = random.nextInt(availableCharacters.length());
            String newPassword = password + availableCharacters.charAt(number);
            return recRandom(leftCharacters, newPassword, availableCharacters);

        } else
            return password;
    }

}