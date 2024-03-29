package com.facebook.internal;

import android.content.Intent;
import java.util.UUID;

public class AppCall {
    private static AppCall currentPendingCall;
    private UUID callId;
    private int requestCode;
    private Intent requestIntent;

    public static AppCall getCurrentPendingCall() {
        return currentPendingCall;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.facebook.internal.AppCall finishPendingCall(java.util.UUID r4, int r5) {
        /*
        r0 = com.facebook.internal.AppCall.class;
        monitor-enter(r0);
        r1 = getCurrentPendingCall();	 Catch:{ all -> 0x0022 }
        r2 = 0;
        if (r1 == 0) goto L_0x0020;
    L_0x000a:
        r3 = r1.getCallId();	 Catch:{ all -> 0x0022 }
        r4 = r3.equals(r4);	 Catch:{ all -> 0x0022 }
        if (r4 == 0) goto L_0x0020;
    L_0x0014:
        r4 = r1.getRequestCode();	 Catch:{ all -> 0x0022 }
        if (r4 == r5) goto L_0x001b;
    L_0x001a:
        goto L_0x0020;
    L_0x001b:
        setCurrentPendingCall(r2);	 Catch:{ all -> 0x0022 }
        monitor-exit(r0);
        return r1;
    L_0x0020:
        monitor-exit(r0);
        return r2;
    L_0x0022:
        r4 = move-exception;
        monitor-exit(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AppCall.finishPendingCall(java.util.UUID, int):com.facebook.internal.AppCall");
    }

    private static synchronized boolean setCurrentPendingCall(AppCall appCall) {
        synchronized (AppCall.class) {
            AppCall currentPendingCall = getCurrentPendingCall();
            currentPendingCall = appCall;
            appCall = currentPendingCall != null ? true : null;
        }
        return appCall;
    }

    public AppCall(int i) {
        this(i, UUID.randomUUID());
    }

    public AppCall(int i, UUID uuid) {
        this.callId = uuid;
        this.requestCode = i;
    }

    public Intent getRequestIntent() {
        return this.requestIntent;
    }

    public UUID getCallId() {
        return this.callId;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    public void setRequestCode(int i) {
        this.requestCode = i;
    }

    public void setRequestIntent(Intent intent) {
        this.requestIntent = intent;
    }

    public boolean setPending() {
        return setCurrentPendingCall(this);
    }
}
