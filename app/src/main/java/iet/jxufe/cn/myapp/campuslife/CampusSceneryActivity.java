package iet.jxufe.cn.myapp.campuslife;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher.ViewFactory;

import androidx.appcompat.app.AppCompatActivity;
import iet.jxufe.cn.myapp.R;


public class CampusSceneryActivity extends AppCompatActivity {
	private ImageSwitcher mSwitcher;
	private LinearLayout mLinearLayout;
	private int lastClicked = 0;
	private int[] imageIds=new int[]{
			R.drawable.a, R.drawable.b,R.drawable.c,
			R.drawable.d,R.drawable.e,R.drawable.f
	};
	private ImageView[] imageViews ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.campus_scenery);
		mSwitcher = (ImageSwitcher)findViewById(R.id.mSwitcher);
		mSwitcher.setFactory(new ViewFactory(){
			public View makeView(){
				ImageView imageView = new ImageView(CampusSceneryActivity.this);
				imageView.setBackgroundColor(0xff0000);
				imageView.setScaleType(ImageView.ScaleType.FIT_XY);
				imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
				return imageView;
			}
		});
		mSwitcher.setImageResource(imageIds[lastClicked]);
		mLinearLayout = (LinearLayout)findViewById(R.id.mLinearLayout);
		init_mLinearLayout();
	}
	public void init_mLinearLayout(){
		imageViews = new ImageView[imageIds.length];
		LinearLayout.LayoutParams mParams=new LinearLayout.LayoutParams(120,90);
		mParams.setMargins(0, 0, 20, 0);//设置图片之间的边距
		MyListener mListener = new MyListener();
		for(int i=0; i<imageIds.length;i++){
			imageViews[i] = new ImageView(this);
			imageViews[i].setId(i);//为ImageView控件添加ID属性
			imageViews[i].setImageResource(imageIds[i]);
			imageViews[i].setLayoutParams(mParams);
			imageViews[i].setOnClickListener(mListener);
			imageViews[i].setScaleType(ImageView.ScaleType.FIT_XY);
			mLinearLayout.addView(imageViews[i]);
			if(i == 0){
				imageViews[i].setImageAlpha(255);
			}else{
				imageViews[i].setImageAlpha(100);
			}
		}
	}
	private class MyListener implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			imageViews[lastClicked].setImageAlpha(100);
			lastClicked = v.getId();
			imageViews[lastClicked].setImageAlpha(255);
			mSwitcher.setImageResource(imageIds[lastClicked]);
		}
	}
}
