package com.example.orientationlistviewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.VideoView;

import com.muddzdev.styleabletoast.StyleableToast;

public class Activity2 extends AppCompatActivity {
    VideoView videoView;
    EditText editter;
    Button returner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        returner = findViewById(R.id.returnz);




      if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
          videoView = findViewById(R.id.videoView);
          editter = findViewById(R.id.editText);
          editter.addTextChangedListener(new TextWatcher() {
              @Override
              public void beforeTextChanged(CharSequence s, int start, int count, int after) {

              }

              @Override
              public void onTextChanged(CharSequence s, int start, int before, int count) {
                  String temper = s.toString();
                  if (temper.equals("gonk")) {
                      String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.gonk;
                      Uri uri = Uri.parse(videoPath);
                      videoView.setVideoURI(uri);

                      MediaController mediaController = new MediaController(Activity2.this);
                      videoView.setMediaController(mediaController);
                      mediaController.setAnchorView(videoView);
                  } else if (temper.equals("grevious")) {
                      String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.grevious;
                      Uri uri = Uri.parse(videoPath);
                      videoView.setVideoURI(uri);

                      MediaController mediaController = new MediaController(Activity2.this);
                      videoView.setMediaController(mediaController);
                      mediaController.setAnchorView(videoView);
                  } else if (temper.equals("darksaber")) {
                      String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.darksaber;
                      Uri uri = Uri.parse(videoPath);
                      videoView.setVideoURI(uri);

                      MediaController mediaController = new MediaController(Activity2.this);
                      videoView.setMediaController(mediaController);
                      mediaController.setAnchorView(videoView);
                  } else if (temper.equals("protosaber")) {
                      String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.protosaber;
                      Uri uri = Uri.parse(videoPath);
                      videoView.setVideoURI(uri);

                      MediaController mediaController = new MediaController(Activity2.this);
                      videoView.setMediaController(mediaController);
                      mediaController.setAnchorView(videoView);
                  } else if (temper.equals("maul")) {
                      String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.maul;
                      Uri uri = Uri.parse(videoPath);
                      videoView.setVideoURI(uri);

                      MediaController mediaController = new MediaController(Activity2.this);
                      videoView.setMediaController(mediaController);
                      mediaController.setAnchorView(videoView);
                  } else if (temper.equals("kylo")) {
                      String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.kyloren;
                      Uri uri = Uri.parse(videoPath);
                      videoView.setVideoURI(uri);

                      MediaController mediaController = new MediaController(Activity2.this);
                      videoView.setMediaController(mediaController);
                      mediaController.setAnchorView(videoView);
                  } else if (temper.equals("whip")) {
                      String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.lightwhip;
                      Uri uri = Uri.parse(videoPath);
                      videoView.setVideoURI(uri);

                      MediaController mediaController = new MediaController(Activity2.this);
                      videoView.setMediaController(mediaController);
                      mediaController.setAnchorView(videoView);
                  } else if (temper.equals("mace")) {
                      String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.windu;
                      Uri uri = Uri.parse(videoPath);
                      videoView.setVideoURI(uri);

                      MediaController mediaController = new MediaController(Activity2.this);
                      videoView.setMediaController(mediaController);
                      mediaController.setAnchorView(videoView);
                  } else if (temper.equals("brood")) {
                      String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.broodsaber;
                      Uri uri = Uri.parse(videoPath);
                      videoView.setVideoURI(uri);

                      MediaController mediaController = new MediaController(Activity2.this);
                      videoView.setMediaController(mediaController);
                      mediaController.setAnchorView(videoView);

                  } else if (temper.equals("guard")) {
                      String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.shadowguard;
                      Uri uri = Uri.parse(videoPath);
                      videoView.setVideoURI(uri);

                      MediaController mediaController = new MediaController(Activity2.this);
                      videoView.setMediaController(mediaController);
                      mediaController.setAnchorView(videoView);
                  }


              }

              @Override
              public void afterTextChanged(Editable s) {

              }
          });

          returner.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  showleaveText();
                  openActivity1();
              }
          });

      }else{
         returner.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 showleaveText();
                 openActivity1();
             }
         });
      }

    }
    public void openActivity1(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
    public void showleaveText(){
        StyleableToast.makeText(this, "Successfully Left", R.style.leavetoast).show();
    }
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
