package wahyuade.approval.Service;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import wahyuade.approval.Service.Model.LoginModel;

/**
 * Created by Wahyu Ade Sasongko on 6/11/2017.
 */

public class ApiConfig {
    public static String BASE_URL = "http://192.168.43.10/approval/public/";
    public interface PostService{
        @FormUrlEncoded
        @POST("api/login")
        Call<LoginModel> postLogin(@Field("email") String email, @Field("password") String password);
    }
    public interface GetService{}
}
