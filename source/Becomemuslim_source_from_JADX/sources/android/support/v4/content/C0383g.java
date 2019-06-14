package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

@Deprecated
/* compiled from: WakefulBroadcastReceiver */
/* renamed from: android.support.v4.content.g */
public abstract class C0383g extends BroadcastReceiver {
    /* renamed from: a */
    private static final SparseArray<WakeLock> f1008a = new SparseArray();
    /* renamed from: b */
    private static int f1009b = 1;

    public static ComponentName a_(Context context, Intent intent) {
        synchronized (f1008a) {
            int i = f1009b;
            f1009b++;
            if (f1009b <= 0) {
                f1009b = 1;
            }
            intent.putExtra("android.support.content.wakelockid", i);
            intent = context.startService(intent);
            if (intent == null) {
                return null;
            }
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("wake:");
            stringBuilder.append(intent.flattenToShortString());
            context = powerManager.newWakeLock(1, stringBuilder.toString());
            context.setReferenceCounted(false);
            context.acquire(60000);
            f1008a.put(i, context);
            return intent;
        }
    }

    /* renamed from: a */
    public static boolean m1161a(Intent intent) {
        intent = intent.getIntExtra("android.support.content.wakelockid", 0);
        if (intent == null) {
            return false;
        }
        synchronized (f1008a) {
            WakeLock wakeLock = (WakeLock) f1008a.get(intent);
            if (wakeLock != null) {
                wakeLock.release();
                f1008a.remove(intent);
                return true;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No active wake lock id #");
            stringBuilder.append(intent);
            Log.w("WakefulBroadcastReceiv.", stringBuilder.toString());
            return true;
        }
    }
}
