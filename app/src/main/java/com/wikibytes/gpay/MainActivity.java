package com.wikibytes.gpay;

import android.os.Bundle;
import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Set theme before setting content view to ensure it applies
    setTheme(R.style.main_theme);
    setContentView(R.layout.activity_main);

    // Make status bar transparent
    Window window = getWindow();
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    window.setStatusBarColor(android.graphics.Color.TRANSPARENT);

    // Handle system bar insets for padding
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
      Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
      return insets;
    });
  }

  @Override
  protected void onResume() {
    super.onResume();
    // Reapply transparency on resume to handle theme changes
    Window window = getWindow();
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    window.setStatusBarColor(android.graphics.Color.TRANSPARENT);
  }
}