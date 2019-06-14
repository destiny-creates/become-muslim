package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import com.amplitude.api.Constants;
import com.google.android.gms.common.internal.C2859l.C2858a;
import com.google.android.gms.common.stats.C2882a;
import com.google.android.gms.internal.p206e.C4962e;
import java.util.HashMap;

final class at extends C2859l implements Callback {
    /* renamed from: a */
    private final HashMap<C2858a, au> f11583a = new HashMap();
    /* renamed from: b */
    private final Context f11584b;
    /* renamed from: c */
    private final Handler f11585c;
    /* renamed from: d */
    private final C2882a f11586d;
    /* renamed from: e */
    private final long f11587e;
    /* renamed from: f */
    private final long f11588f;

    at(Context context) {
        this.f11584b = context.getApplicationContext();
        this.f11585c = new C4962e(context.getMainLooper(), this);
        this.f11586d = C2882a.m8407a();
        this.f11587e = 5000;
        this.f11588f = Constants.MIN_TIME_BETWEEN_SESSIONS_MILLIS;
    }

    /* renamed from: a */
    protected final boolean mo2467a(C2858a c2858a, ServiceConnection serviceConnection, String str) {
        C2872v.m8381a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f11583a) {
            au auVar = (au) this.f11583a.get(c2858a);
            if (auVar == null) {
                auVar = new au(this, c2858a);
                auVar.m8217a(serviceConnection, str);
                auVar.m8218a(str);
                this.f11583a.put(c2858a, auVar);
            } else {
                this.f11585c.removeMessages(0, c2858a);
                if (!auVar.m8220a(serviceConnection)) {
                    auVar.m8217a(serviceConnection, str);
                    switch (auVar.m8221b()) {
                        case 1:
                            serviceConnection.onServiceConnected(auVar.m8226e(), auVar.m8225d());
                            break;
                        case 2:
                            auVar.m8218a(str);
                            break;
                        default:
                            break;
                    }
                }
                c2858a = String.valueOf(c2858a);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(c2858a).length() + 81);
                stringBuilder.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                stringBuilder.append(c2858a);
                throw new IllegalStateException(stringBuilder.toString());
            }
            c2858a = auVar.m8219a();
        }
        return c2858a;
    }

    /* renamed from: b */
    protected final void mo2468b(C2858a c2858a, ServiceConnection serviceConnection, String str) {
        C2872v.m8381a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f11583a) {
            au auVar = (au) this.f11583a.get(c2858a);
            StringBuilder stringBuilder;
            if (auVar == null) {
                c2858a = String.valueOf(c2858a);
                stringBuilder = new StringBuilder(String.valueOf(c2858a).length() + 50);
                stringBuilder.append("Nonexistent connection status for service config: ");
                stringBuilder.append(c2858a);
                throw new IllegalStateException(stringBuilder.toString());
            } else if (auVar.m8220a(serviceConnection)) {
                auVar.m8222b(serviceConnection, str);
                if (auVar.m8224c() != null) {
                    this.f11585c.sendMessageDelayed(this.f11585c.obtainMessage(null, c2858a), this.f11587e);
                }
            } else {
                c2858a = String.valueOf(c2858a);
                stringBuilder = new StringBuilder(String.valueOf(c2858a).length() + 76);
                stringBuilder.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                stringBuilder.append(c2858a);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    public final boolean handleMessage(Message message) {
        C2858a c2858a;
        au auVar;
        switch (message.what) {
            case 0:
                synchronized (this.f11583a) {
                    c2858a = (C2858a) message.obj;
                    auVar = (au) this.f11583a.get(c2858a);
                    if (auVar != null && auVar.m8224c()) {
                        if (auVar.m8219a()) {
                            auVar.m8223b("GmsClientSupervisor");
                        }
                        this.f11583a.remove(c2858a);
                    }
                }
                return true;
            case 1:
                synchronized (this.f11583a) {
                    c2858a = (C2858a) message.obj;
                    auVar = (au) this.f11583a.get(c2858a);
                    if (auVar != null && auVar.m8221b() == 3) {
                        String valueOf = String.valueOf(c2858a);
                        StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 47);
                        stringBuilder.append("Timeout waiting for ServiceConnection callback ");
                        stringBuilder.append(valueOf);
                        Log.wtf("GmsClientSupervisor", stringBuilder.toString(), new Exception());
                        ComponentName e = auVar.m8226e();
                        if (e == null) {
                            e = c2858a.m8354b();
                        }
                        if (e == null) {
                            e = new ComponentName(c2858a.m8353a(), "unknown");
                        }
                        auVar.onServiceDisconnected(e);
                    }
                }
                return true;
            default:
                return null;
        }
    }
}
