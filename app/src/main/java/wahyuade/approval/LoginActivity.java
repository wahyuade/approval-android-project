package wahyuade.approval;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import wahyuade.approval.Service.ApiConfig;
import wahyuade.approval.Service.Model.LoginModel;

public class LoginActivity extends Activity {
    Button reset_button;
    Button login;
    TextView to_register;
    EditText email,password;
    Call<LoginModel> loginModelCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        reset_button = (Button)findViewById(R.id.reset_button);
        to_register = (TextView)findViewById(R.id.to_register);
        login = (Button)findViewById(R.id.login_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data_email = email.getText().toString();
                String data_password = password.getText().toString();
                Retrofit postLogin = new Retrofit.Builder()
                        .baseUrl(ApiConfig.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create()).build();
                ApiConfig.PostService service = postLogin.create(ApiConfig.PostService.class);
                loginModelCall = service.postLogin(data_email,data_password);
                loginModelCall.enqueue(new Callback<LoginModel>() {
                    @Override
                    public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                        Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<LoginModel> call, Throwable t) {

                    }
                });
            }
        });

        to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register);
                finish();
            }
        });

        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email.setText("");
                password.setText("");
            }
        });
    }
}
