package com.friendship.friendshipclinic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.friendship.friendshipclinic.Adapters.UsersAdapter;
import com.friendship.friendshipclinic.Models.AllUsers;
import com.friendship.friendshipclinic.Models.Users;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class deactive_users extends AppCompatActivity {

    List<Users> allUsersList ;

    AppCompatButton button_active, button_deactive;

    RecyclerView deactive_recycler;

    TextView show_text;

    UsersAdapter usersAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deactive_users);

        button_active = findViewById(R.id.button_active);
        button_deactive = findViewById(R.id.button_deactive);

        show_text = findViewById(R.id.show_text);

        deactive_recycler = findViewById(R.id.deactive_recycler);

        allUsersList = new ArrayList<>();

        MyApi myApi = MyRetrofit.getRetrofit().create(MyApi.class);
        Call<AllUsers> allUsers = myApi.getAllUsers();

        allUsers.enqueue(new Callback<AllUsers>() {
            @Override
            public void onResponse(@NonNull Call<AllUsers> call, @NonNull Response<AllUsers> response) {
                assert response.body() != null;
                allUsersList = response.body().getUsers();

                if (allUsersList.size()>0){
                    usersAdapter = new UsersAdapter(deactive_recycler.getContext(), allUsersList);
                    deactive_recycler.setAdapter(usersAdapter);
                }

            }

            @Override
            public void onFailure(@NonNull Call<AllUsers> call, Throwable t) {

            }
        });

        button_active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(deactive_users.this,active_users.class));
                //finish();
                show_text.setText("Active Users");
                show_text.setVisibility(View.VISIBLE);
            }
        });

        button_deactive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(deactive_users.this,deactive_users.class));
                //finish();
                show_text.setText("Inactive Users");
                show_text.setVisibility(View.VISIBLE);
            }
        });

    }
}