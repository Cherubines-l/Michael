package com.example.mylianxi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
int [][]arry={{1,7,7,7},{2,8,8,8},{3,9,9,9}};
int [][]arry1={{3,9,9,9},{2,8,8,8},{1,7,7,7}};
    private Spinner spLight;
    private Button btnFind2;


    private TableRow tableRowOne;

    private TableRow tableRowTwo;

    private TableRow tableRowThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setArry(arry);
    }
    private void initView() {
        spLight = (Spinner) findViewById(R.id.sp_light);
        btnFind2 = (Button) findViewById(R.id.btn_find2);
        tableRowOne = (TableRow) findViewById(R.id.table_row_one);
        tableRowTwo = (TableRow) findViewById(R.id.table_row_two);
        tableRowThree = (TableRow) findViewById(R.id.table_row_three);
        btnFind2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.btn_find2:
                String s= (String) spLight.getItemAtPosition(spLight.getSelectedItemPosition());

                switch (s){
                    case "路口升序":
                      setArry(arry);
                        break;
                    case "路口降序":
                        setArry(arry1);
                        break;
                    case "红灯升序":
                        setArry(arry);
                        break;
                    case "红灯降序":
                        setArry(arry1);
                        break;
                    case "黄灯升序":
                        setArry(arry);
                        break;
                    case "黄灯降序":
                        setArry(arry1);
                        break;
                    case "绿灯升序":
                        setArry(arry);
                        break;
                    case "绿灯降序":
                        setArry(arry1);
                        break;
                }
                break;
                default:
        }}
        private void setArry(int[][] asd){
                tableRowTwo.removeAllViews();
                tableRowOne.removeAllViews();
                tableRowThree.removeAllViews();
            for (int j=0;j<4;j++){
                TextView road=new TextView (MainActivity.this);
                road.setText(""+asd[0][j]);

                tableRowOne.addView(road);
            }for (int y=0;y<4;y++){
                TextView f=new TextView (MainActivity.this);
                f.setText(""+asd[1][y]);
                tableRowTwo.addView(f);
            }for (int q=0;q<4;q++){
                TextView as=new TextView (MainActivity.this);
                as.setText(""+asd[2][q]);
                tableRowThree.addView(as);
            }}
}
