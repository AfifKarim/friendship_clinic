package com.friendship.friendshipclinic.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.friendship.friendshipclinic.R;

public class UsersViewHolder extends RecyclerView.ViewHolder {

    public ImageView user_img;
    public TextView userName, userGender, userEmail, userStatus;

    public UsersViewHolder(@NonNull View itemView) {
        super(itemView);

        //userImg = itemView.findViewById(R.id.user_img);
        userName = itemView.findViewById(R.id.user_name);
        userGender = itemView.findViewById(R.id.user_gender);
        userEmail = itemView.findViewById(R.id.user_email);
        userStatus = itemView.findViewById(R.id.user_status);
    }
}
