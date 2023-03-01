package com.example.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView tvSesi, tvName;
    private Button btnLogout;

    KendaliLogin KL = new KendaliLogin();

    public static String keySPUsername = "spPadang";
    public static String keySPName = "spPadang_name";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if(KL.isLogin(MainActivity.this, keySPUsername) == true)
        {
            setContentView(R.layout.activity_main);

            tvSesi = findViewById(R.id.tv_sesi);
            tvName = findViewById(R.id.tv_name);
            btnLogout = findViewById(R.id.btn_logout);

            tvSesi.setText(KL.getPref(MainActivity.this, keySPUsername));
            tvName.setText(KL.getPref(MainActivity.this,keySPName));

            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    KL.setPref(MainActivity.this, keySPUsername, null);
                    KL.setPref(MainActivity.this, keySPName, null);
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            });
        }
       else{
           startActivity(new Intent(MainActivity.this, LoginActivity.class));
           finish();
        }


    }
}