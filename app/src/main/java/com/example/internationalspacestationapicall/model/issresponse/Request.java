
package com.example.internationalspacestationapicall.model.issresponse;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request implements Parcelable
{

    @SerializedName("altitude")
    @Expose
    private Integer altitude;
    @SerializedName("datetime")
    @Expose
    private Integer datetime;
    @SerializedName("latitude")
    @Expose
    private Float latitude;
    @SerializedName("longitude")
    @Expose
    private Float longitude;
    @SerializedName("passes")
    @Expose
    private Integer passes;
    public final static Parcelable.Creator<Request> CREATOR = new Creator<Request>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Request createFromParcel(Parcel in) {
            return new Request(in);
        }

        public Request[] newArray(int size) {
            return (new Request[size]);
        }

    }
    ;

    protected Request(Parcel in) {
        this.altitude = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.datetime = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.latitude = ((Float) in.readValue((Float.class.getClassLoader())));
        this.longitude = ((Float) in.readValue((Float.class.getClassLoader())));
        this.passes = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Request() {
    }

    /**
     * 
     * @param altitude
     * @param longitude
     * @param passes
     * @param latitude
     * @param datetime
     */
    public Request(Integer altitude, Integer datetime, Float latitude, Float longitude, Integer passes) {
        super();
        this.altitude = altitude;
        this.datetime = datetime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.passes = passes;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    public Integer getDatetime() {
        return datetime;
    }

    public void setDatetime(Integer datetime) {
        this.datetime = datetime;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Integer getPasses() {
        return passes;
    }

    public void setPasses(Integer passes) {
        this.passes = passes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(altitude);
        dest.writeValue(datetime);
        dest.writeValue(latitude);
        dest.writeValue(longitude);
        dest.writeValue(passes);
    }

    public int describeContents() {
        return  0;
    }

}
