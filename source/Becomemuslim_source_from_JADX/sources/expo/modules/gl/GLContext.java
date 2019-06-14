package expo.modules.gl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.opengl.EGL14;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import com.facebook.imageutils.JfifUtil;
import expo.modules.gl.cpp.EXGL;
import expo.modules.gl.utils.FileSystemUtils;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5999f;
import expo.p304a.p305a.p306a.C5993b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class GLContext {
    private EGL10 mEGL;
    private EGLConfig mEGLConfig;
    private EGLContext mEGLContext;
    private EGLDisplay mEGLDisplay;
    private EGLSurface mEGLSurface;
    private int mEXGLCtxId = -1;
    private BlockingQueue<Runnable> mEventQueue = new LinkedBlockingQueue();
    private GLThread mGLThread;
    private final GLObjectManagerModule mManager;

    /* renamed from: expo.modules.gl.GLContext$2 */
    class C60972 implements Runnable {
        C60972() {
        }

        public void run() {
            if (GLContext.this.mEXGLCtxId > 0) {
                EXGL.EXGLContextFlush(GLContext.this.mEXGLCtxId);
                if (!GLContext.this.isHeadless() && EXGL.EXGLContextNeedsRedraw(GLContext.this.mEXGLCtxId)) {
                    if (!GLContext.this.swapBuffers(GLContext.this.mEGLSurface)) {
                        Log.e("EXGL", "Cannot swap buffers!");
                    }
                    EXGL.EXGLContextDrawEnded(GLContext.this.mEXGLCtxId);
                }
            }
        }
    }

    private class GLThread extends Thread {
        private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
        private SurfaceTexture mSurfaceTexture;

        GLThread(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r1.initEGL();
        L_0x0003:
            r1.makeEGLContextCurrent();	 Catch:{ InterruptedException -> 0x0019 }
            r0 = expo.modules.gl.GLContext.this;	 Catch:{ InterruptedException -> 0x0019 }
            r0 = r0.mEventQueue;	 Catch:{ InterruptedException -> 0x0019 }
            r0 = r0.take();	 Catch:{ InterruptedException -> 0x0019 }
            r0 = (java.lang.Runnable) r0;	 Catch:{ InterruptedException -> 0x0019 }
            r0.run();	 Catch:{ InterruptedException -> 0x0019 }
            r1.checkEGLError();	 Catch:{ InterruptedException -> 0x0019 }
            goto L_0x0003;
        L_0x0019:
            r1.deinitEGL();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.gl.GLContext.GLThread.run():void");
        }

        private EGLContext createGLContext(int i, EGLConfig eGLConfig) {
            return GLContext.this.mEGL.eglCreateContext(GLContext.this.mEGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGL_CONTEXT_CLIENT_VERSION, i, 12344});
        }

        private void initEGL() {
            GLContext.this.mEGL = (EGL10) EGLContext.getEGL();
            GLContext.this.mEGLDisplay = GLContext.this.mEGL.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            StringBuilder stringBuilder;
            if (GLContext.this.mEGLDisplay != EGL10.EGL_NO_DISPLAY) {
                if (GLContext.this.mEGL.eglInitialize(GLContext.this.mEGLDisplay, new int[2])) {
                    int[] iArr = new int[1];
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    if (GLContext.this.mEGL.eglChooseConfig(GLContext.this.mEGLDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 0, 12344}, eGLConfigArr, 1, iArr)) {
                        if (iArr[0] > 0) {
                            GLContext.this.mEGLConfig = eGLConfigArr[0];
                        }
                        if (GLContext.this.mEGLConfig != null) {
                            GLContext.this.mEGLContext = createGLContext(3, GLContext.this.mEGLConfig);
                            if (GLContext.this.mEGLContext == null || GLContext.this.mEGLContext == EGL10.EGL_NO_CONTEXT) {
                                GLContext.this.mEGLContext = createGLContext(2, GLContext.this.mEGLConfig);
                            }
                            checkEGLError();
                            GLContext.this.mEGLSurface = GLContext.this.createSurface(GLContext.this.mEGLConfig, this.mSurfaceTexture);
                            checkEGLError();
                            if (GLContext.this.mEGLSurface == null || GLContext.this.mEGLSurface == EGL10.EGL_NO_SURFACE) {
                                int eglGetError = GLContext.this.mEGL.eglGetError();
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("eglCreateWindowSurface failed ");
                                stringBuilder2.append(GLUtils.getEGLErrorString(eglGetError));
                                throw new RuntimeException(stringBuilder2.toString());
                            }
                            makeEGLContextCurrent();
                            checkEGLError();
                            EGL14.eglSurfaceAttrib(EGL14.eglGetCurrentDisplay(), EGL14.eglGetCurrentSurface(12377), 12435, 12436);
                            checkEGLError();
                            return;
                        }
                        throw new RuntimeException("eglConfig not initialized");
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("eglChooseConfig failed ");
                    stringBuilder.append(GLUtils.getEGLErrorString(GLContext.this.mEGL.eglGetError()));
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("eglInitialize failed ");
                stringBuilder.append(GLUtils.getEGLErrorString(GLContext.this.mEGL.eglGetError()));
                throw new RuntimeException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("eglGetDisplay failed ");
            stringBuilder.append(GLUtils.getEGLErrorString(GLContext.this.mEGL.eglGetError()));
            throw new RuntimeException(stringBuilder.toString());
        }

        private void deinitEGL() {
            makeEGLContextCurrent();
            GLContext.this.destroySurface(GLContext.this.mEGLSurface);
            checkEGLError();
            GLContext.this.mEGL.eglDestroyContext(GLContext.this.mEGLDisplay, GLContext.this.mEGLContext);
            checkEGLError();
            GLContext.this.mEGL.eglTerminate(GLContext.this.mEGLDisplay);
            checkEGLError();
        }

        private void makeEGLContextCurrent() {
            if (!GLContext.this.mEGLContext.equals(GLContext.this.mEGL.eglGetCurrentContext()) || !GLContext.this.mEGLSurface.equals(GLContext.this.mEGL.eglGetCurrentSurface(12377))) {
                checkEGLError();
                if (GLContext.this.makeCurrent(GLContext.this.mEGLSurface)) {
                    checkEGLError();
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("eglMakeCurrent failed ");
                stringBuilder.append(GLUtils.getEGLErrorString(GLContext.this.mEGL.eglGetError()));
                throw new RuntimeException(stringBuilder.toString());
            }
        }

        private void checkEGLError() {
            int eglGetError = GLContext.this.mEGL.eglGetError();
            if (eglGetError != 12288) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("EGL error = 0x");
                stringBuilder.append(Integer.toHexString(eglGetError));
                Log.e("EXGL", stringBuilder.toString());
            }
        }
    }

    private static class TakeSnapshot extends AsyncTask<Void, Void, Void> {
        private final int mCompress;
        private final WeakReference<Context> mContext;
        private final int[] mDataArray;
        private final boolean mFlip;
        private final String mFormat;
        private final int mHeight;
        private final C6009f mPromise;
        private final int mWidth;

        TakeSnapshot(Context context, int i, int i2, boolean z, String str, int i3, int[] iArr, C6009f c6009f) {
            this.mContext = new WeakReference(context);
            this.mWidth = i;
            this.mHeight = i2;
            this.mFlip = z;
            this.mFormat = str;
            this.mCompress = i3;
            this.mDataArray = iArr;
            this.mPromise = c6009f;
        }

        protected Void doInBackground(Void... voidArr) {
            Exception e;
            Object bundle;
            for (int i = 0; i < this.mHeight; i++) {
                for (int i2 = 0; i2 < this.mWidth; i2++) {
                    int i3 = (this.mWidth * i) + i2;
                    int i4 = this.mDataArray[i3];
                    this.mDataArray[i3] = ((i4 & -16711936) | ((i4 << 16) & 16711680)) | ((i4 >> 16) & JfifUtil.MARKER_FIRST_BYTE);
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(this.mDataArray, this.mWidth, this.mHeight, Config.ARGB_8888);
            if (this.mFlip == null) {
                Matrix matrix = new Matrix();
                matrix.postScale(1065353216, -1.0f, (float) (this.mWidth / 2), (float) (this.mHeight / 2));
                createBitmap = Bitmap.createBitmap(createBitmap, 0, 0, this.mWidth, this.mHeight, matrix, true);
            }
            voidArr = ".jpeg";
            CompressFormat compressFormat = CompressFormat.JPEG;
            if (this.mFormat != null && this.mFormat.equals("png")) {
                compressFormat = CompressFormat.PNG;
                voidArr = ".png";
            }
            Context context = (Context) this.mContext.get();
            if (context == null) {
                this.mPromise.m25152a("E_GL_CONTEXT_DESTROYED", "Context has been garbage collected.");
                return null;
            }
            OutputStream fileOutputStream;
            try {
                voidArr = FileSystemUtils.generateOutputPath(context.getCacheDir(), "GLView", voidArr);
                try {
                    fileOutputStream = new FileOutputStream(voidArr);
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                    e.printStackTrace();
                    this.mPromise.m25152a("E_GL_CANT_SAVE_SNAPSHOT", e.getMessage());
                    if (fileOutputStream == null) {
                        bundle = new Bundle();
                        voidArr = Uri.fromFile(new File(voidArr)).toString();
                        bundle.putString("uri", voidArr);
                        bundle.putString("localUri", voidArr);
                        bundle.putInt("width", this.mWidth);
                        bundle.putInt("height", this.mHeight);
                        this.mPromise.mo5137a(bundle);
                    }
                    return null;
                }
                try {
                    createBitmap.compress(compressFormat, this.mCompress, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    fileOutputStream = null;
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    this.mPromise.m25152a("E_GL_CANT_SAVE_SNAPSHOT", e.getMessage());
                    if (fileOutputStream == null) {
                        bundle = new Bundle();
                        voidArr = Uri.fromFile(new File(voidArr)).toString();
                        bundle.putString("uri", voidArr);
                        bundle.putString("localUri", voidArr);
                        bundle.putInt("width", this.mWidth);
                        bundle.putInt("height", this.mHeight);
                        this.mPromise.mo5137a(bundle);
                    }
                    return null;
                }
            } catch (Exception e4) {
                e = e4;
                voidArr = null;
                fileOutputStream = voidArr;
                e.printStackTrace();
                this.mPromise.m25152a("E_GL_CANT_SAVE_SNAPSHOT", e.getMessage());
                if (fileOutputStream == null) {
                    bundle = new Bundle();
                    voidArr = Uri.fromFile(new File(voidArr)).toString();
                    bundle.putString("uri", voidArr);
                    bundle.putString("localUri", voidArr);
                    bundle.putInt("width", this.mWidth);
                    bundle.putInt("height", this.mHeight);
                    this.mPromise.mo5137a(bundle);
                }
                return null;
            }
            if (fileOutputStream == null) {
                bundle = new Bundle();
                voidArr = Uri.fromFile(new File(voidArr)).toString();
                bundle.putString("uri", voidArr);
                bundle.putString("localUri", voidArr);
                bundle.putInt("width", this.mWidth);
                bundle.putInt("height", this.mHeight);
                this.mPromise.mo5137a(bundle);
            }
            return null;
        }
    }

    public GLContext(GLObjectManagerModule gLObjectManagerModule) {
        this.mManager = gLObjectManagerModule;
    }

    public int getContextId() {
        return this.mEXGLCtxId;
    }

    public boolean isHeadless() {
        boolean z = true;
        if (this.mGLThread == null) {
            return true;
        }
        if (this.mGLThread.mSurfaceTexture != null) {
            z = false;
        }
        return z;
    }

    public void runAsync(Runnable runnable) {
        this.mEventQueue.add(runnable);
    }

    public void initialize(SurfaceTexture surfaceTexture, Runnable runnable) {
        if (this.mGLThread == null) {
            this.mGLThread = new GLThread(surfaceTexture);
            this.mGLThread.start();
            surfaceTexture = this.mManager.getModuleRegistry();
            C5993b c5993b = (C5993b) surfaceTexture.m25133a(C5993b.class);
            final C5999f c5999f = (C5999f) surfaceTexture.m25133a(C5999f.class);
            final C5993b c5993b2 = c5993b;
            final GLContext gLContext = this;
            final Runnable runnable2 = runnable;
            c5993b.runOnClientCodeQueueThread(new Runnable() {
                public void run() {
                    long javaScriptContextRef = c5999f.getJavaScriptContextRef();
                    synchronized (c5993b2) {
                        GLContext.this.mEXGLCtxId = EXGL.EXGLContextCreate(javaScriptContextRef);
                    }
                    EXGL.EXGLContextSetFlushMethod(GLContext.this.mEXGLCtxId, gLContext);
                    GLContext.this.mManager.saveContext(gLContext);
                    runnable2.run();
                }
            });
        }
    }

    public void flush() {
        runAsync(new C60972());
    }

    public boolean swapBuffers(EGLSurface eGLSurface) {
        return this.mEGL.eglSwapBuffers(this.mEGLDisplay, eGLSurface);
    }

    public boolean makeCurrent(EGLSurface eGLSurface) {
        return this.mEGL.eglMakeCurrent(this.mEGLDisplay, eGLSurface, eGLSurface, this.mEGLContext);
    }

    public EGLSurface createSurface(EGLConfig eGLConfig, Object obj) {
        if (obj != null) {
            return this.mEGL.eglCreateWindowSurface(this.mEGLDisplay, eGLConfig, obj, null);
        }
        return this.mEGL.eglCreatePbufferSurface(this.mEGLDisplay, eGLConfig, new int[]{12375, 1, 12374, 1, 12344});
    }

    public boolean destroySurface(EGLSurface eGLSurface) {
        return this.mEGL.eglDestroySurface(this.mEGLDisplay, eGLSurface);
    }

    public void destroy() {
        if (this.mGLThread != null) {
            this.mManager.deleteContextWithId(this.mEXGLCtxId);
            EXGL.EXGLContextDestroy(this.mEXGLCtxId);
            try {
                this.mGLThread.interrupt();
                this.mGLThread.join();
            } catch (Throwable e) {
                Log.e("EXGL", "Can't interrupt GL thread.", e);
            }
            this.mGLThread = null;
        }
    }

    public Map<String, Object> getViewportRect() {
        int[] iArr = new int[4];
        GLES30.glGetIntegerv(2978, iArr, 0);
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("x", Integer.valueOf(iArr[0]));
        hashMap.put("y", Integer.valueOf(iArr[1]));
        hashMap.put("width", Integer.valueOf(iArr[2]));
        hashMap.put("height", Integer.valueOf(iArr[3]));
        return hashMap;
    }

    public EGLConfig getEGLConfig() {
        return this.mEGLConfig;
    }

    public void takeSnapshot(final Map<String, Object> map, final Context context, final C6009f c6009f) {
        flush();
        runAsync(new Runnable() {
            public void run() {
                Map viewportRect = map.containsKey("rect") ? (Map) map.get("rect") : GLContext.this.getViewportRect();
                boolean z = map.containsKey("flip") && ((Boolean) map.get("flip")).booleanValue();
                Boolean valueOf = Boolean.valueOf(z);
                Map map = null;
                String str = map.containsKey("format") ? (String) map.get("format") : null;
                int doubleValue = map.containsKey("compress") ? (int) (((Double) map.get("compress")).doubleValue() * 100.0d) : 100;
                int access$400 = GLContext.this.castNumberToInt(viewportRect.get("x"));
                int access$4002 = GLContext.this.castNumberToInt(viewportRect.get("y"));
                int access$4003 = GLContext.this.castNumberToInt(viewportRect.get("width"));
                int access$4004 = GLContext.this.castNumberToInt(viewportRect.get("height"));
                int[] iArr = new int[1];
                GLES30.glGetIntegerv(36006, iArr, 0);
                int i = GLContext.this.isHeadless() ? iArr[0] : 0;
                if (map.containsKey("framebuffer")) {
                    map = (Map) map.get("framebuffer");
                }
                if (map != null && map.containsKey("id")) {
                    i = EXGL.EXGLContextGetObject(GLContext.this.mEXGLCtxId, Integer.valueOf(GLContext.this.castNumberToInt(map.get("id"))).intValue());
                }
                GLES30.glBindFramebuffer(36160, i);
                int[] iArr2 = new int[(access$4003 * access$4004)];
                Buffer wrap = IntBuffer.wrap(iArr2);
                wrap.position(0);
                GLES30.glReadPixels(access$400, access$4002, access$4003, access$4004, 6408, 5121, wrap);
                GLES30.glBindFramebuffer(36160, iArr[0]);
                new TakeSnapshot(context, access$4003, access$4004, valueOf.booleanValue(), str, doubleValue, iArr2, c6009f).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        });
    }

    private int castNumberToInt(Object obj) {
        if (obj instanceof Double) {
            return ((Double) obj).intValue();
        }
        return ((Integer) obj).intValue();
    }
}
