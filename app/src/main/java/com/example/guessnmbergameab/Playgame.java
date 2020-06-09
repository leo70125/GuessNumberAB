package com.example.guessnmbergameab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Playgame extends AppCompatActivity {
    private TextView tv,tv1;
    private EditText ed;
    private Button bt_ans,bt_compare,bt_star;
    private int intans_A = 0;
    private int intans_B = 0;
    private String GuessNB = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playgame);
        Init();
        bt_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random RandomNB = new Random();
                int [] intSetNB = new int [04] ;
                for(int i = 0; i<04;i++){
                    intSetNB[i] = -1;
                }

                intSetNB[0]=RandomNB.nextInt(10);

                while (true){
                    intSetNB[1] = RandomNB.nextInt(10);
                    if (intSetNB[0] != intSetNB [1] ){
                        break;
                    }
                }


                while (true){
                    intSetNB[2] = RandomNB.nextInt(10);
                    if (intSetNB[2] != intSetNB [0] && intSetNB[2] != intSetNB[1]){
                        break;
                    }
                }


                while (true){
                    intSetNB[3] = RandomNB.nextInt(10);
                    if (intSetNB[3] != intSetNB [0] && intSetNB[3] != intSetNB[1] && intSetNB[3] != intSetNB[2]){
                        break;
                    }
                }

                GuessNB =
                        String.valueOf(intSetNB[0]).toString().trim()+
                                String.valueOf(intSetNB[1]).toString().trim()+
                                String.valueOf(intSetNB[2]).toString().trim()+
                                String.valueOf(intSetNB[3]).toString().trim();
                intans_A = 0;
                intans_B = 0;

                tv1.setText("猜謎結果:");
                ed.setText("");
                Toast.makeText(Playgame.this,"開始猜謎",Toast.LENGTH_SHORT).show();

            }
        });

        bt_compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strGuessNBanskey = ed.getText().toString().trim();
                if(strGuessNBanskey.length() != 4){
                    tv1.setText("格式錯誤!!!");
                    return;
                }
                if (strGuessNBanskey.equals(GuessNB)){
                    tv1.setText("答對了!!!");
                    return;
                }

                String strCompareStr = "" ;
                int intComparePositionKey = -1;
                intans_A = 0;
                intans_B = 0;
                for(int i = 0; i<4; i++){
                    strCompareStr = strGuessNBanskey.substring(i,i+1);
                    intComparePositionKey = GuessNB.indexOf(strCompareStr);
                    if (i == intComparePositionKey){
                        intans_A++;
                    }else{
                        if (intComparePositionKey >= 0){
                            intans_B++;
                        }
                    }
                }
                tv1.setText("比對結果:" + intans_A + "A" + intans_B + "B");
            }
        });

        bt_ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("正確答案:" + GuessNB);
            }
        });
    }



    private void Init(){
        tv = findViewById(R.id.tv);
        tv1 = findViewById(R.id.tv1);
        bt_ans = findViewById(R.id.bt_ans);
        bt_compare= findViewById(R.id.bt_compare);
        bt_star = findViewById(R.id.bt_star);
        ed = findViewById(R.id.ed);
    }
}
