package com.skakeylapearson.multitrans;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/translate")
    Call<List<RetroTranslation>> getTranslations();
}
