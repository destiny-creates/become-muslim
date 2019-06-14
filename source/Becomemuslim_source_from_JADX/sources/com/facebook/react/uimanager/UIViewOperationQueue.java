package com.facebook.react.uimanager;

import android.os.SystemClock;
import com.facebook.common.logging.FLog;
import com.facebook.react.animation.Animation;
import com.facebook.react.animation.AnimationRegistry;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import com.facebook.react.uimanager.common.SizeMonitoringFrameLayout;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UIViewOperationQueue {
    public static final int DEFAULT_MIN_TIME_LEFT_IN_FRAME_FOR_NONBATCHED_OPERATION_MS = 8;
    private final AnimationRegistry mAnimationRegistry;
    private final Object mDispatchRunnablesLock = new Object();
    private final DispatchUIFrameCallback mDispatchUIFrameCallback;
    private ArrayList<Runnable> mDispatchUIRunnables = new ArrayList();
    private boolean mIsDispatchUIFrameCallbackEnqueued = false;
    private boolean mIsInIllegalUIState = false;
    private boolean mIsProfilingNextBatch = false;
    private final int[] mMeasureBuffer = new int[4];
    private final NativeViewHierarchyManager mNativeViewHierarchyManager;
    private long mNonBatchedExecutionTotalTime;
    private ArrayDeque<UIOperation> mNonBatchedOperations = new ArrayDeque();
    private final Object mNonBatchedOperationsLock = new Object();
    private ArrayList<UIOperation> mOperations = new ArrayList();
    private long mProfiledBatchBatchedExecutionTime;
    private long mProfiledBatchCommitStartTime;
    private long mProfiledBatchDispatchViewUpdatesTime;
    private long mProfiledBatchLayoutTime;
    private long mProfiledBatchNonBatchedExecutionTime;
    private long mProfiledBatchRunStartTime;
    private final ReactApplicationContext mReactApplicationContext;
    private NotThreadSafeViewHierarchyUpdateDebugListener mViewHierarchyUpdateDebugListener;

    public interface UIOperation {
        void execute();
    }

    private static abstract class AnimationOperation implements UIOperation {
        protected final int mAnimationID;

        public AnimationOperation(int i) {
            this.mAnimationID = i;
        }
    }

    private class ConfigureLayoutAnimationOperation implements UIOperation {
        private final ReadableMap mConfig;

        private ConfigureLayoutAnimationOperation(ReadableMap readableMap) {
            this.mConfig = readableMap;
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.configureLayoutAnimation(this.mConfig);
        }
    }

    private final class DismissPopupMenuOperation implements UIOperation {
        private DismissPopupMenuOperation() {
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.dismissPopupMenu();
        }
    }

    private final class FindTargetForTouchOperation implements UIOperation {
        private final Callback mCallback;
        private final int mReactTag;
        private final float mTargetX;
        private final float mTargetY;

        private FindTargetForTouchOperation(int i, float f, float f2, Callback callback) {
            this.mReactTag = i;
            this.mTargetX = f;
            this.mTargetY = f2;
            this.mCallback = callback;
        }

        public void execute() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r11 = this;
            r0 = 0;
            r1 = com.facebook.react.uimanager.UIViewOperationQueue.this;	 Catch:{ IllegalViewOperationException -> 0x00ac }
            r1 = r1.mNativeViewHierarchyManager;	 Catch:{ IllegalViewOperationException -> 0x00ac }
            r2 = r11.mReactTag;	 Catch:{ IllegalViewOperationException -> 0x00ac }
            r3 = com.facebook.react.uimanager.UIViewOperationQueue.this;	 Catch:{ IllegalViewOperationException -> 0x00ac }
            r3 = r3.mMeasureBuffer;	 Catch:{ IllegalViewOperationException -> 0x00ac }
            r1.measure(r2, r3);	 Catch:{ IllegalViewOperationException -> 0x00ac }
            r1 = com.facebook.react.uimanager.UIViewOperationQueue.this;
            r1 = r1.mMeasureBuffer;
            r1 = r1[r0];
            r1 = (float) r1;
            r2 = com.facebook.react.uimanager.UIViewOperationQueue.this;
            r2 = r2.mMeasureBuffer;
            r3 = 1;
            r2 = r2[r3];
            r2 = (float) r2;
            r4 = com.facebook.react.uimanager.UIViewOperationQueue.this;
            r4 = r4.mNativeViewHierarchyManager;
            r5 = r11.mReactTag;
            r6 = r11.mTargetX;
            r7 = r11.mTargetY;
            r4 = r4.findTargetTagForTouch(r5, r6, r7);
            r5 = com.facebook.react.uimanager.UIViewOperationQueue.this;	 Catch:{ IllegalViewOperationException -> 0x00a4 }
            r5 = r5.mNativeViewHierarchyManager;	 Catch:{ IllegalViewOperationException -> 0x00a4 }
            r6 = com.facebook.react.uimanager.UIViewOperationQueue.this;	 Catch:{ IllegalViewOperationException -> 0x00a4 }
            r6 = r6.mMeasureBuffer;	 Catch:{ IllegalViewOperationException -> 0x00a4 }
            r5.measure(r4, r6);	 Catch:{ IllegalViewOperationException -> 0x00a4 }
            r5 = com.facebook.react.uimanager.UIViewOperationQueue.this;
            r5 = r5.mMeasureBuffer;
            r5 = r5[r0];
            r5 = (float) r5;
            r5 = r5 - r1;
            r1 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r5);
            r5 = com.facebook.react.uimanager.UIViewOperationQueue.this;
            r5 = r5.mMeasureBuffer;
            r5 = r5[r3];
            r5 = (float) r5;
            r5 = r5 - r2;
            r2 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r5);
            r5 = com.facebook.react.uimanager.UIViewOperationQueue.this;
            r5 = r5.mMeasureBuffer;
            r6 = 2;
            r5 = r5[r6];
            r5 = (float) r5;
            r5 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r5);
            r7 = com.facebook.react.uimanager.UIViewOperationQueue.this;
            r7 = r7.mMeasureBuffer;
            r8 = 3;
            r7 = r7[r8];
            r7 = (float) r7;
            r7 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r7);
            r9 = r11.mCallback;
            r10 = 5;
            r10 = new java.lang.Object[r10];
            r4 = java.lang.Integer.valueOf(r4);
            r10[r0] = r4;
            r0 = java.lang.Float.valueOf(r1);
            r10[r3] = r0;
            r0 = java.lang.Float.valueOf(r2);
            r10[r6] = r0;
            r0 = java.lang.Float.valueOf(r5);
            r10[r8] = r0;
            r0 = 4;
            r1 = java.lang.Float.valueOf(r7);
            r10[r0] = r1;
            r9.invoke(r10);
            return;
        L_0x00a4:
            r1 = r11.mCallback;
            r0 = new java.lang.Object[r0];
            r1.invoke(r0);
            return;
        L_0x00ac:
            r1 = r11.mCallback;
            r0 = new java.lang.Object[r0];
            r1.invoke(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.UIViewOperationQueue.FindTargetForTouchOperation.execute():void");
        }
    }

    private final class MeasureInWindowOperation implements UIOperation {
        private final Callback mCallback;
        private final int mReactTag;

        private MeasureInWindowOperation(int i, Callback callback) {
            this.mReactTag = i;
            this.mCallback = callback;
        }

        public void execute() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r10 = this;
            r0 = 0;
            r1 = com.facebook.react.uimanager.UIViewOperationQueue.this;	 Catch:{ NoSuchNativeViewException -> 0x006a }
            r1 = r1.mNativeViewHierarchyManager;	 Catch:{ NoSuchNativeViewException -> 0x006a }
            r2 = r10.mReactTag;	 Catch:{ NoSuchNativeViewException -> 0x006a }
            r3 = com.facebook.react.uimanager.UIViewOperationQueue.this;	 Catch:{ NoSuchNativeViewException -> 0x006a }
            r3 = r3.mMeasureBuffer;	 Catch:{ NoSuchNativeViewException -> 0x006a }
            r1.measureInWindow(r2, r3);	 Catch:{ NoSuchNativeViewException -> 0x006a }
            r1 = com.facebook.react.uimanager.UIViewOperationQueue.this;
            r1 = r1.mMeasureBuffer;
            r1 = r1[r0];
            r1 = (float) r1;
            r1 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r1);
            r2 = com.facebook.react.uimanager.UIViewOperationQueue.this;
            r2 = r2.mMeasureBuffer;
            r3 = 1;
            r2 = r2[r3];
            r2 = (float) r2;
            r2 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r2);
            r4 = com.facebook.react.uimanager.UIViewOperationQueue.this;
            r4 = r4.mMeasureBuffer;
            r5 = 2;
            r4 = r4[r5];
            r4 = (float) r4;
            r4 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r4);
            r6 = com.facebook.react.uimanager.UIViewOperationQueue.this;
            r6 = r6.mMeasureBuffer;
            r7 = 3;
            r6 = r6[r7];
            r6 = (float) r6;
            r6 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r6);
            r8 = r10.mCallback;
            r9 = 4;
            r9 = new java.lang.Object[r9];
            r1 = java.lang.Float.valueOf(r1);
            r9[r0] = r1;
            r0 = java.lang.Float.valueOf(r2);
            r9[r3] = r0;
            r0 = java.lang.Float.valueOf(r4);
            r9[r5] = r0;
            r0 = java.lang.Float.valueOf(r6);
            r9[r7] = r0;
            r8.invoke(r9);
            return;
        L_0x006a:
            r1 = r10.mCallback;
            r0 = new java.lang.Object[r0];
            r1.invoke(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.UIViewOperationQueue.MeasureInWindowOperation.execute():void");
        }
    }

    private final class MeasureOperation implements UIOperation {
        private final Callback mCallback;
        private final int mReactTag;

        private MeasureOperation(int i, Callback callback) {
            this.mReactTag = i;
            this.mCallback = callback;
        }

        public void execute() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r11 = this;
            r0 = 0;
            r1 = com.facebook.react.uimanager.UIViewOperationQueue.this;	 Catch:{ NoSuchNativeViewException -> 0x0078 }
            r1 = r1.mNativeViewHierarchyManager;	 Catch:{ NoSuchNativeViewException -> 0x0078 }
            r2 = r11.mReactTag;	 Catch:{ NoSuchNativeViewException -> 0x0078 }
            r3 = com.facebook.react.uimanager.UIViewOperationQueue.this;	 Catch:{ NoSuchNativeViewException -> 0x0078 }
            r3 = r3.mMeasureBuffer;	 Catch:{ NoSuchNativeViewException -> 0x0078 }
            r1.measure(r2, r3);	 Catch:{ NoSuchNativeViewException -> 0x0078 }
            r1 = com.facebook.react.uimanager.UIViewOperationQueue.this;
            r1 = r1.mMeasureBuffer;
            r1 = r1[r0];
            r1 = (float) r1;
            r1 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r1);
            r2 = com.facebook.react.uimanager.UIViewOperationQueue.this;
            r2 = r2.mMeasureBuffer;
            r3 = 1;
            r2 = r2[r3];
            r2 = (float) r2;
            r2 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r2);
            r4 = com.facebook.react.uimanager.UIViewOperationQueue.this;
            r4 = r4.mMeasureBuffer;
            r5 = 2;
            r4 = r4[r5];
            r4 = (float) r4;
            r4 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r4);
            r6 = com.facebook.react.uimanager.UIViewOperationQueue.this;
            r6 = r6.mMeasureBuffer;
            r7 = 3;
            r6 = r6[r7];
            r6 = (float) r6;
            r6 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r6);
            r8 = r11.mCallback;
            r9 = 6;
            r9 = new java.lang.Object[r9];
            r10 = java.lang.Integer.valueOf(r0);
            r9[r0] = r10;
            r0 = java.lang.Integer.valueOf(r0);
            r9[r3] = r0;
            r0 = java.lang.Float.valueOf(r4);
            r9[r5] = r0;
            r0 = java.lang.Float.valueOf(r6);
            r9[r7] = r0;
            r0 = 4;
            r1 = java.lang.Float.valueOf(r1);
            r9[r0] = r1;
            r0 = 5;
            r1 = java.lang.Float.valueOf(r2);
            r9[r0] = r1;
            r8.invoke(r9);
            return;
        L_0x0078:
            r1 = r11.mCallback;
            r0 = new java.lang.Object[r0];
            r1.invoke(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.UIViewOperationQueue.MeasureOperation.execute():void");
        }
    }

    private class SetLayoutAnimationEnabledOperation implements UIOperation {
        private final boolean mEnabled;

        private SetLayoutAnimationEnabledOperation(boolean z) {
            this.mEnabled = z;
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.setLayoutAnimationEnabled(this.mEnabled);
        }
    }

    private class UIBlockOperation implements UIOperation {
        private final UIBlock mBlock;

        public UIBlockOperation(UIBlock uIBlock) {
            this.mBlock = uIBlock;
        }

        public void execute() {
            this.mBlock.execute(UIViewOperationQueue.this.mNativeViewHierarchyManager);
        }
    }

    private abstract class ViewOperation implements UIOperation {
        public int mTag;

        public ViewOperation(int i) {
            this.mTag = i;
        }
    }

    private class AddAnimationOperation extends AnimationOperation {
        private final int mReactTag;
        private final Callback mSuccessCallback;

        private AddAnimationOperation(int i, int i2, Callback callback) {
            super(i2);
            this.mReactTag = i;
            this.mSuccessCallback = callback;
        }

        public void execute() {
            Animation animation = UIViewOperationQueue.this.mAnimationRegistry.getAnimation(this.mAnimationID);
            if (animation != null) {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.startAnimationForNativeView(this.mReactTag, animation, this.mSuccessCallback);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Animation with id ");
            stringBuilder.append(this.mAnimationID);
            stringBuilder.append(" was not found");
            throw new IllegalViewOperationException(stringBuilder.toString());
        }
    }

    private final class ChangeJSResponderOperation extends ViewOperation {
        private final boolean mBlockNativeResponder;
        private final boolean mClearResponder;
        private final int mInitialTag;

        public ChangeJSResponderOperation(int i, int i2, boolean z, boolean z2) {
            super(i);
            this.mInitialTag = i2;
            this.mClearResponder = z;
            this.mBlockNativeResponder = z2;
        }

        public void execute() {
            if (this.mClearResponder) {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.clearJSResponder();
            } else {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.setJSResponder(this.mTag, this.mInitialTag, this.mBlockNativeResponder);
            }
        }
    }

    private final class CreateViewOperation extends ViewOperation {
        private final String mClassName;
        private final ReactStylesDiffMap mInitialProps;
        private final ThemedReactContext mThemedContext;

        public CreateViewOperation(ThemedReactContext themedReactContext, int i, String str, ReactStylesDiffMap reactStylesDiffMap) {
            super(i);
            this.mThemedContext = themedReactContext;
            this.mClassName = str;
            this.mInitialProps = reactStylesDiffMap;
            Systrace.startAsyncFlow(0, "createView", this.mTag);
        }

        public void execute() {
            Systrace.endAsyncFlow(0, "createView", this.mTag);
            UIViewOperationQueue.this.mNativeViewHierarchyManager.createView(this.mThemedContext, this.mTag, this.mClassName, this.mInitialProps);
        }
    }

    private final class DispatchCommandOperation extends ViewOperation {
        private final ReadableArray mArgs;
        private final int mCommand;

        public DispatchCommandOperation(int i, int i2, ReadableArray readableArray) {
            super(i);
            this.mCommand = i2;
            this.mArgs = readableArray;
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.dispatchCommand(this.mTag, this.mCommand, this.mArgs);
        }
    }

    private class DispatchUIFrameCallback extends GuardedFrameCallback {
        private static final int FRAME_TIME_MS = 16;
        private final int mMinTimeLeftInFrameForNonBatchedOperationMs;

        private DispatchUIFrameCallback(ReactContext reactContext, int i) {
            super(reactContext);
            this.mMinTimeLeftInFrameForNonBatchedOperationMs = i;
        }

        public void doFrameGuarded(long j) {
            if (UIViewOperationQueue.this.mIsInIllegalUIState) {
                FLog.m5714w(ReactConstants.TAG, "Not flushing pending UI operations because of previously thrown Exception");
                return;
            }
            Systrace.beginSection(0, "dispatchNonBatchedUIOperations");
            try {
                dispatchPendingNonBatchedOperations(j);
                UIViewOperationQueue.this.flushPendingBatches();
                ReactChoreographer.getInstance().postFrameCallback(CallbackType.DISPATCH_UI, this);
            } finally {
                Systrace.endSection(0);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void dispatchPendingNonBatchedOperations(long r9) {
            /*
            r8 = this;
        L_0x0000:
            r0 = 16;
            r2 = java.lang.System.nanoTime();
            r2 = r2 - r9;
            r4 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
            r2 = r2 / r4;
            r0 = r0 - r2;
            r2 = r8.mMinTimeLeftInFrameForNonBatchedOperationMs;
            r2 = (long) r2;
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 >= 0) goto L_0x0014;
        L_0x0013:
            goto L_0x0028;
        L_0x0014:
            r0 = com.facebook.react.uimanager.UIViewOperationQueue.this;
            r0 = r0.mNonBatchedOperationsLock;
            monitor-enter(r0);
            r1 = com.facebook.react.uimanager.UIViewOperationQueue.this;	 Catch:{ all -> 0x0058 }
            r1 = r1.mNonBatchedOperations;	 Catch:{ all -> 0x0058 }
            r1 = r1.isEmpty();	 Catch:{ all -> 0x0058 }
            if (r1 == 0) goto L_0x0029;
        L_0x0027:
            monitor-exit(r0);	 Catch:{ all -> 0x0058 }
        L_0x0028:
            return;
        L_0x0029:
            r1 = com.facebook.react.uimanager.UIViewOperationQueue.this;	 Catch:{ all -> 0x0058 }
            r1 = r1.mNonBatchedOperations;	 Catch:{ all -> 0x0058 }
            r1 = r1.pollFirst();	 Catch:{ all -> 0x0058 }
            r1 = (com.facebook.react.uimanager.UIViewOperationQueue.UIOperation) r1;	 Catch:{ all -> 0x0058 }
            monitor-exit(r0);	 Catch:{ all -> 0x0058 }
            r2 = android.os.SystemClock.uptimeMillis();	 Catch:{ Exception -> 0x0050 }
            r1.execute();	 Catch:{ Exception -> 0x0050 }
            r0 = com.facebook.react.uimanager.UIViewOperationQueue.this;	 Catch:{ Exception -> 0x0050 }
            r1 = com.facebook.react.uimanager.UIViewOperationQueue.this;	 Catch:{ Exception -> 0x0050 }
            r4 = r1.mNonBatchedExecutionTotalTime;	 Catch:{ Exception -> 0x0050 }
            r6 = android.os.SystemClock.uptimeMillis();	 Catch:{ Exception -> 0x0050 }
            r1 = 0;
            r6 = r6 - r2;
            r4 = r4 + r6;
            r0.mNonBatchedExecutionTotalTime = r4;	 Catch:{ Exception -> 0x0050 }
            goto L_0x0000;
        L_0x0050:
            r9 = move-exception;
            r10 = com.facebook.react.uimanager.UIViewOperationQueue.this;
            r0 = 1;
            r10.mIsInIllegalUIState = r0;
            throw r9;
        L_0x0058:
            r9 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0058 }
            throw r9;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.UIViewOperationQueue.DispatchUIFrameCallback.dispatchPendingNonBatchedOperations(long):void");
        }
    }

    private final class EmitOnLayoutEventOperation extends ViewOperation {
        private final int mScreenHeight;
        private final int mScreenWidth;
        private final int mScreenX;
        private final int mScreenY;

        public EmitOnLayoutEventOperation(int i, int i2, int i3, int i4, int i5) {
            super(i);
            this.mScreenX = i2;
            this.mScreenY = i3;
            this.mScreenWidth = i4;
            this.mScreenHeight = i5;
        }

        public void execute() {
            ((UIManagerModule) UIViewOperationQueue.this.mReactApplicationContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(OnLayoutEvent.obtain(this.mTag, this.mScreenX, this.mScreenY, this.mScreenWidth, this.mScreenHeight));
        }
    }

    private final class ManageChildrenOperation extends ViewOperation {
        private final int[] mIndicesToRemove;
        private final int[] mTagsToDelete;
        private final ViewAtIndex[] mViewsToAdd;

        public ManageChildrenOperation(int i, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
            super(i);
            this.mIndicesToRemove = iArr;
            this.mViewsToAdd = viewAtIndexArr;
            this.mTagsToDelete = iArr2;
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.manageChildren(this.mTag, this.mIndicesToRemove, this.mViewsToAdd, this.mTagsToDelete);
        }
    }

    private class RegisterAnimationOperation extends AnimationOperation {
        private final Animation mAnimation;

        private RegisterAnimationOperation(Animation animation) {
            super(animation.getAnimationID());
            this.mAnimation = animation;
        }

        public void execute() {
            UIViewOperationQueue.this.mAnimationRegistry.registerAnimation(this.mAnimation);
        }
    }

    private final class RemoveAnimationOperation extends AnimationOperation {
        private RemoveAnimationOperation(int i) {
            super(i);
        }

        public void execute() {
            Animation animation = UIViewOperationQueue.this.mAnimationRegistry.getAnimation(this.mAnimationID);
            if (animation != null) {
                animation.cancel();
            }
        }
    }

    private final class RemoveRootViewOperation extends ViewOperation {
        public RemoveRootViewOperation(int i) {
            super(i);
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.removeRootView(this.mTag);
        }
    }

    private final class SendAccessibilityEvent extends ViewOperation {
        private final int mEventType;

        private SendAccessibilityEvent(int i, int i2) {
            super(i);
            this.mEventType = i2;
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.sendAccessibilityEvent(this.mTag, this.mEventType);
        }
    }

    private final class SetChildrenOperation extends ViewOperation {
        private final ReadableArray mChildrenTags;

        public SetChildrenOperation(int i, ReadableArray readableArray) {
            super(i);
            this.mChildrenTags = readableArray;
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.setChildren(this.mTag, this.mChildrenTags);
        }
    }

    private final class ShowPopupMenuOperation extends ViewOperation {
        private final Callback mError;
        private final ReadableArray mItems;
        private final Callback mSuccess;

        public ShowPopupMenuOperation(int i, ReadableArray readableArray, Callback callback, Callback callback2) {
            super(i);
            this.mItems = readableArray;
            this.mError = callback;
            this.mSuccess = callback2;
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.showPopupMenu(this.mTag, this.mItems, this.mSuccess, this.mError);
        }
    }

    private final class UpdateInstanceHandleOperation extends ViewOperation {
        private final long mInstanceHandle;

        private UpdateInstanceHandleOperation(int i, long j) {
            super(i);
            this.mInstanceHandle = j;
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.updateInstanceHandle(this.mTag, this.mInstanceHandle);
        }
    }

    private final class UpdateLayoutOperation extends ViewOperation {
        private final int mHeight;
        private final int mParentTag;
        private final int mWidth;
        private final int mX;
        private final int mY;

        public UpdateLayoutOperation(int i, int i2, int i3, int i4, int i5, int i6) {
            super(i2);
            this.mParentTag = i;
            this.mX = i3;
            this.mY = i4;
            this.mWidth = i5;
            this.mHeight = i6;
            Systrace.startAsyncFlow(0, "updateLayout", this.mTag);
        }

        public void execute() {
            Systrace.endAsyncFlow(0, "updateLayout", this.mTag);
            UIViewOperationQueue.this.mNativeViewHierarchyManager.updateLayout(this.mParentTag, this.mTag, this.mX, this.mY, this.mWidth, this.mHeight);
        }
    }

    private final class UpdatePropertiesOperation extends ViewOperation {
        private final ReactStylesDiffMap mProps;

        private UpdatePropertiesOperation(int i, ReactStylesDiffMap reactStylesDiffMap) {
            super(i);
            this.mProps = reactStylesDiffMap;
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.updateProperties(this.mTag, this.mProps);
        }
    }

    private final class UpdateViewExtraData extends ViewOperation {
        private final Object mExtraData;

        public UpdateViewExtraData(int i, Object obj) {
            super(i);
            this.mExtraData = obj;
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.updateViewExtraData(this.mTag, this.mExtraData);
        }
    }

    public UIViewOperationQueue(ReactApplicationContext reactApplicationContext, NativeViewHierarchyManager nativeViewHierarchyManager, int i) {
        this.mNativeViewHierarchyManager = nativeViewHierarchyManager;
        this.mAnimationRegistry = nativeViewHierarchyManager.getAnimationRegistry();
        if (i == -1) {
            i = 8;
        }
        this.mDispatchUIFrameCallback = new DispatchUIFrameCallback(reactApplicationContext, i);
        this.mReactApplicationContext = reactApplicationContext;
    }

    NativeViewHierarchyManager getNativeViewHierarchyManager() {
        return this.mNativeViewHierarchyManager;
    }

    public void setViewHierarchyUpdateDebugListener(NotThreadSafeViewHierarchyUpdateDebugListener notThreadSafeViewHierarchyUpdateDebugListener) {
        this.mViewHierarchyUpdateDebugListener = notThreadSafeViewHierarchyUpdateDebugListener;
    }

    public void profileNextBatch() {
        this.mIsProfilingNextBatch = true;
        this.mProfiledBatchCommitStartTime = 0;
    }

    public Map<String, Long> getProfiledBatchPerfCounters() {
        Map<String, Long> hashMap = new HashMap();
        hashMap.put("CommitStartTime", Long.valueOf(this.mProfiledBatchCommitStartTime));
        hashMap.put("LayoutTime", Long.valueOf(this.mProfiledBatchLayoutTime));
        hashMap.put("DispatchViewUpdatesTime", Long.valueOf(this.mProfiledBatchDispatchViewUpdatesTime));
        hashMap.put("RunStartTime", Long.valueOf(this.mProfiledBatchRunStartTime));
        hashMap.put("BatchedExecutionTime", Long.valueOf(this.mProfiledBatchBatchedExecutionTime));
        hashMap.put("NonBatchedExecutionTime", Long.valueOf(this.mProfiledBatchNonBatchedExecutionTime));
        return hashMap;
    }

    public boolean isEmpty() {
        return this.mOperations.isEmpty();
    }

    public void addRootView(int i, SizeMonitoringFrameLayout sizeMonitoringFrameLayout, ThemedReactContext themedReactContext) {
        this.mNativeViewHierarchyManager.addRootView(i, sizeMonitoringFrameLayout, themedReactContext);
    }

    protected void enqueueUIOperation(UIOperation uIOperation) {
        SoftAssertions.assertNotNull(uIOperation);
        this.mOperations.add(uIOperation);
    }

    public void enqueueRemoveRootView(int i) {
        this.mOperations.add(new RemoveRootViewOperation(i));
    }

    public void enqueueSetJSResponder(int i, int i2, boolean z) {
        this.mOperations.add(new ChangeJSResponderOperation(i, i2, false, z));
    }

    public void enqueueClearJSResponder() {
        this.mOperations.add(new ChangeJSResponderOperation(0, 0, true, false));
    }

    public void enqueueDispatchCommand(int i, int i2, ReadableArray readableArray) {
        this.mOperations.add(new DispatchCommandOperation(i, i2, readableArray));
    }

    public void enqueueUpdateExtraData(int i, Object obj) {
        this.mOperations.add(new UpdateViewExtraData(i, obj));
    }

    public void enqueueShowPopupMenu(int i, ReadableArray readableArray, Callback callback, Callback callback2) {
        this.mOperations.add(new ShowPopupMenuOperation(i, readableArray, callback, callback2));
    }

    public void enqueueDismissPopupMenu() {
        this.mOperations.add(new DismissPopupMenuOperation());
    }

    public void enqueueCreateView(ThemedReactContext themedReactContext, int i, String str, ReactStylesDiffMap reactStylesDiffMap) {
        synchronized (this.mNonBatchedOperationsLock) {
            this.mNonBatchedOperations.addLast(new CreateViewOperation(themedReactContext, i, str, reactStylesDiffMap));
        }
    }

    public void enqueueUpdateInstanceHandle(int i, long j) {
        this.mOperations.add(new UpdateInstanceHandleOperation(i, j));
    }

    public void enqueueUpdateProperties(int i, String str, ReactStylesDiffMap reactStylesDiffMap) {
        this.mOperations.add(new UpdatePropertiesOperation(i, reactStylesDiffMap));
    }

    public void enqueueOnLayoutEvent(int i, int i2, int i3, int i4, int i5) {
        this.mOperations.add(new EmitOnLayoutEventOperation(i, i2, i3, i4, i5));
    }

    public void enqueueUpdateLayout(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mOperations.add(new UpdateLayoutOperation(i, i2, i3, i4, i5, i6));
    }

    public void enqueueManageChildren(int i, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
        this.mOperations.add(new ManageChildrenOperation(i, iArr, viewAtIndexArr, iArr2));
    }

    public void enqueueSetChildren(int i, ReadableArray readableArray) {
        this.mOperations.add(new SetChildrenOperation(i, readableArray));
    }

    public void enqueueRegisterAnimation(Animation animation) {
        this.mOperations.add(new RegisterAnimationOperation(animation));
    }

    public void enqueueAddAnimation(int i, int i2, Callback callback) {
        this.mOperations.add(new AddAnimationOperation(i, i2, callback));
    }

    public void enqueueRemoveAnimation(int i) {
        this.mOperations.add(new RemoveAnimationOperation(i));
    }

    public void enqueueSetLayoutAnimationEnabled(boolean z) {
        this.mOperations.add(new SetLayoutAnimationEnabledOperation(z));
    }

    public void enqueueConfigureLayoutAnimation(ReadableMap readableMap, Callback callback, Callback callback2) {
        this.mOperations.add(new ConfigureLayoutAnimationOperation(readableMap));
    }

    public void enqueueMeasure(int i, Callback callback) {
        this.mOperations.add(new MeasureOperation(i, callback));
    }

    public void enqueueMeasureInWindow(int i, Callback callback) {
        this.mOperations.add(new MeasureInWindowOperation(i, callback));
    }

    public void enqueueFindTargetForTouch(int i, float f, float f2, Callback callback) {
        this.mOperations.add(new FindTargetForTouchOperation(i, f, f2, callback));
    }

    public void enqueueSendAccessibilityEvent(int i, int i2) {
        this.mOperations.add(new SendAccessibilityEvent(i, i2));
    }

    public void enqueueUIBlock(UIBlock uIBlock) {
        this.mOperations.add(new UIBlockOperation(uIBlock));
    }

    public void prependUIBlock(UIBlock uIBlock) {
        this.mOperations.add(null, new UIBlockOperation(uIBlock));
    }

    public void dispatchViewUpdates(int i, long j, long j2) {
        UIViewOperationQueue uIViewOperationQueue = this;
        int i2 = i;
        SystraceMessage.beginSection(0, "UIViewOperationQueue.dispatchViewUpdates").arg("batchId", i2).flush();
        try {
            ArrayList arrayList;
            final ArrayDeque arrayDeque;
            final long uptimeMillis = SystemClock.uptimeMillis();
            ArrayDeque arrayDeque2 = null;
            if (uIViewOperationQueue.mOperations.isEmpty()) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = uIViewOperationQueue.mOperations;
                uIViewOperationQueue.mOperations = new ArrayList();
                arrayList = arrayList2;
            }
            synchronized (uIViewOperationQueue.mNonBatchedOperationsLock) {
                if (!uIViewOperationQueue.mNonBatchedOperations.isEmpty()) {
                    arrayDeque2 = uIViewOperationQueue.mNonBatchedOperations;
                    uIViewOperationQueue.mNonBatchedOperations = new ArrayDeque();
                }
                arrayDeque = arrayDeque2;
            }
            if (uIViewOperationQueue.mViewHierarchyUpdateDebugListener != null) {
                uIViewOperationQueue.mViewHierarchyUpdateDebugListener.onViewHierarchyUpdateEnqueued();
            }
            final int i3 = i;
            final long j3 = j;
            final long j4 = j2;
            C19681 c19681 = new Runnable() {
                public void run() {
                    SystraceMessage.beginSection(0, "DispatchUI").arg("BatchId", i3).flush();
                    try {
                        Iterator it;
                        long uptimeMillis = SystemClock.uptimeMillis();
                        if (arrayDeque != null) {
                            it = arrayDeque.iterator();
                            while (it.hasNext()) {
                                ((UIOperation) it.next()).execute();
                            }
                        }
                        if (arrayList != null) {
                            it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((UIOperation) it.next()).execute();
                            }
                        }
                        if (UIViewOperationQueue.this.mIsProfilingNextBatch && UIViewOperationQueue.this.mProfiledBatchCommitStartTime == 0) {
                            UIViewOperationQueue.this.mProfiledBatchCommitStartTime = j3;
                            UIViewOperationQueue.this.mProfiledBatchLayoutTime = j4;
                            UIViewOperationQueue.this.mProfiledBatchDispatchViewUpdatesTime = uptimeMillis;
                            UIViewOperationQueue.this.mProfiledBatchRunStartTime = uptimeMillis;
                            Systrace.beginAsyncSection(0, "delayBeforeDispatchViewUpdates", 0, UIViewOperationQueue.this.mProfiledBatchCommitStartTime * 1000000);
                            Systrace.endAsyncSection(0, "delayBeforeDispatchViewUpdates", 0, UIViewOperationQueue.this.mProfiledBatchDispatchViewUpdatesTime * 1000000);
                            Systrace.beginAsyncSection(0, "delayBeforeBatchRunStart", 0, UIViewOperationQueue.this.mProfiledBatchDispatchViewUpdatesTime * 1000000);
                            Systrace.endAsyncSection(0, "delayBeforeBatchRunStart", 0, UIViewOperationQueue.this.mProfiledBatchRunStartTime * 1000000);
                        }
                        UIViewOperationQueue.this.mNativeViewHierarchyManager.clearLayoutAnimation();
                        if (UIViewOperationQueue.this.mViewHierarchyUpdateDebugListener != null) {
                            UIViewOperationQueue.this.mViewHierarchyUpdateDebugListener.onViewHierarchyUpdateFinished();
                        }
                        Systrace.endSection(0);
                    } catch (Exception e) {
                        UIViewOperationQueue.this.mIsInIllegalUIState = true;
                        throw e;
                    } catch (Throwable th) {
                        Systrace.endSection(0);
                    }
                }
            };
            SystraceMessage.beginSection(0, "acquiring mDispatchRunnablesLock").arg("batchId", i2).flush();
            synchronized (uIViewOperationQueue.mDispatchRunnablesLock) {
                Systrace.endSection(0);
                uIViewOperationQueue.mDispatchUIRunnables.add(c19681);
            }
            if (!uIViewOperationQueue.mIsDispatchUIFrameCallbackEnqueued) {
                UiThreadUtil.runOnUiThread(new GuardedRunnable(uIViewOperationQueue.mReactApplicationContext) {
                    public void runGuarded() {
                        UIViewOperationQueue.this.flushPendingBatches();
                    }
                });
            }
            Systrace.endSection(0);
        } catch (Throwable th) {
            Systrace.endSection(0);
        }
    }

    void resumeFrameCallback() {
        this.mIsDispatchUIFrameCallbackEnqueued = true;
        ReactChoreographer.getInstance().postFrameCallback(CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
    }

    void pauseFrameCallback() {
        this.mIsDispatchUIFrameCallbackEnqueued = false;
        ReactChoreographer.getInstance().removeFrameCallback(CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
        flushPendingBatches();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void flushPendingBatches() {
        /*
        r12 = this;
        r0 = r12.mIsInIllegalUIState;
        if (r0 == 0) goto L_0x000c;
    L_0x0004:
        r0 = "ReactNative";
        r1 = "Not flushing pending UI operations because of previously thrown Exception";
        com.facebook.common.logging.FLog.m5714w(r0, r1);
        return;
    L_0x000c:
        r0 = r12.mDispatchRunnablesLock;
        monitor-enter(r0);
        r1 = r12.mDispatchUIRunnables;	 Catch:{ all -> 0x0064 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0064 }
        if (r1 != 0) goto L_0x0062;
    L_0x0017:
        r1 = r12.mDispatchUIRunnables;	 Catch:{ all -> 0x0064 }
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x0064 }
        r2.<init>();	 Catch:{ all -> 0x0064 }
        r12.mDispatchUIRunnables = r2;	 Catch:{ all -> 0x0064 }
        monitor-exit(r0);	 Catch:{ all -> 0x0064 }
        r2 = android.os.SystemClock.uptimeMillis();
        r0 = r1.iterator();
    L_0x0029:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0039;
    L_0x002f:
        r1 = r0.next();
        r1 = (java.lang.Runnable) r1;
        r1.run();
        goto L_0x0029;
    L_0x0039:
        r0 = r12.mIsProfilingNextBatch;
        r4 = 0;
        if (r0 == 0) goto L_0x005f;
    L_0x003f:
        r0 = android.os.SystemClock.uptimeMillis();
        r0 = r0 - r2;
        r12.mProfiledBatchBatchedExecutionTime = r0;
        r0 = r12.mNonBatchedExecutionTotalTime;
        r12.mProfiledBatchNonBatchedExecutionTime = r0;
        r0 = 0;
        r12.mIsProfilingNextBatch = r0;
        r6 = 0;
        r8 = "batchedExecutionTime";
        r9 = 0;
        r10 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r10 = r10 * r2;
        com.facebook.systrace.Systrace.beginAsyncSection(r6, r8, r9, r10);
        r1 = "batchedExecutionTime";
        com.facebook.systrace.Systrace.endAsyncSection(r4, r1, r0);
    L_0x005f:
        r12.mNonBatchedExecutionTotalTime = r4;
        return;
    L_0x0062:
        monitor-exit(r0);	 Catch:{ all -> 0x0064 }
        return;
    L_0x0064:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0064 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.UIViewOperationQueue.flushPendingBatches():void");
    }
}
