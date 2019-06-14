package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentHostCallback */
/* renamed from: android.support.v4.app.m */
public abstract class C3179m<E> extends C0305k {
    /* renamed from: a */
    private final Activity f8171a;
    /* renamed from: b */
    final Context f8172b;
    /* renamed from: c */
    final int f8173c;
    /* renamed from: d */
    final C3184o f8174d;
    /* renamed from: e */
    private final Handler f8175e;

    /* renamed from: a */
    public View mo195a(int i) {
        return null;
    }

    /* renamed from: a */
    public void mo2671a(C3178i c3178i, String[] strArr, int i) {
    }

    /* renamed from: a */
    public void mo2672a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* renamed from: a */
    public boolean mo196a() {
        return true;
    }

    /* renamed from: a */
    public boolean mo2673a(C3178i c3178i) {
        return true;
    }

    /* renamed from: a */
    public boolean mo2674a(String str) {
        return false;
    }

    /* renamed from: b */
    void mo2676b(C3178i c3178i) {
    }

    /* renamed from: d */
    public void mo2677d() {
    }

    /* renamed from: e */
    public boolean mo2678e() {
        return true;
    }

    /* renamed from: g */
    public abstract E mo2680g();

    C3179m(C4890j c4890j) {
        this(c4890j, c4890j, c4890j.mHandler, 0);
    }

    C3179m(Activity activity, Context context, Handler handler, int i) {
        this.f8174d = new C3184o();
        this.f8171a = activity;
        this.f8172b = context;
        this.f8175e = handler;
        this.f8173c = i;
    }

    /* renamed from: b */
    public LayoutInflater mo2675b() {
        return LayoutInflater.from(this.f8172b);
    }

    /* renamed from: a */
    public void mo2669a(C3178i c3178i, Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            this.f8172b.startActivity(intent);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    /* renamed from: a */
    public void mo2670a(C3178i c3178i, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (i == -1) {
            C3169a.m9427a(this.f8171a, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            C3179m c3179m = this;
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
    }

    /* renamed from: f */
    public int mo2679f() {
        return this.f8173c;
    }

    /* renamed from: h */
    Activity m9497h() {
        return this.f8171a;
    }

    /* renamed from: i */
    Context m9498i() {
        return this.f8172b;
    }

    /* renamed from: j */
    Handler m9499j() {
        return this.f8175e;
    }

    /* renamed from: k */
    C3184o m9500k() {
        return this.f8174d;
    }
}
