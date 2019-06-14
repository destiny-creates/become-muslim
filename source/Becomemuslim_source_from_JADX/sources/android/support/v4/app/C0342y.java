package android.support.v4.app;

import android.app.Service;
import android.content.ComponentName;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: JobIntentService */
/* renamed from: android.support.v4.app.y */
public abstract class C0342y extends Service {
    /* renamed from: e */
    static final Object f928e = new Object();
    /* renamed from: f */
    static final HashMap<ComponentName, Object> f929f = new HashMap();
    /* renamed from: a */
    boolean f930a = false;
    /* renamed from: b */
    boolean f931b = false;
    /* renamed from: c */
    boolean f932c = false;
    /* renamed from: d */
    final ArrayList<Object> f933d;

    public C0342y() {
        if (VERSION.SDK_INT >= 26) {
            this.f933d = null;
        } else {
            this.f933d = new ArrayList();
        }
    }
}
