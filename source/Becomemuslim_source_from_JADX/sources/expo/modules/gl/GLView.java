package expo.modules.gl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import expo.p304a.C6007d;
import expo.p304a.p305a.p306a.C5991a;
import expo.p304a.p305a.p306a.C5991a.C7368a;

public class GLView extends TextureView implements SurfaceTextureListener {
    private GLContext mGLContext;
    private C6007d mModuleRegistry;
    private boolean mOnSurfaceCreateCalled = false;
    private boolean mOnSurfaceTextureCreatedWithZeroSize = false;

    /* renamed from: expo.modules.gl.GLView$1 */
    class C61011 implements Runnable {
        C61011() {
        }

        public void run() {
            final Bundle bundle = new Bundle();
            C5991a c5991a = (C5991a) GLView.this.mModuleRegistry.m25133a(C5991a.class);
            bundle.putInt("exglCtxId", GLView.this.mGLContext.getContextId());
            c5991a.mo5141a(GLView.this.getId(), new C7368a() {
                public String getEventName() {
                    return "onSurfaceCreate";
                }

                public Bundle getEventBody() {
                    return bundle;
                }
            });
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public GLView(Context context) {
        super(context);
    }

    public GLView(Context context, C6007d c6007d) {
        super(context);
        setSurfaceTextureListener(this);
        setOpaque(false);
        this.mGLContext = new GLContext((GLObjectManagerModule) c6007d.m25141b(GLObjectManagerModule.class));
        this.mModuleRegistry = c6007d;
    }

    public void runOnGLThread(Runnable runnable) {
        this.mGLContext.runAsync(runnable);
    }

    public GLContext getGLContext() {
        return this.mGLContext;
    }

    public synchronized void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (!this.mOnSurfaceCreateCalled) {
            if (i == 0 || i2 == 0) {
                this.mOnSurfaceTextureCreatedWithZeroSize = true;
            }
            if (this.mOnSurfaceTextureCreatedWithZeroSize == 0) {
                initializeSurfaceInGLContext(surfaceTexture);
            }
            this.mOnSurfaceCreateCalled = true;
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.mGLContext.destroy();
        this.mOnSurfaceCreateCalled = null;
        return true;
    }

    public synchronized void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (!(!this.mOnSurfaceTextureCreatedWithZeroSize || i == 0 || i2 == 0)) {
            initializeSurfaceInGLContext(surfaceTexture);
            this.mOnSurfaceTextureCreatedWithZeroSize = null;
        }
    }

    public void flush() {
        this.mGLContext.flush();
    }

    public int getEXGLCtxId() {
        return this.mGLContext.getContextId();
    }

    private void initializeSurfaceInGLContext(SurfaceTexture surfaceTexture) {
        this.mGLContext.initialize(surfaceTexture, new C61011());
    }
}
