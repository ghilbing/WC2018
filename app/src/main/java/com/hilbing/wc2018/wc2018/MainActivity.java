package com.hilbing.wc2018.wc2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.hilbing.wc2018.wc2018.model.Stadium;
import com.hilbing.wc2018.wc2018.model.Team;
import com.hilbing.wc2018.wc2018.model.WorldCup2018;
import com.hilbing.wc2018.wc2018.rest.Api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final String BASE_URL = "https://raw.githubusercontent.com/lsv/fifa-worldcup-2018/master/";

    private Button btnGetData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetData = findViewById(R.id.btnGetData);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        api.getData().enqueue(new Callback<WorldCup2018>() {
            @Override
            public void onResponse(Call<WorldCup2018> call, Response<WorldCup2018> response) {
                Log.d(TAG, "onResponse: Server Response: " + response.toString());
                Log.d(TAG, "onResponse: received information: " + response.body().toString());

                int stadiums = response.body().getStadiums().size();
                for (int i = 0; i < stadiums ; i++) {
                    Log.d(TAG, "onResponse: \n" +
                                    "id: " + response.body().getStadiums().get(i).getId() + "\n"  +
                                    "name: " + response.body().getStadiums().get(i).getName() + "\n" +
                                    "city: " + response.body().getStadiums().get(i).getCity() + "\n" +
                                    "lat: " + response.body().getStadiums().get(i).getLat() + "\n" +
                                    "lng: " + response.body().getStadiums().get(i).getLng() + "\n"
                    );

                }

                int team = response.body().getTeams().size();
                for (int i = 0; i <team ; i++) {
                    Log.d(TAG, "id: " + response.body().getTeams().get(i).getId() + "\n" +
                            "emoji: " + response.body().getTeams().get(i).getEmoji() + "\n" +
                            "flag: " + response.body().getTeams().get(i).getFlag() + "\n");



                }
            }

            @Override
            public void onFailure(Call<WorldCup2018> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });



    }
}
