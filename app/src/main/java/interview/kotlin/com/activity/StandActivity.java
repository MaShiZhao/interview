package interview.kotlin.com.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.jetbrains.annotations.Nullable;

import interview.kotlin.com.base.BaseActivity;

/**
 * Copyright (C) 2018, PING AN TECHNOLOGIES CO., LTD.
 * StandActivity
 * <p>
 * Description
 *
 * @author MaShiZhao
 * @version 1.0
 * <p>
 * Ver 1.0, 2019-11-13, MaShiZhao, Create file
 */
public class StandActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contentTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StandActivity.this, SingleActivity.class));
            }
        });
    }
}
