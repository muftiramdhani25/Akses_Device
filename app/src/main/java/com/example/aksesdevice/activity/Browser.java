package com.example.aksesdevice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import com.example.aksesdevice.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Browser extends AppCompatActivity {

    @BindView(R.id.btnBrowser)
    Button btnBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnBrowser)
    public void onViewClicked(){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/?hl=in")));
    }
}
