package iet.jxufe.cn.myapp.youwanhefei;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import iet.jxufe.cn.myapp.R;

public class SceneryShowActivity extends AppCompatActivity {
	private ImageView imageView;
	private TextView content;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scenery_show);
		imageView=(ImageView)findViewById(R.id.image);
		content=(TextView)findViewById(R.id.content);
		int image=getIntent().getIntExtra("image",R.drawable.tengwangge);
		String show=getIntent().getStringExtra("content");
		System.out.println(show);
		imageView.setBackgroundResource(image);
		content.setText(show);
	}
}
