package com.tvo.tavv.productchecking.networking;

import com.tvo.tavv.productchecking.BuildConfig;
import com.tvo.tavv.productchecking.constants.AppConstant;
import com.tvo.tavv.productchecking.services.Service;

import java.io.File;
import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tavv
 * on 25/04/2017.
 */
@Module
public class NetworkModule {
    private File fileCache;

    public NetworkModule(File fileCache) {
        this.fileCache = fileCache;
    }

    @Provides
    @Singleton
    public Retrofit retrofitCall() {
        Cache cache = null;
        try {
            cache = new Cache(fileCache, 10 * 1024 * 1024);
        } catch (Exception e) {
            e.printStackTrace();
        }
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request request = original.newBuilder()
                                .header(AppConstant.CONTENT_TYPE, AppConstant.CONTENT_TYPE_JSON)
                                .removeHeader("Prama")
                                .header("Cache-Control", String.format(BuildConfig.STR_CACHE_TEMPLATE, BuildConfig.CACHE_TIME))
                                .build();
                        Response response = chain.proceed(request);
                        response.cacheResponse();
                        return response;
                    }
                })
                .cache(cache)
                .build();
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public NetworkService provideNetworkService(Retrofit retrofit) {
        return retrofit.create(NetworkService.class);
    }

    @Provides
    @Singleton
    public Service provideService(NetworkService networkService) {
        return new Service(networkService);
    }


}
