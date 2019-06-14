package com.facebook.soloader;

import android.util.Log;
import java.util.List;

public abstract class NativeLibrary {
    private static final String TAG = "com.facebook.soloader.NativeLibrary";
    private boolean mLibrariesLoaded = false;
    private List<String> mLibraryNames;
    private volatile UnsatisfiedLinkError mLinkError = null;
    private Boolean mLoadLibraries = Boolean.valueOf(true);
    private final Object mLock = new Object();

    protected void initialNativeCheck() {
    }

    protected NativeLibrary(List<String> list) {
        this.mLibraryNames = list;
    }

    public boolean loadLibraries() {
        synchronized (this.mLock) {
            if (this.mLoadLibraries.booleanValue()) {
                try {
                    if (this.mLibraryNames != null) {
                        for (String loadLibrary : this.mLibraryNames) {
                            SoLoader.loadLibrary(loadLibrary);
                        }
                    }
                    initialNativeCheck();
                    this.mLibrariesLoaded = true;
                    this.mLibraryNames = null;
                } catch (Throwable e) {
                    Log.e(TAG, "Failed to load native lib (initial check): ", e);
                    this.mLinkError = e;
                    this.mLibrariesLoaded = false;
                } catch (Throwable e2) {
                    Log.e(TAG, "Failed to load native lib (other error): ", e2);
                    this.mLinkError = new UnsatisfiedLinkError("Failed loading libraries");
                    this.mLinkError.initCause(e2);
                    this.mLibrariesLoaded = false;
                }
                this.mLoadLibraries = Boolean.valueOf(false);
                boolean z = this.mLibrariesLoaded;
                return z;
            }
            z = this.mLibrariesLoaded;
            return z;
        }
    }

    public void ensureLoaded() {
        if (!loadLibraries()) {
            throw this.mLinkError;
        }
    }

    public UnsatisfiedLinkError getError() {
        return this.mLinkError;
    }
}
