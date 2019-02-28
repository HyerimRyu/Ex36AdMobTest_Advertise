package kr.co.teada.ex36admobtest_advertise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class InterstitialActivity extends AppCompatActivity {

    InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);

        //1. 전면광고 객체 생성
        interstitialAd=new InterstitialAd(this);
        //2. 광고단위 ID부여
        interstitialAd.setAdUnitId("ca-app-pub-1309515283107607/4548675409");

        //3. 광고요청
        AdRequest adRequest=new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);

        //4. 광고가 load되는 것에 대한 리스너 객체 추가    --------------------------------------------------tip!
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                //6. 로드가 완료된 후 보여주도록!
                interstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                //7. 실패시 알 수 있게 토스트
                Toast.makeText(InterstitialActivity.this, "fail", Toast.LENGTH_SHORT).show();
            }
        });

        //5. 광고 보여줘-바로 안 보여져




    }

    public void clickBtn(View view) {
        //8. 광고 다시 보이도록 요청
        AdRequest adRequest=new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);
    }
}
