package com.google.android.p133a;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.media.MediaRecorder.OnInfoListener;
import android.os.Build.VERSION;
import android.support.v4.util.C0464m;
import android.view.SurfaceHolder;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.p133a.C2200f.C2199a;
import com.google.android.p133a.C2205i.C2204a;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Camera1 */
/* renamed from: com.google.android.a.b */
class C4069b extends C2200f implements PreviewCallback, OnErrorListener, OnInfoListener {
    /* renamed from: b */
    private static final C0464m<String> f10156b = new C0464m();
    /* renamed from: c */
    private static final C0464m<String> f10157c = new C0464m();
    /* renamed from: a */
    Camera f10158a;
    /* renamed from: d */
    private int f10159d;
    /* renamed from: e */
    private final AtomicBoolean f10160e = new AtomicBoolean(false);
    /* renamed from: h */
    private Parameters f10161h;
    /* renamed from: i */
    private final CameraInfo f10162i = new CameraInfo();
    /* renamed from: j */
    private MediaRecorder f10163j;
    /* renamed from: k */
    private String f10164k;
    /* renamed from: l */
    private boolean f10165l;
    /* renamed from: m */
    private final C2211l f10166m = new C2211l();
    /* renamed from: n */
    private boolean f10167n = false;
    /* renamed from: o */
    private final C2211l f10168o = new C2211l();
    /* renamed from: p */
    private C2210k f10169p;
    /* renamed from: q */
    private C2186a f10170q;
    /* renamed from: r */
    private boolean f10171r;
    /* renamed from: s */
    private boolean f10172s;
    /* renamed from: t */
    private int f10173t;
    /* renamed from: u */
    private int f10174u;
    /* renamed from: v */
    private int f10175v;
    /* renamed from: w */
    private float f10176w;
    /* renamed from: x */
    private int f10177x;
    /* renamed from: y */
    private boolean f10178y;
    /* renamed from: z */
    private SurfaceTexture f10179z;

    /* compiled from: Camera1 */
    /* renamed from: com.google.android.a.b$2 */
    class C21872 implements AutoFocusCallback {
        /* renamed from: a */
        final /* synthetic */ C4069b f5228a;

        C21872(C4069b c4069b) {
            this.f5228a = c4069b;
        }

        public void onAutoFocus(boolean z, Camera camera) {
            this.f5228a.m12552s();
        }
    }

    /* compiled from: Camera1 */
    /* renamed from: com.google.android.a.b$3 */
    class C21883 implements PictureCallback {
        /* renamed from: a */
        final /* synthetic */ C4069b f5229a;

        C21883(C4069b c4069b) {
            this.f5229a = c4069b;
        }

        public void onPictureTaken(byte[] bArr, Camera camera) {
            this.f5229a.f10160e.set(false);
            camera.cancelAutoFocus();
            camera.startPreview();
            this.f5229a.f10167n = true;
            if (this.f5229a.f10178y) {
                camera.setPreviewCallback(this.f5229a);
            }
            this.f5229a.f.mo2096a(bArr);
        }
    }

    /* compiled from: Camera1 */
    /* renamed from: com.google.android.a.b$1 */
    class C40681 implements C2204a {
        /* renamed from: a */
        final /* synthetic */ C4069b f10155a;

        C40681(C4069b c4069b) {
            this.f10155a = c4069b;
        }

        /* renamed from: a */
        public void mo2057a() {
            if (this.f10155a.f10158a != null) {
                this.f10155a.m12534c();
                this.f10155a.m12555v();
            }
        }

        /* renamed from: b */
        public void mo2058b() {
            this.f10155a.mo2067b();
        }
    }

    /* renamed from: g */
    private boolean m12514g(int i) {
        if (i != 90) {
            if (i != RotationOptions.ROTATE_270) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void mo2060a(float f) {
    }

    /* renamed from: n */
    float mo2084n() {
        return 0.0f;
    }

    static {
        f10156b.m1471b(0, "off");
        f10156b.m1471b(1, ViewProps.ON);
        f10156b.m1471b(2, "torch");
        f10156b.m1471b(3, "auto");
        f10156b.m1471b(4, "red-eye");
        f10157c.m1471b(0, "auto");
        f10157c.m1471b(1, "cloudy-daylight");
        f10157c.m1471b(2, "daylight");
        f10157c.m1471b(3, "shade");
        f10157c.m1471b(4, "fluorescent");
        f10157c.m1471b(5, "incandescent");
    }

    C4069b(C2199a c2199a, C2205i c2205i) {
        super(c2199a, c2205i);
        c2205i.m6084a(new C40681(this));
    }

    /* renamed from: a */
    boolean mo2065a() {
        m12518x();
        if (m12519y()) {
            if (this.g.mo2104d()) {
                m12534c();
            }
            this.f10171r = true;
            m12517w();
            return true;
        }
        this.f.mo2099c();
        return true;
    }

    /* renamed from: b */
    void mo2067b() {
        if (this.f10158a != null) {
            this.f10158a.stopPreview();
            this.f10167n = false;
            this.f10158a.setPreviewCallback(null);
        }
        this.f10171r = false;
        if (this.f10163j != null) {
            this.f10163j.stop();
            this.f10163j.release();
            this.f10163j = null;
            if (this.f10165l) {
                this.f.mo2095a(this.f10164k);
                this.f10165l = false;
            }
        }
        m12501A();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    void m12534c() {
        try {
            if (this.f10179z != null) {
                this.f10158a.setPreviewTexture(this.f10179z);
            } else if (this.g.mo2103c() == SurfaceHolder.class) {
                Object obj = (!this.f10171r || VERSION.SDK_INT >= 14) ? null : 1;
                if (obj != null) {
                    this.f10158a.stopPreview();
                    this.f10167n = false;
                }
                this.f10158a.setPreviewDisplay(this.g.mo2105g());
                if (obj != null) {
                    m12517w();
                }
            } else {
                this.f10158a.setPreviewTexture((SurfaceTexture) this.g.mo2107h());
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: w */
    private void m12517w() {
        this.f10158a.startPreview();
        this.f10167n = true;
        if (this.f10178y) {
            this.f10158a.setPreviewCallback(this);
        }
    }

    /* renamed from: d */
    public void mo2073d() {
        m12517w();
    }

    /* renamed from: e */
    public void mo2075e() {
        this.f10158a.stopPreview();
        this.f10167n = false;
    }

    /* renamed from: f */
    boolean mo2076f() {
        return this.f10158a != null;
    }

    /* renamed from: a */
    void mo2061a(int i) {
        if (this.f10173t != i) {
            this.f10173t = i;
            if (mo2076f() != 0) {
                mo2067b();
                mo2065a();
            }
        }
    }

    /* renamed from: g */
    int mo2077g() {
        return this.f10173t;
    }

    /* renamed from: h */
    int mo2078h() {
        return this.f10159d;
    }

    /* renamed from: i */
    Set<C2186a> mo2079i() {
        C2211l c2211l = this.f10166m;
        for (C2186a c2186a : c2211l.m6101a()) {
            if (this.f10168o.m6104b(c2186a) == null) {
                c2211l.m6102a(c2186a);
            }
        }
        return c2211l.m6101a();
    }

    /* renamed from: a */
    SortedSet<C2210k> mo2059a(C2186a c2186a) {
        return this.f10168o.m6104b(c2186a);
    }

    /* renamed from: a */
    void mo2063a(C2210k c2210k) {
        if (c2210k != null) {
            this.f10169p = c2210k;
            if (!(this.f10161h == null || this.f10158a == null)) {
                this.f10161h.setPictureSize(c2210k.m6098a(), c2210k.m6100b());
                this.f10158a.setParameters(this.f10161h);
            }
        }
    }

    /* renamed from: j */
    C2210k mo2080j() {
        return this.f10169p;
    }

    /* renamed from: b */
    boolean mo2071b(C2186a c2186a) {
        if (this.f10170q != null) {
            if (mo2076f()) {
                if (this.f10170q.equals(c2186a)) {
                    return null;
                }
                if (this.f10166m.m6104b(c2186a) != null) {
                    this.f10170q = c2186a;
                    this.f10169p = (C2210k) this.f10168o.m6104b(this.f10170q).last();
                    m12555v();
                    return true;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(c2186a);
                stringBuilder.append(" is not supported");
                throw new UnsupportedOperationException(stringBuilder.toString());
            }
        }
        this.f10170q = c2186a;
        return true;
    }

    /* renamed from: k */
    C2186a mo2081k() {
        return this.f10170q;
    }

    /* renamed from: a */
    void mo2064a(boolean z) {
        if (this.f10172s != z && m12510c(z)) {
            this.f10158a.setParameters(this.f10161h);
        }
    }

    /* renamed from: l */
    boolean mo2082l() {
        if (!mo2076f()) {
            return this.f10172s;
        }
        String focusMode = this.f10161h.getFocusMode();
        boolean z = focusMode != null && focusMode.contains("continuous");
        return z;
    }

    /* renamed from: b */
    void mo2069b(int i) {
        if (!(i == this.f10174u || m12515h(i) == 0)) {
            this.f10158a.setParameters(this.f10161h);
        }
    }

    /* renamed from: m */
    int mo2083m() {
        return this.f10174u;
    }

    /* renamed from: b */
    void mo2068b(float f) {
        if (!(f == this.f10176w || m12509c(f) == null)) {
            this.f10158a.setParameters(this.f10161h);
        }
    }

    /* renamed from: o */
    float mo2085o() {
        return this.f10176w;
    }

    /* renamed from: c */
    public void mo2072c(int i) {
        if (!(i == this.f10177x || m12516i(i) == 0)) {
            this.f10158a.setParameters(this.f10161h);
        }
    }

    /* renamed from: p */
    public int mo2086p() {
        return this.f10177x;
    }

    /* renamed from: b */
    void mo2070b(boolean z) {
        if (z != this.f10178y) {
            m12511d(z);
        }
    }

    /* renamed from: q */
    boolean mo2087q() {
        return this.f10178y;
    }

    /* renamed from: r */
    void mo2088r() {
        if (!mo2076f()) {
            throw new IllegalStateException("Camera is not ready. Call start() before takePicture().");
        } else if (!this.f10167n) {
            throw new IllegalStateException("Preview is paused - resume it before taking a picture.");
        } else if (mo2082l()) {
            this.f10158a.cancelAutoFocus();
            this.f10158a.autoFocus(new C21872(this));
        } else {
            m12552s();
        }
    }

    /* renamed from: s */
    void m12552s() {
        if (!this.f10160e.getAndSet(true)) {
            this.f10158a.takePicture(null, null, null, new C21883(this));
        }
    }

    /* renamed from: a */
    boolean mo2066a(String str, int i, int i2, boolean z, CamcorderProfile camcorderProfile) {
        if (this.f10165l) {
            return false;
        }
        m12507b(str, i, i2, z, camcorderProfile);
        try {
            this.f10163j.prepare();
            this.f10163j.start();
            this.f10165l = true;
            return true;
        } catch (String str2) {
            str2.printStackTrace();
            return false;
        }
    }

    /* renamed from: t */
    void mo2089t() {
        if (this.f10165l) {
            m12502B();
            if (this.f10158a != null) {
                this.f10158a.lock();
            }
        }
    }

    /* renamed from: d */
    void mo2074d(int i) {
        if (this.f10175v != i) {
            this.f10175v = i;
            if (mo2076f()) {
                this.f10161h.setRotation(m12513f(i));
                this.f10158a.setParameters(this.f10161h);
                Object obj = (!this.f10171r || VERSION.SDK_INT >= 14) ? null : 1;
                if (obj != null) {
                    this.f10158a.stopPreview();
                    this.f10167n = false;
                }
                this.f10158a.setDisplayOrientation(m12512e(i));
                if (obj != null) {
                    m12517w();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo2062a(SurfaceTexture surfaceTexture) {
        try {
            if (this.f10158a == null) {
                this.f10179z = surfaceTexture;
                return;
            }
            this.f10158a.stopPreview();
            this.f10167n = false;
            if (surfaceTexture == null) {
                this.f10158a.setPreviewTexture((SurfaceTexture) this.g.mo2107h());
            } else {
                this.f10158a.setPreviewTexture(surfaceTexture);
            }
            this.f10179z = surfaceTexture;
            m12517w();
        } catch (SurfaceTexture surfaceTexture2) {
            throw new RuntimeException(surfaceTexture2);
        }
    }

    /* renamed from: u */
    public C2210k mo2090u() {
        Size previewSize = this.f10161h.getPreviewSize();
        return new C2210k(previewSize.width, previewSize.height);
    }

    /* renamed from: x */
    private void m12518x() {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, this.f10162i);
            if (this.f10162i.facing == this.f10173t) {
                this.f10159d = i;
                return;
            }
        }
        this.f10159d = -1;
    }

    /* renamed from: y */
    private boolean m12519y() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r5 = this;
        r0 = r5.f10158a;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r5.m12501A();
    L_0x0007:
        r0 = r5.f10159d;	 Catch:{ RuntimeException -> 0x0088 }
        r0 = android.hardware.Camera.open(r0);	 Catch:{ RuntimeException -> 0x0088 }
        r5.f10158a = r0;	 Catch:{ RuntimeException -> 0x0088 }
        r0 = r5.f10158a;	 Catch:{ RuntimeException -> 0x0088 }
        r0 = r0.getParameters();	 Catch:{ RuntimeException -> 0x0088 }
        r5.f10161h = r0;	 Catch:{ RuntimeException -> 0x0088 }
        r0 = r5.f10166m;	 Catch:{ RuntimeException -> 0x0088 }
        r0.m6105b();	 Catch:{ RuntimeException -> 0x0088 }
        r0 = r5.f10161h;	 Catch:{ RuntimeException -> 0x0088 }
        r0 = r0.getSupportedPreviewSizes();	 Catch:{ RuntimeException -> 0x0088 }
        r0 = r0.iterator();	 Catch:{ RuntimeException -> 0x0088 }
    L_0x0026:
        r1 = r0.hasNext();	 Catch:{ RuntimeException -> 0x0088 }
        if (r1 == 0) goto L_0x0041;	 Catch:{ RuntimeException -> 0x0088 }
    L_0x002c:
        r1 = r0.next();	 Catch:{ RuntimeException -> 0x0088 }
        r1 = (android.hardware.Camera.Size) r1;	 Catch:{ RuntimeException -> 0x0088 }
        r2 = r5.f10166m;	 Catch:{ RuntimeException -> 0x0088 }
        r3 = new com.google.android.a.k;	 Catch:{ RuntimeException -> 0x0088 }
        r4 = r1.width;	 Catch:{ RuntimeException -> 0x0088 }
        r1 = r1.height;	 Catch:{ RuntimeException -> 0x0088 }
        r3.<init>(r4, r1);	 Catch:{ RuntimeException -> 0x0088 }
        r2.m6103a(r3);	 Catch:{ RuntimeException -> 0x0088 }
        goto L_0x0026;	 Catch:{ RuntimeException -> 0x0088 }
    L_0x0041:
        r0 = r5.f10168o;	 Catch:{ RuntimeException -> 0x0088 }
        r0.m6105b();	 Catch:{ RuntimeException -> 0x0088 }
        r0 = r5.f10161h;	 Catch:{ RuntimeException -> 0x0088 }
        r0 = r0.getSupportedPictureSizes();	 Catch:{ RuntimeException -> 0x0088 }
        r0 = r0.iterator();	 Catch:{ RuntimeException -> 0x0088 }
    L_0x0050:
        r1 = r0.hasNext();	 Catch:{ RuntimeException -> 0x0088 }
        if (r1 == 0) goto L_0x006b;	 Catch:{ RuntimeException -> 0x0088 }
    L_0x0056:
        r1 = r0.next();	 Catch:{ RuntimeException -> 0x0088 }
        r1 = (android.hardware.Camera.Size) r1;	 Catch:{ RuntimeException -> 0x0088 }
        r2 = r5.f10168o;	 Catch:{ RuntimeException -> 0x0088 }
        r3 = new com.google.android.a.k;	 Catch:{ RuntimeException -> 0x0088 }
        r4 = r1.width;	 Catch:{ RuntimeException -> 0x0088 }
        r1 = r1.height;	 Catch:{ RuntimeException -> 0x0088 }
        r3.<init>(r4, r1);	 Catch:{ RuntimeException -> 0x0088 }
        r2.m6103a(r3);	 Catch:{ RuntimeException -> 0x0088 }
        goto L_0x0050;	 Catch:{ RuntimeException -> 0x0088 }
    L_0x006b:
        r0 = r5.f10170q;	 Catch:{ RuntimeException -> 0x0088 }
        if (r0 != 0) goto L_0x0073;	 Catch:{ RuntimeException -> 0x0088 }
    L_0x006f:
        r0 = com.google.android.p133a.C2201g.f5248a;	 Catch:{ RuntimeException -> 0x0088 }
        r5.f10170q = r0;	 Catch:{ RuntimeException -> 0x0088 }
    L_0x0073:
        r5.m12555v();	 Catch:{ RuntimeException -> 0x0088 }
        r0 = r5.f10158a;	 Catch:{ RuntimeException -> 0x0088 }
        r1 = r5.f10175v;	 Catch:{ RuntimeException -> 0x0088 }
        r1 = r5.m12512e(r1);	 Catch:{ RuntimeException -> 0x0088 }
        r0.setDisplayOrientation(r1);	 Catch:{ RuntimeException -> 0x0088 }
        r0 = r5.f;	 Catch:{ RuntimeException -> 0x0088 }
        r0.mo2094a();	 Catch:{ RuntimeException -> 0x0088 }
        r0 = 1;
        return r0;
    L_0x0088:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.a.b.y():boolean");
    }

    /* renamed from: z */
    private C2186a m12520z() {
        C2186a c2186a = null;
        for (C2186a c2186a2 : this.f10166m.m6101a()) {
            if (c2186a2.equals(C2201g.f5248a)) {
                return c2186a2;
            }
        }
        return c2186a2;
    }

    /* renamed from: v */
    void m12555v() {
        SortedSet b = this.f10166m.m6104b(this.f10170q);
        if (b == null) {
            this.f10170q = m12520z();
            b = this.f10166m.m6104b(this.f10170q);
        }
        C2210k a = m12503a(b);
        if (this.f10169p == null) {
            this.f10169p = (C2210k) this.f10168o.m6104b(this.f10170q).last();
        }
        if (this.f10171r) {
            this.f10158a.stopPreview();
            this.f10167n = false;
        }
        this.f10161h.setPreviewSize(a.m6098a(), a.m6100b());
        this.f10161h.setPictureSize(this.f10169p.m6098a(), this.f10169p.m6100b());
        this.f10161h.setRotation(m12513f(this.f10175v));
        m12510c(this.f10172s);
        m12515h(this.f10174u);
        mo2071b(this.f10170q);
        m12509c(this.f10176w);
        m12516i(this.f10177x);
        m12511d(this.f10178y);
        this.f10158a.setParameters(this.f10161h);
        if (this.f10171r) {
            m12517w();
        }
    }

    /* renamed from: a */
    private C2210k m12503a(SortedSet<C2210k> sortedSet) {
        if (!this.g.mo2104d()) {
            return (C2210k) sortedSet.first();
        }
        int i = this.g.m6093i();
        int j = this.g.m6094j();
        if (m12514g(this.f10175v)) {
            int i2 = j;
            j = i;
            i = i2;
        }
        C2210k c2210k = null;
        for (C2210k c2210k2 : sortedSet) {
            if (i <= c2210k2.m6098a() && r1 <= c2210k2.m6100b()) {
                return c2210k2;
            }
        }
        return c2210k2;
    }

    /* renamed from: A */
    private void m12501A() {
        if (this.f10158a != null) {
            this.f10158a.release();
            this.f10158a = null;
            this.f10169p = null;
            this.f.mo2098b();
        }
    }

    /* renamed from: e */
    private int m12512e(int i) {
        if (this.f10162i.facing == 1) {
            return (360 - ((this.f10162i.orientation + i) % 360)) % 360;
        }
        return ((this.f10162i.orientation - i) + 360) % 360;
    }

    /* renamed from: f */
    private int m12513f(int i) {
        if (this.f10162i.facing == 1) {
            return (this.f10162i.orientation + i) % 360;
        }
        return ((this.f10162i.orientation + i) + (m12514g(i) ? RotationOptions.ROTATE_180 : 0)) % 360;
    }

    /* renamed from: c */
    private boolean m12510c(boolean z) {
        this.f10172s = z;
        if (!mo2076f()) {
            return false;
        }
        List supportedFocusModes = this.f10161h.getSupportedFocusModes();
        if (z && supportedFocusModes.contains("continuous-picture")) {
            this.f10161h.setFocusMode("continuous-picture");
        } else if (supportedFocusModes.contains("fixed")) {
            this.f10161h.setFocusMode("fixed");
        } else if (supportedFocusModes.contains("infinity")) {
            this.f10161h.setFocusMode("infinity");
        } else {
            this.f10161h.setFocusMode((String) supportedFocusModes.get(0));
        }
        return true;
    }

    /* renamed from: h */
    private boolean m12515h(int i) {
        if (mo2076f()) {
            List supportedFlashModes = this.f10161h.getSupportedFlashModes();
            String str = (String) f10156b.m1467a(i);
            if (supportedFlashModes == null || !supportedFlashModes.contains(str)) {
                String str2 = (String) f10156b.m1467a(this.f10174u);
                if (supportedFlashModes != null) {
                    if (supportedFlashModes.contains(str2) != 0) {
                        return false;
                    }
                }
                this.f10161h.setFlashMode("off");
                return true;
            }
            this.f10161h.setFlashMode(str);
            this.f10174u = i;
            return true;
        }
        this.f10174u = i;
        return false;
    }

    /* renamed from: c */
    private boolean m12509c(float f) {
        if (mo2076f() && this.f10161h.isZoomSupported()) {
            this.f10161h.setZoom((int) (((float) this.f10161h.getMaxZoom()) * f));
            this.f10176w = f;
            return true;
        }
        this.f10176w = f;
        return false;
    }

    /* renamed from: i */
    private boolean m12516i(int i) {
        this.f10177x = i;
        if (!mo2076f()) {
            return false;
        }
        List supportedWhiteBalance = this.f10161h.getSupportedWhiteBalance();
        String str = (String) f10157c.m1467a(i);
        if (supportedWhiteBalance == null || !supportedWhiteBalance.contains(str)) {
            str = (String) f10157c.m1467a(this.f10177x);
            if (supportedWhiteBalance != null) {
                if (supportedWhiteBalance.contains(str) != 0) {
                    return false;
                }
            }
            this.f10161h.setWhiteBalance("auto");
            return true;
        }
        this.f10161h.setWhiteBalance(str);
        return true;
    }

    /* renamed from: d */
    private void m12511d(boolean z) {
        this.f10178y = z;
        if (!mo2076f()) {
            return;
        }
        if (this.f10178y) {
            this.f10158a.setPreviewCallback(this);
        } else {
            this.f10158a.setPreviewCallback(null);
        }
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        camera = this.f10161h.getPreviewSize();
        this.f.mo2097a(bArr, camera.width, camera.height, this.f10175v);
    }

    /* renamed from: b */
    private void m12507b(String str, int i, int i2, boolean z, CamcorderProfile camcorderProfile) {
        this.f10163j = new MediaRecorder();
        this.f10158a.unlock();
        this.f10163j.setCamera(this.f10158a);
        this.f10163j.setVideoSource(1);
        if (z) {
            this.f10163j.setAudioSource(5);
        }
        this.f10163j.setOutputFile(str);
        this.f10164k = str;
        if (CamcorderProfile.hasProfile(this.f10159d, camcorderProfile.quality) != null) {
            m12505a(CamcorderProfile.get(this.f10159d, camcorderProfile.quality), z);
        } else {
            m12505a(CamcorderProfile.get(this.f10159d, 1), z);
        }
        this.f10163j.setOrientationHint(m12513f(this.f10175v));
        if (i != -1) {
            this.f10163j.setMaxDuration(i);
        }
        if (i2 != -1) {
            this.f10163j.setMaxFileSize((long) i2);
        }
        this.f10163j.setOnInfoListener(this);
        this.f10163j.setOnErrorListener(this);
    }

    /* renamed from: B */
    private void m12502B() {
        this.f10165l = false;
        if (this.f10163j != null) {
            try {
                this.f10163j.stop();
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            this.f10163j.reset();
            this.f10163j.release();
            this.f10163j = null;
        }
        if (this.f10164k != null) {
            if (new File(this.f10164k).exists()) {
                this.f.mo2095a(this.f10164k);
                this.f10164k = null;
                return;
            }
        }
        this.f.mo2095a(null);
    }

    /* renamed from: a */
    private void m12505a(CamcorderProfile camcorderProfile, boolean z) {
        this.f10163j.setOutputFormat(camcorderProfile.fileFormat);
        this.f10163j.setVideoFrameRate(camcorderProfile.videoFrameRate);
        this.f10163j.setVideoSize(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
        this.f10163j.setVideoEncodingBitRate(camcorderProfile.videoBitRate);
        this.f10163j.setVideoEncoder(camcorderProfile.videoCodec);
        if (z) {
            this.f10163j.setAudioEncodingBitRate(camcorderProfile.audioBitRate);
            this.f10163j.setAudioChannels(camcorderProfile.audioChannels);
            this.f10163j.setAudioSamplingRate(camcorderProfile.audioSampleRate);
            this.f10163j.setAudioEncoder(camcorderProfile.audioCodec);
        }
    }

    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
        if (i == 800 || i == 801) {
            mo2089t();
        }
    }

    public void onError(MediaRecorder mediaRecorder, int i, int i2) {
        mo2089t();
    }
}
