package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class wc extends abq<wc, C8293a> implements acz {
    private static volatile adj<wc> zzakh;
    private static final wc zzdja = new wc();
    private int zzdir;

    /* renamed from: com.google.android.gms.internal.ads.wc$a */
    public static final class C8293a extends C8211a<wc, C8293a> implements acz {
        private C8293a() {
            super(wc.zzdja);
        }
    }

    static {
        abq.m42174a(wc.class, zzdja);
    }

    private wc() {
    }

    /* renamed from: a */
    public static wc m43591a(aai aai) {
        return (wc) abq.m42167a(zzdja, aai);
    }

    /* renamed from: a */
    public final int m43593a() {
        return this.zzdir;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (wd.f16077a[i - 1]) {
            case 1:
                return new wc();
            case 2:
                return new C8293a();
            case 3:
                Object[] objArr = new Object[]{"zzdir"};
                return abq.m42172a(zzdja, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0003\u0000\u0000\u0000\u0002\u000b", objArr);
            case 4:
                return zzdja;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (wc.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdja);
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
}
