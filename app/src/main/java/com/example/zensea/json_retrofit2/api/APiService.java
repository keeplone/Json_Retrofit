package com.example.zensea.json_retrofit2.api;

import com.example.zensea.json_retrofit2.model.Food;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Zensea on 01-Aug-17.
 */

public interface APiService {
    @GET("/food/array_food.php")
    Call<Food> getFoods();
}
