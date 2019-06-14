package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@TargetApi(14)
@cm
public final class pl extends Thread implements OnFrameAvailableListener, pk {
    /* renamed from: a */
    private static final float[] f24215a = new float[]{-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    /* renamed from: A */
    private volatile boolean f24216A;
    /* renamed from: B */
    private volatile boolean f24217B;
    /* renamed from: b */
    private final pi f24218b;
    /* renamed from: c */
    private final float[] f24219c;
    /* renamed from: d */
    private final float[] f24220d;
    /* renamed from: e */
    private final float[] f24221e;
    /* renamed from: f */
    private final float[] f24222f;
    /* renamed from: g */
    private final float[] f24223g;
    /* renamed from: h */
    private final float[] f24224h;
    /* renamed from: i */
    private final float[] f24225i;
    /* renamed from: j */
    private float f24226j;
    /* renamed from: k */
    private float f24227k;
    /* renamed from: l */
    private float f24228l;
    /* renamed from: m */
    private int f24229m;
    /* renamed from: n */
    private int f24230n;
    /* renamed from: o */
    private SurfaceTexture f24231o;
    /* renamed from: p */
    private SurfaceTexture f24232p;
    /* renamed from: q */
    private int f24233q;
    /* renamed from: r */
    private int f24234r;
    /* renamed from: s */
    private int f24235s;
    /* renamed from: t */
    private FloatBuffer f24236t = ByteBuffer.allocateDirect(f24215a.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
    /* renamed from: u */
    private final CountDownLatch f24237u;
    /* renamed from: v */
    private final Object f24238v;
    /* renamed from: w */
    private EGL10 f24239w;
    /* renamed from: x */
    private EGLDisplay f24240x;
    /* renamed from: y */
    private EGLContext f24241y;
    /* renamed from: z */
    private EGLSurface f24242z;

    public pl(Context context) {
        super("SphericalVideoProcessor");
        this.f24236t.put(f24215a).position(0);
        this.f24219c = new float[9];
        this.f24220d = new float[9];
        this.f24221e = new float[9];
        this.f24222f = new float[9];
        this.f24223g = new float[9];
        this.f24224h = new float[9];
        this.f24225i = new float[9];
        this.f24226j = Float.NaN;
        this.f24218b = new pi(context);
        this.f24218b.m20002a((pk) this);
        this.f24237u = new CountDownLatch(1);
        this.f24238v = new Object();
    }

    /* renamed from: a */
    private static int m30963a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        m30964a("createShader");
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        m30964a("shaderSource");
        GLES20.glCompileShader(glCreateShader);
        m30964a("compileShader");
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        m30964a("getShaderiv");
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("Could not compile shader ");
        stringBuilder.append(i);
        stringBuilder.append(":");
        Log.e("SphericalVideoRenderer", stringBuilder.toString());
        Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        m30964a("deleteShader");
        return 0;
    }

    /* renamed from: a */
    private static void m30964a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 21);
            stringBuilder.append(str);
            stringBuilder.append(": glError ");
            stringBuilder.append(glGetError);
            Log.e("SphericalVideoRenderer", stringBuilder.toString());
        }
    }

    /* renamed from: a */
    private static void m30965a(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d = (double) f;
        fArr[4] = (float) Math.cos(d);
        fArr[5] = (float) (-Math.sin(d));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d);
        fArr[8] = (float) Math.cos(d);
    }

    /* renamed from: a */
    private static void m30966a(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = ((fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3])) + (fArr2[2] * fArr3[6]);
        fArr[1] = ((fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4])) + (fArr2[2] * fArr3[7]);
        fArr[2] = ((fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5])) + (fArr2[2] * fArr3[8]);
        fArr[3] = ((fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3])) + (fArr2[5] * fArr3[6]);
        fArr[4] = ((fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4])) + (fArr2[5] * fArr3[7]);
        fArr[5] = ((fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5])) + (fArr2[5] * fArr3[8]);
        fArr[6] = ((fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3])) + (fArr2[8] * fArr3[6]);
        fArr[7] = ((fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4])) + (fArr2[8] * fArr3[7]);
        fArr[8] = ((fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5])) + (fArr2[8] * fArr3[8]);
    }

    /* renamed from: b */
    private static void m30967b(float[] fArr, float f) {
        double d = (double) f;
        fArr[0] = (float) Math.cos(d);
        fArr[1] = (float) (-Math.sin(d));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d);
        fArr[4] = (float) Math.cos(d);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    /* renamed from: d */
    private final boolean m30968d() {
        boolean z = false;
        if (!(this.f24242z == null || this.f24242z == EGL10.EGL_NO_SURFACE)) {
            z = this.f24239w.eglDestroySurface(this.f24240x, this.f24242z) | (this.f24239w.eglMakeCurrent(this.f24240x, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT) | 0);
            this.f24242z = null;
        }
        if (this.f24241y != null) {
            z |= this.f24239w.eglDestroyContext(this.f24240x, this.f24241y);
            this.f24241y = null;
        }
        if (this.f24240x == null) {
            return z;
        }
        z |= this.f24239w.eglTerminate(this.f24240x);
        this.f24240x = null;
        return z;
    }

    /* renamed from: a */
    public final void mo4336a() {
        synchronized (this.f24238v) {
            this.f24238v.notifyAll();
        }
    }

    /* renamed from: a */
    public final void m30970a(float f, float f2) {
        int i;
        if (this.f24230n > this.f24229m) {
            f = (f * 1.7453293f) / ((float) this.f24230n);
            f2 *= 1.7453293f;
            i = this.f24230n;
        } else {
            f = (f * 1.7453293f) / ((float) this.f24229m);
            f2 *= 1.7453293f;
            i = this.f24229m;
        }
        f2 /= (float) i;
        this.f24227k -= f;
        this.f24228l -= f2;
        if (this.f24228l < -1.5707964f) {
            this.f24228l = -1.5707964f;
        }
        if (this.f24228l > 1.5707964f) {
            this.f24228l = 1.5707964f;
        }
    }

    /* renamed from: a */
    public final void m30971a(int i, int i2) {
        synchronized (this.f24238v) {
            this.f24230n = i;
            this.f24229m = i2;
            this.f24216A = true;
            this.f24238v.notifyAll();
        }
    }

    /* renamed from: a */
    public final void m30972a(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f24230n = i;
        this.f24229m = i2;
        this.f24232p = surfaceTexture;
    }

    /* renamed from: b */
    public final void m30973b() {
        synchronized (this.f24238v) {
            this.f24217B = true;
            this.f24232p = null;
            this.f24238v.notifyAll();
        }
    }

    /* renamed from: c */
    public final android.graphics.SurfaceTexture m30974c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.f24232p;
        if (r0 != 0) goto L_0x0006;
    L_0x0004:
        r0 = 0;
        return r0;
    L_0x0006:
        r0 = r1.f24237u;	 Catch:{ InterruptedException -> 0x000b }
        r0.await();	 Catch:{ InterruptedException -> 0x000b }
    L_0x000b:
        r0 = r1.f24231o;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.pl.c():android.graphics.SurfaceTexture");
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f24235s++;
        synchronized (this.f24238v) {
            this.f24238v.notifyAll();
        }
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r14 = this;
        r0 = r14.f24232p;
        if (r0 != 0) goto L_0x000f;
    L_0x0004:
        r0 = "SphericalVideoProcessor started with no output texture.";
        com.google.android.gms.internal.ads.mt.m19920c(r0);
        r0 = r14.f24237u;
        r0.countDown();
        return;
    L_0x000f:
        r0 = javax.microedition.khronos.egl.EGLContext.getEGL();
        r0 = (javax.microedition.khronos.egl.EGL10) r0;
        r14.f24239w = r0;
        r0 = r14.f24239w;
        r1 = javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY;
        r0 = r0.eglGetDisplay(r1);
        r14.f24240x = r0;
        r0 = r14.f24240x;
        r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY;
        r2 = 3;
        r3 = 2;
        r4 = 0;
        r5 = 1;
        r6 = 0;
        if (r0 != r1) goto L_0x002f;
    L_0x002c:
        r0 = 0;
        goto L_0x00a4;
    L_0x002f:
        r0 = new int[r3];
        r1 = r14.f24239w;
        r7 = r14.f24240x;
        r0 = r1.eglInitialize(r7, r0);
        if (r0 != 0) goto L_0x003c;
    L_0x003b:
        goto L_0x002c;
    L_0x003c:
        r0 = new int[r5];
        r1 = new javax.microedition.khronos.egl.EGLConfig[r5];
        r7 = 11;
        r9 = new int[r7];
        r9 = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344};
        r7 = r14.f24239w;
        r8 = r14.f24240x;
        r11 = 1;
        r10 = r1;
        r12 = r0;
        r7 = r7.eglChooseConfig(r8, r9, r10, r11, r12);
        if (r7 == 0) goto L_0x005b;
    L_0x0054:
        r0 = r0[r6];
        if (r0 <= 0) goto L_0x005b;
    L_0x0058:
        r0 = r1[r6];
        goto L_0x005c;
    L_0x005b:
        r0 = r4;
    L_0x005c:
        if (r0 != 0) goto L_0x005f;
    L_0x005e:
        goto L_0x002c;
    L_0x005f:
        r1 = new int[r2];
        r1 = {12440, 2, 12344};
        r7 = r14.f24239w;
        r8 = r14.f24240x;
        r9 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT;
        r1 = r7.eglCreateContext(r8, r0, r9, r1);
        r14.f24241y = r1;
        r1 = r14.f24241y;
        if (r1 == 0) goto L_0x002c;
    L_0x0074:
        r1 = r14.f24241y;
        r7 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT;
        if (r1 != r7) goto L_0x007b;
    L_0x007a:
        goto L_0x002c;
    L_0x007b:
        r1 = r14.f24239w;
        r7 = r14.f24240x;
        r8 = r14.f24232p;
        r0 = r1.eglCreateWindowSurface(r7, r0, r8, r4);
        r14.f24242z = r0;
        r0 = r14.f24242z;
        if (r0 == 0) goto L_0x002c;
    L_0x008b:
        r0 = r14.f24242z;
        r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE;
        if (r0 != r1) goto L_0x0092;
    L_0x0091:
        goto L_0x002c;
    L_0x0092:
        r0 = r14.f24239w;
        r1 = r14.f24240x;
        r7 = r14.f24242z;
        r8 = r14.f24242z;
        r9 = r14.f24241y;
        r0 = r0.eglMakeCurrent(r1, r7, r8, r9);
        if (r0 != 0) goto L_0x00a3;
    L_0x00a2:
        goto L_0x002c;
    L_0x00a3:
        r0 = 1;
    L_0x00a4:
        r1 = 35633; // 0x8b31 float:4.9932E-41 double:1.7605E-319;
        r7 = com.google.android.gms.internal.ads.asp.bj;
        r8 = com.google.android.gms.internal.ads.aph.m18688f();
        r8 = r8.m18889a(r7);
        r8 = (java.lang.String) r8;
        r9 = r7.m18880b();
        r8 = r8.equals(r9);
        if (r8 != 0) goto L_0x00c8;
    L_0x00bd:
        r8 = com.google.android.gms.internal.ads.aph.m18688f();
        r7 = r8.m18889a(r7);
        r7 = (java.lang.String) r7;
        goto L_0x00ca;
    L_0x00c8:
        r7 = "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}";
    L_0x00ca:
        r1 = m30963a(r1, r7);
        if (r1 != 0) goto L_0x00d3;
    L_0x00d0:
        r8 = 0;
        goto L_0x0155;
    L_0x00d3:
        r7 = 35632; // 0x8b30 float:4.9931E-41 double:1.76045E-319;
        r8 = com.google.android.gms.internal.ads.asp.bk;
        r9 = com.google.android.gms.internal.ads.aph.m18688f();
        r9 = r9.m18889a(r8);
        r9 = (java.lang.String) r9;
        r10 = r8.m18880b();
        r9 = r9.equals(r10);
        if (r9 != 0) goto L_0x00f7;
    L_0x00ec:
        r9 = com.google.android.gms.internal.ads.aph.m18688f();
        r8 = r9.m18889a(r8);
        r8 = (java.lang.String) r8;
        goto L_0x00f9;
    L_0x00f7:
        r8 = "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}";
    L_0x00f9:
        r7 = m30963a(r7, r8);
        if (r7 != 0) goto L_0x0100;
    L_0x00ff:
        goto L_0x00d0;
    L_0x0100:
        r8 = android.opengl.GLES20.glCreateProgram();
        r9 = "createProgram";
        m30964a(r9);
        if (r8 == 0) goto L_0x0155;
    L_0x010b:
        android.opengl.GLES20.glAttachShader(r8, r1);
        r1 = "attachShader";
        m30964a(r1);
        android.opengl.GLES20.glAttachShader(r8, r7);
        r1 = "attachShader";
        m30964a(r1);
        android.opengl.GLES20.glLinkProgram(r8);
        r1 = "linkProgram";
        m30964a(r1);
        r1 = new int[r5];
        r7 = 35714; // 0x8b82 float:5.0046E-41 double:1.7645E-319;
        android.opengl.GLES20.glGetProgramiv(r8, r7, r1, r6);
        r7 = "getProgramiv";
        m30964a(r7);
        r1 = r1[r6];
        if (r1 == r5) goto L_0x014d;
    L_0x0134:
        r1 = "SphericalVideoRenderer";
        r7 = "Could not link program: ";
        android.util.Log.e(r1, r7);
        r1 = "SphericalVideoRenderer";
        r7 = android.opengl.GLES20.glGetProgramInfoLog(r8);
        android.util.Log.e(r1, r7);
        android.opengl.GLES20.glDeleteProgram(r8);
        r1 = "deleteProgram";
        m30964a(r1);
        goto L_0x00d0;
    L_0x014d:
        android.opengl.GLES20.glValidateProgram(r8);
        r1 = "validateProgram";
        m30964a(r1);
    L_0x0155:
        r14.f24233q = r8;
        r1 = r14.f24233q;
        android.opengl.GLES20.glUseProgram(r1);
        r1 = "useProgram";
        m30964a(r1);
        r1 = r14.f24233q;
        r7 = "aPosition";
        r1 = android.opengl.GLES20.glGetAttribLocation(r1, r7);
        r9 = 3;
        r10 = 5126; // 0x1406 float:7.183E-42 double:2.5326E-320;
        r11 = 0;
        r12 = 12;
        r13 = r14.f24236t;
        r8 = r1;
        android.opengl.GLES20.glVertexAttribPointer(r8, r9, r10, r11, r12, r13);
        r7 = "vertexAttribPointer";
        m30964a(r7);
        android.opengl.GLES20.glEnableVertexAttribArray(r1);
        r1 = "enableVertexAttribArray";
        m30964a(r1);
        r1 = new int[r5];
        android.opengl.GLES20.glGenTextures(r5, r1, r6);
        r7 = "genTextures";
        m30964a(r7);
        r1 = r1[r6];
        r7 = 36197; // 0x8d65 float:5.0723E-41 double:1.78837E-319;
        android.opengl.GLES20.glBindTexture(r7, r1);
        r8 = "bindTextures";
        m30964a(r8);
        r8 = 10240; // 0x2800 float:1.4349E-41 double:5.059E-320;
        r9 = 9729; // 0x2601 float:1.3633E-41 double:4.807E-320;
        android.opengl.GLES20.glTexParameteri(r7, r8, r9);
        r8 = "texParameteri";
        m30964a(r8);
        r8 = 10241; // 0x2801 float:1.435E-41 double:5.0597E-320;
        android.opengl.GLES20.glTexParameteri(r7, r8, r9);
        r8 = "texParameteri";
        m30964a(r8);
        r8 = 10242; // 0x2802 float:1.4352E-41 double:5.06E-320;
        r9 = 33071; // 0x812f float:4.6342E-41 double:1.6339E-319;
        android.opengl.GLES20.glTexParameteri(r7, r8, r9);
        r8 = "texParameteri";
        m30964a(r8);
        r8 = 10243; // 0x2803 float:1.4354E-41 double:5.0607E-320;
        android.opengl.GLES20.glTexParameteri(r7, r8, r9);
        r7 = "texParameteri";
        m30964a(r7);
        r7 = r14.f24233q;
        r8 = "uVMat";
        r7 = android.opengl.GLES20.glGetUniformLocation(r7, r8);
        r14.f24234r = r7;
        r7 = 9;
        r7 = new float[r7];
        r7 = {1065353216, 0, 0, 0, 1065353216, 0, 0, 0, 1065353216};
        r8 = r14.f24234r;
        android.opengl.GLES20.glUniformMatrix3fv(r8, r5, r6, r7, r6);
        r7 = r14.f24233q;
        if (r7 == 0) goto L_0x01e2;
    L_0x01e0:
        r7 = 1;
        goto L_0x01e3;
    L_0x01e2:
        r7 = 0;
    L_0x01e3:
        if (r0 == 0) goto L_0x039f;
    L_0x01e5:
        if (r7 != 0) goto L_0x01e9;
    L_0x01e7:
        goto L_0x039f;
    L_0x01e9:
        r0 = new android.graphics.SurfaceTexture;
        r0.<init>(r1);
        r14.f24231o = r0;
        r0 = r14.f24231o;
        r0.setOnFrameAvailableListener(r14);
        r0 = r14.f24237u;
        r0.countDown();
        r0 = r14.f24218b;
        r0.m20001a();
        r14.f24216A = r5;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
    L_0x0201:
        r0 = r14.f24217B;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        if (r0 != 0) goto L_0x0349;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
    L_0x0205:
        r0 = r14.f24235s;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        if (r0 <= 0) goto L_0x0214;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
    L_0x0209:
        r0 = r14.f24231o;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0.updateTexImage();	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r14.f24235s;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r0 - r5;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r14.f24235s = r0;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        goto L_0x0205;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
    L_0x0214:
        r0 = r14.f24218b;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r1 = r14.f24219c;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r0.m20003a(r1);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r1 = 5;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r7 = 4;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r8 = 1070141403; // 0x3fc90fdb float:1.5707964 double:5.287201034E-315;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        if (r0 == 0) goto L_0x0294;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
    L_0x0223:
        r0 = r14.f24226j;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = java.lang.Float.isNaN(r0);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        if (r0 == 0) goto L_0x0289;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
    L_0x022b:
        r0 = r14.f24219c;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r9 = new float[r2];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r9 = {0, 1065353216, 0};	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r10 = new float[r2];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r11 = r0[r6];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r12 = r9[r6];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r11 = r11 * r12;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r12 = r0[r5];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r13 = r9[r5];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r12 = r12 * r13;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r11 = r11 + r12;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r12 = r0[r3];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r13 = r9[r3];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r12 = r12 * r13;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r11 = r11 + r12;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r10[r6] = r11;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r11 = r0[r2];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r12 = r9[r6];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r11 = r11 * r12;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r12 = r0[r7];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r13 = r9[r5];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r12 = r12 * r13;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r11 = r11 + r12;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r12 = r0[r1];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r13 = r9[r3];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r12 = r12 * r13;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r11 = r11 + r12;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r10[r5] = r11;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r11 = 6;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r11 = r0[r11];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r12 = r9[r6];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r11 = r11 * r12;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r12 = 7;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r12 = r0[r12];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r13 = r9[r5];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r12 = r12 * r13;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r11 = r11 + r12;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r12 = 8;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r0[r12];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r9 = r9[r3];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r0 * r9;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r11 = r11 + r0;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r10[r3] = r11;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r10[r5];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r11 = (double) r0;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r10[r6];	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r9 = (double) r0;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r9 = java.lang.Math.atan2(r11, r9);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = (float) r9;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r0 - r8;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = -r0;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r14.f24226j = r0;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
    L_0x0289:
        r0 = r14.f24224h;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r9 = r14.f24226j;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r10 = r14.f24227k;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r9 = r9 + r10;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        m30967b(r0, r9);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        goto L_0x02a3;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
    L_0x0294:
        r0 = r14.f24219c;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r9 = -1077342245; // 0xffffffffbfc90fdb float:-1.5707964 double:NaN;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        m30965a(r0, r9);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r14.f24224h;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r9 = r14.f24227k;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        m30967b(r0, r9);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
    L_0x02a3:
        r0 = r14.f24220d;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        m30965a(r0, r8);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r14.f24221e;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r8 = r14.f24224h;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r9 = r14.f24220d;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        m30966a(r0, r8, r9);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r14.f24222f;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r8 = r14.f24219c;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r9 = r14.f24221e;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        m30966a(r0, r8, r9);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r14.f24223g;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r8 = r14.f24228l;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        m30965a(r0, r8);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r14.f24225i;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r8 = r14.f24223g;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r9 = r14.f24222f;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        m30966a(r0, r8, r9);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r14.f24234r;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r8 = r14.f24225i;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        android.opengl.GLES20.glUniformMatrix3fv(r0, r5, r6, r8, r6);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        android.opengl.GLES20.glDrawArrays(r1, r6, r7);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = "drawArrays";	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        m30964a(r0);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        android.opengl.GLES20.glFinish();	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r14.f24239w;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r1 = r14.f24240x;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r7 = r14.f24242z;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0.eglSwapBuffers(r1, r7);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r14.f24216A;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        if (r0 == 0) goto L_0x032f;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
    L_0x02e9:
        r0 = r14.f24230n;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r1 = r14.f24229m;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        android.opengl.GLES20.glViewport(r6, r6, r0, r1);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = "viewport";	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        m30964a(r0);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r14.f24233q;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r1 = "uFOVx";	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = android.opengl.GLES20.glGetUniformLocation(r0, r1);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r1 = r14.f24233q;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r7 = "uFOVy";	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r1 = android.opengl.GLES20.glGetUniformLocation(r1, r7);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r7 = r14.f24230n;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r8 = r14.f24229m;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r9 = 1063216883; // 0x3f5f66f3 float:0.87266463 double:5.25298936E-315;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        if (r7 <= r8) goto L_0x031e;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
    L_0x030e:
        android.opengl.GLES20.glUniform1f(r0, r9);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r14.f24229m;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = (float) r0;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r0 * r9;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r7 = r14.f24230n;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r7 = (float) r7;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r0 = r0 / r7;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        android.opengl.GLES20.glUniform1f(r1, r0);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        goto L_0x032d;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
    L_0x031e:
        r7 = r14.f24230n;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r7 = (float) r7;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r7 = r7 * r9;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r8 = r14.f24229m;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r8 = (float) r8;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        r7 = r7 / r8;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        android.opengl.GLES20.glUniform1f(r0, r7);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        android.opengl.GLES20.glUniform1f(r1, r9);	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
    L_0x032d:
        r14.f24216A = r6;	 Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
    L_0x032f:
        r0 = r14.f24238v;	 Catch:{ InterruptedException -> 0x0201 }
        monitor-enter(r0);	 Catch:{ InterruptedException -> 0x0201 }
        r1 = r14.f24217B;	 Catch:{ all -> 0x0346 }
        if (r1 != 0) goto L_0x0343;	 Catch:{ all -> 0x0346 }
    L_0x0336:
        r1 = r14.f24216A;	 Catch:{ all -> 0x0346 }
        if (r1 != 0) goto L_0x0343;	 Catch:{ all -> 0x0346 }
    L_0x033a:
        r1 = r14.f24235s;	 Catch:{ all -> 0x0346 }
        if (r1 != 0) goto L_0x0343;	 Catch:{ all -> 0x0346 }
    L_0x033e:
        r1 = r14.f24238v;	 Catch:{ all -> 0x0346 }
        r1.wait();	 Catch:{ all -> 0x0346 }
    L_0x0343:
        monitor-exit(r0);	 Catch:{ all -> 0x0346 }
        goto L_0x0201;	 Catch:{ all -> 0x0346 }
    L_0x0346:
        r1 = move-exception;	 Catch:{ all -> 0x0346 }
        monitor-exit(r0);	 Catch:{ all -> 0x0346 }
        throw r1;	 Catch:{ InterruptedException -> 0x0201 }
    L_0x0349:
        r0 = r14.f24218b;
        r0.m20004b();
        r0 = r14.f24231o;
        r0.setOnFrameAvailableListener(r4);
        r14.f24231o = r4;
        r14.m30968d();
        return;
    L_0x0359:
        r0 = move-exception;
        goto L_0x038f;
    L_0x035b:
        r0 = move-exception;
        r1 = "SphericalVideoProcessor died.";	 Catch:{ all -> 0x0359 }
        com.google.android.gms.internal.ads.mt.m19919b(r1, r0);	 Catch:{ all -> 0x0359 }
        r1 = com.google.android.gms.ads.internal.ax.i();	 Catch:{ all -> 0x0359 }
        r2 = "SphericalVideoProcessor.run.2";	 Catch:{ all -> 0x0359 }
        r1.m30834a(r0, r2);	 Catch:{ all -> 0x0359 }
        r0 = r14.f24218b;
        r0.m20004b();
        r0 = r14.f24231o;
        r0.setOnFrameAvailableListener(r4);
        r14.f24231o = r4;
        r14.m30968d();
        return;
    L_0x037a:
        r0 = "SphericalVideoProcessor halted unexpectedly.";	 Catch:{ all -> 0x0359 }
        com.google.android.gms.internal.ads.mt.m19924e(r0);	 Catch:{ all -> 0x0359 }
        r0 = r14.f24218b;
        r0.m20004b();
        r0 = r14.f24231o;
        r0.setOnFrameAvailableListener(r4);
        r14.f24231o = r4;
        r14.m30968d();
        return;
    L_0x038f:
        r1 = r14.f24218b;
        r1.m20004b();
        r1 = r14.f24231o;
        r1.setOnFrameAvailableListener(r4);
        r14.f24231o = r4;
        r14.m30968d();
        throw r0;
    L_0x039f:
        r0 = r14.f24239w;
        r0 = r0.eglGetError();
        r0 = android.opengl.GLUtils.getEGLErrorString(r0);
        r1 = "EGL initialization failed: ";
        r0 = java.lang.String.valueOf(r0);
        r2 = r0.length();
        if (r2 == 0) goto L_0x03ba;
    L_0x03b5:
        r0 = r1.concat(r0);
        goto L_0x03bf;
    L_0x03ba:
        r0 = new java.lang.String;
        r0.<init>(r1);
    L_0x03bf:
        com.google.android.gms.internal.ads.mt.m19920c(r0);
        r1 = com.google.android.gms.ads.internal.ax.i();
        r2 = new java.lang.Throwable;
        r2.<init>(r0);
        r0 = "SphericalVideoProcessor.run.1";
        r1.m30834a(r2, r0);
        r14.m30968d();
        r0 = r14.f24237u;
        r0.countDown();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.pl.run():void");
    }
}
