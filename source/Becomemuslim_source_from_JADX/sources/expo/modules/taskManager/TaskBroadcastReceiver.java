package expo.modules.taskManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TaskBroadcastReceiver extends BroadcastReceiver {
    public static String INTENT_ACTION = "expo.modules.taskManager.TaskBroadcastReceiver";

    public void onReceive(Context context, Intent intent) {
        new TaskService(context.getApplicationContext()).handleIntent(intent);
    }
}
