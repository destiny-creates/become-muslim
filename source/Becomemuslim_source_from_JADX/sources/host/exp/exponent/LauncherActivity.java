package host.exp.exponent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C7560j;
import javax.inject.C6562a;

public class LauncherActivity extends Activity {
    @C6562a
    /* renamed from: a */
    C7560j f20438a;

    /* renamed from: host.exp.exponent.LauncherActivity$1 */
    class C62861 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ LauncherActivity f20437a;

        C62861(LauncherActivity launcherActivity) {
            this.f20437a = launcherActivity;
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = android.app.ActivityManager.RecentTaskInfo.class;	 Catch:{ Exception -> 0x003c }
            r1 = "numActivities";	 Catch:{ Exception -> 0x003c }
            r0.getDeclaredField(r1);	 Catch:{ Exception -> 0x003c }
            r0 = r4.f20437a;	 Catch:{ Exception -> 0x003c }
            r0 = r0.f20438a;	 Catch:{ Exception -> 0x003c }
            r0 = r0.m34258f();	 Catch:{ Exception -> 0x003c }
            r0 = r0.iterator();	 Catch:{ Exception -> 0x003c }
        L_0x0013:
            r1 = r0.hasNext();	 Catch:{ Exception -> 0x003c }
            if (r1 == 0) goto L_0x003c;	 Catch:{ Exception -> 0x003c }
        L_0x0019:
            r1 = r0.next();	 Catch:{ Exception -> 0x003c }
            r1 = (android.app.ActivityManager.AppTask) r1;	 Catch:{ Exception -> 0x003c }
            r2 = r1.getTaskInfo();	 Catch:{ Exception -> 0x003c }
            r2 = r2.id;	 Catch:{ Exception -> 0x003c }
            r3 = r4.f20437a;	 Catch:{ Exception -> 0x003c }
            r3 = r3.getTaskId();	 Catch:{ Exception -> 0x003c }
            if (r2 != r3) goto L_0x0013;	 Catch:{ Exception -> 0x003c }
        L_0x002d:
            r0 = r1.getTaskInfo();	 Catch:{ Exception -> 0x003c }
            r0 = r0.numActivities;	 Catch:{ Exception -> 0x003c }
            r1 = 1;	 Catch:{ Exception -> 0x003c }
            if (r0 != r1) goto L_0x003c;	 Catch:{ Exception -> 0x003c }
        L_0x0036:
            r0 = r4.f20437a;	 Catch:{ Exception -> 0x003c }
            r0.finishAndRemoveTask();	 Catch:{ Exception -> 0x003c }
            return;
        L_0x003c:
            r0 = r4.f20437a;
            r0.finish();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.LauncherActivity.1.run():void");
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C6294a.m25957a().m25961b(LauncherActivity.class, this);
        this.f20438a.m34239a((Activity) this);
        this.f20438a.m34240a((Activity) this, getIntent());
        startService(ExponentIntentService.m25927a(getApplicationContext()));
        new Handler(getMainLooper()).postDelayed(new C62861(this), 100);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f20438a.m34240a((Activity) this, intent);
    }
}
