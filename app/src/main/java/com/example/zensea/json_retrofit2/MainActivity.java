package com.example.zensea.json_retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zensea.json_retrofit2.adapter.MyAdapter;
import com.example.zensea.json_retrofit2.api.APiService;
import com.example.zensea.json_retrofit2.api.Client;
import com.example.zensea.json_retrofit2.model.Food;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rv1);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager lim = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(lim);
        loadJSON();
    }

    private void loadJSON() {
        try {
            Client client = new Client();
            APiService apiService =
                    Client.getClient().create(APiService.class);
            Call<Food> call = apiService.getFoods();
            call.enqueue(new Callback<Food>() {
                @Override
                public void onResponse(Call<Food> call, Response<Food> response) {
                    List<Food.FoodsBean> food = response.body().getFoods();
                    recyclerView.setAdapter(new MyAdapter(getApplicationContext(), food));
                }

                @Override
                public void onFailure(Call<Food> call, Throwable t) {
                    Log.d("Error",t.getMessage());
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e){
            Log.d("Error",e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
