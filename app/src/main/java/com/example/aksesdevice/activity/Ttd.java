package com.example.aksesdevice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aksesdevice.R;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Ttd extends AppCompatActivity implements TextToSpeech.OnInitListener {

    @BindView(R.id.tv_ttd)
    TextView tvttd;
    @BindView(R.id.edt_ttd)
    EditText edtttd;
    @BindView(R.id.btnSpeech)
    Button btnspeech;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttd);
        ButterKnife.bind(this);

        // class tts
        tts = new TextToSpeech(this, this);
        if (tts == null){
            Toast.makeText(this, "Perangkat ini tidak tersedia tts", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btnSpeech)
    public void onViewClicked(){
        bicara();
        Toast.makeText(this, "berhasil diklik", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS){
            Locale indo = new Locale("en", "EN");
            int result = tts.setLanguage(indo);
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED ){
                Toast.makeText(this,"Bahasa tidak mendukung", Toast.LENGTH_SHORT).show();
            } else {
                btnspeech.setEnabled(true);
                bicara();
            }
        }
    }

    private void bicara(){
        String tulisan = edtttd.getText().toString();
        tts.speak(tulisan, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
