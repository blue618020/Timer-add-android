package com.blue.timer2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    ImageView imgAlarm;
    EditText editTimer;
    Button btnStart;
    Button btnCancel;
    TextView txtTimer;

    // 필요에 의해 로컬에서 멤버로 나온 변수들
    CountDownTimer timer;
    Long time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgAlarm = findViewById(R.id.imgAlarm);
        editTimer = findViewById(R.id.editTimer);
        txtTimer = findViewById(R.id.txtTimer);
        btnStart = findViewById(R.id.btnStart);
        btnCancel = findViewById(R.id.btnCancel);

        // 타이머 시작버튼
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override

            // 타이머 객체를 만들기
            // 1초 = 1000
            public void onClick(View v) {
                // 1. 유저가 입력한 시간 가져오기
                String strTime = editTimer.getText().toString().trim();

                time = Long.parseLong(strTime); // 타이머의 데이터타입인 long 으로 변경
                time = time*1000;

                // 2. 타이머 객체 생성해서 만들기
                timer = new CountDownTimer(time, 1000) {
                    @Override
                    public void onTick(long l) {
                        // 위의 인터벌 파라미터에 의해서 실행되는 함수로,
                        // 1초 지날때마다 남은 시간을 화면에 표시하기

                        long remain = l / 1000;
                        txtTimer.setText(remain+"초");
                    }

                    @Override
                    public void onFinish() {
                        // 타이머가 종료될 때 실행되는 함수로,
                        // 소리나 진동 등 종료될 때 하고싶은 동작을 여기에 작성

                        // 소리와 애니메이션 효과 넣기
                        MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.alarm);
                        mp.start(); // 소리

                        YoYo.with(Techniques.Shake)
                                .duration(700)
                                .repeat(5)
                                .playOn(findViewById(R.id.imgAlarm)); // 애니메이션

                    }
                }; // 동작하기 위해 new 로 메모리에 자리를 만든 것(실행x)
                timer.start(); // 타이머 동작 실행!!하려면 스타트 해줘야지
            }
        });


        // 타이머 취소 버튼
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (timer == null){ // time 이 아니고 timer 였다...(와;)
                    return;
                }
                // 1. 타이머 취소하기
                timer.cancel();

                // 2. 남은 시간은 셋팅한 시간으로 초기화
                txtTimer.setText(time/1000+"");
            }
        });







        // 타이머 시간 입력받기
//        String number = editNumber.getText().toString().trim();
//
//        int time = Integer.parseInt(number);

        // 시작 버튼 클릭
//        btnStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // 타이머 객체
//                CountDownTimer timer1 = new CountDownTimer(time*1000, 1000) {
//                    @Override
//                    public void onTick(long l) {
//                        long remain = l / 1000;
//                        txtTimer.setText(remain+"초");
//                    }
//
//                    @Override
//                    public void onFinish() {
//                        isFinish = true;
//
//                        mp = MediaPlayer.create(MainActivity.this, R.raw.alarm);
//
//                    }
//                };
//
//            }
//        });

    }
}