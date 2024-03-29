package com.facebook.react.common;

import expolib_v1.com.facebook.infer.annotation.Assertions;

public class SingleThreadAsserter {
    private Thread mThread = null;

    public void assertNow() {
        Thread currentThread = Thread.currentThread();
        if (this.mThread == null) {
            this.mThread = currentThread;
        }
        Assertions.assertCondition(this.mThread == currentThread);
    }
}
