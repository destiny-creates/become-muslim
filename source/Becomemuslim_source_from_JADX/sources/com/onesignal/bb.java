package com.onesignal;

import android.content.Context;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.model.ProductDataResponse.RequestStatus;
import com.onesignal.am.C5464i;
import java.lang.reflect.Field;

/* compiled from: TrackAmazonPurchase */
class bb {
    /* renamed from: a */
    private Context f18471a;
    /* renamed from: b */
    private boolean f18472b = false;
    /* renamed from: c */
    private C5489a f18473c;
    /* renamed from: d */
    private Object f18474d;
    /* renamed from: e */
    private Field f18475e;

    /* compiled from: TrackAmazonPurchase */
    /* renamed from: com.onesignal.bb$1 */
    static /* synthetic */ class C54881 {
        /* renamed from: a */
        static final /* synthetic */ int[] f18468a = new int[RequestStatus.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = com.amazon.device.iap.model.ProductDataResponse.RequestStatus.values();
            r0 = r0.length;
            r0 = new int[r0];
            f18468a = r0;
            r0 = f18468a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = com.amazon.device.iap.model.ProductDataResponse.RequestStatus.SUCCESSFUL;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.bb.1.<clinit>():void");
        }
    }

    /* compiled from: TrackAmazonPurchase */
    /* renamed from: com.onesignal.bb$a */
    private class C5489a implements PurchasingListener {
        /* renamed from: a */
        PurchasingListener f18469a;
        /* renamed from: b */
        final /* synthetic */ bb f18470b;

        private C5489a(bb bbVar) {
            this.f18470b = bbVar;
        }
    }

    bb(Context context) {
        this.f18471a = context;
        try {
            context = Class.forName("com.amazon.device.iap.internal.d");
            this.f18474d = context.getMethod("d", new Class[0]).invoke(null, new Object[0]);
            this.f18475e = context.getDeclaredField("f");
            this.f18475e.setAccessible(true);
            this.f18473c = new C5489a();
            this.f18473c.f18469a = (PurchasingListener) this.f18475e.get(this.f18474d);
            this.f18472b = true;
            m23344b();
        } catch (Throwable th) {
            am.m23161a(C5464i.ERROR, "Error adding Amazon IAP listener.", th);
        }
    }

    /* renamed from: b */
    private void m23344b() {
        PurchasingService.registerListener(this.f18471a, this.f18473c);
    }

    /* renamed from: a */
    void m23345a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.f18472b;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r2.f18475e;	 Catch:{ Throwable -> 0x001a }
        r1 = r2.f18474d;	 Catch:{ Throwable -> 0x001a }
        r0 = r0.get(r1);	 Catch:{ Throwable -> 0x001a }
        r0 = (com.amazon.device.iap.PurchasingListener) r0;	 Catch:{ Throwable -> 0x001a }
        r1 = r2.f18473c;	 Catch:{ Throwable -> 0x001a }
        if (r0 == r1) goto L_0x001a;	 Catch:{ Throwable -> 0x001a }
    L_0x0013:
        r1 = r2.f18473c;	 Catch:{ Throwable -> 0x001a }
        r1.f18469a = r0;	 Catch:{ Throwable -> 0x001a }
        r2.m23344b();	 Catch:{ Throwable -> 0x001a }
    L_0x001a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.bb.a():void");
    }
}
