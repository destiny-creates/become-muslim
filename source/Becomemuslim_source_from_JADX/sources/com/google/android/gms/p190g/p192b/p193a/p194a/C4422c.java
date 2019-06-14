package com.google.android.gms.p190g.p192b.p193a.p194a;

import android.content.Context;
import android.graphics.PointF;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.p214m.C5059j;
import com.google.android.gms.internal.p214m.C7829k;
import com.google.android.gms.p174b.C4757d;
import com.google.android.gms.p190g.p192b.C3048a;
import com.google.android.gms.p190g.p192b.C3050c;
import java.nio.ByteBuffer;

/* renamed from: com.google.android.gms.g.b.a.a.c */
public final class C4422c extends C5059j<C3045g> {
    /* renamed from: a */
    private final C4823e f11785a;

    public C4422c(Context context, C4823e c4823e) {
        super(context, "FaceNativeHandle", "face");
        this.f11785a = c4823e;
        d();
    }

    /* renamed from: a */
    protected final /* synthetic */ Object m14695a(DynamiteModule dynamiteModule, Context context) {
        C3046i c3046i;
        IBinder a = dynamiteModule.m8520a("com.google.android.gms.vision.face.ChimeraNativeFaceDetectorCreator");
        if (a == null) {
            c3046i = null;
        } else {
            IInterface queryLocalInterface = a.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
            c3046i = queryLocalInterface instanceof C3046i ? (C3046i) queryLocalInterface : new C4424j(a);
        }
        return c3046i == null ? null : c3046i.mo2600a(C4757d.m16684a((Object) context), this.f11785a);
    }

    /* renamed from: a */
    protected final void m14696a() {
        ((C3045g) d()).K_();
    }

    /* renamed from: a */
    public final C3048a[] m14697a(ByteBuffer byteBuffer, C7829k c7829k) {
        int i = 0;
        if (!b()) {
            return new C3048a[0];
        }
        try {
            C4821a[] a = ((C3045g) d()).mo2599a(C4757d.m16684a((Object) byteBuffer), c7829k);
            C3048a[] c3048aArr = new C3048a[a.length];
            int i2 = 0;
            while (i2 < a.length) {
                C4821a[] c4821aArr;
                C3050c[] c3050cArr;
                C4821a c4821a = a[i2];
                int i3 = c4821a.f13628a;
                PointF pointF = new PointF(c4821a.f13629b, c4821a.f13630c);
                float f = c4821a.f13631d;
                float f2 = c4821a.f13632e;
                float f3 = c4821a.f13633f;
                float f4 = c4821a.f13634g;
                C4822b[] c4822bArr = c4821a.f13635h;
                if (c4822bArr == null) {
                    c4821aArr = a;
                    c3050cArr = new C3050c[i];
                } else {
                    c3050cArr = new C3050c[c4822bArr.length];
                    int i4 = 0;
                    while (i4 < c4822bArr.length) {
                        C4822b c4822b = c4822bArr[i4];
                        c4821aArr = a;
                        C4822b[] c4822bArr2 = c4822bArr;
                        c3050cArr[i4] = new C3050c(new PointF(c4822b.f13640a, c4822b.f13641b), c4822b.f13642c);
                        i4++;
                        a = c4821aArr;
                        c4822bArr = c4822bArr2;
                    }
                    c4821aArr = a;
                }
                c3048aArr[i2] = new C3048a(i3, pointF, f, f2, f3, f4, c3050cArr, c4821a.f13636i, c4821a.f13637j, c4821a.f13638k);
                i2++;
                a = c4821aArr;
                i = 0;
            }
            return c3048aArr;
        } catch (Throwable e) {
            Log.e("FaceNativeHandle", "Could not call native face detector", e);
            return new C3048a[0];
        }
    }
}
