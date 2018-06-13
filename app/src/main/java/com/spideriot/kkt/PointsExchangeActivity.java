package com.spideriot.kkt;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.spideriot.kkt.common.Constants;
import com.spideriot.kkt.utils.DensityUtil;

public class PointsExchangeActivity extends AppCompatActivity {

    private ImageView adImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.point_exchange_layout);

        adImg = findViewById(R.id.icbc_ad_btn);

        findViewById(R.id.back_btn).setOnClickListener(clickListener);
        findViewById(R.id.icbc_ad_btn).setOnClickListener(clickListener);

        handleView();

    }

    private void handleView() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.point_exchange_ad_icbc, options);
        int imgWidth = options.outWidth;
        int imgHeight = options.outHeight;
        int rImgHeight = (int) ((Constants.SCREEN_WIDTH- DensityUtil.dp2px(20)) * 1.0 / imgWidth * imgHeight);
        ViewGroup.LayoutParams lp = adImg.getLayoutParams();
        lp.width = Constants.SCREEN_WIDTH;
        lp.height = rImgHeight;
        adImg.setLayoutParams(lp);
    }


    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.back_btn:
                    finish();
                    break;
                case R.id.icbc_ad_btn:
                    Intent intent = new Intent(PointsExchangeActivity.this, PointsExchangeDetailActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
