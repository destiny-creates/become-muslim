package com.google.android.exoplayer2.p157i;

import com.google.android.exoplayer2.C2515k;

/* compiled from: SubtitleDecoderFactory */
/* renamed from: com.google.android.exoplayer2.i.h */
public interface C2474h {
    /* renamed from: a */
    public static final C2474h f6295a = new C42341();

    /* compiled from: SubtitleDecoderFactory */
    /* renamed from: com.google.android.exoplayer2.i.h$1 */
    static class C42341 implements C2474h {
        C42341() {
        }

        /* renamed from: a */
        public boolean mo2295a(C2515k c2515k) {
            c2515k = c2515k.f6380f;
            if (!("text/vtt".equals(c2515k) || "text/x-ssa".equals(c2515k) || "application/ttml+xml".equals(c2515k) || "application/x-mp4-vtt".equals(c2515k) || "application/x-subrip".equals(c2515k) || "application/x-quicktime-tx3g".equals(c2515k) || "application/cea-608".equals(c2515k) || "application/x-mp4-cea-608".equals(c2515k) || "application/cea-708".equals(c2515k))) {
                if ("application/dvbsubs".equals(c2515k) == null) {
                    return null;
                }
            }
            return true;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: b */
        public com.google.android.exoplayer2.p157i.C4230f mo2296b(com.google.android.exoplayer2.C2515k r3) {
            /*
            r2 = this;
            r0 = r3.f6380f;
            r1 = r0.hashCode();
            switch(r1) {
                case -1351681404: goto L_0x0066;
                case -1026075066: goto L_0x005c;
                case -1004728940: goto L_0x0052;
                case 691401887: goto L_0x0048;
                case 822864842: goto L_0x003e;
                case 930165504: goto L_0x0034;
                case 1566015601: goto L_0x002a;
                case 1566016562: goto L_0x001f;
                case 1668750253: goto L_0x0015;
                case 1693976202: goto L_0x000b;
                default: goto L_0x0009;
            };
        L_0x0009:
            goto L_0x0071;
        L_0x000b:
            r1 = "application/ttml+xml";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x0013:
            r0 = 3;
            goto L_0x0072;
        L_0x0015:
            r1 = "application/x-subrip";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x001d:
            r0 = 4;
            goto L_0x0072;
        L_0x001f:
            r1 = "application/cea-708";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x0027:
            r0 = 8;
            goto L_0x0072;
        L_0x002a:
            r1 = "application/cea-608";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x0032:
            r0 = 6;
            goto L_0x0072;
        L_0x0034:
            r1 = "application/x-mp4-cea-608";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x003c:
            r0 = 7;
            goto L_0x0072;
        L_0x003e:
            r1 = "text/x-ssa";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x0046:
            r0 = 1;
            goto L_0x0072;
        L_0x0048:
            r1 = "application/x-quicktime-tx3g";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x0050:
            r0 = 5;
            goto L_0x0072;
        L_0x0052:
            r1 = "text/vtt";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x005a:
            r0 = 0;
            goto L_0x0072;
        L_0x005c:
            r1 = "application/x-mp4-vtt";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x0064:
            r0 = 2;
            goto L_0x0072;
        L_0x0066:
            r1 = "application/dvbsubs";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x006e:
            r0 = 9;
            goto L_0x0072;
        L_0x0071:
            r0 = -1;
        L_0x0072:
            switch(r0) {
                case 0: goto L_0x00b9;
                case 1: goto L_0x00b1;
                case 2: goto L_0x00ab;
                case 3: goto L_0x00a5;
                case 4: goto L_0x009f;
                case 5: goto L_0x0097;
                case 6: goto L_0x008d;
                case 7: goto L_0x008d;
                case 8: goto L_0x0085;
                case 9: goto L_0x007d;
                default: goto L_0x0075;
            };
        L_0x0075:
            r3 = new java.lang.IllegalArgumentException;
            r0 = "Attempted to create decoder for unsupported format";
            r3.<init>(r0);
            throw r3;
        L_0x007d:
            r0 = new com.google.android.exoplayer2.i.b.a;
            r3 = r3.f6382h;
            r0.<init>(r3);
            return r0;
        L_0x0085:
            r0 = new com.google.android.exoplayer2.i.a.c;
            r3 = r3.f6400z;
            r0.<init>(r3);
            return r0;
        L_0x008d:
            r0 = new com.google.android.exoplayer2.i.a.a;
            r1 = r3.f6380f;
            r3 = r3.f6400z;
            r0.<init>(r1, r3);
            return r0;
        L_0x0097:
            r0 = new com.google.android.exoplayer2.i.f.a;
            r3 = r3.f6382h;
            r0.<init>(r3);
            return r0;
        L_0x009f:
            r3 = new com.google.android.exoplayer2.i.d.a;
            r3.<init>();
            return r3;
        L_0x00a5:
            r3 = new com.google.android.exoplayer2.i.e.a;
            r3.<init>();
            return r3;
        L_0x00ab:
            r3 = new com.google.android.exoplayer2.i.g.b;
            r3.<init>();
            return r3;
        L_0x00b1:
            r0 = new com.google.android.exoplayer2.i.c.a;
            r3 = r3.f6382h;
            r0.<init>(r3);
            return r0;
        L_0x00b9:
            r3 = new com.google.android.exoplayer2.i.g.g;
            r3.<init>();
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.h.1.b(com.google.android.exoplayer2.k):com.google.android.exoplayer2.i.f");
        }
    }

    /* renamed from: a */
    boolean mo2295a(C2515k c2515k);

    /* renamed from: b */
    C4230f mo2296b(C2515k c2515k);
}
