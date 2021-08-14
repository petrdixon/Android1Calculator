package com.geek.android1calculator;


import android.os.Parcel;
import android.os.Parcelable;


public class SettingsForTransferData implements Parcelable {

    // класс для получения и передачи данных из/в SecondActivity (Intent)

    private int themeStatus;
    private int style;

    public SettingsForTransferData(){
    }

    public SettingsForTransferData(int themeStatus) {
        setThemeStatus(themeStatus);
    }

    protected SettingsForTransferData(Parcel in) {
        themeStatus = in.readInt();
        style = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(themeStatus);
        dest.writeInt(style);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SettingsForTransferData> CREATOR = new Creator<SettingsForTransferData>() {
        @Override
        public SettingsForTransferData createFromParcel(Parcel in) {
            return new SettingsForTransferData(in);
        }

        @Override
        public SettingsForTransferData[] newArray(int size) {
            return new SettingsForTransferData[size];
        }
    };

    public int getThemeStatus() {
        return themeStatus;
    }

    public void setThemeStatus(int themeStatus) {
        this.themeStatus = themeStatus;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }


}
