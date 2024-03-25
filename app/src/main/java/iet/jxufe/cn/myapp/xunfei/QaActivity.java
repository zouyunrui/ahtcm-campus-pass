package iet.jxufe.cn.myapp.xunfei;

import static com.google.firebase.inappmessaging.internal.Logging.TAG;

import android.Manifest;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.iflytek.sparkchain.core.LLM;
import com.iflytek.sparkchain.core.LLMConfig;
import com.iflytek.sparkchain.core.LLMOutput;
import com.iflytek.sparkchain.core.SparkChain;
import com.iflytek.sparkchain.core.SparkChainConfig;

import java.io.IOException;

import iet.jxufe.cn.myapp.R;
import kr.co.namee.permissiongen.PermissionGen;

public class QaActivity extends AppCompatActivity {
    private static final String LOG_TAG = "QaActivity";
    private static final int RECORD_AUDIO_PERMISSION_CODE = 100;
    private EditText etQuestion, etAnswer;
    private Button btnSubmit, btnStartRecord,btnStopRecord,btnStartPlay, btnStopPlay;
    private MediaPlayer mPlayer=null;
    private MediaRecorder mRecorder=null;
    private String FileName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wenda);
        requestPermission();  //请求麦克风权限
        String location = getIntent().getStringExtra("rcity");
        String address = getIntent().getStringExtra("address");
        etQuestion = findViewById(R.id.et_question);
        etAnswer = findViewById(R.id.et_answer);
        btnSubmit = findViewById(R.id.btn_submit);



        //开始录音

       /* //绑定监听器
        btnStartRecord.setOnClickListener(new startRecordListener());

        //结束录音

        btnStopRecord.setOnClickListener(new stopRecordListener());

        //开始播放

        //绑定监听器
        btnStartPlay.setOnClickListener(new startPlayListener());

        //结束播放

        btnStopPlay.setOnClickListener(new stopPlayListener());

        //设置sdcard的路径
        FileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        FileName += "/test.mp3";*/


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = etQuestion.getText().toString();
                String answer = etAnswer.getText().toString();
                SparkChainConfig config = SparkChainConfig.builder()
                        .appID("3099291c")
                        .apiKey("eea99deb675c2666dfadd4bc2dc4af96")
                        .apiSecret("YzgwOTE5OWYwMjM5MmYwM2UzY2QyODMw");

                SparkChain.getInst().init(getApplicationContext(), config);
                LLMConfig llmConfig = LLMConfig.builder()
                        .domain("generalv3")
                        .url("ws(s)://spark-api.xf-yun.com/v2.1/chat");

                LLM llm = new LLM(llmConfig);
              //  String question1 = "当前位置为" + location + question;
              //  String question1 = "当前位置为" + location + question;
                LLMOutput syncOutput = llm.run(question);

                if (syncOutput.getErrCode() == 0) {
                    Log.i(TAG, "同步调用：" + syncOutput.getRole() + ":" + syncOutput.getContent());
                    answer = syncOutput.getContent();
                } else {
                    Log.e(TAG, "同步调用：" + "errCode" + syncOutput.getErrCode() + " errMsg:" + syncOutput.getErrMsg());
                }

                String message = answer;
                Toast.makeText(QaActivity.this, message, Toast.LENGTH_SHORT).show();


            }
        });
    }
    private void requestPermission() {
        PermissionGen.with(this)
                .addRequestCode(100)
                .permissions(Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.WAKE_LOCK)
                .request();
    }

    //开始录音
    class startRecordListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            mRecorder = new MediaRecorder();
            mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mRecorder.setOutputFile(FileName);
            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            try {
                mRecorder.prepare();
                mRecorder.start();
            } catch (IOException e) {
                Log.e(LOG_TAG, "prepare() failed ---" + e.getMessage());
            }
        }

    }

    //停止录音
    class stopRecordListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            mRecorder.stop();
            mRecorder.release();
            mRecorder = null;
        }
    }

    //播放录音
    class startPlayListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            mPlayer = new MediaPlayer();
            try {
                mPlayer.setDataSource(FileName);
                mPlayer.prepare();
                mPlayer.start();
            } catch (IOException e) {
                Log.e(LOG_TAG, "播放失败");
            }
        }

    }

    //停止播放录音
    class stopPlayListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            mPlayer.release();
            mPlayer = null;
        }

    }

}