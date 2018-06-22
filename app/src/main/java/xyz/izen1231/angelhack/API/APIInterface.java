package xyz.izen1231.angelhack.API;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import xyz.izen1231.angelhack.pojo.User;

/**
 * Created by jeong-woochang on 2018. 6. 16..
 */

public interface APIInterface {

    @POST("/user/signin")
    Call<User> login(@Body User logininfo);

    @POST("/user/signup")
    Call<User> signup(@Body User signupinfo);

}
