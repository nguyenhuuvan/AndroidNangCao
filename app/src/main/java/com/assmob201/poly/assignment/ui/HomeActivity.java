package com.assmob201.poly.assignment.ui;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.assmob201.poly.assignment.R;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    private GioiThieuFragment gioiThieuFragment;
    private CaNhanFragment caNhanFragment;
    MenuFragment menuFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         toolbar = (Toolbar) findViewById(R.id.toolbarNews);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toolbar.setTitleTextColor(Color.WHITE);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        gioiThieuFragment = new GioiThieuFragment();
        caNhanFragment = new CaNhanFragment();
        menuFragment = new MenuFragment();
        showFragmentMenu();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_menu) {
            toolbar.setTitle("Menu");
            showFragmentMenu();
        } else if (id == R.id.nav_canhan) {
            toolbar.setTitle("Cá nhân");
            showFragmentCaNhan();
        } else if (id == R.id.nav_gioithieu) {
            toolbar.setTitle("Giới thiệu");
            showFragmentGioiThieu();
        } else if (id == R.id.nav_thoat) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle(getString(R.string.back));
            alertDialogBuilder
                    .setMessage(getString(R.string.click))
                    .setCancelable(false)
                    .setPositiveButton(getString(R.string.yes),
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    moveTaskToBack(true);
                                    android.os.Process.killProcess(android.os.Process.myPid());
                                    System.exit(1);
                                }
                            })

                    .setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            dialog.cancel();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFragmentGioiThieu(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        if (gioiThieuFragment.isAdded()) {
            ft.show(gioiThieuFragment);
        } else {
            ft.add(R.id.container1, gioiThieuFragment);
        }
        if (caNhanFragment.isAdded()) {
            ft.hide(caNhanFragment);
        }
        if (menuFragment.isAdded()) {
            ft.hide(menuFragment);
        }
        ft.commit();
    }
    public void showFragmentCaNhan(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        if (caNhanFragment.isAdded()) {
            ft.show(caNhanFragment);
        } else {
            ft.add(R.id.container1, caNhanFragment);
        }
        if (gioiThieuFragment.isAdded()) {
            ft.hide(gioiThieuFragment);
        }
        if (menuFragment.isAdded()) {
            ft.hide(menuFragment);
        }
        ft.commit();
    }
    public void showFragmentMenu(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        if (menuFragment.isAdded()) {
            ft.show(menuFragment);
        } else {
            ft.add(R.id.container1, menuFragment);
        }
        if (gioiThieuFragment.isAdded()) {
            ft.hide(gioiThieuFragment);
        }
        if (caNhanFragment.isAdded()) {
            ft.hide(caNhanFragment);
        }
        ft.commit();
    }
}
