package com.wikibytes.gpay;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.ViewGroup;
import android.os.Build;
import androidx.core.view.ViewCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;

public class Maina extends Activity{
  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    // Set the window flags for transparent status bar
    Window middel = getWindow();
    middel.setFlags(
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
    );

        // Handle system bar insets for padding
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
      Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
      return insets;
    });


    // Window window = getWindow();
    // window.setStatusBarColor(Color.TRANSPARENT);
    // window.getDecorView().setSystemUiVisibility(
    //     View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN 
    //     | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    //     | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        //     ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        //     Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        //     v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        //     return insets;
        // });

  }
}


