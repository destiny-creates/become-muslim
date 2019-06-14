package com.p079e.p080a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Thumbnails;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.p079e.p080a.C1236t.C1233d;
import com.p079e.p080a.C1245y.C1244a;

/* compiled from: MediaStoreRequestHandler */
/* renamed from: com.e.a.o */
class C4546o extends C3503g {
    /* renamed from: b */
    private static final String[] f12275b = new String[]{"orientation"};

    /* compiled from: MediaStoreRequestHandler */
    /* renamed from: com.e.a.o$a */
    enum C1224a {
        MICRO(3, 96, 96),
        MINI(1, 512, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT),
        FULL(2, -1, -1);
        
        /* renamed from: d */
        final int f3459d;
        /* renamed from: e */
        final int f3460e;
        /* renamed from: f */
        final int f3461f;

        private C1224a(int i, int i2, int i3) {
            this.f3459d = i;
            this.f3460e = i2;
            this.f3461f = i3;
        }
    }

    C4546o(Context context) {
        super(context);
    }

    /* renamed from: a */
    public boolean mo821a(C1242w c1242w) {
        c1242w = c1242w.f3540d;
        return (!UriUtil.LOCAL_CONTENT_SCHEME.equals(c1242w.getScheme()) || "media".equals(c1242w.getAuthority()) == null) ? null : true;
    }

    /* renamed from: a */
    public C1244a mo820a(C1242w c1242w, int i) {
        C1242w c1242w2 = c1242w;
        ContentResolver contentResolver = this.a.getContentResolver();
        int a = C4546o.m15455a(contentResolver, c1242w2.f3540d);
        String type = contentResolver.getType(c1242w2.f3540d);
        Object obj = (type == null || !type.startsWith("video/")) ? null : 1;
        if (c1242w.m4332d()) {
            C1224a a2 = C4546o.m15456a(c1242w2.f3544h, c1242w2.f3545i);
            if (obj == null && a2 == C1224a.FULL) {
                return new C1244a(null, m11296b(c1242w), C1233d.DISK, a);
            }
            Bitmap thumbnail;
            long parseId = ContentUris.parseId(c1242w2.f3540d);
            Options c = C1245y.m4348c(c1242w);
            c.inJustDecodeBounds = true;
            Options options = c;
            C1245y.m4345a(c1242w2.f3544h, c1242w2.f3545i, a2.f3460e, a2.f3461f, c, c1242w);
            if (obj != null) {
                thumbnail = Thumbnails.getThumbnail(contentResolver, parseId, a2 == C1224a.FULL ? 1 : a2.f3459d, options);
            } else {
                thumbnail = Images.Thumbnails.getThumbnail(contentResolver, parseId, a2.f3459d, options);
            }
            if (thumbnail != null) {
                return new C1244a(thumbnail, null, C1233d.DISK, a);
            }
        }
        return new C1244a(null, m11296b(c1242w), C1233d.DISK, a);
    }

    /* renamed from: a */
    static C1224a m15456a(int i, int i2) {
        if (i <= C1224a.MICRO.f3460e && i2 <= C1224a.MICRO.f3461f) {
            return C1224a.MICRO;
        }
        if (i > C1224a.MINI.f3460e || i2 > C1224a.MINI.f3461f) {
            return C1224a.FULL;
        }
        return C1224a.MINI;
    }

    /* renamed from: a */
    static int m15455a(android.content.ContentResolver r8, android.net.Uri r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = 0;
        r1 = 0;
        r4 = f12275b;	 Catch:{ RuntimeException -> 0x0032, all -> 0x002a }
        r5 = 0;	 Catch:{ RuntimeException -> 0x0032, all -> 0x002a }
        r6 = 0;	 Catch:{ RuntimeException -> 0x0032, all -> 0x002a }
        r7 = 0;	 Catch:{ RuntimeException -> 0x0032, all -> 0x002a }
        r2 = r8;	 Catch:{ RuntimeException -> 0x0032, all -> 0x002a }
        r3 = r9;	 Catch:{ RuntimeException -> 0x0032, all -> 0x002a }
        r8 = r2.query(r3, r4, r5, r6, r7);	 Catch:{ RuntimeException -> 0x0032, all -> 0x002a }
        if (r8 == 0) goto L_0x0024;
    L_0x000f:
        r9 = r8.moveToFirst();	 Catch:{ RuntimeException -> 0x0022, all -> 0x0020 }
        if (r9 != 0) goto L_0x0016;	 Catch:{ RuntimeException -> 0x0022, all -> 0x0020 }
    L_0x0015:
        goto L_0x0024;	 Catch:{ RuntimeException -> 0x0022, all -> 0x0020 }
    L_0x0016:
        r9 = r8.getInt(r0);	 Catch:{ RuntimeException -> 0x0022, all -> 0x0020 }
        if (r8 == 0) goto L_0x001f;
    L_0x001c:
        r8.close();
    L_0x001f:
        return r9;
    L_0x0020:
        r9 = move-exception;
        goto L_0x002c;
        goto L_0x0033;
    L_0x0024:
        if (r8 == 0) goto L_0x0029;
    L_0x0026:
        r8.close();
    L_0x0029:
        return r0;
    L_0x002a:
        r9 = move-exception;
        r8 = r1;
    L_0x002c:
        if (r8 == 0) goto L_0x0031;
    L_0x002e:
        r8.close();
    L_0x0031:
        throw r9;
    L_0x0032:
        r8 = r1;
    L_0x0033:
        if (r8 == 0) goto L_0x0038;
    L_0x0035:
        r8.close();
    L_0x0038:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e.a.o.a(android.content.ContentResolver, android.net.Uri):int");
    }
}
