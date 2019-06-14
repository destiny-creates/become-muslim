package expo.modules.gl;

import expo.modules.gl.cpp.EXGL;

public class GLObject {
    protected int exglCtxId;
    protected int exglObjId;

    GLObject(int i) {
        this.exglCtxId = i;
        this.exglObjId = EXGL.EXGLContextCreateObject(i);
    }

    int getEXGLObjId() {
        return this.exglObjId;
    }

    void destroy() {
        EXGL.EXGLContextDestroyObject(this.exglCtxId, this.exglObjId);
    }
}
