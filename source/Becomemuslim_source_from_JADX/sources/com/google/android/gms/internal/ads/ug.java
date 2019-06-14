package com.google.android.gms.internal.ads;

import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.internal.ads.xo.C8309b;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class ug<P> {
    /* renamed from: a */
    private static final Charset f16045a = Charset.forName(Utf8Charset.NAME);
    /* renamed from: b */
    private ConcurrentMap<String, List<uh<P>>> f16046b = new ConcurrentHashMap();
    /* renamed from: c */
    private uh<P> f16047c;

    /* renamed from: a */
    public final uh<P> m20141a() {
        return this.f16047c;
    }

    /* renamed from: a */
    protected final uh<P> m20142a(P p, C8309b c8309b) {
        ByteBuffer allocate;
        byte b;
        byte[] bArr;
        switch (tx.f16042a[c8309b.m43742e().ordinal()]) {
            case 1:
            case 2:
                allocate = ByteBuffer.allocate(5);
                b = (byte) 0;
                break;
            case 3:
                allocate = ByteBuffer.allocate(5);
                b = (byte) 1;
                break;
            case 4:
                bArr = tw.f16041a;
                break;
            default:
                throw new GeneralSecurityException("unknown output prefix type");
        }
        bArr = allocate.put(b).putInt(c8309b.m43741d()).array();
        uh<P> uhVar = new uh(p, bArr, c8309b.m43740c(), c8309b.m43742e());
        List arrayList = new ArrayList();
        arrayList.add(uhVar);
        String str = new String(uhVar.m20145b(), f16045a);
        arrayList = (List) this.f16046b.put(str, Collections.unmodifiableList(arrayList));
        if (arrayList != null) {
            List arrayList2 = new ArrayList();
            arrayList2.addAll(arrayList);
            arrayList2.add(uhVar);
            this.f16046b.put(str, Collections.unmodifiableList(arrayList2));
        }
        return uhVar;
    }

    /* renamed from: a */
    protected final void m20143a(uh<P> uhVar) {
        this.f16047c = uhVar;
    }
}
