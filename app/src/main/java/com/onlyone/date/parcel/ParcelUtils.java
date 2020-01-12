package com.onlyone.date.parcel;

import android.content.Intent;

public class ParcelUtils {


    //https://www.cnblogs.com/caoxinyu/p/10568491.html

    public static Intent put(Intent intent, String key, UserParcel parcel) {
        return intent.putExtra(key, parcel);
    }

}
