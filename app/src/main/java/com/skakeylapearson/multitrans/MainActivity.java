package com.skakeylapearson.multitrans;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.skakeylapearson.multitrans.RetroTranslation;
import com.skakeylapearson.multitrans.GetDataService;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonTranslate).setOnClickListener(v -> {
            EditText txtTrs = findViewById(R.id.textTranslate);
            String data = txtTrs.toString();
            if (!data.equals("")) {
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.show();

                // RetrofitInstance interface reference
                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<List<RetroTranslation>> call = service.getTranslations();
                call.enqueue(new Callback<List<RetroTranslation>>() {
                    @Override
                    public void onResponse(Call<List<RetroTranslation>> call, Response<List<RetroTranslation>> response) {
                        progressDialog.dismiss();
                        generateTranslations(response.body());
                    }
                    @Override
                    public void onFailure(Call<List<RetroTranslation>> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Something went wrong.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void generateTranslations(List<RetroTranslation> translations) {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new RecyclerAdapter(this, translations);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}