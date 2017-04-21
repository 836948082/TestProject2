package com.runtai.testproject2.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.runtai.testproject2.activity.JumpActivity;
import com.runtai.testproject2.activity.SweetAlertDialogActivity;

/**
 * @作者：高炎鹏
 * @日期：2017/3/16时间15:10
 * @描述：
 */

public class TestReceive extends BroadcastReceiver {

    private static final String Taction = "com.runtai.testproject2";
    private static final String Taction0 = "com.runtai.testproject20";

    public TestReceive() {
        Log.e("TestReceive", "构造器");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(Taction)) {
            Toast.makeText(context, "Taction", Toast.LENGTH_SHORT).show();

            intent = new Intent(context, JumpActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } else if (action.equals(Taction0)) {
            Toast.makeText(context, "Taction0", Toast.LENGTH_SHORT).show();

            intent = new Intent(context, SweetAlertDialogActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

}
