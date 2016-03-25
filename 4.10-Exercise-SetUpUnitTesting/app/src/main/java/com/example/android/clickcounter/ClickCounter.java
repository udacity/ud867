package com.example.android.clickcounter;


import android.os.Parcel;
import android.os.Parcelable;

public class ClickCounter implements Parcelable {

    public static final Parcelable.Creator<ClickCounter> CREATOR = new Parcelable.Creator<ClickCounter>() {
        @Override
        public ClickCounter createFromParcel(Parcel parcel) {
            return new ClickCounter(parcel);
        }

        @Override
        public ClickCounter[] newArray(int i) {
            return new ClickCounter[0];
        }
    };
    private int count = 0;

    public ClickCounter() {

    }

    private ClickCounter(Parcel parcel) {
        count = parcel.readInt();
    }

    public void increment() {
        count += 1;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(count);

    }
}
