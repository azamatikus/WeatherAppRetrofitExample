package com.azamat.weatherappretrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.azamat.weatherappretrofitexample.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private String url = "api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}";
    private String id = "84455d709fd781ad630d96172e812c88";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }

    public void getWeather(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApi myApi = retrofit.create(WeatherApi.class);
        Call<Example> exampleCall = myApi.getWeather(binding.et.getText().toString().trim(), id);
        exampleCall.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.code() == 404){
                    Toast.makeText(MainActivity.this, "Please enter a valid city...", Toast.LENGTH_SHORT).show();
                }else if (!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                }
                Example mydata = response.body();
                WeatherModel model = mydata.getModel();
                Double temp = model.getTemp();
                Integer temperature = (int)(temp - 273.15);
                String txt = temperature +"C";
                binding.tv.setText(txt);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}