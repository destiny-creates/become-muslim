package com.google.android.gms.internal.p214m;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.p174b.C4757d;
import com.google.android.gms.p190g.p191a.C4820a;
import java.nio.ByteBuffer;

/* renamed from: com.google.android.gms.internal.m.e */
public final class C6825e extends C5059j<C5057f> {
    /* renamed from: a */
    private final C7828c f24644a;

    public C6825e(Context context, C7828c c7828c) {
        super(context, "BarcodeNativeHandle", "barcode");
        this.f24644a = c7828c;
        m21516d();
    }

    /* renamed from: a */
    protected final /* synthetic */ Object mo4767a(DynamiteModule dynamiteModule, Context context) {
        C5058h c5058h;
        IBinder a = dynamiteModule.a("com.google.android.gms.vision.barcode.ChimeraNativeBarcodeDetectorCreator");
        if (a == null) {
            c5058h = null;
        } else {
            IInterface queryLocalInterface = a.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
            c5058h = queryLocalInterface instanceof C5058h ? (C5058h) queryLocalInterface : new C6827i(a);
        }
        return c5058h == null ? null : c5058h.mo4772a(C4757d.a(context), this.f24644a);
    }

    /* renamed from: a */
    protected final void mo4768a() {
        if (m21514b()) {
            ((C5057f) m21516d()).J_();
        }
    }

    /* renamed from: a */
    public final C4820a[] m32096a(Bitmap bitmap, C7829k c7829k) {
        if (!m21514b()) {
            return new C4820a[0];
        }
        try {
            return ((C5057f) m21516d()).mo4771b(C4757d.a(bitmap), c7829k);
        } catch (Throwable e) {
            Log.e("BarcodeNativeHandle", "Error calling native barcode detector", e);
            return new C4820a[0];
        }
    }

    /* renamed from: a */
    public final C4820a[] m32097a(ByteBuffer byteBuffer, C7829k c7829k) {
        if (!m21514b()) {
            return new C4820a[0];
        }
        try {
            return ((C5057f) m21516d()).mo4770a(C4757d.a(byteBuffer), c7829k);
        } catch (Throwable e) {
            Log.e("BarcodeNativeHandle", "Error calling native barcode detector", e);
            return new C4820a[0];
        }
    }
}
