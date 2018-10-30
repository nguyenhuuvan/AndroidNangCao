package com.assmob201.poly.assignment;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


public class FacebookActivity extends AppCompatActivity {

    ProfilePictureView profilePictureView;
    LoginButton loginButton;
    TextView tvName, tvEmail;
    CallbackManager callbackManager;
    String email, name, firstName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_facebook);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        profilePictureView = findViewById(R.id.imgProfilePicture);
        tvName = findViewById(R.id.tvName_f);
        tvEmail = findViewById(R.id.tvEmail);
        loginButton = findViewById(R.id.login_button);
        tvEmail.setVisibility(View.INVISIBLE);
        tvName.setVisibility(View.INVISIBLE);
        loginButton.setReadPermissions(Arrays.asList("public_profile", "email"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                loginButton.setVisibility(View.INVISIBLE);

                tvEmail.setVisibility(View.VISIBLE);
                tvName.setVisibility(View.VISIBLE);

                GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.e("abc", response.getJSONObject().toString());
                        try {
                            email = object.getString("email");
                            name = object.getString("name");
                            profilePictureView.setProfileId("2212890982370174");
                            tvEmail.setText("Email: "+email);
                            tvName.setText("Xin chào: "+name);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "name,email,first_name");
                graphRequest.setParameters(parameters);
                graphRequest.executeAsync();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_facebook,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.dangxuat)
            dangxuat();
        if(item.getItemId()==R.id.chucnang)
            startActivity(new Intent(FacebookActivity.this,ChucnangActivity.class));
        return false;
    }

    public void dangxuat(){
        LoginManager.getInstance().logOut();
        tvEmail.setVisibility(View.INVISIBLE);
        tvName.setVisibility(View.INVISIBLE);

        tvEmail.setText("");
        tvName.setText("");
        profilePictureView.setProfileId(null);
        loginButton.setVisibility(View.VISIBLE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    protected void onStart() {
        LoginManager.getInstance().getLoginBehavior();
        super.onStart();
    }
}
