package iet.jxufe.cn.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import iet.jxufe.cn.myapp.campuslife.CampusLifeActivity;

import iet.jxufe.cn.myapp.loginregister.LoginActivity;
import iet.jxufe.cn.myapp.loginregister.RegisterActivity;
import iet.jxufe.cn.myapp.xunfei.QaActivity;
import iet.jxufe.cn.myapp.youwanhefei.SceneryActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void goto_tianqi(View view) {// 跳转到地图
        Intent intent = new Intent(MainActivity.this, QaActivity.class);
        startActivity(intent);
    }

    public void goto_campus_life(View view) {// 跳转到校园生活
        Intent intent = new Intent(MainActivity.this, CampusLifeActivity.class);
        startActivity(intent);
    }


    public void goto_scenery(View view) {//跳转到游玩
        Intent intent = new Intent(MainActivity.this, SceneryActivity.class);
        startActivity(intent);
    }


    public void goto_map(View view) {//跳转到天气问答
        Intent intent = new Intent(MainActivity.this, MappingActivity.class);
        startActivity(intent);
    }

    public void goto_login(View view) {//跳转到天气问答
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
    public void goto_register(View view) {//跳转到天气问答
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }


    /*public void goto_image_generate(View view) {//跳转到图片生成
        Intent intent = new Intent(MainActivity.this, ChatActivity.class);
        startActivity(intent);
    }*/
}
