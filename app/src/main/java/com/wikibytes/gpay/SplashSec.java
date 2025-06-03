package com.wikibytes.gpay;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;
import android.view.View;

public class SplashSec extends Activity{
  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash_sec);

    ImageView blank = findViewById(R.id.global_white_sqr);
    ImageView img = findViewById(R.id.logo);
    TextView txt = findViewById(R.id.google);

    new Handler().postDelayed(() -> {
      blank.setVisibility(View.GONE);
      img.setVisibility(View.GONE);
      txt.setVisibility(View.GONE);

      img.animate().translationY(0f).setDuration(5).start();
      txt.animate().translationY(0f).setDuration(5).start();

      img.setVisibility(View.VISIBLE);
      txt.setVisibility(View.VISIBLE);

      new Handler().postDelayed(() -> {
        Intent intent = new Intent(SplashSec.this, MainActivity.class);
        startActivity(intent);
        finish();
      },100);
    },20);

  }
}
