package com.example.internationalspacestationapicall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.example.internationalspacestationapicall.model.datasource.remote.rxjava.Callback;
import com.example.internationalspacestationapicall.model.datasource.remote.rxjava.ISSRepo;
import com.example.internationalspacestationapicall.model.issresponse.ISSResponse;
import com.example.internationalspacestationapicall.model.issresponse.Response;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Callback {

    private RecyclerView rvISSList;
    private List<Response> responses = new ArrayList<>();
    private LocationManager locationManager;
    private Location location;
    private final int REQUEST_LOCATION_CODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvISSList = findViewById(R.id.rvISSList);
        rvISSList.setLayoutManager(new LinearLayoutManager(this));

        getLocation();

        if (location != null) {
            ISSRepo.getISS(this, String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()));
        }
    }

    private void getLocation() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_CODE);
        else
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    }

    @Override
    public void getISSResponse(ISSResponse issResponse) {
        responses = issResponse.getResponse();

        ISSListAdapter issListAdapter = new ISSListAdapter(responses);
        rvISSList.setAdapter(issListAdapter);
    }

}
