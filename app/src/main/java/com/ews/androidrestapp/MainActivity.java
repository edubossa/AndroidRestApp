package com.ews.androidrestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ews.androidrestapp.adapter.AndroidAdapter;
import com.ews.androidrestapp.api.APIUtils;
import com.ews.androidrestapp.api.AndroidAPI;
import com.ews.androidrestapp.model.ResponseAndroid;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvAndroids;
    private AndroidAPI androidAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidAPI = APIUtils.getAndroidAPI();
        this.rvAndroids = (RecyclerView) findViewById(R.id.rvAndroids);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        this.rvAndroids.setLayoutManager(layout);
        this.rvAndroids.setHasFixedSize(true);

        //Separa a lista colocando uma linha
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvAndroids.addItemDecoration(itemDecoration);

    }

    @Override
    protected void onStart() {
        super.onStart();
        carregaDados();
    }

    private void carregaDados() {
        androidAPI.getVersoes().enqueue(new Callback<ResponseAndroid>() {
            @Override
            public void onResponse(Call<ResponseAndroid> call, Response<ResponseAndroid> response) {
                if (response.isSuccessful()) {
                    rvAndroids.setAdapter(new AndroidAdapter(response.body().getAndroids()));
                }
            }

            @Override
            public void onFailure(Call<ResponseAndroid> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

}
