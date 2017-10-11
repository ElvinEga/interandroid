package ke.co.interintel.interapp.interintelapp.networking;


import ke.co.interintel.interapp.interintelapp.model.request.LoginRequest;
import ke.co.interintel.interapp.interintelapp.model.request.RegisterRequest;
import ke.co.interintel.interapp.interintelapp.model.response.Login;
import ke.co.interintel.interapp.interintelapp.model.response.Register;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by beast on 7/17/17.
 */

public interface ApiInterface {
    //url points

    //login
    @POST("/users/login/")
    Call<Login> postLogin(@Body LoginRequest loginRequest);

    //register user
    @POST("/users/create_user/")
    Call<Register> postRegister(@Body RegisterRequest registerRequest);


    }

