package expo.modules.gl;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6001h;
import expo.p304a.p305a.p306a.C5993b;
import expo.p304a.p305a.p306a.C5993b.C5992a;
import expo.p307b.p309b.C6022a;
import java.util.Map;

public class GLObjectManagerModule extends C6006c implements C6001h {
    private SparseArray<GLContext> mGLContextMap = new SparseArray();
    private SparseArray<GLObject> mGLObjects = new SparseArray();
    private C6007d mModuleRegistry;

    public String getName() {
        return "ExponentGLObjectManager";
    }

    public GLObjectManagerModule(Context context) {
        super(context);
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mModuleRegistry = c6007d;
    }

    public C6007d getModuleRegistry() {
        return this.mModuleRegistry;
    }

    public GLContext getContextWithId(int i) {
        return (GLContext) this.mGLContextMap.get(i);
    }

    public void saveContext(GLContext gLContext) {
        this.mGLContextMap.put(gLContext.getContextId(), gLContext);
    }

    public void deleteContextWithId(int i) {
        this.mGLContextMap.delete(i);
    }

    @C5996c
    public void destroyObjectAsync(int i, C6009f c6009f) {
        GLObject gLObject = (GLObject) this.mGLObjects.get(i);
        if (gLObject != null) {
            this.mGLObjects.remove(i);
            gLObject.destroy();
            c6009f.mo5137a(Boolean.valueOf(1));
            return;
        }
        c6009f.mo5137a(Boolean.valueOf(0));
    }

    @C5996c
    public void createCameraTextureAsync(final int i, int i2, final C6009f c6009f) {
        C5993b c5993b = (C5993b) this.mModuleRegistry.m25133a(C5993b.class);
        if (c5993b == null) {
            c6009f.m25152a("E_UI_MANAGER_NOT_FOUND", "UIManager not found in module registry.");
        } else {
            c5993b.addUIBlock(i2, new C5992a<C6022a>() {
                public void resolve(final C6022a c6022a) {
                    final GLContext contextWithId = GLObjectManagerModule.this.getContextWithId(i);
                    if (contextWithId == null) {
                        c6009f.m25152a("E_GL_NO_CONTEXT", "ExponentGLObjectManager.createCameraTextureAsync: GLContext not found for given context id.");
                    } else {
                        contextWithId.runAsync(new Runnable() {
                            public void run() {
                                GLCameraObject gLCameraObject = new GLCameraObject(contextWithId, c6022a);
                                int eXGLObjId = gLCameraObject.getEXGLObjId();
                                GLObjectManagerModule.this.mGLObjects.put(eXGLObjId, gLCameraObject);
                                Object bundle = new Bundle();
                                bundle.putInt("exglObjId", eXGLObjId);
                                c6009f.mo5137a(bundle);
                            }
                        });
                    }
                }

                public void reject(Throwable th) {
                    c6009f.mo5138a("E_GL_BAD_CAMERA_VIEW_TAG", "ExponentGLObjectManager.createCameraTextureAsync: Expected a CameraView", th);
                }
            }, C6022a.class);
        }
    }

    @C5996c
    public void takeSnapshotAsync(int i, Map<String, Object> map, C6009f c6009f) {
        i = getContextWithId(i);
        if (i == 0) {
            c6009f.m25152a("E_GL_NO_CONTEXT", "ExponentGLObjectManager.takeSnapshotAsync: GLContext not found for given context id.");
        } else {
            i.takeSnapshot(map, getContext(), c6009f);
        }
    }

    @C5996c
    public void createContextAsync(final C6009f c6009f) {
        final GLContext gLContext = new GLContext(this);
        gLContext.initialize(null, new Runnable() {
            public void run() {
                Object bundle = new Bundle();
                bundle.putInt("exglCtxId", gLContext.getContextId());
                c6009f.mo5137a(bundle);
            }
        });
    }

    @C5996c
    public void destroyContextAsync(int i, C6009f c6009f) {
        i = getContextWithId(i);
        if (i != 0) {
            i.destroy();
            c6009f.mo5137a(Boolean.valueOf(1));
            return;
        }
        c6009f.mo5137a(Boolean.valueOf(0));
    }
}
