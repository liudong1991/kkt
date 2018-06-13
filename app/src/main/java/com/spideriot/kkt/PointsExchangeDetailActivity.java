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

public class PointsExchangeDetailActivity extends AppCompatActivity {

    private ImageView stepImg;
    private ImageView detail_list_img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.points_exchange_detail_layout);
        ((TextView) findViewById(R.id.title)).setText("详情");
        findViewById(R.id.back_btn).setOnClickListener(clickListener);
        findViewById(R.id.fill_declaration_btn).setOnClickListener(clickListener);
        detail_list_img = findViewById(R.id.detail_list_image);
        stepImg = findViewById(R.id.exchange_step_detail);
        handleView();
    }

    private void handleView() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.detail_list_image, options);
        int imgWidth = options.outWidth;
        int imgHeight = options.outHeight;
        int rImgHeight = (int) (Constants.SCREEN_WIDTH * 1.0 / imgWidth * imgHeight);
        ViewGroup.LayoutParams lp = detail_list_img.getLayoutParams();
        lp.width = Constants.SCREEN_WIDTH;
        lp.height = rImgHeight;
        detail_list_img.setLayoutParams(lp);

        options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.detail_image_1, options);
        imgWidth = options.outWidth;
        imgHeight = options.outHeight;
        rImgHeight = (int) (Constants.SCREEN_WIDTH * 1.0 / imgWidth * imgHeight);
        lp = stepImg.getLayoutParams();
        lp.width = Constants.SCREEN_WIDTH;
        lp.height = rImgHeight;
        stepImg.setLayoutParams(lp);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.back_btn:
                    finish();
                    break;
                case R.id.fill_declaration_btn:
                    Intent intent = new Intent(PointsExchangeDetailActivity.this, FillDeclarationFormActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
