package xyz.izen1231.angelhack;

import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.security.Permission;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.izen1231.angelhack.API.APIClient;
import xyz.izen1231.angelhack.API.APIInterface;
import xyz.izen1231.angelhack.pojo.User;

public class LoginActivity extends AppCompatActivity {

    Button login;
    TextView signup;
    EditText id, pw;
    FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //FirebaseAuth의 항목을 가져옴
        auth=FirebaseAuth.getInstance();

        //우선 로그아웃 상태로 만들어 로그인 과정을 거친다
        auth.signOut();

        auth=FirebaseAuth.getInstance();
        login=(Button)findViewById(R.id.login_btn);
        signup=(TextView)findViewById(R.id.signup_go);
        id=(EditText) findViewById(R.id.id_tv);
        pw=(EditText)findViewById(R.id.pw_tv);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if((id.getText().toString()!=null||!id.getText().toString().equalsIgnoreCase(""))&&(pw.getText().toString()!=null||!pw.getText().toString().equalsIgnoreCase("")))
                    loginEvent();
                else
                    Toast.makeText(LoginActivity.this, "빈칸을 모두 채워주시기 바랍니다", Toast.LENGTH_SHORT).show();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!=null){
                    //로그인
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    id.setText("");
                    pw.setText("");
                    auth.signOut();
                    startActivity(intent);
                }else{
                    //로그아웃
                }
            }
        };
    }

    private void loginEvent() {
        try {
            auth.signInWithEmailAndPassword(id.getText().toString(), pw.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        //로그인 실패한 부분
                        Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }catch (Exception e) {
            Toast.makeText(this, "빈칸을 모두 채워주시기 바랍니다", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        auth.addAuthStateListener(authStateListener);
    }
}

