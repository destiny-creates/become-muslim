package com.p079e.p080a;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Downloader */
/* renamed from: com.e.a.j */
public interface C1222j {

    /* compiled from: Downloader */
    /* renamed from: com.e.a.j$a */
    public static class C1220a {
        /* renamed from: a */
        final InputStream f3444a;
        /* renamed from: b */
        final Bitmap f3445b;
        /* renamed from: c */
        final boolean f3446c;
        /* renamed from: d */
        final long f3447d;

        public C1220a(InputStream inputStream, boolean z, long j) {
            if (inputStream != null) {
                this.f3444a = inputStream;
                this.f3445b = null;
                this.f3446c = z;
                this.f3447d = j;
                return;
            }
            throw new IllegalArgumentException("Stream may not be null.");
        }

        /* renamed from: a */
        public InputStream m4287a() {
            return this.f3444a;
        }

        @Deprecated
        /* renamed from: b */
        public Bitmap m4288b() {
            return this.f3445b;
        }

        /* renamed from: c */
        public long m4289c() {
            return this.f3447d;
        }
    }

    /* compiled from: Downloader */
    /* renamed from: com.e.a.j$b */
    public static class C1221b extends IOException {
        /* renamed from: a */
        final boolean f3448a;
        /* renamed from: b */
        final int f3449b;

        public C1221b(String str, int i, int i2) {
            super(str);
            this.f3448a = C1226q.m4299c(i);
            this.f3449b = i2;
        }
    }

    /* renamed from: a */
    C1220a mo819a(Uri uri, int i);
}
