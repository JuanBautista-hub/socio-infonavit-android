package com.socio_infonavit_android.socio_infonavit_android;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.GridView;

import com.google.android.material.navigation.NavigationView;
import com.socio_infonavit_android.socio_infonavit_android.model.BenevitWallets;
import com.socio_infonavit_android.socio_infonavit_android.model.Landing_Benevits;
import com.socio_infonavit_android.socio_infonavit_android.model.Locked;
import com.socio_infonavit_android.socio_infonavit_android.service.Client;
import com.socio_infonavit_android.socio_infonavit_android.service.ServiceJWT;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {
    private GridView gridView;
    ArrayList<BenevitWallets> benevitWallets = new ArrayList<>();
    ArrayList<Object> loked = new ArrayList<Object>();

    private AppBarConfiguration mAppBarConfiguration;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gridView = findViewById(R.id.griew);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        //   NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        // NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        //   NavigationUI.setupWithNavController(navigationView, navController);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                token = null;
            } else {
                token = extras.getString("token");
            }
        } else {
            token = (String) savedInstanceState.getSerializable("token");
        }
        obtenerBenevit();
    }
        public void obtenerBenevit(){

            Call<ArrayList<BenevitWallets>> call = ServiceJWT
                    .getInstance()
                    .createService(Client.class)
                    .ObtenerBenevitWallets();
            call.enqueue(new Callback<ArrayList<BenevitWallets>>() {
                @Override
                public void onResponse(Call<ArrayList<BenevitWallets>> call, Response<ArrayList<BenevitWallets>> response) {

                    if (response.code() == 200) {
                        benevitWallets.addAll(response.body());
                        AdapterCustom adapter = new AdapterCustom(DashboardActivity.this, benevitWallets);
                        gridView.setAdapter(adapter);
                        obtenerList();
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<BenevitWallets>> call, Throwable t) {

                }
            });
        }

    public void obtenerList() {
        Log.d("Tag", "El topken es" + token);

        Call<Landing_Benevits> call = ServiceJWT
                .getInstance()
                .createService(Client.class)
                .obtenerListasCategprias(token);

        call.enqueue(new Callback<Landing_Benevits>() {
            @Override
            public void onResponse(Call<Landing_Benevits> call, Response<Landing_Benevits> response) {
                if (response.code() == 200) {

                    ArrayList<Object> phi = new ArrayList<>();
                    phi.addAll(benevitWallets);

                    Log.d("Tag", "Datos" + phi);
                }
            }

            @Override
            public void onFailure(Call<Landing_Benevits> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }
/*
    @Override
    public boolean onSupportNavigateUp() {
  //      NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
  //      return NavigationUI.navigateUp(navController, mAppBarConfiguration)
             //   || super.onSupportNavigateUp();
    }*/
}