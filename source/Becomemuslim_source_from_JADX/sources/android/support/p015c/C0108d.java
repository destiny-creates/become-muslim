package android.support.p015c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.p015c.C0111g.C3114a;

/* compiled from: CustomTabsServiceConnection */
/* renamed from: android.support.c.d */
public abstract class C0108d implements ServiceConnection {
    /* renamed from: a */
    public abstract void m217a(ComponentName componentName, C0104b c0104b);

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        m217a(componentName, new C0104b(this, C3114a.m9154a(iBinder), componentName) {
            /* renamed from: a */
            final /* synthetic */ C0108d f7939a;
        });
    }
}
