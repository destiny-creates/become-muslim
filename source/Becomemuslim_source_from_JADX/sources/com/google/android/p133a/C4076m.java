package com.google.android.p133a;

import android.content.Context;
import android.support.v4.view.C0517s;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.p133a.C2208j.C2206a;
import com.google.android.p133a.C2208j.C2207b;

/* compiled from: SurfaceViewPreview */
/* renamed from: com.google.android.a.m */
class C4076m extends C2205i {
    /* renamed from: a */
    final SurfaceView f10219a;

    /* compiled from: SurfaceViewPreview */
    /* renamed from: com.google.android.a.m$1 */
    class C22121 implements Callback {
        /* renamed from: a */
        final /* synthetic */ C4076m f5261a;

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        C22121(C4076m c4076m) {
            this.f5261a = c4076m;
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            this.f5261a.m6086b(i2, i3);
            if (C0517s.m1729w(this.f5261a.f10219a) == null) {
                this.f5261a.m6089e();
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f5261a.m6086b(0, 0);
        }
    }

    /* renamed from: a */
    void mo2101a(int i) {
    }

    C4076m(Context context, ViewGroup viewGroup) {
        this.f10219a = (SurfaceView) View.inflate(context, C2207b.surface_view, viewGroup).findViewById(C2206a.surface_view);
        context = this.f10219a.getHolder();
        context.setType(3);
        context.addCallback(new C22121(this));
    }

    /* renamed from: a */
    Surface mo2100a() {
        return mo2105g().getSurface();
    }

    /* renamed from: g */
    SurfaceHolder mo2105g() {
        return this.f10219a.getHolder();
    }

    /* renamed from: b */
    View mo2102b() {
        return this.f10219a;
    }

    /* renamed from: c */
    Class mo2103c() {
        return SurfaceHolder.class;
    }

    /* renamed from: d */
    boolean mo2104d() {
        return (m6093i() == 0 || m6094j() == 0) ? false : true;
    }
}
