package com.example.luct.marqueedemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;

import com.example.luct.marqueedemo.view.CustomMarqueeTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_speed)
    AppCompatEditText etSpeed;
    @BindView(R.id.et_text)
    AppCompatEditText etText;
    @BindView(R.id.btn_help)
    AppCompatButton btnHelp;
    @BindView(R.id.btn_setting)
    AppCompatButton btnSetting;
    @BindView(R.id.marquee_text_view)
    CustomMarqueeTextView marqueeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_help)
    public void dohelp(View view) {
        new AlertDialog.Builder(this)
                .setTitle("提示")
                .setMessage("系统跑马灯文本长度必须大于控件宽度才能滚动" +
                        "\r\n自定义的跑马灯文本每次滚动完之后才会发生下一次滚动，首位没有衔接" +
                        "\r\n文本或者滚动速度改变后都要调用init()方法")
                .show();
    }

    @OnClick(R.id.btn_setting)
    public void doSetting() {
        String text = etText.getText().toString();
        if (!TextUtils.isEmpty(text)) {
            marqueeTextView.setText(text);
            marqueeTextView.init(getWindowManager());
        }
        try {
            int speed = Integer.parseInt(etSpeed.getText().toString());
            marqueeTextView.setSpeed(speed);
            marqueeTextView.init(getWindowManager());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在这里初始化确保CustomMarqueeTextView 类中的getW
        marqueeTextView.postDelayed(new Runnable() {
            @Override
            public void run() {
                marqueeTextView.setText("你尽力而为即可，让我来全力以赴");
                marqueeTextView.setTextColor(Color.RED);
                marqueeTextView.init(getWindowManager());//文本或者滚动速度改变后都要调用该方法
                marqueeTextView.startScroll();
                marqueeTextView.setEnabled(false);
            }
        }, 300);
    }
}
