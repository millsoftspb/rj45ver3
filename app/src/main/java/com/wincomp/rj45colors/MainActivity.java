package com.wincomp.rj45colors;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class  MainActivity extends AppCompatActivity implements com.wincomp.rj45colors.Fragment_568B4.OnFragmentInteractionListener, com.wincomp.rj45colors.Fragment_568B2.OnFragmentInteractionListener,
com.wincomp.rj45colors.Fragment_568A4.OnFragmentInteractionListener, com.wincomp.rj45colors.Fragment_568A2.OnFragmentInteractionListener {
    Boolean screenActivity = false;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        // Create an adapter that knows which fragment should be shown on each page
        com.wincomp.rj45colors.CategoryAdapter adapter = new com.wincomp.rj45colors.CategoryAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        //Set and init ad_view
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Set and init interstitial
        MobileAds.initialize(this,
                "ca-app-pub-9294821841734437~8999697286");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9294821841734437/9545305034");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        //ner ads loaded
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    public void pingTool(MenuItem item) {
        // run reklama
        if (mInterstitialAd.isLoaded()) mInterstitialAd.show();

        Intent messageIntent = new Intent(this, com.wincomp.rj45colors.Instruction_Activity.class);
        startActivity(messageIntent);
    }

    public void powerSaweOf(View view) {
        FloatingActionButton fab = (FloatingActionButton) view;
        if (!screenActivity) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            fab.setImageResource(R.drawable.ic_wb_incandescent_black_24dp);
            screenActivity = true;
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            fab.setImageResource(R.drawable.ic_wb_incandescent_grey_24dp);
            screenActivity = false;
        }
    }
}

