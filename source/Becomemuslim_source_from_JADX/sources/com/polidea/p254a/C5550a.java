package com.polidea.p254a;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.ContentResolver;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.facebook.places.model.PlaceFields;
import com.polidea.p254a.p256b.p260d.C5589i;
import com.polidea.p254a.p256b.p260d.C5592s;
import com.polidea.p254a.p256b.p260d.C7042j;
import com.polidea.p254a.p256b.p260d.C7043l;
import com.polidea.p254a.p256b.p260d.C7056t;
import com.polidea.p254a.p256b.p260d.C7057v;
import com.polidea.p254a.p256b.p260d.C7058x;
import com.polidea.p254a.p256b.p262f.C5607o;
import com.polidea.p254a.p256b.p262f.C5608t;
import com.polidea.p254a.p256b.p262f.C7079m;
import com.polidea.p254a.p256b.p262f.C7080p;
import com.polidea.p254a.p256b.p262f.C7081r;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p000a.p003b.p004a.C0003a;
import p289e.C5974e;
import p289e.C5986h;
import p289e.p301g.C5983a;

/* compiled from: ClientComponent */
/* renamed from: com.polidea.a.a */
public interface C5550a {

    /* compiled from: ClientComponent */
    /* renamed from: com.polidea.a.a$a */
    public interface C5546a {
        /* renamed from: a */
        void mo4972a();
    }

    /* compiled from: ClientComponent */
    /* renamed from: com.polidea.a.a$b */
    public static class C5547b {
        /* renamed from: a */
        private final Context f18594a;

        public C5547b(Context context) {
            this.f18594a = context;
        }

        /* renamed from: a */
        Context m23608a() {
            return this.f18594a;
        }

        /* renamed from: b */
        BluetoothManager m23612b() {
            return (BluetoothManager) this.f18594a.getSystemService("bluetooth");
        }

        /* renamed from: c */
        static BluetoothAdapter m23599c() {
            return BluetoothAdapter.getDefaultAdapter();
        }

        /* renamed from: d */
        static C5986h m23600d() {
            return C5983a.m25109b();
        }

        /* renamed from: e */
        static int m23601e() {
            return VERSION.SDK_INT;
        }

        /* renamed from: f */
        ContentResolver m23613f() {
            return this.f18594a.getContentResolver();
        }

        /* renamed from: a */
        C5607o m23609a(int i, C0003a<C7080p> c0003a, C0003a<C7081r> c0003a2) {
            if (i < 23) {
                return (C5607o) c0003a.a();
            }
            return (C5607o) c0003a2.a();
        }

        /* renamed from: a */
        C5974e<Boolean> m23610a(int i, C0003a<C7079m> c0003a) {
            if (i < 23) {
                return C5608t.m23831a(Boolean.valueOf(1));
            }
            return (C5974e) c0003a.a();
        }

        /* renamed from: g */
        static ExecutorService m23602g() {
            return Executors.newCachedThreadPool();
        }

        /* renamed from: h */
        static ExecutorService m23603h() {
            return Executors.newSingleThreadExecutor();
        }

        /* renamed from: i */
        static ExecutorService m23604i() {
            return Executors.newSingleThreadExecutor();
        }

        /* renamed from: a */
        static C5986h m23596a(ExecutorService executorService) {
            return C5983a.m25108a(executorService);
        }

        /* renamed from: b */
        static C5986h m23598b(ExecutorService executorService) {
            return C5983a.m25108a(executorService);
        }

        /* renamed from: a */
        static C5546a m23594a(final ExecutorService executorService, final ExecutorService executorService2, final ExecutorService executorService3) {
            return new C5546a() {
                /* renamed from: a */
                public void mo4972a() {
                    executorService.shutdown();
                    executorService2.shutdown();
                    executorService3.shutdown();
                }
            };
        }

        /* renamed from: j */
        LocationManager m23614j() {
            return (LocationManager) this.f18594a.getSystemService(PlaceFields.LOCATION);
        }

        /* renamed from: k */
        int m23615k() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = r3.f18594a;	 Catch:{ Throwable -> 0x0014 }
            r0 = r0.getPackageManager();	 Catch:{ Throwable -> 0x0014 }
            r1 = r3.f18594a;	 Catch:{ Throwable -> 0x0014 }
            r1 = r1.getPackageName();	 Catch:{ Throwable -> 0x0014 }
            r2 = 0;	 Catch:{ Throwable -> 0x0014 }
            r0 = r0.getApplicationInfo(r1, r2);	 Catch:{ Throwable -> 0x0014 }
            r0 = r0.targetSdkVersion;	 Catch:{ Throwable -> 0x0014 }
            return r0;
        L_0x0014:
            r0 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.polidea.a.a.b.k():int");
        }

        @SuppressLint({"InlinedApi"})
        /* renamed from: a */
        boolean m23611a(int i) {
            return i >= 20 && this.f18594a.getPackageManager().hasSystemFeature("android.hardware.type.watch") != 0;
        }

        /* renamed from: a */
        static C5592s m23595a(int i, C0003a<C7056t> c0003a, C0003a<C7057v> c0003a2, C0003a<C7058x> c0003a3) {
            if (i < 21) {
                return (C5592s) c0003a.a();
            }
            if (i < 23) {
                return (C5592s) c0003a2.a();
            }
            return (C5592s) c0003a3.a();
        }

        /* renamed from: l */
        static byte[] m23605l() {
            return BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        }

        /* renamed from: m */
        static byte[] m23606m() {
            return BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        }

        /* renamed from: n */
        static byte[] m23607n() {
            return BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        }

        /* renamed from: b */
        static C5589i m23597b(int i, C0003a<C7042j> c0003a, C0003a<C7043l> c0003a2) {
            if (i < 24) {
                return (C5589i) c0003a.a();
            }
            return (C5589i) c0003a2.a();
        }
    }

    /* renamed from: a */
    ac mo5037a();
}
