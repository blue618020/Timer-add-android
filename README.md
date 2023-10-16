# 타이머 앱

📝 <b> tistory : </b> https://blue618020.tistory.com/83

### 🔍 학습 내용
- 타이머 시작 버튼을 누르면, 유저가 입력한 시간으로 타이머가 작동하기
- 타이머가 종료되면 알람소리와 애니메이션 효과 적용하기

### 💻 실습
 
- 유저가 입력한 시간을 가져오고, 타이머의 데이터타입인 Long 으로 형변환을 한다.
  
      time = Long.parseLong(strTime);
      time = time*1000;

- <b> CountDownTimer </b> 객체

  : 유저가 입력한 시간으로 타이머가 작동하는 코드.
  
  1초 지날때마다 남은 시간을 화면에 표시하기
  
      timer = new CountDownTimer(time, 1000) {
                    @Override
                    public void onTick(long l) {
                        long remain = l / 1000;
                        txtTimer.setText(remain+"초");
                    }

- 타이머가 종료되면 알람소리와 애니메이션 효과를 추가.
  
  : 사용한 오픈소스 라이브러리  깃허브 주소
  -> <b> https://github.com/daimajia/AndroidViewAnimations </b>

  안내되어있는 순서대로<b> build.gradle(:app) </b> 에 라이브러리 세팅 후, 효과를 실행시키는 YoYo 함수코드를 복붙해와서 원하는 효과를 추가하기

- 알람소리 파일은 <b> res -> raw -> alarm.wav </b> 로 넣어둠
