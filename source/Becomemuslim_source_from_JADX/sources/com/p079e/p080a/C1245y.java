package com.p079e.p080a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import com.p079e.p080a.C1236t.C1233d;
import java.io.InputStream;

/* compiled from: RequestHandler */
/* renamed from: com.e.a.y */
public abstract class C1245y {

    /* compiled from: RequestHandler */
    /* renamed from: com.e.a.y$a */
    public static final class C1244a {
        /* renamed from: a */
        private final C1233d f3568a;
        /* renamed from: b */
        private final Bitmap f3569b;
        /* renamed from: c */
        private final InputStream f3570c;
        /* renamed from: d */
        private final int f3571d;

        public C1244a(Bitmap bitmap, C1233d c1233d) {
            this((Bitmap) ae.m4212a((Object) bitmap, "bitmap == null"), null, c1233d, 0);
        }

        public C1244a(InputStream inputStream, C1233d c1233d) {
            this(null, (InputStream) ae.m4212a((Object) inputStream, "stream == null"), c1233d, 0);
        }

        C1244a(Bitmap bitmap, InputStream inputStream, C1233d c1233d, int i) {
            int i2 = 0;
            int i3 = bitmap != null ? 1 : 0;
            if (inputStream != null) {
                i2 = 1;
            }
            if ((i2 ^ i3) != 0) {
                this.f3569b = bitmap;
                this.f3570c = inputStream;
                this.f3568a = (C1233d) ae.m4212a((Object) c1233d, "loadedFrom == null");
                this.f3571d = i;
                return;
            }
            throw new AssertionError();
        }

        /* renamed from: a */
        public Bitmap m4341a() {
            return this.f3569b;
        }

        /* renamed from: b */
        public InputStream m4342b() {
            return this.f3570c;
        }

        /* renamed from: c */
        public C1233d m4343c() {
            return this.f3568a;
        }

        /* renamed from: d */
        int m4344d() {
            return this.f3571d;
        }
    }

    /* renamed from: a */
    int mo829a() {
        return 0;
    }

    /* renamed from: a */
    public abstract C1244a mo820a(C1242w c1242w, int i);

    /* renamed from: a */
    public abstract boolean mo821a(C1242w c1242w);

    /* renamed from: a */
    boolean mo830a(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    /* renamed from: b */
    boolean mo831b() {
        return false;
    }

    /* renamed from: c */
    static Options m4348c(C1242w c1242w) {
        boolean d = c1242w.m4332d();
        Object obj = c1242w.f3553q != null ? 1 : null;
        Options options = null;
        if (d || obj != null) {
            options = new Options();
            options.inJustDecodeBounds = d;
            if (obj != null) {
                options.inPreferredConfig = c1242w.f3553q;
            }
        }
        return options;
    }

    /* renamed from: a */
    static boolean m4347a(Options options) {
        return (options == null || options.inJustDecodeBounds == null) ? null : true;
    }

    /* renamed from: a */
    static void m4346a(int i, int i2, Options options, C1242w c1242w) {
        C1245y.m4345a(i, i2, options.outWidth, options.outHeight, options, c1242w);
    }

    /* renamed from: a */
    static void m4345a(int i, int i2, int i3, int i4, Options options, C1242w c1242w) {
        if (i4 <= i2) {
            if (i3 <= i) {
                i = 1;
                options.inSampleSize = i;
                options.inJustDecodeBounds = false;
            }
        }
        if (i2 == 0) {
            i = (int) Math.floor((double) (((float) i3) / ((float) i)));
        } else if (i == 0) {
            i = (int) Math.floor((double) (((float) i4) / ((float) i2)));
        } else {
            i2 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
            i = (int) Math.floor((double) (((float) i3) / ((float) i)));
            i = c1242w.f3547k != 0 ? Math.max(i2, i) : Math.min(i2, i);
        }
        options.inSampleSize = i;
        options.inJustDecodeBounds = false;
    }
}
