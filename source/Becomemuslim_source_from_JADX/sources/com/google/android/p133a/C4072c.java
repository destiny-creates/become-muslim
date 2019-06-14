package com.google.android.p133a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraManager.AvailabilityCallback;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.Image;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.media.MediaRecorder.OnInfoListener;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import com.google.android.p133a.C2200f.C2199a;
import com.google.android.p133a.C2205i.C2204a;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

@TargetApi(21)
/* compiled from: Camera2 */
/* renamed from: com.google.android.a.c */
class C4072c extends C2200f implements OnErrorListener, OnInfoListener {
    /* renamed from: h */
    private static final SparseIntArray f10182h = new SparseIntArray();
    /* renamed from: A */
    private boolean f10183A;
    /* renamed from: B */
    private int f10184B;
    /* renamed from: C */
    private int f10185C;
    /* renamed from: D */
    private float f10186D;
    /* renamed from: E */
    private float f10187E;
    /* renamed from: F */
    private int f10188F;
    /* renamed from: G */
    private boolean f10189G;
    /* renamed from: H */
    private Surface f10190H;
    /* renamed from: I */
    private Rect f10191I;
    /* renamed from: a */
    C2195a f10192a = new C40703(this);
    /* renamed from: b */
    CameraDevice f10193b;
    /* renamed from: c */
    CameraCaptureSession f10194c;
    /* renamed from: d */
    Builder f10195d;
    /* renamed from: e */
    Set<String> f10196e = new HashSet();
    /* renamed from: i */
    private final CameraManager f10197i;
    /* renamed from: j */
    private final StateCallback f10198j = new C21891(this);
    /* renamed from: k */
    private final CameraCaptureSession.StateCallback f10199k = new C21902(this);
    /* renamed from: l */
    private final OnImageAvailableListener f10200l = new C21914(this);
    /* renamed from: m */
    private String f10201m;
    /* renamed from: n */
    private CameraCharacteristics f10202n;
    /* renamed from: o */
    private ImageReader f10203o;
    /* renamed from: p */
    private ImageReader f10204p;
    /* renamed from: q */
    private int f10205q;
    /* renamed from: r */
    private MediaRecorder f10206r;
    /* renamed from: s */
    private String f10207s;
    /* renamed from: t */
    private boolean f10208t;
    /* renamed from: u */
    private final C2211l f10209u = new C2211l();
    /* renamed from: v */
    private final C2211l f10210v = new C2211l();
    /* renamed from: w */
    private C2210k f10211w;
    /* renamed from: x */
    private int f10212x;
    /* renamed from: y */
    private C2186a f10213y = C2201g.f5248a;
    /* renamed from: z */
    private C2186a f10214z;

    /* compiled from: Camera2 */
    /* renamed from: com.google.android.a.c$1 */
    class C21891 extends StateCallback {
        /* renamed from: a */
        final /* synthetic */ C4072c f5230a;

        C21891(C4072c c4072c) {
            this.f5230a = c4072c;
        }

        public void onOpened(CameraDevice cameraDevice) {
            this.f5230a.f10193b = cameraDevice;
            this.f5230a.f.mo2094a();
            this.f5230a.m12591c();
        }

        public void onClosed(CameraDevice cameraDevice) {
            this.f5230a.f.mo2098b();
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            this.f5230a.f10193b = null;
        }

        public void onError(CameraDevice cameraDevice, int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onError: ");
            stringBuilder.append(cameraDevice.getId());
            stringBuilder.append(" (");
            stringBuilder.append(i);
            stringBuilder.append(")");
            Log.e("Camera2", stringBuilder.toString());
            this.f5230a.f10193b = 0;
        }
    }

    /* compiled from: Camera2 */
    /* renamed from: com.google.android.a.c$2 */
    class C21902 extends CameraCaptureSession.StateCallback {
        /* renamed from: a */
        final /* synthetic */ C4072c f5231a;

        C21902(C4072c c4072c) {
            this.f5231a = c4072c;
        }

        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            if (this.f5231a.f10193b != null) {
                this.f5231a.f10194c = cameraCaptureSession;
                this.f5231a.f10191I = (Rect) this.f5231a.f10195d.get(CaptureRequest.SCALER_CROP_REGION);
                this.f5231a.m12612v();
                this.f5231a.m12613w();
                this.f5231a.m12614x();
                this.f5231a.m12616z();
                this.f5231a.m12615y();
                try {
                    this.f5231a.f10194c.setRepeatingRequest(this.f5231a.f10195d.build(), this.f5231a.f10192a, null);
                } catch (CameraCaptureSession cameraCaptureSession2) {
                    Log.e("Camera2", "Failed to start camera preview because it couldn't access camera", cameraCaptureSession2);
                } catch (CameraCaptureSession cameraCaptureSession22) {
                    Log.e("Camera2", "Failed to start camera preview.", cameraCaptureSession22);
                }
            }
        }

        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            Log.e("Camera2", "Failed to configure capture session.");
        }

        public void onClosed(CameraCaptureSession cameraCaptureSession) {
            if (this.f5231a.f10194c != null && this.f5231a.f10194c.equals(cameraCaptureSession) != null) {
                this.f5231a.f10194c = null;
            }
        }
    }

    /* compiled from: Camera2 */
    /* renamed from: com.google.android.a.c$4 */
    class C21914 implements OnImageAvailableListener {
        /* renamed from: a */
        final /* synthetic */ C4072c f5232a;

        C21914(C4072c c4072c) {
            this.f5232a = c4072c;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onImageAvailable(android.media.ImageReader r8) {
            /*
            r7 = this;
            r8 = r8.acquireNextImage();
            r0 = 0;
            r1 = r8.getFormat();	 Catch:{ Throwable -> 0x005d }
            r2 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
            r3 = 0;
            if (r1 != r2) goto L_0x0029;
        L_0x000e:
            r1 = r8.getPlanes();	 Catch:{ Throwable -> 0x005d }
            r1 = r1[r3];	 Catch:{ Throwable -> 0x005d }
            r1 = r1.getBuffer();	 Catch:{ Throwable -> 0x005d }
            r2 = r1.remaining();	 Catch:{ Throwable -> 0x005d }
            r2 = new byte[r2];	 Catch:{ Throwable -> 0x005d }
            r1.get(r2);	 Catch:{ Throwable -> 0x005d }
            r1 = r7.f5232a;	 Catch:{ Throwable -> 0x005d }
            r1 = r1.f;	 Catch:{ Throwable -> 0x005d }
            r1.mo2096a(r2);	 Catch:{ Throwable -> 0x005d }
            goto L_0x0055;
        L_0x0029:
            r1 = com.google.android.p133a.C4072c.m12574b(r8);	 Catch:{ Throwable -> 0x005d }
            r2 = r8.getWidth();	 Catch:{ Throwable -> 0x005d }
            r4 = r8.getHeight();	 Catch:{ Throwable -> 0x005d }
            r5 = r8.getPlanes();	 Catch:{ Throwable -> 0x005d }
            r3 = r5[r3];	 Catch:{ Throwable -> 0x005d }
            r5 = r3.getPixelStride();	 Catch:{ Throwable -> 0x005d }
            r3 = r3.getRowStride();	 Catch:{ Throwable -> 0x005d }
            r6 = r5 * r2;
            r3 = r3 - r6;
            r3 = r3 / r5;
            r5 = r7.f5232a;	 Catch:{ Throwable -> 0x005d }
            r5 = r5.f;	 Catch:{ Throwable -> 0x005d }
            r2 = r2 + r3;
            r3 = r7.f5232a;	 Catch:{ Throwable -> 0x005d }
            r3 = r3.f10185C;	 Catch:{ Throwable -> 0x005d }
            r5.mo2097a(r1, r2, r4, r3);	 Catch:{ Throwable -> 0x005d }
        L_0x0055:
            if (r8 == 0) goto L_0x005a;
        L_0x0057:
            r8.close();
        L_0x005a:
            return;
        L_0x005b:
            r1 = move-exception;
            goto L_0x005f;
        L_0x005d:
            r0 = move-exception;
            throw r0;	 Catch:{ all -> 0x005b }
        L_0x005f:
            if (r8 == 0) goto L_0x006f;
        L_0x0061:
            if (r0 == 0) goto L_0x006c;
        L_0x0063:
            r8.close();	 Catch:{ Throwable -> 0x0067 }
            goto L_0x006f;
        L_0x0067:
            r8 = move-exception;
            r0.addSuppressed(r8);
            goto L_0x006f;
        L_0x006c:
            r8.close();
        L_0x006f:
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.a.c.4.onImageAvailable(android.media.ImageReader):void");
        }
    }

    /* compiled from: Camera2 */
    /* renamed from: com.google.android.a.c$5 */
    class C21925 extends AvailabilityCallback {
        /* renamed from: a */
        final /* synthetic */ C4072c f5233a;

        C21925(C4072c c4072c) {
            this.f5233a = c4072c;
        }

        public void onCameraAvailable(String str) {
            super.onCameraAvailable(str);
            this.f5233a.f10196e.add(str);
        }

        public void onCameraUnavailable(String str) {
            super.onCameraUnavailable(str);
            this.f5233a.f10196e.remove(str);
        }
    }

    /* compiled from: Camera2 */
    /* renamed from: com.google.android.a.c$7 */
    class C21937 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C4072c f5234a;

        C21937(C4072c c4072c) {
            this.f5234a = c4072c;
        }

        public void run() {
            if (this.f5234a.f10194c != null) {
                this.f5234a.f10194c.close();
                this.f5234a.f10194c = null;
            }
            this.f5234a.m12591c();
        }
    }

    /* compiled from: Camera2 */
    /* renamed from: com.google.android.a.c$8 */
    class C21948 extends CaptureCallback {
        /* renamed from: a */
        final /* synthetic */ C4072c f5235a;

        C21948(C4072c c4072c) {
            this.f5235a = c4072c;
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            this.f5235a.m12576B();
        }
    }

    /* compiled from: Camera2 */
    /* renamed from: com.google.android.a.c$a */
    private static abstract class C2195a extends CaptureCallback {
        /* renamed from: a */
        private int f5236a;

        /* renamed from: a */
        public abstract void mo2091a();

        /* renamed from: b */
        public abstract void mo2092b();

        C2195a() {
        }

        /* renamed from: a */
        void m6033a(int i) {
            this.f5236a = i;
        }

        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            m6031a(captureResult);
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            m6031a((CaptureResult) totalCaptureResult);
        }

        /* renamed from: a */
        private void m6031a(CaptureResult captureResult) {
            int i = this.f5236a;
            Integer num;
            if (i != 1) {
                switch (i) {
                    case 3:
                        num = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                        if (num == null || num.intValue() == 5 || num.intValue() == 4 || num.intValue() == 2) {
                            m6033a(4);
                            return;
                        }
                        return;
                    case 4:
                        num = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                        if (num == null || num.intValue() != 5) {
                            m6033a(5);
                            mo2092b();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
            if (num2 != null) {
                if (num2.intValue() == 4 || num2.intValue() == 5) {
                    num = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                    if (num != null) {
                        if (num.intValue() != 2) {
                            m6033a(2);
                            mo2091a();
                            return;
                        }
                    }
                    m6033a(5);
                    mo2092b();
                }
            }
        }
    }

    /* compiled from: Camera2 */
    /* renamed from: com.google.android.a.c$3 */
    class C40703 extends C2195a {
        /* renamed from: a */
        final /* synthetic */ C4072c f10180a;

        C40703(C4072c c4072c) {
            this.f10180a = c4072c;
        }

        /* renamed from: a */
        public void mo2091a() {
            this.f10180a.f10195d.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
            m6033a(3);
            try {
                this.f10180a.f10194c.capture(this.f10180a.f10195d.build(), this, null);
                this.f10180a.f10195d.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
            } catch (Throwable e) {
                Log.e("Camera2", "Failed to run precapture sequence.", e);
            }
        }

        /* renamed from: b */
        public void mo2092b() {
            this.f10180a.m12575A();
        }
    }

    /* compiled from: Camera2 */
    /* renamed from: com.google.android.a.c$6 */
    class C40716 implements C2204a {
        /* renamed from: a */
        final /* synthetic */ C4072c f10181a;

        C40716(C4072c c4072c) {
            this.f10181a = c4072c;
        }

        /* renamed from: a */
        public void mo2057a() {
            this.f10181a.m12591c();
        }

        /* renamed from: b */
        public void mo2058b() {
            this.f10181a.mo2067b();
        }
    }

    static {
        f10182h.put(0, 1);
        f10182h.put(1, 0);
    }

    /* renamed from: b */
    private static byte[] m12574b(Image image) {
        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        ByteBuffer buffer2 = image.getPlanes()[1].getBuffer();
        image = image.getPlanes()[2].getBuffer();
        int remaining = buffer.remaining();
        int remaining2 = buffer2.remaining();
        int remaining3 = image.remaining();
        byte[] bArr = new byte[((remaining + remaining2) + remaining3)];
        buffer.get(bArr, 0, remaining);
        image.get(bArr, remaining, remaining3);
        buffer2.get(bArr, remaining + remaining3, remaining2);
        return bArr;
    }

    C4072c(C2199a c2199a, C2205i c2205i, Context context) {
        super(c2199a, c2205i);
        this.f10197i = (CameraManager) context.getSystemService("camera");
        this.f10197i.registerAvailabilityCallback(new C21925(this), null);
        this.f10205q = this.f10189G != null ? 35 : 256;
        this.g.m6084a(new C40716(this));
    }

    /* renamed from: a */
    boolean mo2065a() {
        if (m12560D()) {
            m12561E();
            mo2071b(this.f10214z);
            this.f10214z = null;
            m12562F();
            m12563G();
            m12564H();
            return true;
        }
        this.f10213y = this.f10214z;
        return false;
    }

    /* renamed from: b */
    void mo2067b() {
        if (this.f10194c != null) {
            this.f10194c.close();
            this.f10194c = null;
        }
        if (this.f10193b != null) {
            this.f10193b.close();
            this.f10193b = null;
        }
        if (this.f10203o != null) {
            this.f10203o.close();
            this.f10203o = null;
        }
        if (this.f10204p != null) {
            this.f10204p.close();
            this.f10204p = null;
        }
        if (this.f10206r != null) {
            this.f10206r.stop();
            this.f10206r.reset();
            this.f10206r.release();
            this.f10206r = null;
            if (this.f10208t) {
                this.f.mo2095a(this.f10207s);
                this.f10208t = false;
            }
        }
    }

    /* renamed from: f */
    boolean mo2076f() {
        return this.f10193b != null;
    }

    /* renamed from: a */
    void mo2061a(int i) {
        if (this.f10212x != i) {
            this.f10212x = i;
            if (mo2076f() != 0) {
                mo2067b();
                mo2065a();
            }
        }
    }

    /* renamed from: g */
    int mo2077g() {
        return this.f10212x;
    }

    /* renamed from: h */
    int mo2078h() {
        return Integer.parseInt(this.f10201m);
    }

    /* renamed from: i */
    Set<C2186a> mo2079i() {
        return this.f10209u.m6101a();
    }

    /* renamed from: a */
    SortedSet<C2210k> mo2059a(C2186a c2186a) {
        return this.f10210v.m6104b(c2186a);
    }

    /* renamed from: a */
    void mo2063a(C2210k c2210k) {
        if (c2210k != null) {
            if (this.f10194c != null) {
                try {
                    this.f10194c.stopRepeating();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
                this.f10194c.close();
                this.f10194c = null;
            }
            if (this.f10203o != null) {
                this.f10203o.close();
            }
            this.f10211w = c2210k;
            m12562F();
            m12591c();
        }
    }

    /* renamed from: j */
    C2210k mo2080j() {
        return this.f10211w;
    }

    /* renamed from: b */
    boolean mo2071b(C2186a c2186a) {
        if (c2186a == null || !this.f10209u.m6106c()) {
            if (!(c2186a == null || c2186a.equals(this.f10213y))) {
                if (this.f10209u.m6101a().contains(c2186a)) {
                    this.f10213y = c2186a;
                    this.f10211w = (C2210k) this.f10210v.m6104b(this.f10213y).last();
                    m12562F();
                    m12563G();
                    if (this.f10194c != null) {
                        this.f10194c.close();
                        this.f10194c = null;
                        m12591c();
                    }
                    return true;
                }
            }
            return false;
        }
        this.f10214z = c2186a;
        return false;
    }

    /* renamed from: k */
    C2186a mo2081k() {
        return this.f10213y;
    }

    /* renamed from: a */
    void mo2064a(boolean r4) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = r3.f10183A;
        if (r0 != r4) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r3.f10183A = r4;
        r4 = r3.f10195d;
        if (r4 == 0) goto L_0x0027;
    L_0x000b:
        r3.m12612v();
        r4 = r3.f10194c;
        if (r4 == 0) goto L_0x0027;
    L_0x0012:
        r4 = r3.f10194c;	 Catch:{ CameraAccessException -> 0x0021 }
        r0 = r3.f10195d;	 Catch:{ CameraAccessException -> 0x0021 }
        r0 = r0.build();	 Catch:{ CameraAccessException -> 0x0021 }
        r1 = r3.f10192a;	 Catch:{ CameraAccessException -> 0x0021 }
        r2 = 0;	 Catch:{ CameraAccessException -> 0x0021 }
        r4.setRepeatingRequest(r0, r1, r2);	 Catch:{ CameraAccessException -> 0x0021 }
        goto L_0x0027;
    L_0x0021:
        r4 = r3.f10183A;
        r4 = r4 ^ 1;
        r3.f10183A = r4;
    L_0x0027:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.a.c.a(boolean):void");
    }

    /* renamed from: l */
    boolean mo2082l() {
        return this.f10183A;
    }

    /* renamed from: b */
    void mo2069b(int r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r4 = this;
        r0 = r4.f10184B;
        if (r0 != r5) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r4.f10184B;
        r4.f10184B = r5;
        r5 = r4.f10195d;
        if (r5 == 0) goto L_0x0025;
    L_0x000d:
        r4.m12613w();
        r5 = r4.f10194c;
        if (r5 == 0) goto L_0x0025;
    L_0x0014:
        r5 = r4.f10194c;	 Catch:{ CameraAccessException -> 0x0023 }
        r1 = r4.f10195d;	 Catch:{ CameraAccessException -> 0x0023 }
        r1 = r1.build();	 Catch:{ CameraAccessException -> 0x0023 }
        r2 = r4.f10192a;	 Catch:{ CameraAccessException -> 0x0023 }
        r3 = 0;	 Catch:{ CameraAccessException -> 0x0023 }
        r5.setRepeatingRequest(r1, r2, r3);	 Catch:{ CameraAccessException -> 0x0023 }
        goto L_0x0025;
    L_0x0023:
        r4.f10184B = r0;
    L_0x0025:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.a.c.b(int):void");
    }

    /* renamed from: m */
    int mo2083m() {
        return this.f10184B;
    }

    /* renamed from: r */
    void mo2088r() {
        if (this.f10183A) {
            m12566J();
        } else {
            m12575A();
        }
    }

    /* renamed from: a */
    boolean mo2066a(String str, int i, int i2, boolean z, CamcorderProfile camcorderProfile) {
        if (this.f10208t) {
            return false;
        }
        m12573b(str, i, i2, z, camcorderProfile);
        try {
            this.f10206r.prepare();
            if (this.f10194c != null) {
                this.f10194c.close();
                this.f10194c = null;
            }
            str = m12565I();
            this.g.mo2106a(str.m6098a(), str.m6100b());
            str = m12609s();
            i2 = this.f10206r.getSurface();
            this.f10195d = this.f10193b.createCaptureRequest(3);
            this.f10195d.addTarget(str);
            this.f10195d.addTarget(i2);
            this.f10193b.createCaptureSession(Arrays.asList(new Surface[]{str, i2}), this.f10199k, null);
            this.f10206r.start();
            this.f10208t = true;
            return true;
        } catch (String str2) {
            str2.printStackTrace();
            return false;
        }
    }

    /* renamed from: t */
    void mo2089t() {
        if (this.f10208t) {
            m12568L();
            if (this.f10194c != null) {
                this.f10194c.close();
                this.f10194c = null;
            }
            m12591c();
        }
    }

    /* renamed from: a */
    public void mo2060a(float r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r4 = this;
        r0 = r4.f10186D;
        r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r4.f10186D;
        r4.f10186D = r5;
        r5 = r4.f10194c;
        if (r5 == 0) goto L_0x0023;
    L_0x000f:
        r4.m12614x();
        r5 = r4.f10194c;	 Catch:{ CameraAccessException -> 0x0021 }
        r1 = r4.f10195d;	 Catch:{ CameraAccessException -> 0x0021 }
        r1 = r1.build();	 Catch:{ CameraAccessException -> 0x0021 }
        r2 = r4.f10192a;	 Catch:{ CameraAccessException -> 0x0021 }
        r3 = 0;	 Catch:{ CameraAccessException -> 0x0021 }
        r5.setRepeatingRequest(r1, r2, r3);	 Catch:{ CameraAccessException -> 0x0021 }
        goto L_0x0023;
    L_0x0021:
        r4.f10186D = r0;
    L_0x0023:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.a.c.a(float):void");
    }

    /* renamed from: n */
    float mo2084n() {
        return this.f10186D;
    }

    /* renamed from: b */
    public void mo2068b(float r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r4 = this;
        r0 = r4.f10187E;
        r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r4.f10187E;
        r4.f10187E = r5;
        r5 = r4.f10194c;
        if (r5 == 0) goto L_0x0023;
    L_0x000f:
        r4.m12615y();
        r5 = r4.f10194c;	 Catch:{ CameraAccessException -> 0x0021 }
        r1 = r4.f10195d;	 Catch:{ CameraAccessException -> 0x0021 }
        r1 = r1.build();	 Catch:{ CameraAccessException -> 0x0021 }
        r2 = r4.f10192a;	 Catch:{ CameraAccessException -> 0x0021 }
        r3 = 0;	 Catch:{ CameraAccessException -> 0x0021 }
        r5.setRepeatingRequest(r1, r2, r3);	 Catch:{ CameraAccessException -> 0x0021 }
        goto L_0x0023;
    L_0x0021:
        r4.f10187E = r0;
    L_0x0023:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.a.c.b(float):void");
    }

    /* renamed from: o */
    float mo2085o() {
        return this.f10187E;
    }

    /* renamed from: c */
    public void mo2072c(int r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r4 = this;
        r0 = r4.f10188F;
        if (r0 != r5) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r4.f10188F;
        r4.f10188F = r5;
        r5 = r4.f10194c;
        if (r5 == 0) goto L_0x0021;
    L_0x000d:
        r4.m12616z();
        r5 = r4.f10194c;	 Catch:{ CameraAccessException -> 0x001f }
        r1 = r4.f10195d;	 Catch:{ CameraAccessException -> 0x001f }
        r1 = r1.build();	 Catch:{ CameraAccessException -> 0x001f }
        r2 = r4.f10192a;	 Catch:{ CameraAccessException -> 0x001f }
        r3 = 0;	 Catch:{ CameraAccessException -> 0x001f }
        r5.setRepeatingRequest(r1, r2, r3);	 Catch:{ CameraAccessException -> 0x001f }
        goto L_0x0021;
    L_0x001f:
        r4.f10188F = r0;
    L_0x0021:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.a.c.c(int):void");
    }

    /* renamed from: p */
    public int mo2086p() {
        return this.f10188F;
    }

    /* renamed from: b */
    void mo2070b(boolean z) {
        if (this.f10189G != z) {
            this.f10189G = z;
            if (this.f10189G) {
                this.f10205q = true;
            } else {
                this.f10205q = true;
            }
            if (this.f10194c) {
                this.f10194c.close();
                this.f10194c = false;
            }
            m12591c();
        }
    }

    /* renamed from: q */
    boolean mo2087q() {
        return this.f10189G;
    }

    /* renamed from: d */
    void mo2074d(int i) {
        this.f10185C = i;
        this.g.mo2101a(this.f10185C);
    }

    /* renamed from: D */
    private boolean m12560D() {
        try {
            int i = f10182h.get(this.f10212x);
            String[] cameraIdList = this.f10197i.getCameraIdList();
            if (cameraIdList.length != 0) {
                int i2;
                for (String str : cameraIdList) {
                    CameraCharacteristics cameraCharacteristics = this.f10197i.getCameraCharacteristics(str);
                    Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
                    if (num != null) {
                        if (num.intValue() != 2) {
                            Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                            if (num2 == null) {
                                throw new NullPointerException("Unexpected state: LENS_FACING null");
                            } else if (num2.intValue() == i) {
                                this.f10201m = str;
                                this.f10202n = cameraCharacteristics;
                                return true;
                            }
                        }
                    }
                }
                this.f10201m = cameraIdList[0];
                this.f10202n = this.f10197i.getCameraCharacteristics(this.f10201m);
                Integer num3 = (Integer) this.f10202n.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
                if (num3 != null) {
                    if (num3.intValue() != 2) {
                        num3 = (Integer) this.f10202n.get(CameraCharacteristics.LENS_FACING);
                        if (num3 != null) {
                            int size = f10182h.size();
                            for (i2 = 0; i2 < size; i2++) {
                                if (f10182h.valueAt(i2) == num3.intValue()) {
                                    this.f10212x = f10182h.keyAt(i2);
                                    return true;
                                }
                            }
                            this.f10212x = 0;
                            return true;
                        }
                        throw new NullPointerException("Unexpected state: LENS_FACING null");
                    }
                }
                return false;
            }
            throw new RuntimeException("No camera available.");
        } catch (Throwable e) {
            throw new RuntimeException("Failed to get a list of camera devices", e);
        }
    }

    /* renamed from: E */
    private void m12561E() {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.f10202n.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            this.f10209u.m6105b();
            for (Size size : streamConfigurationMap.getOutputSizes(this.g.mo2103c())) {
                int width = size.getWidth();
                int height = size.getHeight();
                if (width <= 1920 && height <= 1080) {
                    this.f10209u.m6103a(new C2210k(width, height));
                }
            }
            this.f10210v.m6105b();
            mo3176a(this.f10210v, streamConfigurationMap);
            if (this.f10211w == null) {
                this.f10211w = (C2210k) this.f10210v.m6104b(this.f10213y).last();
            }
            for (C2186a c2186a : this.f10209u.m6101a()) {
                if (!this.f10210v.m6101a().contains(c2186a)) {
                    this.f10209u.m6102a(c2186a);
                }
            }
            if (!this.f10209u.m6101a().contains(this.f10213y)) {
                this.f10213y = (C2186a) this.f10209u.m6101a().iterator().next();
                return;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to get configuration map: ");
        stringBuilder.append(this.f10201m);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: a */
    protected void mo3176a(C2211l c2211l, StreamConfigurationMap streamConfigurationMap) {
        for (Size size : streamConfigurationMap.getOutputSizes(this.f10205q)) {
            this.f10210v.m6103a(new C2210k(size.getWidth(), size.getHeight()));
        }
    }

    /* renamed from: F */
    private void m12562F() {
        if (this.f10203o != null) {
            this.f10203o.close();
        }
        this.f10203o = ImageReader.newInstance(this.f10211w.m6098a(), this.f10211w.m6100b(), 256, 1);
        this.f10203o.setOnImageAvailableListener(this.f10200l, null);
    }

    /* renamed from: G */
    private void m12563G() {
        if (this.f10204p != null) {
            this.f10204p.close();
        }
        C2210k c2210k = (C2210k) this.f10209u.m6104b(this.f10213y).last();
        this.f10204p = ImageReader.newInstance(c2210k.m6098a(), c2210k.m6100b(), 35, 1);
        this.f10204p.setOnImageAvailableListener(this.f10200l, null);
    }

    /* renamed from: H */
    private void m12564H() {
        try {
            this.f10197i.openCamera(this.f10201m, this.f10198j, null);
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to open camera: ");
            stringBuilder.append(this.f10201m);
            throw new RuntimeException(stringBuilder.toString(), e);
        }
    }

    /* renamed from: c */
    void m12591c() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r5 = this;
        r0 = r5.mo2076f();
        if (r0 == 0) goto L_0x0073;
    L_0x0006:
        r0 = r5.g;
        r0 = r0.mo2104d();
        if (r0 == 0) goto L_0x0073;
    L_0x000e:
        r0 = r5.f10203o;
        if (r0 == 0) goto L_0x0073;
    L_0x0012:
        r0 = r5.f10204p;
        if (r0 != 0) goto L_0x0017;
    L_0x0016:
        goto L_0x0073;
    L_0x0017:
        r0 = r5.m12565I();
        r1 = r5.g;
        r2 = r0.m6098a();
        r0 = r0.m6100b();
        r1.mo2106a(r2, r0);
        r0 = r5.m12609s();
        r1 = r5.f10193b;	 Catch:{ CameraAccessException -> 0x006d }
        r2 = 1;	 Catch:{ CameraAccessException -> 0x006d }
        r1 = r1.createCaptureRequest(r2);	 Catch:{ CameraAccessException -> 0x006d }
        r5.f10195d = r1;	 Catch:{ CameraAccessException -> 0x006d }
        r1 = r5.f10195d;	 Catch:{ CameraAccessException -> 0x006d }
        r1.addTarget(r0);	 Catch:{ CameraAccessException -> 0x006d }
        r1 = r5.f10189G;	 Catch:{ CameraAccessException -> 0x006d }
        if (r1 == 0) goto L_0x0049;	 Catch:{ CameraAccessException -> 0x006d }
    L_0x003e:
        r1 = r5.f10195d;	 Catch:{ CameraAccessException -> 0x006d }
        r3 = r5.f10204p;	 Catch:{ CameraAccessException -> 0x006d }
        r3 = r3.getSurface();	 Catch:{ CameraAccessException -> 0x006d }
        r1.addTarget(r3);	 Catch:{ CameraAccessException -> 0x006d }
    L_0x0049:
        r1 = r5.f10193b;	 Catch:{ CameraAccessException -> 0x006d }
        r3 = 3;	 Catch:{ CameraAccessException -> 0x006d }
        r3 = new android.view.Surface[r3];	 Catch:{ CameraAccessException -> 0x006d }
        r4 = 0;	 Catch:{ CameraAccessException -> 0x006d }
        r3[r4] = r0;	 Catch:{ CameraAccessException -> 0x006d }
        r0 = r5.f10203o;	 Catch:{ CameraAccessException -> 0x006d }
        r0 = r0.getSurface();	 Catch:{ CameraAccessException -> 0x006d }
        r3[r2] = r0;	 Catch:{ CameraAccessException -> 0x006d }
        r0 = 2;	 Catch:{ CameraAccessException -> 0x006d }
        r2 = r5.f10204p;	 Catch:{ CameraAccessException -> 0x006d }
        r2 = r2.getSurface();	 Catch:{ CameraAccessException -> 0x006d }
        r3[r0] = r2;	 Catch:{ CameraAccessException -> 0x006d }
        r0 = java.util.Arrays.asList(r3);	 Catch:{ CameraAccessException -> 0x006d }
        r2 = r5.f10199k;	 Catch:{ CameraAccessException -> 0x006d }
        r3 = 0;	 Catch:{ CameraAccessException -> 0x006d }
        r1.createCaptureSession(r0, r2, r3);	 Catch:{ CameraAccessException -> 0x006d }
        goto L_0x0072;
    L_0x006d:
        r0 = r5.f;
        r0.mo2099c();
    L_0x0072:
        return;
    L_0x0073:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.a.c.c():void");
    }

    /* renamed from: d */
    public void mo2073d() {
        m12591c();
    }

    /* renamed from: e */
    public void mo2075e() {
        try {
            this.f10194c.stopRepeating();
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: s */
    public Surface m12609s() {
        if (this.f10190H != null) {
            return this.f10190H;
        }
        return this.g.mo2100a();
    }

    /* renamed from: a */
    public void mo2062a(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null) {
            this.f10190H = new Surface(surfaceTexture);
        } else {
            this.f10190H = null;
        }
        new Handler(Looper.getMainLooper()).post(new C21937(this));
    }

    /* renamed from: u */
    public C2210k mo2090u() {
        return new C2210k(this.g.m6093i(), this.g.m6094j());
    }

    /* renamed from: I */
    private C2210k m12565I() {
        int i = this.g.m6093i();
        int j = this.g.m6094j();
        if (i < j) {
            int i2 = j;
            j = i;
            i = i2;
        }
        SortedSet<C2210k> b = this.f10209u.m6104b(this.f10213y);
        for (C2210k c2210k : b) {
            if (c2210k.m6098a() >= i && c2210k.m6100b() >= r1) {
                return c2210k;
            }
        }
        return (C2210k) b.last();
    }

    /* renamed from: v */
    void m12612v() {
        if (this.f10183A) {
            int[] iArr = (int[]) this.f10202n.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
            if (!(iArr == null || iArr.length == 0)) {
                if (iArr.length != 1 || iArr[0] != 0) {
                    this.f10195d.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
                    return;
                }
            }
            this.f10183A = false;
            this.f10195d.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(0));
            return;
        }
        this.f10195d.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(0));
    }

    /* renamed from: w */
    void m12613w() {
        switch (this.f10184B) {
            case 0:
                this.f10195d.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
                this.f10195d.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
                return;
            case 1:
                this.f10195d.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(3));
                this.f10195d.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
                return;
            case 2:
                this.f10195d.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
                this.f10195d.set(CaptureRequest.FLASH_MODE, Integer.valueOf(2));
                return;
            case 3:
                this.f10195d.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(2));
                this.f10195d.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
                return;
            case 4:
                this.f10195d.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(4));
                this.f10195d.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
                return;
            default:
                return;
        }
    }

    /* renamed from: x */
    void m12614x() {
        if (!this.f10183A) {
            Float f = (Float) this.f10202n.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
            if (f != null) {
                this.f10195d.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(this.f10186D * f.floatValue()));
                return;
            }
            throw new NullPointerException("Unexpected state: LENS_INFO_MINIMUM_FOCUS_DISTANCE null");
        }
    }

    /* renamed from: y */
    void m12615y() {
        float floatValue = (this.f10187E * (((Float) this.f10202n.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue() - 1.0f)) + 1.0f;
        Rect rect = (Rect) this.f10202n.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (rect != null) {
            int width = rect.width();
            int height = rect.height();
            width = (width - ((int) (((float) width) / floatValue))) / 2;
            height = (height - ((int) (((float) height) / floatValue))) / 2;
            Rect rect2 = new Rect(rect.left + width, rect.top + height, rect.right - width, rect.bottom - height);
            if (floatValue != 1.0f) {
                this.f10195d.set(CaptureRequest.SCALER_CROP_REGION, rect2);
            } else {
                this.f10195d.set(CaptureRequest.SCALER_CROP_REGION, this.f10191I);
            }
        }
    }

    /* renamed from: z */
    void m12616z() {
        switch (this.f10188F) {
            case 0:
                this.f10195d.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(1));
                return;
            case 1:
                this.f10195d.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(6));
                return;
            case 2:
                this.f10195d.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(5));
                return;
            case 3:
                this.f10195d.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(8));
                return;
            case 4:
                this.f10195d.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(3));
                return;
            case 5:
                this.f10195d.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(2));
                return;
            default:
                return;
        }
    }

    /* renamed from: J */
    private void m12566J() {
        this.f10195d.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
        try {
            this.f10192a.m6033a(1);
            this.f10194c.capture(this.f10195d.build(), this.f10192a, null);
        } catch (Throwable e) {
            Log.e("Camera2", "Failed to lock focus.", e);
        }
    }

    /* renamed from: A */
    void m12575A() {
        try {
            Builder createCaptureRequest = this.f10193b.createCaptureRequest(2);
            if (this.f10189G) {
                this.f10205q = 256;
                createCaptureRequest.removeTarget(this.f10204p.getSurface());
            }
            createCaptureRequest.addTarget(this.f10203o.getSurface());
            createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, this.f10195d.get(CaptureRequest.CONTROL_AF_MODE));
            switch (this.f10184B) {
                case 0:
                    createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
                    createCaptureRequest.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
                    break;
                case 1:
                    createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(3));
                    break;
                case 2:
                    createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
                    createCaptureRequest.set(CaptureRequest.FLASH_MODE, Integer.valueOf(2));
                    break;
                case 3:
                    createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(2));
                    break;
                case 4:
                    createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(2));
                    break;
                default:
                    break;
            }
            createCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(m12567K()));
            createCaptureRequest.set(CaptureRequest.SCALER_CROP_REGION, this.f10195d.get(CaptureRequest.SCALER_CROP_REGION));
            this.f10194c.stopRepeating();
            this.f10194c.capture(createCaptureRequest.build(), new C21948(this), null);
        } catch (Throwable e) {
            Log.e("Camera2", "Cannot capture a still picture.", e);
        }
    }

    /* renamed from: K */
    private int m12567K() {
        int intValue = ((Integer) this.f10202n.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        int i = this.f10185C;
        int i2 = 1;
        if (this.f10212x != 1) {
            i2 = -1;
        }
        return ((intValue + (i * i2)) + 360) % 360;
    }

    /* renamed from: b */
    private void m12573b(String str, int i, int i2, boolean z, CamcorderProfile camcorderProfile) {
        this.f10206r = new MediaRecorder();
        this.f10206r.setVideoSource(2);
        if (z) {
            this.f10206r.setAudioSource(1);
        }
        this.f10206r.setOutputFile(str);
        this.f10207s = str;
        if (CamcorderProfile.hasProfile(mo2078h(), camcorderProfile.quality) != null) {
            m12571a(camcorderProfile, z);
        } else {
            m12571a(CamcorderProfile.get(mo2078h(), 1), z);
        }
        this.f10206r.setOrientationHint(m12567K());
        if (i != -1) {
            this.f10206r.setMaxDuration(i);
        }
        if (i2 != -1) {
            this.f10206r.setMaxFileSize((long) i2);
        }
        this.f10206r.setOnInfoListener(this);
        this.f10206r.setOnErrorListener(this);
    }

    /* renamed from: a */
    private void m12571a(CamcorderProfile camcorderProfile, boolean z) {
        this.f10206r.setOutputFormat(camcorderProfile.fileFormat);
        this.f10206r.setVideoFrameRate(camcorderProfile.videoFrameRate);
        this.f10206r.setVideoSize(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
        this.f10206r.setVideoEncodingBitRate(camcorderProfile.videoBitRate);
        this.f10206r.setVideoEncoder(camcorderProfile.videoCodec);
        if (z) {
            this.f10206r.setAudioEncodingBitRate(camcorderProfile.audioBitRate);
            this.f10206r.setAudioChannels(camcorderProfile.audioChannels);
            this.f10206r.setAudioSamplingRate(camcorderProfile.audioSampleRate);
            this.f10206r.setAudioEncoder(camcorderProfile.audioCodec);
        }
    }

    /* renamed from: L */
    private void m12568L() {
        this.f10208t = false;
        try {
            this.f10194c.stopRepeating();
            this.f10194c.abortCaptures();
            this.f10206r.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f10206r.reset();
        this.f10206r.release();
        this.f10206r = null;
        if (this.f10207s != null) {
            if (new File(this.f10207s).exists()) {
                this.f.mo2095a(this.f10207s);
                this.f10207s = null;
                return;
            }
        }
        this.f.mo2095a(null);
    }

    /* renamed from: B */
    void m12576B() {
        this.f10195d.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
        try {
            this.f10194c.capture(this.f10195d.build(), this.f10192a, null);
            m12612v();
            m12613w();
            if (this.f10189G) {
                this.f10205q = 35;
                m12591c();
                return;
            }
            this.f10195d.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(0));
            this.f10194c.setRepeatingRequest(this.f10195d.build(), this.f10192a, null);
            this.f10192a.m6033a(0);
        } catch (Throwable e) {
            Log.e("Camera2", "Failed to restart camera preview.", e);
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
