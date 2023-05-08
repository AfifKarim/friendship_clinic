package com.friendship.friendshipclinic.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllUsers {

    @SerializedName("data")
    @Expose
    private List<Users> data = null;

    public List<Users> getUsers() {
        return data;
    }


}
