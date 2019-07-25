
package com.example.internationalspacestationapicall.model.issresponse;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response implements Parcelable
{

    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("risetime")
    @Expose
    private Integer risetime;
    public final static Parcelable.Creator<Response> CREATOR = new Creator<Response>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Response createFromParcel(Parcel in) {
            return new Response(in);
        }

        public Response[] newArray(int size) {
            return (new Response[size]);
        }

    }
    ;

    protected Response(Parcel in) {
        this.duration = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.risetime = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Response() {
    }

    /**
     * 
     * @param duration
     * @param risetime
     */
    public Response(Integer duration, Integer risetime) {
        super();
        this.duration = duration;
        this.risetime = risetime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getRisetime() {
        return risetime;
    }

    public void setRisetime(Integer risetime) {
        this.risetime = risetime;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(duration);
        dest.writeValue(risetime);
    }

    public int describeContents() {
        return  0;
    }

}
