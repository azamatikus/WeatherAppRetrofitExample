package com.azamat.weatherappretrofitexample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET ("weather")
    Call<Example> getWeather(@Query("q") String city,
                                  @Query("appid") String id);
}
