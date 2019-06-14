package com.google.firebase.iid;

import java.util.concurrent.ThreadFactory;

final /* synthetic */ class am implements ThreadFactory {
    /* renamed from: a */
    static final ThreadFactory f18080a = new am();

    private am() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "firebase-iid-executor");
    }
}
