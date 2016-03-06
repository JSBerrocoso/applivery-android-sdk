package com.applivery.applvsdklib.network.api;

import com.applivery.applvsdklib.network.api.requests.ApiFeedbackRequestData;
import com.applivery.applvsdklib.network.api.responses.ApiAppConfigResponse;
import com.applivery.applvsdklib.network.api.responses.ApiBuildTokenResponse;
import com.applivery.applvsdklib.network.api.responses.ApiFeedbackResponse;
import com.squareup.okhttp.ResponseBody;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Streaming;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 18/10/15.
 */
public interface AppliveryApiService {

  @GET("/api/apps/{app_id}") Call<ApiAppConfigResponse> obtainAppConfig(@Path("app_id") String appId);

  @GET("/api/builds/{build_id}/token")
  Call<ApiBuildTokenResponse> obtainBuildToken(@Path("build_id") String buildId);

  @GET("/download/{build_id}/manifest/{download_token}")
  @Streaming
  Call<ResponseBody> downloadBuild(@Path("build_id") String buildId, @Path("download_token") String download_token);

  @POST("/api/bugs")
  Call<ApiFeedbackResponse> sendFeedback(@Body ApiFeedbackRequestData bugRequest);


  //TODO this will be implemented in second phase
  //@POST("/api/crashes/")
  //Call<ApiCrashResponse> reportCrash(ApiCrashRequest crashRequest);

}

