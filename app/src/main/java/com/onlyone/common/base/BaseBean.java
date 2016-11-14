package com.onlyone.common.base;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 创建者：许方镇
 * 日期：2016/11/7
 * 功能模块：
 */
public class BaseBean implements Parcelable {

    private int type;

    protected BaseBean(Parcel in) {
        type = in.readInt();
    }

    public static final Creator<BaseBean> CREATOR = new Creator<BaseBean>() {
        @Override
        public BaseBean createFromParcel(Parcel in) {
            return new BaseBean(in);
        }

        @Override
        public BaseBean[] newArray(int size) {
            return new BaseBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(type);  // 写出 type
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
