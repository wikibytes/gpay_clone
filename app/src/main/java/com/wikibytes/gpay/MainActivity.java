package com.wikibytes.gpay;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate started");

        // Set theme before setting content view to ensure it applies
        setTheme(R.style.main_theme);
        setContentView(R.layout.activity_main);

        // Make status bar transparent (commented out to test crash fix)
        /*
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        window.setStatusBarColor(android.graphics.Color.TRANSPARENT);
        */

        // Handle system bar insets for padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            if (v == null) {
                Log.e(TAG, "Root view with ID 'main' not found");
                return insets;
            }
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize RecyclerViews with null checks
        initRecyclerViewPeople();
        initRecyclerViewBusinesses();
        initRecyclerViewOffers();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
        // Reapply transparency on resume to handle theme changes (commented out to test crash fix)
        /*
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        window.setStatusBarColor(android.graphics.Color.TRANSPARENT);
        */
    }

    private void initRecyclerViewPeople() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_people);
        if (recyclerView == null) {
            Log.e(TAG, "RecyclerView 'recycler_view_people' not found in layout");
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<PersonItem> peopleList = new ArrayList<>();
        peopleList.add(new PersonItem("Bishel", R.drawable.circle));
        peopleList.add(new PersonItem("Siddharth", R.drawable.circle));
        peopleList.add(new PersonItem("Ranjit", R.drawable.circle));
        peopleList.add(new PersonItem("Rasminita", R.drawable.circle));
        peopleList.add(new PersonItem("Sankar", R.drawable.circle));
        PeopleAdapter adapter = new PeopleAdapter(peopleList);
        recyclerView.setAdapter(adapter);
    }

    private void initRecyclerViewBusinesses() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_businesses);
        if (recyclerView == null) {
            Log.e(TAG, "RecyclerView 'recycler_view_businesses' not found in layout");
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<BusinessItem> businessList = new ArrayList<>();
        businessList.add(new BusinessItem("Pahali Store", R.drawable.circle));
        businessList.add(new BusinessItem("Sahoo General", R.drawable.circle));
        businessList.add(new BusinessItem("JAGANNATH", R.drawable.circle));
        businessList.add(new BusinessItem("Local Shop", R.drawable.circle));
        BusinessAdapter adapter = new BusinessAdapter(businessList);
        recyclerView.setAdapter(adapter);
    }

    private void initRecyclerViewOffers() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_offers);
        if (recyclerView == null) {
            Log.e(TAG, "RecyclerView 'recycler_view_offers' not found in layout");
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<OfferItem> offerList = new ArrayList<>();
        offerList.add(new OfferItem("Rewards", R.drawable.circle));
        offerList.add(new OfferItem("Offers", R.drawable.circle));
        offerList.add(new OfferItem("Referrals", R.drawable.circle));
        OfferAdapter adapter = new OfferAdapter(offerList);
        recyclerView.setAdapter(adapter);
    }

    // Data classes for RecyclerView items
    public static class PersonItem {
        String name;
        int imageRes;

        PersonItem(String name, int imageRes) {
            this.name = name;
            this.imageRes = imageRes;
        }
    }

    public static class BusinessItem {
        String name;
        int imageRes;

        BusinessItem(String name, int imageRes) {
            this.name = name;
            this.imageRes = imageRes;
        }
    }

    public static class OfferItem {
        String name;
        int imageRes;

        OfferItem(String name, int imageRes) {
            this.name = name;
            this.imageRes = imageRes;
        }
    }

    // Adapter for People
    public static class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {
        List<PersonItem> items;

        PeopleAdapter(List<PersonItem> items) {
            this.items = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
            android.view.View view = android.view.LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_person, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            PersonItem item = items.get(position);
            holder.imageView.setImageResource(item.imageRes);
            holder.textView.setText(item.name);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView textView;

            ViewHolder(android.view.View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.profile_image);
                textView = itemView.findViewById(R.id.profile_name);
            }
        }
    }

    // Adapter for Businesses
    public static class BusinessAdapter extends RecyclerView.Adapter<BusinessAdapter.ViewHolder> {
        List<BusinessItem> items;

        BusinessAdapter(List<BusinessItem> items) {
            this.items = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
            android.view.View view = android.view.LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_business, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            BusinessItem item = items.get(position);
            holder.imageView.setImageResource(item.imageRes);
            holder.textView.setText(item.name);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView textView;

            ViewHolder(android.view.View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.business_image);
                textView = itemView.findViewById(R.id.business_name);
            }
        }
    }

    // Adapter for Offers
    public static class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {
        List<OfferItem> items;

        OfferAdapter(List<OfferItem> items) {
            this.items = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
            android.view.View view = android.view.LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_offer, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            OfferItem item = items.get(position);
            holder.imageView.setImageResource(item.imageRes);
            holder.textView.setText(item.name);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView textView;

            ViewHolder(android.view.View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.offer_image);
                textView = itemView.findViewById(R.id.offer_name);
            }
        }
    }
}
