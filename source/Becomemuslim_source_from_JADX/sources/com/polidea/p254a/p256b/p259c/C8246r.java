package com.polidea.p254a.p256b.p259c;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import com.polidea.p254a.p255a.C6975n;
import com.polidea.p254a.p256b.C5615p;
import com.polidea.p254a.p256b.p260d.C5585a;
import com.polidea.p254a.p256b.p260d.C5586c;
import com.polidea.p254a.p256b.p260d.C5587d;
import com.polidea.p254a.p256b.p260d.C5588h;
import com.polidea.p254a.p256b.p262f.C5610w;
import com.polidea.p254a.p263c.C5619b;
import com.polidea.p254a.p263c.C5624e;
import java.util.List;
import p289e.C7332c;

/* compiled from: ScanOperationApi21 */
/* renamed from: com.polidea.a.b.c.r */
public class C8246r extends C7960p<C5588h, ScanCallback> {
    /* renamed from: a */
    private final C5587d f32420a;
    /* renamed from: b */
    private final C5585a f32421b;
    /* renamed from: c */
    private final C5624e f32422c;
    /* renamed from: d */
    private final C5586c f32423d;
    /* renamed from: e */
    private final C5619b[] f32424e;

    /* renamed from: a */
    /* synthetic */ Object mo6757a(C7332c c7332c) {
        return m42832b(c7332c);
    }

    public C8246r(C5610w c5610w, C5587d c5587d, C5585a c5585a, C5624e c5624e, C5586c c5586c, C5619b[] c5619bArr) {
        super(c5610w);
        this.f32420a = c5587d;
        this.f32422c = c5624e;
        this.f32423d = c5586c;
        this.f32424e = c5619bArr;
        this.f32421b = c5585a;
    }

    /* renamed from: b */
    ScanCallback m42832b(final C7332c<C5588h> c7332c) {
        return new ScanCallback(this) {
            /* renamed from: b */
            final /* synthetic */ C8246r f18692b;

            public void onScanResult(int i, ScanResult scanResult) {
                i = this.f18692b.f32420a.m23777a(i, scanResult);
                if (this.f18692b.f32423d.m23775a(i) != null) {
                    c7332c.mo5000a((Object) i);
                }
            }

            public void onBatchScanResults(List<ScanResult> list) {
                for (ScanResult a : list) {
                    C5588h a2 = this.f18692b.f32420a.m23779a(a);
                    if (this.f18692b.f32423d.m23775a(a2)) {
                        c7332c.mo5000a((Object) a2);
                    }
                }
            }

            public void onScanFailed(int i) {
                c7332c.mo5001a(new C6975n(C8246r.m42827b(i)));
            }
        };
    }

    /* renamed from: a */
    boolean m42830a(C5610w c5610w, ScanCallback scanCallback) {
        c5610w.m23838a(this.f32421b.m23774a(this.f32424e), this.f32421b.m23773a(this.f32422c), scanCallback);
        return true;
    }

    /* renamed from: b */
    void m42833b(C5610w c5610w, ScanCallback scanCallback) {
        c5610w.m23837a(scanCallback);
    }

    /* renamed from: b */
    private static int m42827b(int i) {
        switch (i) {
            case 1:
                return 5;
            case 2:
                return 6;
            case 3:
                return 7;
            case 4:
                return 8;
            case 5:
                return 9;
            default:
                C5615p.m23870d("Encountered unknown scanning error code: %d -> check android.bluetooth.le.ScanCallback", new Object[0]);
                return Integer.MAX_VALUE;
        }
    }
}
