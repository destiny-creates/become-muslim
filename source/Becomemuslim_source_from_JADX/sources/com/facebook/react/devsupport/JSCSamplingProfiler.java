package com.facebook.react.devsupport;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@ReactModule(name = "JSCSamplingProfiler", needsEagerInit = true)
public class JSCSamplingProfiler extends ReactContextBaseJavaModule {
    private static final HashSet<JSCSamplingProfiler> sRegisteredDumpers = new HashSet();
    private String mOperationError = null;
    private boolean mOperationInProgress = false;
    private int mOperationToken = 0;
    private SamplingProfiler mSamplingProfiler = null;
    private String mSamplingProfilerResult = null;

    public static class ProfilerException extends Exception {
        ProfilerException(String str) {
            super(str);
        }
    }

    public interface SamplingProfiler extends JavaScriptModule {
        void poke(int i);
    }

    public String getName() {
        return "JSCSamplingProfiler";
    }

    private static synchronized void registerSamplingProfiler(JSCSamplingProfiler jSCSamplingProfiler) {
        synchronized (JSCSamplingProfiler.class) {
            if (sRegisteredDumpers.contains(jSCSamplingProfiler)) {
                throw new RuntimeException("a JSCSamplingProfiler registered more than once");
            }
            sRegisteredDumpers.add(jSCSamplingProfiler);
        }
    }

    private static synchronized void unregisterSamplingProfiler(JSCSamplingProfiler jSCSamplingProfiler) {
        synchronized (JSCSamplingProfiler.class) {
            sRegisteredDumpers.remove(jSCSamplingProfiler);
        }
    }

    public static synchronized List<String> poke(long j) {
        List linkedList;
        synchronized (JSCSamplingProfiler.class) {
            linkedList = new LinkedList();
            if (sRegisteredDumpers.isEmpty()) {
                throw new ProfilerException("No JSC registered");
            }
            Iterator it = sRegisteredDumpers.iterator();
            while (it.hasNext()) {
                JSCSamplingProfiler jSCSamplingProfiler = (JSCSamplingProfiler) it.next();
                jSCSamplingProfiler.pokeHelper(j);
                linkedList.add(jSCSamplingProfiler.mSamplingProfilerResult);
            }
        }
        return linkedList;
    }

    public JSCSamplingProfiler(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private synchronized void pokeHelper(long j) {
        if (this.mSamplingProfiler != null) {
            this.mSamplingProfiler.poke(getOperationToken());
            waitForOperation(j);
        } else {
            throw new ProfilerException("SamplingProfiler.js module not connected");
        }
    }

    private int getOperationToken() {
        if (this.mOperationInProgress) {
            throw new ProfilerException("Another operation already in progress.");
        }
        this.mOperationInProgress = true;
        int i = this.mOperationToken + 1;
        this.mOperationToken = i;
        return i;
    }

    private void waitForOperation(long j) {
        try {
            wait(j);
            if (this.mOperationInProgress != null) {
                this.mOperationInProgress = 0;
                throw new ProfilerException("heap capture timed out.");
            } else if (this.mOperationError != null) {
                throw new ProfilerException(this.mOperationError);
            }
        } catch (long j2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Waiting for heap capture failed: ");
            stringBuilder.append(j2.getMessage());
            throw new ProfilerException(stringBuilder.toString());
        }
    }

    @ReactMethod
    public synchronized void operationComplete(int i, String str, String str2) {
        if (i == this.mOperationToken) {
            this.mOperationInProgress = false;
            this.mSamplingProfilerResult = str;
            this.mOperationError = str2;
            notify();
        } else {
            throw new RuntimeException("Completed operation is not in progress.");
        }
    }

    public void initialize() {
        super.initialize();
        this.mSamplingProfiler = (SamplingProfiler) getReactApplicationContext().getJSModule(SamplingProfiler.class);
        registerSamplingProfiler(this);
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        unregisterSamplingProfiler(this);
        this.mSamplingProfiler = null;
    }
}
