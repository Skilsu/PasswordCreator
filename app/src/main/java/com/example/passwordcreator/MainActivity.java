package com.example.passwordcreator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static String[] a;
    private static String b = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.,-!%&/()=?#+*";
    private static boolean Kleinbuchstaben, Großbuchstaben, Zahlen, Zeichen;
    private static int länge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public static void main(String[] args) {

        Kleinbuchstaben = true; // 1 - 26
        Großbuchstaben = true;  // 27 - 52
        Zahlen = true;          // 51 - 62
        Zeichen = true;         // 63 - 76
        länge = 10;             // Passwortlänge
        a = new String[76];
        for (int i = 0; i < a.length; i++) {
            a[i] = String.valueOf(b.charAt(i));
        }
        recRandom(länge, null, 62);

    }

    private static String recRandom(int restbuchstaben, String passwort, int length) {

        if (restbuchstaben > 0) {
            restbuchstaben--;
            Random random = new Random();
            int zahl = random.nextInt(length);
            if (passwort == null) {
                String newPasswort = a[zahl];
                return recRandom(restbuchstaben, newPasswort, length);
            } else {
                String newPasswort = passwort + a[zahl];
                return recRandom(restbuchstaben, newPasswort, length);
            }
        } else
            return passwort;
    }

}