package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.C3178i;
import android.support.v4.app.C4890j;
import android.support.v4.util.C3211a;
import com.google.android.gms.internal.p206e.C4962e;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class da extends C3178i implements C2801g {
    /* renamed from: a */
    private static WeakHashMap<C4890j, WeakReference<da>> f13199a = new WeakHashMap();
    /* renamed from: b */
    private Map<String, LifecycleCallback> f13200b = new C3211a();
    /* renamed from: c */
    private int f13201c = 0;
    /* renamed from: d */
    private Bundle f13202d;

    /* renamed from: a */
    public static da m16803a(C4890j c4890j) {
        da daVar;
        WeakReference weakReference = (WeakReference) f13199a.get(c4890j);
        if (weakReference != null) {
            daVar = (da) weakReference.get();
            if (daVar != null) {
                return daVar;
            }
        }
        try {
            daVar = (da) c4890j.getSupportFragmentManager().mo200a("SupportLifecycleFragmentImpl");
            if (daVar == null || daVar.isRemoving()) {
                daVar = new da();
                c4890j.getSupportFragmentManager().mo201a().mo185a((C3178i) daVar, "SupportLifecycleFragmentImpl").mo191d();
            }
            f13199a.put(c4890j, new WeakReference(daVar));
            return daVar;
        } catch (C4890j c4890j2) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", c4890j2);
        }
    }

    /* renamed from: a */
    public final <T extends LifecycleCallback> T mo2449a(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.f13200b.get(str));
    }

    /* renamed from: a */
    public final void mo2450a(String str, LifecycleCallback lifecycleCallback) {
        if (this.f13200b.containsKey(str)) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 59);
            stringBuilder.append("LifecycleCallback with tag ");
            stringBuilder.append(str);
            stringBuilder.append(" already added to this fragment.");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.f13200b.put(str, lifecycleCallback);
        if (this.f13201c > 0) {
            new C4962e(Looper.getMainLooper()).post(new db(this, lifecycleCallback, str));
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f13201c = 1;
        this.f13202d = bundle;
        for (Entry entry : this.f13200b.entrySet()) {
            ((LifecycleCallback) entry.getValue()).mo2432a(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void onStart() {
        super.onStart();
        this.f13201c = 2;
        for (LifecycleCallback b : this.f13200b.values()) {
            b.mo2433b();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f13201c = 3;
        for (LifecycleCallback c : this.f13200b.values()) {
            c.mo3289c();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback a : this.f13200b.values()) {
            a.mo2431a(i, i2, intent);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.f13200b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).mo2434b(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void onStop() {
        super.onStop();
        this.f13201c = 4;
        for (LifecycleCallback d : this.f13200b.values()) {
            d.mo2435d();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f13201c = 5;
        for (LifecycleCallback e : this.f13200b.values()) {
            e.m7979e();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a : this.f13200b.values()) {
            a.mo3286a(str, fileDescriptor, printWriter, strArr);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Activity mo2448a() {
        return getActivity();
    }
}
