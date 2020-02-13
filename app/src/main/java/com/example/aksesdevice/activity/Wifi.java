package com.example.aksesdevice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.aksesdevice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Wifi extends AppCompatActivity {

    @BindView(R.id.switch1)
    Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        ButterKnife.bind(this);
        switch1.setChecked(status());
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                wifiStatus(isChecked);
            }
        });
    }

    // method cek status
    private void wifiStatus(boolean isChecked){
        WifiManager manager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        if ((isChecked == true && !manager.isWifiEnabled())){
            Toast.makeText(this, "Wifi aktif", Toast.LENGTH_SHORT).show();
            manager.setWifiEnabled(false);
        }
    }

    private boolean status(){
        WifiManager manager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        return manager.isWifiEnabled();
    }
}
