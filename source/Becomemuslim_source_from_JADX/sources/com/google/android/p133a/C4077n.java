package com.google.android.p133a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.imagepipeline.common.RotationOptions;
import com.google.android.p133a.C2208j.C2206a;
import com.google.android.p133a.C2208j.C2207b;

@TargetApi(14)
/* compiled from: TextureViewPreview */
/* renamed from: com.google.android.a.n */
class C4077n extends C2205i {
    /* renamed from: a */
    private final TextureView f10220a;
    /* renamed from: b */
    private int f10221b;

    /* compiled from: TextureViewPreview */
    /* renamed from: com.google.android.a.n$1 */
    class C22131 implements SurfaceTextureListener {
        /* renamed from: a */
        final /* synthetic */ C4077n f5262a;

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        C22131(C4077n c4077n) {
            this.f5262a = c4077n;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f5262a.m6086b(i, i2);
            this.f5262a.m12645l();
            this.f5262a.m6089e();
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f5262a.m6086b(i, i2);
            this.f5262a.m12645l();
            this.f5262a.m6089e();
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f5262a.m6086b(0, 0);
            this.f5262a.m6090f();
            return true;
        }
    }

    /* renamed from: h */
    /* synthetic */ Object mo2107h() {
        return m12644k();
    }

    C4077n(Context context, ViewGroup viewGroup) {
        this.f10220a = (TextureView) View.inflate(context, C2207b.texture_view, viewGroup).findViewById(C2206a.texture_view);
        this.f10220a.setSurfaceTextureListener(new C22131(this));
    }

    @TargetApi(15)
    /* renamed from: a */
    void mo2106a(int i, int i2) {
        this.f10220a.getSurfaceTexture().setDefaultBufferSize(i, i2);
    }

    /* renamed from: a */
    Surface mo2100a() {
        return new Surface(this.f10220a.getSurfaceTexture());
    }

    /* renamed from: k */
    SurfaceTexture m12644k() {
        return this.f10220a.getSurfaceTexture();
    }

    /* renamed from: b */
    View mo2102b() {
        return this.f10220a;
    }

    /* renamed from: c */
    Class mo2103c() {
        return SurfaceTexture.class;
    }

    /* renamed from: a */
    void mo2101a(int i) {
        this.f10221b = i;
        m12645l();
    }

    /* renamed from: d */
    boolean mo2104d() {
        return this.f10220a.getSurfaceTexture() != null;
    }

    /* renamed from: l */
    void m12645l() {
        Matrix matrix = new Matrix();
        if (this.f10221b % RotationOptions.ROTATE_180 == 90) {
            int i = m6093i();
            int j = m6094j();
            r6 = new float[8];
            float f = (float) i;
            r6[2] = f;
            r6[3] = 0.0f;
            r6[4] = 0.0f;
            float f2 = (float) j;
            r6[5] = f2;
            r6[6] = f;
            r6[7] = f2;
            matrix.setPolyToPoly(r6, 0, r0.f10221b == 90 ? new float[]{0.0f, f2, 0.0f, 0.0f, f, f2, f, 0.0f} : new float[]{f, 0.0f, f, f2, 0.0f, 0.0f, 0.0f, f2}, 0, 4);
        } else if (r0.f10221b == RotationOptions.ROTATE_180) {
            matrix.postRotate(180.0f, (float) (m6093i() / 2), (float) (m6094j() / 2));
        }
        r0.f10220a.setTransform(matrix);
    }
}
