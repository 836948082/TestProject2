package com.runtai.testproject2.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.runtai.testproject2.R;
import com.runtai.testproject2.cehua.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @作者：高炎鹏
 * @日期：2017/1/10时间15:17
 * @描述：
 */
public class JumpActivity extends BaseActivity {

    TextView denglu;

    @Override
    protected void beforeSetContent() {

    }

    @Override
    protected int getView() {
        return R.layout.activity_jump;
    }

    @Override
    protected void initView() {
//        ((TextView)findViewById(R.id.text)).setText("修改后");
        denglu = getView(R.id.text);
        denglu.setOnClickListener(this);
        daojishi();
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        skip(new Intent(JumpActivity.this, JumpActivity.class));
    }


    private static String TAG = "TimerDemo";
    private TextView mTextView = null;
    private Button mButton_start = null;
    private Button mButton_pause = null;
    private Timer mTimer = null;
    private TimerTask mTimerTask = null;
    private Handler mHandler = null;
    private static int count = 0;
    private boolean isPause = false;
    private boolean isStop = true;
    private static int delay = 1000;
    private static int period = 1000;
    private static final int UPDATE_NUM = 0;


    private void daojishi() {
        mTextView = (TextView) findViewById(R.id.mytextview);
        mButton_start = (Button) findViewById(R.id.mybutton_start);
        mButton_pause = (Button) findViewById(R.id.mybutton_pause);

        mButton_start.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (isStop) {
                    Log.i(TAG, "Start");
                } else {
                    Log.i(TAG, "Stop");
                }

                isStop = !isStop;

                if (!isStop) {
                    startTimer();
                } else {
                    stopTimer();
                }

                if (isStop) {
                    mButton_start.setText(R.string.start);
                } else {
                    mButton_start.setText(R.string.stop);
                }
            }
        });

        mButton_pause.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (isPause) {
                    Log.i(TAG, "Resume");
                } else {
                    Log.i(TAG, "Pause");
                }

                isPause = !isPause;

                if (isPause) {
                    mButton_pause.setText(R.string.resume);
                } else {
                    mButton_pause.setText(R.string.pause);
                }
            }
        });

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case UPDATE_NUM:
                        updateTextView();
                        break;
                    default:
                        break;
                }
            }
        };
    }

    private void updateTextView() {
        mTextView.setText(String.valueOf(count));
        if (count == 10) {
            Log.i(TAG, "count----10");
            stopTimer();
        }
    }

    /**
     * 开始计时
     */
    private void startTimer() {
        if (mTimer == null) {
            mTimer = new Timer();
        }
        if (mTimerTask == null) {
            mTimerTask = new TimerTask() {
                @Override
                public void run() {
                    Log.i(TAG, "count: " + String.valueOf(count));
                    sendMessage(UPDATE_NUM);
                    do {
                        try {
                            Log.i(TAG, "sleep(1000)...");
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                    } while (isPause);
                    count++;
                }
            };
        }
        if (mTimer != null) {
            mTimer.schedule(mTimerTask, delay, period);
        }
    }

    /**
     * 停止计时
     */
    private void stopTimer() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
        if (mTimerTask != null) {
            mTimerTask.cancel();
            mTimerTask = null;
        }
        count = 0;
        isPause = false;
    }

    public void sendMessage(int id) {
        if (mHandler != null) {
            Message message = Message.obtain(mHandler, id);
            mHandler.sendMessage(message);
        }
    }

}
