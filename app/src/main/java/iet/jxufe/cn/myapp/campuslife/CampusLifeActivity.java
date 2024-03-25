package iet.jxufe.cn.myapp.campuslife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import iet.jxufe.cn.myapp.R;

public class CampusLifeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campus_life);
    }

    public void goto_campus_build(View view) {// 跳转到校区平面图
        Intent intent = new Intent(CampusLifeActivity.this, CampusBuildActivity.class);
        startActivity(intent);
    }

    public void goto_campus_scenery(View view) {// 跳转到校园风景
        Intent intent = new Intent(CampusLifeActivity.this, CampusSceneryActivity.class);
        startActivity(intent);
    }

    public void goto_fresh_assist(View view) {// 跳转到新生指南
        Intent intent = new Intent(CampusLifeActivity.this, FreshAssistActivity.class);
        startActivity(intent);
    }
}
