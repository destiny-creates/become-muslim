package io.p347a.p348a.p349a.p350a.p357f;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import io.p347a.p348a.p349a.C6520i;

/* compiled from: PreferenceStoreImpl */
/* renamed from: io.a.a.a.a.f.d */
public class C7619d implements C6490c {
    /* renamed from: a */
    private final SharedPreferences f26332a;
    /* renamed from: b */
    private final String f26333b;
    /* renamed from: c */
    private final Context f26334c;

    public C7619d(Context context, String str) {
        if (context != null) {
            this.f26334c = context;
            this.f26333b = str;
            this.f26332a = this.f26334c.getSharedPreferences(this.f26333b, 0);
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    @Deprecated
    public C7619d(C6520i c6520i) {
        this(c6520i.m26655E(), c6520i.getClass().getName());
    }

    /* renamed from: a */
    public SharedPreferences mo5462a() {
        return this.f26332a;
    }

    /* renamed from: b */
    public Editor mo5464b() {
        return this.f26332a.edit();
    }

    @TargetApi(9)
    /* renamed from: a */
    public boolean mo5463a(Editor editor) {
        if (VERSION.SDK_INT < 9) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }
}
