package iet.jxufe.cn.myapp.campuslife;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import iet.jxufe.cn.myapp.R;


public class DetailInfoActivity extends AppCompatActivity {
	private TextView info;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_info);
		String detail=getIntent().getStringExtra("info");
		info=(TextView)findViewById(R.id.info);
		info.setText(detail);
	}
}
