package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class ws extends abq<ws, C8300a> implements acz {
    private static volatile adj<ws> zzakh;
    private static final ws zzdjx = new ws();
    private int zzdju;
    private int zzdjv;
    private aai zzdjw = aai.f14132a;

    /* renamed from: com.google.android.gms.internal.ads.ws$a */
    public static final class C8300a extends C8211a<ws, C8300a> implements acz {
        private C8300a() {
            super(ws.zzdjx);
        }
    }

    static {
        abq.m42174a(ws.class, zzdjx);
    }

    private ws() {
    }

    /* renamed from: d */
    public static ws m43658d() {
        return zzdjx;
    }

    /* renamed from: a */
    public final wu m43660a() {
        wu a = wu.m31220a(this.zzdju);
        return a == null ? wu.UNRECOGNIZED : a;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (wt.f16084a[i - 1]) {
            case 1:
                return new ws();
            case 2:
                return new C8300a();
            case 3:
                Object[] objArr = new Object[]{"zzdju", "zzdjv", "zzdjw"};
                return abq.m42172a(zzdjx, "\u0000\u0003\u0000\u0000\u0001\u000b\u000b\f\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", objArr);
            case 4:
                return zzdjx;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (ws.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdjx);
                            zzakh = obj3;
                        }
                    }
                }
                return obj3;
            case 6:
                return Byte.valueOf((byte) 1);
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    /* renamed from: b */
    public final wx m43662b() {
        wx a = wx.m31223a(this.zzdjv);
        return a == null ? wx.UNRECOGNIZED : a;
    }

    /* renamed from: c */
    public final aai m43663c() {
        return this.zzdjw;
    }
}
