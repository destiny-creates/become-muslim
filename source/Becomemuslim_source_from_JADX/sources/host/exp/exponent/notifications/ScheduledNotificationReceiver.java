package host.exp.exponent.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import host.exp.exponent.C6369g;
import host.exp.exponent.notifications.C6405i.C6403a;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p336c.C6294a;
import java.util.HashMap;
import javax.inject.C6562a;

public class ScheduledNotificationReceiver extends BroadcastReceiver {
    @C6562a
    /* renamed from: a */
    C6369g f20699a;

    /* renamed from: host.exp.exponent.notifications.ScheduledNotificationReceiver$1 */
    class C75851 implements C6403a {
        /* renamed from: a */
        final /* synthetic */ ScheduledNotificationReceiver f26245a;

        public void onSuccess(int i) {
        }

        C75851(ScheduledNotificationReceiver scheduledNotificationReceiver) {
            this.f26245a = scheduledNotificationReceiver;
        }

        public void onFailure(Exception exception) {
            C6289b.m25950a(ScheduledNotificationReceiver.class.getName(), (Throwable) exception);
        }
    }

    public ScheduledNotificationReceiver() {
        C6294a.m25957a().m25961b(ScheduledNotificationReceiver.class, this);
    }

    public void onReceive(Context context, Intent intent) {
        intent = intent.getExtras();
        C6405i.m26288a(context, intent.getInt("notification_id", 0), (HashMap) intent.getSerializable("notification_object"), this.f20699a, new C75851(this));
    }
}
