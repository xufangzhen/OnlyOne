package com.onlyone.date.parcel;

import android.os.Parcel;
import android.os.Parcelable;

public class UserParcel implements Parcelable {

    private String name;
    private String city;

    protected UserParcel(Parcel in) {
        name = in.readString();
        city = in.readString();
    }

    public UserParcel(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public static final Creator<UserParcel> CREATOR = new Creator<UserParcel>() {
        @Override
        public UserParcel createFromParcel(Parcel in) {
            return new UserParcel(in);
        }

        @Override
        public UserParcel[] newArray(int size) {
            return new UserParcel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(city);
    }

}
