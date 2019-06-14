package com.facebook.react.bridge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public final class FallbackJSBundleLoader extends JSBundleLoader {
    static final String RECOVERABLE = "facebook::react::Recoverable";
    static final String TAG = "FallbackJSBundleLoader";
    private Stack<JSBundleLoader> mLoaders = new Stack();
    private final ArrayList<Exception> mRecoveredErrors = new ArrayList();

    public FallbackJSBundleLoader(List<JSBundleLoader> list) {
        list = list.listIterator(list.size());
        while (list.hasPrevious()) {
            this.mLoaders.push(list.previous());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String loadScript(com.facebook.react.bridge.CatalystInstanceImpl r4) {
        /*
        r3 = this;
    L_0x0000:
        r0 = r3.getDelegateLoader();	 Catch:{ Exception -> 0x0009 }
        r0 = r0.loadScript(r4);	 Catch:{ Exception -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = move-exception;
        r1 = r0.getMessage();
        if (r1 == 0) goto L_0x002e;
    L_0x0010:
        r1 = r0.getMessage();
        r2 = "facebook::react::Recoverable";
        r1 = r1.startsWith(r2);
        if (r1 == 0) goto L_0x002e;
    L_0x001c:
        r1 = r3.mLoaders;
        r1.pop();
        r1 = r3.mRecoveredErrors;
        r1.add(r0);
        r1 = "FallbackJSBundleLoader";
        r2 = "Falling back from recoverable error";
        com.facebook.common.logging.FLog.wtf(r1, r2, r0);
        goto L_0x0000;
    L_0x002e:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.FallbackJSBundleLoader.loadScript(com.facebook.react.bridge.CatalystInstanceImpl):java.lang.String");
    }

    private JSBundleLoader getDelegateLoader() {
        if (!this.mLoaders.empty()) {
            return (JSBundleLoader) this.mLoaders.peek();
        }
        Throwable runtimeException = new RuntimeException("No fallback options available");
        Iterator it = this.mRecoveredErrors.iterator();
        Throwable th = runtimeException;
        while (it.hasNext()) {
            th.initCause((Exception) it.next());
            while (th.getCause() != null) {
                th = th.getCause();
            }
        }
        throw runtimeException;
    }
}
