package com.tvo.tavv.productchecking.networking;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.tvo.tavv.productchecking.models.CategoryReponsitory;
import com.tvo.tavv.productchecking.models.Product;
import com.tvo.tavv.productchecking.models.ProductRepository;
import com.tvo.tavv.productchecking.models.ResponseModel;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Tavv
 * on 25/04/2017.
 */

public interface NetworkService {

    Observable<ProductRepository> getAllProduct(@Nullable @Query("limit") Integer limit, @Nullable @Query("offset") Integer offset);

    Observable<ResponseModel> saveProduct(@NonNull @Body Product product);

    Observable<ResponseModel> updateProduct(@NonNull @Body Product product);

    Observable<ResponseModel> deleteProduct(@NonNull @Query("product_id") String product_id);

    Observable<Product> getProduct(@NonNull @Query("product_id") String product_id);

    @GET
    Observable<CategoryReponsitory> getAllCategory(@Url String url);
}
