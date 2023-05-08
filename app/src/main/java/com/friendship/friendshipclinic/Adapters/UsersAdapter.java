package com.friendship.friendshipclinic.Adapters;

import android.annotation.SuppressLint;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.friendship.friendshipclinic.active_users;
import com.friendship.friendshipclinic.ViewHolders.UsersViewHolder;
import com.friendship.friendshipclinic.Models.Users;

import com.friendship.friendshipclinic.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class UsersAdapter extends RecyclerView.Adapter<UsersViewHolder> {
    Context context;
    List<Users> allUsersList;

    public UsersAdapter(Context context, List<Users> allUsersList) {
        this.context = context;
        this.allUsersList = allUsersList;
    }


    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_info, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, @SuppressLint("RecyclerView")  int position) {
        Users allUsers = allUsersList.get(position);

        holder.userName.setText(allUsers.getName());
        holder.userEmail.setText(allUsers.getEmail());
        holder.userGender.setText(allUsers.getGender());
        holder.userStatus.setText(allUsers.getStatus());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, active_users.class);
                intent.putExtra("id", allUsers.getId().toString());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return allUsersList.size();
    }
}
