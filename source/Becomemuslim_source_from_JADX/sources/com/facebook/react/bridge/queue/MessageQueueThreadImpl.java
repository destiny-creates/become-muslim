package com.facebook.react.bridge.queue;

import android.os.Looper;
import android.os.Process;
import com.facebook.common.logging.FLog;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.futures.SimpleSettableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@DoNotStrip
public class MessageQueueThreadImpl implements MessageQueueThread {
    private final String mAssertionErrorMessage;
    private final MessageQueueThreadHandler mHandler;
    private volatile boolean mIsFinished = false;
    private final Looper mLooper;
    private final String mName;

    /* renamed from: com.facebook.react.bridge.queue.MessageQueueThreadImpl$2 */
    static class C18942 implements Runnable {
        C18942() {
        }

        public void run() {
            Process.setThreadPriority(-4);
        }
    }

    private MessageQueueThreadImpl(String str, Looper looper, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        this.mName = str;
        this.mLooper = looper;
        this.mHandler = new MessageQueueThreadHandler(looper, queueThreadExceptionHandler);
        str = new StringBuilder();
        str.append("Expected to be called from the '");
        str.append(getName());
        str.append("' thread!");
        this.mAssertionErrorMessage = str.toString();
    }

    @DoNotStrip
    public void runOnQueue(Runnable runnable) {
        if (this.mIsFinished) {
            String str = ReactConstants.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Tried to enqueue runnable on already finished thread: '");
            stringBuilder.append(getName());
            stringBuilder.append("... dropping Runnable.");
            FLog.m5714w(str, stringBuilder.toString());
        }
        this.mHandler.post(runnable);
    }

    @DoNotStrip
    public <T> Future<T> callOnQueue(final Callable<T> callable) {
        final Future simpleSettableFuture = new SimpleSettableFuture();
        runOnQueue(new Runnable() {
            public void run() {
                try {
                    simpleSettableFuture.set(callable.call());
                } catch (Exception e) {
                    simpleSettableFuture.setException(e);
                }
            }
        });
        return simpleSettableFuture;
    }

    @DoNotStrip
    public boolean isOnThread() {
        return this.mLooper.getThread() == Thread.currentThread();
    }

    @DoNotStrip
    public void assertIsOnThread() {
        SoftAssertions.assertCondition(isOnThread(), this.mAssertionErrorMessage);
    }

    @DoNotStrip
    public void assertIsOnThread(String str) {
        boolean isOnThread = isOnThread();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mAssertionErrorMessage);
        stringBuilder.append(" ");
        stringBuilder.append(str);
        SoftAssertions.assertCondition(isOnThread, stringBuilder.toString());
    }

    @com.facebook.proguard.annotations.DoNotStrip
    public void quitSynchronous() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = 1;
        r3.mIsFinished = r0;
        r0 = r3.mLooper;
        r0.quit();
        r0 = r3.mLooper;
        r0 = r0.getThread();
        r1 = java.lang.Thread.currentThread();
        if (r0 == r1) goto L_0x0037;
    L_0x0014:
        r0 = r3.mLooper;	 Catch:{ InterruptedException -> 0x001e }
        r0 = r0.getThread();	 Catch:{ InterruptedException -> 0x001e }
        r0.join();	 Catch:{ InterruptedException -> 0x001e }
        goto L_0x0037;
    L_0x001e:
        r0 = new java.lang.RuntimeException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Got interrupted waiting to join thread ";
        r1.append(r2);
        r2 = r3.mName;
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0037:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.queue.MessageQueueThreadImpl.quitSynchronous():void");
    }

    public Looper getLooper() {
        return this.mLooper;
    }

    public String getName() {
        return this.mName;
    }

    public static MessageQueueThreadImpl create(MessageQueueThreadSpec messageQueueThreadSpec, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        switch (messageQueueThreadSpec.getThreadType()) {
            case MAIN_UI:
                return createForMainThread(messageQueueThreadSpec.getName(), queueThreadExceptionHandler);
            case NEW_BACKGROUND:
                return startNewBackgroundThread(messageQueueThreadSpec.getName(), messageQueueThreadSpec.getStackSize(), queueThreadExceptionHandler);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown thread type: ");
                stringBuilder.append(messageQueueThreadSpec.getThreadType());
                throw new RuntimeException(stringBuilder.toString());
        }
    }

    private static MessageQueueThreadImpl createForMainThread(String str, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        MessageQueueThreadImpl messageQueueThreadImpl = new MessageQueueThreadImpl(str, Looper.getMainLooper(), queueThreadExceptionHandler);
        if (UiThreadUtil.isOnUiThread() != null) {
            Process.setThreadPriority(-4);
        } else {
            UiThreadUtil.runOnUiThread(new C18942());
        }
        return messageQueueThreadImpl;
    }

    private static MessageQueueThreadImpl startNewBackgroundThread(String str, long j, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        final SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
        Runnable c18953 = new Runnable() {
            public void run() {
                Process.setThreadPriority(-4);
                Looper.prepare();
                simpleSettableFuture.set(Looper.myLooper());
                Looper.loop();
            }
        };
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mqt_");
        stringBuilder.append(str);
        new Thread(null, c18953, stringBuilder.toString(), j).start();
        return new MessageQueueThreadImpl(str, (Looper) simpleSettableFuture.getOrThrow(), queueThreadExceptionHandler);
    }
}
