package com.example.mypract;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataService {
    public static final String BASEURL = "https://www.metaweather.com/api/location/search/?query=";
    Context context;
    String cityId = "";

    public WeatherDataService(Context context) {
        this.context = context;
    }

    public interface volleyResponseListener{
        void onError(String message);
        void onResponse(String message);
    }

    public void getCityId(String cityName, volleyResponseListener vrl) {
        //RequestQueue queue = Volley.newRequestQueue(this);
        String url = BASEURL + cityName;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONObject cityInfo = response.getJSONObject(0);
                            cityId = cityInfo.getString("woeid");
                            vrl.onResponse(cityId);
                            Toast.makeText(context, cityId, Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        vrl.onError(error.toString());
                        Toast.makeText(context, "Something Wrong", Toast.LENGTH_SHORT).show();
                    }
                });
        //queue.add(jsonArrayRequest);
        MySingleton.getInstance(context).addToRequestQueue(jsonArrayRequest);
        //return cityId;
    }

//    public getCityForcastById(String cityID) {
//        List<WeatherReportModel> report = new ArrayList<>();
//    }
//
//    public List<WeatherReportModel> getCityForcastById(String cityName) {
//
//    }


}
