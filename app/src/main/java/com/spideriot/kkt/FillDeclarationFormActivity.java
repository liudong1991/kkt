package com.spideriot.kkt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class FillDeclarationFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fill_declaration_form_layout);
        findViewById(R.id.back_btn).setOnClickListener(clickListener);
        ((TextView) findViewById(R.id.title)).setText("填写报单");
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.back_btn:
                    finish();
                    break;
            }
        }
    };
}
