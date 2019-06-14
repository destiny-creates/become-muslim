package com.onesignal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ac.C0280e;
import com.onesignal.am.C5464i;
import java.util.List;
import org.json.JSONObject;

/* compiled from: NotificationExtenderService */
/* renamed from: com.onesignal.s */
public abstract class C6965s extends JobIntentService {
    /* renamed from: j */
    private ac f24840j;
    /* renamed from: k */
    private JSONObject f24841k;
    /* renamed from: l */
    private boolean f24842l;
    /* renamed from: m */
    private Long f24843m;
    /* renamed from: n */
    private C5531a f24844n;

    /* compiled from: NotificationExtenderService */
    /* renamed from: com.onesignal.s$a */
    public static class C5531a {
        /* renamed from: a */
        public C0280e f18569a;
        /* renamed from: b */
        public Integer f18570b;
    }

    /* renamed from: a */
    protected abstract boolean m32694a(af afVar);

    /* renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo4931a() {
        return super.mo4931a();
    }

    public /* bridge */ /* synthetic */ IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    public /* bridge */ /* synthetic */ void onCreate() {
        super.onCreate();
    }

    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    public /* bridge */ /* synthetic */ int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    /* renamed from: a */
    protected final void mo4930a(Intent intent) {
        if (intent != null) {
            m32689b(intent);
            GcmBroadcastReceiver.a(intent);
        }
    }

    /* renamed from: b */
    private void m32689b(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            C5464i c5464i = C5464i.ERROR;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No extras sent to NotificationExtenderService in its Intent!\n");
            stringBuilder.append(intent);
            am.m23187b(c5464i, stringBuilder.toString());
            return;
        }
        intent = extras.getString("json_payload");
        if (intent == null) {
            C5464i c5464i2 = C5464i.ERROR;
            stringBuilder = new StringBuilder();
            stringBuilder.append("json_payload key is nonexistent from bundle passed to NotificationExtenderService: ");
            stringBuilder.append(extras);
            am.m23187b(c5464i2, stringBuilder.toString());
            return;
        }
        try {
            this.f24841k = new JSONObject(intent);
            this.f24842l = extras.getBoolean("restoring", false);
            if (extras.containsKey("android_notif_id") != null) {
                this.f24844n = new C5531a();
                this.f24844n.f18570b = Integer.valueOf(extras.getInt("android_notif_id"));
            }
            if (this.f24842l != null || am.m23177a((Context) this, this.f24841k) == null) {
                this.f24843m = Long.valueOf(extras.getLong("timestamp"));
                m32692a(this.f24841k, this.f24842l);
            }
        } catch (Intent intent2) {
            intent2.printStackTrace();
        }
    }

    /* renamed from: a */
    void m32692a(JSONObject jSONObject, boolean z) {
        boolean a;
        af afVar = new af();
        afVar.f18308c = C5529q.m23530a(jSONObject);
        afVar.f18306a = z;
        afVar.f18307b = am.m23257u();
        this.f24840j = null;
        try {
            a = m32694a(afVar);
        } catch (Throwable th) {
            if (this.f24840j == null) {
                am.m23161a(C5464i.ERROR, "onNotificationProcessing throw an exception. Displaying normal OneSignal notification.", th);
            } else {
                am.m23161a(C5464i.ERROR, "onNotificationProcessing throw an exception. Extended notification displayed but custom processing did not finish.", th);
            }
            a = false;
        }
        if (this.f24840j == null) {
            Object obj = (a || !C5529q.m23541a(jSONObject.optString("alert"))) ? null : 1;
            if (obj != null) {
                C5529q.m23529a(m32690e());
            } else if (!z) {
                C5538t c5538t = new C5538t(this);
                c5538t.f18577b = jSONObject;
                c5538t.f18587l = new C5531a();
                c5538t.f18587l.f18570b = Integer.valueOf(-1);
                C5529q.m23538a(c5538t, true);
                am.m23171a(C5529q.m23542b(jSONObject), false, false);
            } else if (this.f24844n != null) {
                C5529q.m23543b(m32690e());
            }
            if (z) {
                al.m23089a(100);
            }
        }
    }

    /* renamed from: a */
    static Intent m32688a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent().setAction("com.onesignal.NotificationExtender").setPackage(context.getPackageName());
        List queryIntentServices = packageManager.queryIntentServices(intent, 128);
        if (queryIntentServices.size() < 1) {
            return null;
        }
        intent.setComponent(new ComponentName(context, ((ResolveInfo) queryIntentServices.get(0)).serviceInfo.name));
        return intent;
    }

    /* renamed from: e */
    private C5538t m32690e() {
        C5538t c5538t = new C5538t(this);
        c5538t.f18578c = this.f24842l;
        c5538t.f18577b = this.f24841k;
        c5538t.f18580e = this.f24843m;
        c5538t.f18587l = this.f24844n;
        return c5538t;
    }
}
