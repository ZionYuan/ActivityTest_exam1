package com.example.yuanzi.activitytest_exam1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    int answer = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        answer = intent.getIntExtra("result",-1);
        TextView res = (TextView)findViewById(R.id.answer);
        res.setText(Integer.toString(answer));


    }

    /*
    点击返回按钮，返回数据的方法如下。
     */
    @Override
    public void onBackPressed() {

        Intent intent1 = new Intent();
        intent1.putExtra("data","...........");
        setResult(RESULT_OK,intent1);
        finish();
    }
}
