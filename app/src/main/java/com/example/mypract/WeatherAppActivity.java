package com.example.mypract;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherAppActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnCityId, btnWeatherId, btnWeatherName;
    EditText editText;
    ListView listView;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.weather_app);

        btnCityId = findViewById(R.id.cityId);
        btnCityId.setOnClickListener(this);

        btnWeatherId = findViewById(R.id.weatherId);
        btnWeatherId.setOnClickListener(this);

        btnWeatherName = findViewById(R.id.weatherName);
        btnWeatherName.setOnClickListener(this);


        editText = findViewById(R.id.editTxt);
        listView = findViewById(R.id.listVw);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cityId:
                handleCityId();
                break;
            case R.id.weatherId:
                handleWeatherId();
                break;
            case R.id.weatherName:
                handleWeatherName();
                break;
            default:
                break;
        }
    }

    private void handleCityId() {
        WeatherDataService weatherDataService = new WeatherDataService(this);
        weatherDataService.getCityId(editText.getText().toString(), new WeatherDataService.volleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(WeatherAppActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(String message) {
                Toast.makeText(WeatherAppActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void handleWeatherId() {
//        WeatherDataService weatherDataService = new WeatherDataService(this);
//        weatherDataService.getCityForcastById(editText.getText().toString(), new WeatherDataService.volleyResponseListener() {
//            @Override
//            public void onError(String message) {
//                Toast.makeText(WeatherAppActivity.this, message, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onResponse(String message) {
//                Toast.makeText(WeatherAppActivity.this, message, Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void handleWeatherName() {


        Toast.makeText(this, editText.getText().toString(), Toast.LENGTH_SHORT).show();

    }
}
