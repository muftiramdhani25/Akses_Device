package com.example.aksesdevice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aksesdevice.activity.AudioManagerActivity;
import com.example.aksesdevice.activity.AudioRec;
import com.example.aksesdevice.activity.Bluetooth;
import com.example.aksesdevice.activity.Browser;
import com.example.aksesdevice.activity.Camera;
import com.example.aksesdevice.activity.Email;
import com.example.aksesdevice.activity.Sms;
import com.example.aksesdevice.activity.Telepon;
import com.example.aksesdevice.activity.Ttd;
import com.example.aksesdevice.activity.Wifi;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bluetooth)
    Button bluetooth;
    @BindView(R.id.telepon)
    Button telepon;
    @BindView(R.id.sms)
    Button sms;
    @BindView(R.id.wifi)
    Button wifi;
    @BindView(R.id.browser)
    Button browser;
    @BindView(R.id.audiorec)
    Button audiorec;
    @BindView(R.id.audiomanager)
    Button audiomanager;
    @BindView(R.id.camera)
    Button camera;
    @BindView(R.id.email)
    Button email;
    @BindView(R.id.tts)
    Button tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bluetooth, R.id.telepon, R.id.sms, R.id.wifi, R.id.browser, R.id.audiorec, R.id.audiomanager, R.id.camera, R.id.email, R.id.tts })
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.bluetooth:
                startActivity(new Intent(this, Bluetooth.class));
                break;
            case R.id.telepon:
                startActivity(new Intent(this, Telepon.class));
                break;
            case R.id.sms:
                startActivity(new Intent(this, Sms.class));
                break;
            case R.id.wifi:
                startActivity(new Intent(this, Wifi.class));
                break;
            case R.id.browser:
                startActivity(new Intent(this, Browser.class));
                break;
            case R.id.audiorec:
                startActivity(new Intent(this, AudioRec.class));
                break;
            case R.id.audiomanager:
                startActivity(new Intent(this, AudioManagerActivity.class));
                break;
            case R.id.camera:
                startActivity(new Intent(this, Camera.class));
                break;
            case R.id.email:
                startActivity(new Intent(this, Email.class));
                break;
            case R.id.tts:
                startActivity(new Intent(this, Ttd.class));
                break;
        }
    }
}
