
package com.example.internationalspacestationapicall.model.issresponse;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ISSResponse implements Parcelable
{

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("request")
    @Expose
    private Request request;
    @SerializedName("response")
    @Expose
    private List<Response> response = null;
    public final static Parcelable.Creator<ISSResponse> CREATOR = new Creator<ISSResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ISSResponse createFromParcel(Parcel in) {
            return new ISSResponse(in);
        }

        public ISSResponse[] newArray(int size) {
            return (new ISSResponse[size]);
        }

    }
    ;

    protected ISSResponse(Parcel in) {
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.request = ((Request) in.readValue((Request.class.getClassLoader())));
        in.readList(this.response, (com.example.internationalspacestationapicall.model.issresponse.Response.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public ISSResponse() {
    }

    /**
     * 
     * @param response
     * @param message
     * @param request
     */
    public ISSResponse(String message, Request request, List<Response> response) {
        super();
        this.message = message;
        this.request = request;
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(message);
        dest.writeValue(request);
        dest.writeList(response);
    }

    public int describeContents() {
        return  0;
    }

}
