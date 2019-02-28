package kr.co.teada.ex36admobtest_advertise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class RewardedActivity extends AppCompatActivity {

    RewardedVideoAd rewardedVideoAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewarded);

        //1. 리워디드 광고 객체 생성_싱글톤(객체가 여러개 생기는 것 방지)
        rewardedVideoAd=MobileAds.getRewardedVideoAdInstance(this);

        //4. 광고 리스너 설정
        rewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            @Override
            public void onRewardedVideoAdLoaded() {
                //로딩이 완료되면 실행
                rewardedVideoAd.show();
            }

            @Override
            public void onRewardedVideoAdOpened() {

            }

            @Override
            public void onRewardedVideoStarted() {

            }

            @Override
            public void onRewardedVideoAdClosed() {

            }

            @Override
            public void onRewarded(RewardItem rewardItem) {
                //일정 시간의 동영상 시청을 완료하여 보상받을 조건에 충족할 때 자동실행 메소드
                //매개변수(파라미터)가 보상내역을 가지고 있어
                String type=rewardItem.getType();
                int cnt=rewardItem.getAmount();

                Toast.makeText(RewardedActivity.this, type+":"+cnt, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onRewardedVideoAdLeftApplication() {

            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int i) {
                Toast.makeText(RewardedActivity.this, "failed", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onRewardedVideoCompleted() {

            }
        });

        //2. 광고요청하면서 광고다위 ID 지정
        rewardedVideoAd.loadAd("ca-app-pub-1309515283107607/8383198388", new AdRequest.Builder().build());  //광고단위 ID 복붙

        //3.보여줘(바로 show하면 안돼)-->4번으로~
    }

    public void clickBtn(View view) {
        //5. 광고요청하면서 광고다위 ID 지정
        rewardedVideoAd.loadAd("ca-app-pub-1309515283107607/8383198388", new AdRequest.Builder().build());

    }
}
