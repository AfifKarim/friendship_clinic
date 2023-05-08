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

public class create extends AppCompatActivity {

    TextInputEditText create_name, create_email;

    TextView toolbar_txt;

    AutoCompleteTextView create_gender, create_status;

    String[] Gender = {"male", "female"};

    String[] Status = {"active", "inactive"};

    Toolbar toolbar;

    String token;

    AppCompatButton create_btn;

    ProgressDialog progressDialog;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);


        toolbar = findViewById(R.id.toolbar);
        toolbar_txt = findViewById(R.id.toolbar_txt);
        setSupportActionBar(toolbar);

        toolbar_txt.setText("Create New");

        create_name = findViewById(R.id.user_create_name);
        create_email = findViewById(R.id.user_create_email);
        create_gender = findViewById(R.id.user_create_gender);
        create_status = findViewById(R.id.user_create_status);

        progressDialog = new ProgressDialog(create.this);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Creating Profile");

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(create.this, android.R.layout.simple_list_item_1, Gender);
        create_gender.setAdapter(genderAdapter);
        create_gender.addTextChangedListener(new TextWatcher() {
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

        ArrayAdapter<String> statusAdapter = new ArrayAdapter<String>(create.this, android.R.layout.simple_list_item_1, Status);
        create_status.setAdapter(statusAdapter);
        create_status.addTextChangedListener(new TextWatcher() {
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

        /*create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animation = new AlphaAnimation(1.0f, 0.0f);
                animation.setDuration(500);
                create_btn.startAnimation(animation);

                // convert user input into string
                String name = create_name.getText().toString().trim();
                String email = create_email.getText().toString().trim();
                String gender = create_gender.getText().toString().trim();
                String status = create_status.getText().toString().trim();


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

                    //progressDialog.show();

                    Call<ResponseBody> create = Api.create(
                            "Bearer 5f54c461fb7d6b345b3a770fa4586795ec1125bb80459ed9daba5f1c26cf26e0" + token,
                            name,
                            email,
                            gender,
                            status);

                    create.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                            //progressDialog.dismiss();
                            Log.i("update", "onResponse: " + response.body() + "Code " + response.code());

                            if (response.isSuccessful()) {
                                //Log.i("update_S", "Success: " + response + response.body() + " " + response.code());
                                Toast.makeText(Create.this, "Create", Toast.LENGTH_SHORT).show();
                                //isStudentProfileComplete = true;
                                //Log.i("isStudentProfile", "onResponse: "+isStudentProfileComplete);
                                //SharedPrefManager.getInstance(Update.this).studentProfileComplete(isStudentProfileComplete);
                                startActivity(new Intent(Create.this, MainActivity.class));
                                finish();

                            } else {

                                assert response.errorBody() != null;
                                try {
                                    Log.i("create", "error1: " + response.errorBody().string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Toast.makeText(Create.this, "Create Failed ! Try Again", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            progressDialog.dismiss();
                            Log.i("create", "error2: " + t.getMessage().toString());
                            Toast.makeText(Create.this, "Create Failed ! Try Again", Toast.LENGTH_SHORT).show();
                        }
                    });
                }


            }


        });
        */

    }


    private void ShowError(String msg) {


        AlertDialog.Builder builder = new AlertDialog.Builder(create.this);

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