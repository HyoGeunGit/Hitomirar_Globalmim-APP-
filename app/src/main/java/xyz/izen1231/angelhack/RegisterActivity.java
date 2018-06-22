package xyz.izen1231.angelhack;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.izen1231.angelhack.API.APIClient;
import xyz.izen1231.angelhack.API.APIInterface;
import xyz.izen1231.angelhack.pojo.User;

public class RegisterActivity extends AppCompatActivity {

    Button signup;
    EditText id, pw, name;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();
        signup = (Button) findViewById(R.id.sign_btn);
        name = (EditText) findViewById(R.id.name_tv);
        id = (EditText) findViewById(R.id.id_tv);
        pw = (EditText) findViewById(R.id.pw_tv);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id.getText().toString().equalsIgnoreCase("") || pw.getText().toString().equalsIgnoreCase("") || name.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(RegisterActivity.this, "빈칸을 모두 채워주시기 바랍니다.", Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseAuth.getInstance()
                            .createUserWithEmailAndPassword(id.getText().toString(), pw.getText().toString())
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    try {
                                        final String uid = task.getResult().getUser().getUid();
                                        User userModel = new User();
                                        userModel.name=name.getText().toString();
                                        userModel.id=id.getText().toString();
                                        userModel.pw=pw.getText().toString();
                                        FirebaseDatabase.getInstance().getReference().child("users").child(uid).setValue(userModel);
                                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                        Toast.makeText(RegisterActivity.this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                                        finish();
                                    } catch (Exception e) {
                                        Toast.makeText(RegisterActivity.this, "올바른 형식을 입력해 주시기바랍니다", Toast.LENGTH_SHORT).show();
                                        System.out.println(e.getMessage());
                                    }
                                }
                            });
                }
            }
        });
    }

}
