package com.wikibytes.gpay;
import android.os.Bundle; 
import android.app.Activity;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.core.splashscreen.SplashScreen;


public class Splash extends Activity{
  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);

    SplashScreen splashScreen = SplashScreen.installSplashScreen(this);

    // Optionally dismiss it immediately
    splashScreen.setKeepOnScreenCondition(() -> false);

    //to enable edge to edge
    WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
    //set light status bar
    WindowInsetsControllerCompat controller = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
    controller.setAppearanceLightStatusBars(true);
    setContentView(R.layout.splash);

    ImageView logo = findViewById(R.id.google_icon_colored);
    logo.setVisibility(View.VISIBLE);

    float finalScale = 1f;

    ObjectAnimator scaleX = ObjectAnimator.ofFloat(logo, "scaleX", 0.1f, finalScale);
    ObjectAnimator scaleY = ObjectAnimator.ofFloat(logo, "scaleY", 0.1f, finalScale);
    ObjectAnimator alpha = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f);

    scaleY.setDuration(1000);
    scaleX.setDuration(1000);
    alpha.setDuration(1000);

    alpha.addListener(new AnimatorListenerAdapter(){
      @Override
      public void onAnimationEnd(Animator animation){
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
          Intent intent = new Intent(Splash.this, SplashSec.class);
          startActivity(intent);
          overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
          finish();
        },1350);
      }
    });

    scaleX.start();
    scaleY.start();
    alpha.start();
  }
}
