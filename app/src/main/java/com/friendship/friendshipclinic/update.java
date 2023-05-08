package com.friendship.friendshipclinic;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class update extends AppCompatActivity {

    TextInputEditText update_name, update_email;

    TextView toolbar_txt;

    AutoCompleteTextView update_gender, update_status;

    String[] Gender = {"male", "female"};

    String[] Status = {"active", "inactive"};

    Toolbar toolbar;

    String token;

    AppCompatButton update;

    ProgressDialog progressDialog;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);


        toolbar = findViewById(R.id.toolbar);
        toolbar_txt = findViewById(R.id.toolbar_txt);
        //setSupportActionBar(toolbar);

        toolbar_txt.setText("Update");

        update_name = findViewById(R.id.user_update_name);
        update_email = findViewById(R.id.user_update_email);
        update_gender = findViewById(R.id.user_update_gender);
        update_status = findViewById(R.id.user_update_status);

        progressDialog = new ProgressDialog(update.this);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Updating Profile");

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(update.this, android.R.layout.simple_list_item_1, Gender);
        update_gender.setAdapter(genderAdapter);
        update_gender.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ArrayAdapter<String> statusAdapter = new ArrayAdapter<String>(update.this, android.R.layout.simple_list_item_1, Status);
        update_status.setAdapter(statusAdapter);
        update_status.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        MyApi MyApi = MyRetrofit.getRetrofit().create(MyApi.class);

        /*update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // convert user input into string
                String name = update_name.getText().toString().trim();
                String email = update_email.getText().toString().trim();
                String gender = update_gender.getText().toString().trim();
                String status = update_status.getText().toString().trim();


                // check validation user input
                if (name.equals("")) {
                    ShowError("Input Name");
                } else if (email.equals("")) {
                    ShowError("Input Email");
                } else if (gender.equals("")) {
                    ShowError("Select Gender");
                } else if (status.equals("")) {
                    ShowError("Select Status");
                } else {

                    progressDialog.show();



                    Call<ResponseBody> update = Api.update(
                            "Bearer " + token,
                            name,
                            email,
                            gender,
                            status);

                    update.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                            progressDialog.dismiss();
                            Log.i("update", "onResponse: " + response.body() + "Code " + response.code());

                            if (response.isSuccessful()) {
                                //Log.i("update_S", "Success: " + response + response.body() + " " + response.code());
                                Toast.makeText(Update.this, "Update", Toast.LENGTH_SHORT).show();
                                //isStudentProfileComplete = true;
                                //Log.i("isStudentProfile", "onResponse: "+isStudentProfileComplete);
                                //SharedPrefManager.getInstance(Update.this).studentProfileComplete(isStudentProfileComplete);
                                startActivity(new Intent(Update.this, ProfileFragment.class));
                                finish();

                            } else {

                                assert response.errorBody() != null;
                                try {
                                    Log.i("update", "error1: " + response.errorBody().string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Toast.makeText(Update.this, "Update Failed ! Try Again", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            progressDialog.dismiss();
                            Log.i("update", "error2: " + t.getMessage().toString());
                            Toast.makeText(Update.this, "Update Failed ! Try Again", Toast.LENGTH_SHORT).show();
                        }
                    });
                }


            }



        });*/


    }


    private void ShowError(String msg) {


        AlertDialog.Builder builder = new AlertDialog.Builder(update.this);

        builder.setIcon(R.drawable.ic_error);
        builder.setTitle("Error");
        builder.setMessage(msg);

        builder.setPositiveButton("Correct Now", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        AlertDialog alertDialog = builder.create();

        alertDialog.show();
    }

}