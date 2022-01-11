package com.example.backbuttonexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long backBtntim = 0; // 백버튼을 누렸을때 시간을 나타내는 변수 0으로 기본 초기화


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {               //현재 시간은 계속 흐르기 때문에 무조건 curtime - bakctntim이다.
        long curTime = System.currentTimeMillis(); //curTime은 현재 시간을 나타내는 변수로 CurrentTimeMilleis()
        long gapTime = curTime - backBtntim; // 현재 시간에서 back버튼을 누른 시간을 빼신간으로 차이를 계산
        if(0 <= gapTime && 2000 >= gapTime){//2000밀리세컨드로 2초안에 한번더 누르면
            super.onBackPressed();          //해당 실질적인 백버튼 이벤트가 실행됨
        }
        else { //질문: 해당 curTime이 현재시간을 가져오는것을 알고 있는데 시간이 흐르는 동안 지속적으로 현재 시간을 가져오는것인지? 그리고 해당 curtime은 언제부터 가져오는것인지?(해당 객체를 생성한 후부터인지 아니면 코드가 실행된 시간 부터인지?)
            backBtntim = curTime;
            Toast.makeText(this, "한번 더 누르면 중지됩니다.", Toast.LENGTH_SHORT).show();

            //삭제

        }


    }

}