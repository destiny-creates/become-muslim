package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

final class hv implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ Bitmap f15535a;
    /* renamed from: b */
    private final /* synthetic */ hs f15536b;

    hv(hs hsVar, Bitmap bitmap) {
        this.f15536b = hsVar;
        this.f15535a = bitmap;
    }

    public final void run() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f15535a.compress(CompressFormat.PNG, 0, byteArrayOutputStream);
        synchronized (this.f15536b.f24100l) {
            this.f15536b.f24091c.f28048g = new afz();
            this.f15536b.f24091c.f28048g.f28083c = byteArrayOutputStream.toByteArray();
            this.f15536b.f24091c.f28048g.f28082b = "image/png";
            this.f15536b.f24091c.f28048g.f28081a = Integer.valueOf(1);
        }
    }
}
