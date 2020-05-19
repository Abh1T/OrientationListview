package com.example.orientationlistviewproject;

import android.os.Parcel;
import android.os.Parcelable;

public class lightsaber implements Parcelable {
    private  String chara;
    private int id;
    private String appearance;

    public lightsaber(String name, int id, String appearance, int power, String descriptio){
        this.chara = name;
        this.id = id;
        this.appearance = appearance;
        this.power = power;
        this.descriptio = descriptio;
    }
    protected lightsaber(Parcel in) {
        chara = in.readString();
        id = in.readInt();
        appearance = in.readString();
        power = in.readInt();
        descriptio = in.readString();
    }

    public static final Creator<lightsaber> CREATOR = new Creator<lightsaber>() {
        @Override
        public lightsaber createFromParcel(Parcel in) {
            return new lightsaber(in);
        }

        @Override
        public lightsaber[] newArray(int size) {
            return new lightsaber[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(chara);
        dest.writeInt(id);
        dest.writeString(appearance);
        dest.writeInt(power);
        dest.writeString(descriptio);
    }

    private int power;
    private String descriptio;

    public String getName(){
        return chara;
    }
    public int getID(){
        return id;
    }

    public String getAppearances(){
        return appearance;
    }

    public String getDescription(){
        return descriptio;
    }

    public int getPower(){
        return power;
    }



}
