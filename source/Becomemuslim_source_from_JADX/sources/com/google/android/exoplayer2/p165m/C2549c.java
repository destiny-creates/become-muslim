package com.google.android.exoplayer2.p165m;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2541v;

@TargetApi(17)
/* compiled from: DummySurface */
/* renamed from: com.google.android.exoplayer2.m.c */
public final class C2549c extends Surface {
    /* renamed from: b */
    private static int f6496b;
    /* renamed from: c */
    private static boolean f6497c;
    /* renamed from: a */
    public final boolean f6498a;
    /* renamed from: d */
    private final C2548a f6499d;
    /* renamed from: e */
    private boolean f6500e;

    /* compiled from: DummySurface */
    /* renamed from: com.google.android.exoplayer2.m.c$a */
    private static class C2548a extends HandlerThread implements OnFrameAvailableListener, Callback {
        /* renamed from: a */
        private final int[] f6487a = new int[1];
        /* renamed from: b */
        private EGLDisplay f6488b;
        /* renamed from: c */
        private EGLContext f6489c;
        /* renamed from: d */
        private EGLSurface f6490d;
        /* renamed from: e */
        private Handler f6491e;
        /* renamed from: f */
        private SurfaceTexture f6492f;
        /* renamed from: g */
        private Error f6493g;
        /* renamed from: h */
        private RuntimeException f6494h;
        /* renamed from: i */
        private C2549c f6495i;

        public C2548a() {
            super("dummySurface");
        }

        /* renamed from: a */
        public com.google.android.exoplayer2.p165m.C2549c m7207a(int r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r3 = this;
            r3.start();
            r0 = new android.os.Handler;
            r1 = r3.getLooper();
            r0.<init>(r1, r3);
            r3.f6491e = r0;
            monitor-enter(r3);
            r0 = r3.f6491e;	 Catch:{ all -> 0x0047 }
            r1 = 1;	 Catch:{ all -> 0x0047 }
            r2 = 0;	 Catch:{ all -> 0x0047 }
            r4 = r0.obtainMessage(r1, r4, r2);	 Catch:{ all -> 0x0047 }
            r4.sendToTarget();	 Catch:{ all -> 0x0047 }
        L_0x001a:
            r4 = r3.f6495i;	 Catch:{ all -> 0x0047 }
            if (r4 != 0) goto L_0x002c;	 Catch:{ all -> 0x0047 }
        L_0x001e:
            r4 = r3.f6494h;	 Catch:{ all -> 0x0047 }
            if (r4 != 0) goto L_0x002c;	 Catch:{ all -> 0x0047 }
        L_0x0022:
            r4 = r3.f6493g;	 Catch:{ all -> 0x0047 }
            if (r4 != 0) goto L_0x002c;
        L_0x0026:
            r3.wait();	 Catch:{ InterruptedException -> 0x002a }
            goto L_0x001a;
        L_0x002a:
            r2 = 1;
            goto L_0x001a;
        L_0x002c:
            monitor-exit(r3);	 Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x0036;
        L_0x002f:
            r4 = java.lang.Thread.currentThread();
            r4.interrupt();
        L_0x0036:
            r4 = r3.f6494h;
            if (r4 != 0) goto L_0x0044;
        L_0x003a:
            r4 = r3.f6493g;
            if (r4 != 0) goto L_0x0041;
        L_0x003e:
            r4 = r3.f6495i;
            return r4;
        L_0x0041:
            r4 = r3.f6493g;
            throw r4;
        L_0x0044:
            r4 = r3.f6494h;
            throw r4;
        L_0x0047:
            r4 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0047 }
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.m.c.a.a(int):com.google.android.exoplayer2.m.c");
        }

        /* renamed from: a */
        public void m7208a() {
            this.f6491e.sendEmptyMessage(3);
        }

        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.f6491e.sendEmptyMessage(2);
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    try {
                        m7206b(message.arg1);
                        synchronized (this) {
                            notify();
                        }
                    } catch (Message message2) {
                        Log.e("DummySurface", "Failed to initialize dummy surface", message2);
                        this.f6494h = message2;
                        synchronized (this) {
                            notify();
                        }
                    } catch (Message message22) {
                        try {
                            Log.e("DummySurface", "Failed to initialize dummy surface", message22);
                            this.f6493g = message22;
                            synchronized (this) {
                                notify();
                            }
                        } catch (Throwable th) {
                            synchronized (this) {
                                notify();
                            }
                        }
                    }
                    return true;
                case 2:
                    this.f6492f.updateTexImage();
                    return true;
                case 3:
                    try {
                        m7205b();
                    } catch (Throwable th2) {
                        quit();
                    }
                    quit();
                    return true;
                default:
                    return true;
            }
        }

        /* renamed from: b */
        private void m7206b(int i) {
            int[] iArr;
            EGLSurface eGLSurface;
            boolean z = false;
            this.f6488b = EGL14.eglGetDisplay(0);
            C2516a.m7020b(this.f6488b != null, "eglGetDisplay failed");
            int[] iArr2 = new int[2];
            C2516a.m7020b(EGL14.eglInitialize(this.f6488b, iArr2, 0, iArr2, 1), "eglInitialize failed");
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr3 = new int[1];
            boolean z2 = EGL14.eglChooseConfig(this.f6488b, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr3, 0) && iArr3[0] > 0 && eGLConfigArr[0] != null;
            C2516a.m7020b(z2, "eglChooseConfig failed");
            EGLConfig eGLConfig = eGLConfigArr[0];
            if (i == 0) {
                iArr = new int[]{12440, 2, 12344};
            } else {
                iArr = new int[]{12440, 2, 12992, 1, 12344};
            }
            this.f6489c = EGL14.eglCreateContext(this.f6488b, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
            C2516a.m7020b(this.f6489c != null, "eglCreateContext failed");
            if (i == 1) {
                eGLSurface = EGL14.EGL_NO_SURFACE;
            } else {
                int[] iArr4;
                if (i == 2) {
                    iArr4 = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
                } else {
                    iArr4 = new int[]{12375, 1, 12374, 1, 12344};
                }
                this.f6490d = EGL14.eglCreatePbufferSurface(this.f6488b, eGLConfig, iArr4, 0);
                C2516a.m7020b(this.f6490d != null, "eglCreatePbufferSurface failed");
                eGLSurface = this.f6490d;
            }
            C2516a.m7020b(EGL14.eglMakeCurrent(this.f6488b, eGLSurface, eGLSurface, this.f6489c), "eglMakeCurrent failed");
            GLES20.glGenTextures(1, this.f6487a, 0);
            this.f6492f = new SurfaceTexture(this.f6487a[0]);
            this.f6492f.setOnFrameAvailableListener(this);
            SurfaceTexture surfaceTexture = this.f6492f;
            if (i != 0) {
                z = true;
            }
            this.f6495i = new C2549c(this, surfaceTexture, z);
        }

        /* renamed from: b */
        private void m7205b() {
            try {
                if (this.f6492f != null) {
                    this.f6492f.release();
                    GLES20.glDeleteTextures(1, this.f6487a, 0);
                }
                if (this.f6490d != null) {
                    EGL14.eglDestroySurface(this.f6488b, this.f6490d);
                }
                if (this.f6489c != null) {
                    EGL14.eglDestroyContext(this.f6488b, this.f6489c);
                }
                this.f6490d = null;
                this.f6489c = null;
                this.f6488b = null;
                this.f6495i = null;
                this.f6492f = null;
            } catch (Throwable th) {
                if (this.f6490d != null) {
                    EGL14.eglDestroySurface(this.f6488b, this.f6490d);
                }
                if (this.f6489c != null) {
                    EGL14.eglDestroyContext(this.f6488b, this.f6489c);
                }
                this.f6490d = null;
                this.f6489c = null;
                this.f6488b = null;
                this.f6495i = null;
                this.f6492f = null;
            }
        }
    }

    /* renamed from: a */
    public static synchronized boolean m7211a(Context context) {
        boolean z;
        synchronized (C2549c.class) {
            z = true;
            if (!f6497c) {
                f6496b = C2541v.f6467a < 24 ? null : C2549c.m7212b(context);
                f6497c = true;
            }
            if (f6496b == null) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: a */
    public static C2549c m7209a(Context context, boolean z) {
        C2549c.m7210a();
        int i = 0;
        if (z) {
            if (C2549c.m7211a(context) == null) {
                context = null;
                C2516a.m7019b(context);
                context = new C2548a();
                if (z) {
                    i = f6496b;
                }
                return context.m7207a(i);
            }
        }
        context = true;
        C2516a.m7019b(context);
        context = new C2548a();
        if (z) {
            i = f6496b;
        }
        return context.m7207a(i);
    }

    private C2549c(C2548a c2548a, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.f6499d = c2548a;
        this.f6498a = z;
    }

    public void release() {
        super.release();
        synchronized (this.f6499d) {
            if (!this.f6500e) {
                this.f6499d.m7208a();
                this.f6500e = true;
            }
        }
    }

    /* renamed from: a */
    private static void m7210a() {
        if (C2541v.f6467a < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    @TargetApi(24)
    /* renamed from: b */
    private static int m7212b(Context context) {
        if (C2541v.f6467a < 26 && ("samsung".equals(C2541v.f6469c) || "XT1650".equals(C2541v.f6470d))) {
            return 0;
        }
        if (C2541v.f6467a < 26 && context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance") == null) {
            return 0;
        }
        context = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
        if (context == null || !context.contains("EGL_EXT_protected_content")) {
            return 0;
        }
        return context.contains("EGL_KHR_surfaceless_context") != null ? true : 2;
    }
}
