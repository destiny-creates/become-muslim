package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.C0074c;
import android.arch.lifecycle.C0074c.C0073b;
import android.arch.lifecycle.C0076e;
import android.arch.lifecycle.C0084m;
import android.arch.lifecycle.C3107f;
import android.os.Bundle;
import android.support.v4.util.C0463l;

/* compiled from: SupportActivity */
public class ak extends Activity implements C0076e {
    private C0463l<Class<? extends C0288a>, C0288a> mExtraDataMap = new C0463l();
    private C3107f mLifecycleRegistry = new C3107f(this);

    /* compiled from: SupportActivity */
    /* renamed from: android.support.v4.app.ak$a */
    public static class C0288a {
    }

    public void putExtraData(C0288a c0288a) {
        this.mExtraDataMap.put(c0288a.getClass(), c0288a);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0084m.m195a((Activity) this);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.m9134a(C0073b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    public <T extends C0288a> T getExtraData(Class<T> cls) {
        return (C0288a) this.mExtraDataMap.get(cls);
    }

    public C0074c getLifecycle() {
        return this.mLifecycleRegistry;
    }
}
