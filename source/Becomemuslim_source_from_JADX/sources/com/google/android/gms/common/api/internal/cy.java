package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.C3211a;
import com.google.android.gms.internal.p206e.C4962e;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class cy extends Fragment implements C2801g {
    /* renamed from: a */
    private static WeakHashMap<Activity, WeakReference<cy>> f11540a = new WeakHashMap();
    /* renamed from: b */
    private Map<String, LifecycleCallback> f11541b = new C3211a();
    /* renamed from: c */
    private int f11542c = 0;
    /* renamed from: d */
    private Bundle f11543d;

    /* renamed from: a */
    public static cy m14293a(Activity activity) {
        cy cyVar;
        WeakReference weakReference = (WeakReference) f11540a.get(activity);
        if (weakReference != null) {
            cyVar = (cy) weakReference.get();
            if (cyVar != null) {
                return cyVar;
            }
        }
        try {
            cyVar = (cy) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (cyVar == null || cyVar.isRemoving()) {
                cyVar = new cy();
                activity.getFragmentManager().beginTransaction().add(cyVar, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            f11540a.put(activity, new WeakReference(cyVar));
            return cyVar;
        } catch (Activity activity2) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", activity2);
        }
    }

    /* renamed from: a */
    public final <T extends LifecycleCallback> T mo2449a(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.f11541b.get(str));
    }

    /* renamed from: a */
    public final void mo2450a(String str, LifecycleCallback lifecycleCallback) {
        if (this.f11541b.containsKey(str)) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 59);
            stringBuilder.append("LifecycleCallback with tag ");
            stringBuilder.append(str);
            stringBuilder.append(" already added to this fragment.");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.f11541b.put(str, lifecycleCallback);
        if (this.f11542c > 0) {
            new C4962e(Looper.getMainLooper()).post(new cz(this, lifecycleCallback, str));
        }
    }

    /* renamed from: a */
    public final Activity mo2448a() {
        return getActivity();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11542c = 1;
        this.f11543d = bundle;
        for (Entry entry : this.f11541b.entrySet()) {
            ((LifecycleCallback) entry.getValue()).mo2432a(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void onStart() {
        super.onStart();
        this.f11542c = 2;
        for (LifecycleCallback b : this.f11541b.values()) {
            b.mo2433b();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f11542c = 3;
        for (LifecycleCallback c : this.f11541b.values()) {
            c.mo3289c();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback a : this.f11541b.values()) {
            a.mo2431a(i, i2, intent);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.f11541b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).mo2434b(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void onStop() {
        super.onStop();
        this.f11542c = 4;
        for (LifecycleCallback d : this.f11541b.values()) {
            d.mo2435d();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f11542c = 5;
        for (LifecycleCallback e : this.f11541b.values()) {
            e.m7979e();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a : this.f11541b.values()) {
            a.mo3286a(str, fileDescriptor, printWriter, strArr);
        }
    }
}
