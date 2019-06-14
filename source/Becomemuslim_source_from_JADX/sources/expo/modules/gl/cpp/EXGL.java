package expo.modules.gl.cpp;

import com.facebook.soloader.SoLoader;

public class EXGL {
    public static native int EXGLContextCreate(long j);

    public static native int EXGLContextCreateObject(int i);

    public static native void EXGLContextDestroy(int i);

    public static native void EXGLContextDestroyObject(int i, int i2);

    public static native void EXGLContextDrawEnded(int i);

    public static native void EXGLContextFlush(int i);

    public static native int EXGLContextGetObject(int i, int i2);

    public static native void EXGLContextMapObject(int i, int i2, int i3);

    public static native boolean EXGLContextNeedsRedraw(int i);

    public static native void EXGLContextSetFlushMethod(int i, Object obj);

    static {
        SoLoader.loadLibrary("expo-gl");
    }
}
