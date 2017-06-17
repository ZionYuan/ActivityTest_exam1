package com.example.yuanzi.activitytest_exam1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private Button button;
    private CheckBox multiply;
    private CheckBox add;
    int result = 0;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.d("YZ_TAG","this is log.d");
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        button = (Button)findViewById(R.id.button);
        multiply = (CheckBox)findViewById(R.id.multiply_);
        add = (CheckBox)findViewById(R.id.add_);
        spinner = (Spinner)findViewById(R.id.spinner);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                if(multiply.isChecked()){
                    result = Integer.parseInt(num1.getText().toString())*Integer.parseInt(num2.getText().toString());
                }else{
                    result = Integer.parseInt(num1.getText().toString())+Integer.parseInt(num2.getText().toString());
                }
                intent.putExtra("result",result);
                startActivityForResult(intent,1);
            }
        });


        multiply.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    add.setChecked(false);
                    //result = Integer.parseInt(num1.getText().toString())*Integer.parseInt(num2.getText().toString());
                    Toast.makeText(MainActivity.this,buttonView.getText()+"被选择",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,buttonView.getText()+"被取消",Toast.LENGTH_SHORT).show();
                }
            }
        });
        add.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    multiply.setChecked(false);
                    //result = Integer.parseInt(num1.getText().toString())+Integer.parseInt(num2.getText().toString());
                    Toast.makeText(MainActivity.this,buttonView.getText()+"被选择",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,buttonView.getText()+"被取消",Toast.LENGTH_SHORT).show();
                }
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] languages = getResources().getStringArray(R.array.languages);
                Toast.makeText(MainActivity.this,languages[position],Toast.LENGTH_SHORT).show();
                Log.d("YZ_TAG","fuck");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    /*

    获取下一个activity返回的数据。
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    String answer = data.getStringExtra("data");
                    Toast.makeText(MainActivity.this,answer,Toast.LENGTH_SHORT).show();
                    Log.d("YZ_TAG","获取返回数据成功");
                }
                break;
        }
    }
}
