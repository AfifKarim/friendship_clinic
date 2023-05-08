package com.friendship.friendshipclinic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.friendship.friendshipclinic.Adapters.UsersAdapter;
import com.friendship.friendshipclinic.Models.AllUsers;
import com.friendship.friendshipclinic.Models.Users;
import com.github.dhaval2404.imagepicker.ImagePicker;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import android.widget.ImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class active_users extends AppCompatActivity {


    List<Users> allUsersList ;

    CircleImageView create_btn;
    AppCompatButton button_active, button_deactive;

    RecyclerView active_recycler;

    TextView show_text;

    UsersAdapter usersAdapter;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_users);

        button_active = findViewById(R.id.button_active);
        button_deactive = findViewById(R.id.button_deactive);

        create_btn = findViewById(R.id.create_user);

        create_btn.setImageResource(R.drawable.ic_plus_symbol);

        show_text = findViewById(R.id.show_text);

        active_recycler = findViewById(R.id.active_recycler);

        allUsersList = new ArrayList<>();

        create_btn.setOnClickListener(view -> {
            ImagePicker.with(create.this)
                    .crop()
                    .compress(512)
                    .maxResultSize(400, 400)
                    .start(102);

        });

        MyApi myApi = MyRetrofit.getRetrofit().create(MyApi.class);
        Call<AllUsers> allUsers = myApi.getAllUsers();

        allUsers.enqueue(new Callback<AllUsers>() {
            @Override
            public void onResponse(@NonNull Call<AllUsers> call, @NonNull Response<AllUsers> response) {
                assert response.body() != null;
                allUsersList = response.body().getUsers();

                if (allUsersList.size()>0){
                    usersAdapter = new UsersAdapter(active_users.this, allUsersList);
                    active_recycler.setAdapter(usersAdapter);
                }

            }

            @Override
            public void onFailure(@NonNull Call<AllUsers> call, Throwable t) {

            }
        });

        button_active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                startActivity(new Intent(active_users.this,active_users.class));
                //finish();
                show_text.setText("Active Users");
                show_text.setVisibility(View.VISIBLE);
            }
        });

        button_deactive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(active_users.this,deactive_users.class));
                //finish();
                show_text.setText("Inactive Users");
                show_text.setVisibility(View.VISIBLE);
            }
        });

    }
}