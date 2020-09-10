package com.socio_infonavit_android.socio_infonavit_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.socio_infonavit_android.socio_infonavit_android.model.ResponseLogin;
import com.socio_infonavit_android.socio_infonavit_android.model.User;
import com.socio_infonavit_android.socio_infonavit_android.model.User_login;
import com.socio_infonavit_android.socio_infonavit_android.service.Client;
import com.socio_infonavit_android.socio_infonavit_android.service.ServiceJWT;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private EditText txtuser;
    private EditText txtpassword;
    private String tokenResponse;
    Context context;
    ProgressDialog progressDialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setup();


    }

    private void setup() {
        login = findViewById(R.id.button_login);
        txtuser = findViewById(R.id.txtUser);
        txtpassword = findViewById(R.id.txtPassword);
        String user = txtuser.getText().toString();
        String passw = txtuser.getText().toString();

        if (user.equals("")) {
            Toast.makeText(getApplicationContext(), "Ingresa un correo", Toast.LENGTH_SHORT).show();
            login.setBackground(getResources().getDrawable(R.drawable.button_background2));
            login.setEnabled(false);

        }

        txtpassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                login.setEnabled(true);
                login.setBackground(getResources().getDrawable(R.drawable.button_background));
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Token();
                progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setMessage("Procesando....");
                progressDialog.setIndeterminate(false);
                progressDialog.setMax(100);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setCancelable(true);
            }
        });
    }

    private void Token() {
        User login = new User();
        User_login user_login = new User_login();
        login.setEmail(txtuser.getText().toString());
        login.setPassword(txtpassword.getText().toString());
        user_login.setUser(login);

        Call<ResponseLogin> call = ServiceJWT
                .getInstance()
                .createService(Client.class)
                .login_userToken(user_login);
        call.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                response.hashCode();

                response.toString();
                if (response.isSuccessful()) {
                    tokenResponse = response.headers().get("Authorization");
                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                    String JWT = tokenResponse;
                    intent.putExtra("token", JWT);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this,"Bienvenido",Toast.LENGTH_LONG);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this,"Ha ocurrido un error de autenticacion, verifique los datos",Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {

            }
        });
    }
}