package com.example.taskapp.childfragments;

import android.app.DownloadManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.taskapp.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatusFragment extends Fragment {

    public StatusFragment() {
        // Required empty public constructor
    }

    TextView tvResponse;
    Button btnRequest;
    String server_url= "https://run.mocky.io/v3/deef9a2e-08cb-4c8c-985a-b6a5980b96c2";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_status, container, false);
        tvResponse=v.findViewById(R.id.tvResponse);
        btnRequest=v.findViewById(R.id.btnRequest);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                StringRequest stringRequest = new StringRequest(Request.Method.GET, server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                tvResponse.setText(response);
                                requestQueue.stop();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tvResponse.setText("Error No internet connection");
                        error.printStackTrace();
                        requestQueue.stop();
                    }
                });
            requestQueue.add(stringRequest);
            }
        });
        return v;
    }
}
