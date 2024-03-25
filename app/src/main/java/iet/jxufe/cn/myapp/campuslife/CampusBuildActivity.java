package iet.jxufe.cn.myapp.campuslife;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import iet.jxufe.cn.myapp.R;

public class CampusBuildActivity extends AppCompatActivity {
    private Button goBack;
    private Spinner mSpinner;
    private ImageView mImage;
    private float m_x, m_y;
    int[] imageIds = new int[]{
            R.drawable.jiaotong, R.drawable.shaoquanhuxiaoqu,
            R.drawable.meishanluxiaoqu, R.drawable.shiheluxiaoqu};
    String[] xiaoqu = new String[]{"交通示意图", "少荃湖校区", "梅山路校区", "史河路校区"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campus_build);
        mImage = (ImageView) findViewById(R.id.myImage);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, xiaoqu);
        mSpinner = (Spinner) findViewById(R.id.spinner);
        //为Spinner设置Adapter
        mSpinner.setAdapter(adapter);
        //添加选中事件监听器
        mSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {
                mImage.setImageResource(imageIds[position]);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                mImage.setImageResource(imageIds[0]);
            }
        });
        mImage.setOnTouchListener(new OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                float curX, curY;
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        m_x = event.getX();
                        m_y = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        curX = event.getX();
                        curY = event.getY();
                        mImage.scrollBy((int) (m_x - curX), (int) (m_y - curY));
                        m_x = curX;
                        m_y = curY;
                        break;
                    case MotionEvent.ACTION_UP:
                        curX = event.getX();
                        curY = event.getY();
                        mImage.scrollBy((int) (m_x - curX), (int) (m_y - curY));
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }
}