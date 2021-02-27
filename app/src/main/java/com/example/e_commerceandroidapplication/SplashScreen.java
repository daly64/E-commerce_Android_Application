package com.example.e_commerceandroidapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    TextView tvVersion;

    @Override
    protected void onStart() {
        super.onStart();
        //   mettre l'activité en plein ecran
        fullScreen();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash_screen);
        tvVersion = findViewById(R.id.version);
        tvVersion.setText(getString(R.string.version) + " " + getVersion(this));

        // durée d'affichage du splash screen 3 seconde
        settingUp_waiting(3);


    }

    // après un délaie de x secondes ferme le splash screen et affiche la main activity
    private void settingUp_waiting(int seconds) {
        int SPLASH_DISPLAY_LENGTH = seconds * 1000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                SplashScreen.this.startActivity(intent);
                SplashScreen.this.finish();

            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    // mode plein ecran
    private void fullScreen() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // cache la barre de navigation
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // cache la barre d'etat
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

    // récupére la version de l'application
    private String getVersion(Context context) {
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
//            String version = pInfo.versionName;
            return pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "1.0";
    }
}