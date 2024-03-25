package iet.jxufe.cn.myapp.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import iet.jxufe.cn.myapp.MainActivity;
import iet.jxufe.cn.myapp.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText etUsername, etPassword, etConfirmPwd;
    private Button btnRegister, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        etConfirmPwd = findViewById(R.id.et_confirm_password);

        btnRegister = findViewById(R.id.btn_register);
        btnLogin = findViewById(R.id.btn_login);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 验证数据
                if(verifyData()) {
                    // TODO 实现注册逻辑
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

    }

    private boolean verifyData() {
        // 验证用户名密码是否为空
        if(etUsername.getText().toString().isEmpty()) {
            etUsername.setError("用户名不能为空");
            return false;
        }

        // 验证密码是否一致
        if(!etPassword.getText().toString().equals(etConfirmPwd.getText().toString())) {
            etConfirmPwd.setError("两次输入的密码不一致");
            return false;
        }

        return true;
    }

}