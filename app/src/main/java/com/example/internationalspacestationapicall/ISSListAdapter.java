package com.example.internationalspacestationapicall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internationalspacestationapicall.model.issresponse.Response;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ISSListAdapter extends RecyclerView.Adapter<ISSListAdapter.ViewHolder> {

    private List<Response> responseArrayList;

    public ISSListAdapter(List<Response> responseArrayList) {
        this.responseArrayList = responseArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.iss_pass_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Response response = responseArrayList.get(position);

        Timestamp ts = new Timestamp((long)response.getRisetime() * 1000);
        Date date = new Date(ts.getTime());
        holder.tvDuration.setText(response.getDuration() + " seconds");
        holder.tvTime.setText(date.toString());
        holder.setResponse(response);
    }

    @Override
    public int getItemCount() {
        return responseArrayList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvDuration, tvTime;
        Response response;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDuration = itemView.findViewById(R.id.tvDuration);
            tvTime = itemView.findViewById(R.id.tvTime);
            itemView.setOnClickListener(this);
        }

        public Response getResponse() {
            return response;
        }

        public void setResponse(Response response) {
            this.response = response;
        }

        @Override
        public void onClick(View view) {

        }
    }
}
