package com.myandroid.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //宣告介面元件相同型態的物件
    private EditText mEdtSex, mEdtAge;
    private TextView mTxtR;
    private Button mBtnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //利用findViewById() 取得介面元件 並設定給對應的物件
        //記得要轉型 (粗體標示的部分)
        mEdtSex = (EditText) findViewById(R.id.edtSex);
        mEdtAge = (EditText) findViewById(R.id.edtAge);
        mTxtR = (TextView) findViewById(R.id.txtR);
        mBtnOK = (Button) findViewById(R.id.btnOK);

        mBtnOK.setOnClickListener(btnOKOnClick);
    }

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //按下按鈕後要執行的程式碼
            String strSex = mEdtSex.getText().toString();
            int iAge = Integer.parseInt(mEdtAge.getText().toString());

            String strSug = getString(R.string.subjuect);
            if(strSex.equals(getString(R.string.sex_male)))
                if(iAge<28) {
                    strSug += getString(R.string.sug_not_hurry);
                    Log.d("MarrisSug", "man, 1");
                }
                else if(iAge>33) {
                    strSug += getString(R.string.sug_get_married);
                    Log.d("MarrisSug", "man, 2");
                }
                else {
                    strSug += getString(R.string.sug_find_couple);
                    Log.d("MarrisSug", "man, 3");
                }
            else {
                if (iAge < 25) {
                    strSug += getString(R.string.sug_not_hurry);
                    Log.d("MarrisSug", "woman, 1");
                }
                else if (iAge > 30) {
                    strSug += getString(R.string.sug_get_married);
                    Log.d("MarrisSug", "woman, 2");
                }
                else {
                    strSug += getString(R.string.sug_find_couple);
                    Log.d("MarrisSug", "woman, 3");
                }
            }

            mTxtR.setText(strSug);

        }
    };
}
