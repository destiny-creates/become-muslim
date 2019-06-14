package com.facebook.react.bridge;

import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.systrace.SystraceMessage;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Provider;

@DoNotStrip
public class ModuleHolder {
    private static final AtomicInteger sInstanceKeyCounter = new AtomicInteger(1);
    private final boolean mCanOverrideExistingModule;
    private final boolean mHasConstants;
    private boolean mInitializable;
    private final int mInstanceKey = sInstanceKeyCounter.getAndIncrement();
    private boolean mIsCreating;
    private final boolean mIsCxxModule;
    private boolean mIsInitializing;
    private NativeModule mModule;
    private final String mName;
    private Provider<? extends NativeModule> mProvider;

    public ModuleHolder(ReactModuleInfo reactModuleInfo, Provider<? extends NativeModule> provider) {
        this.mName = reactModuleInfo.name();
        this.mCanOverrideExistingModule = reactModuleInfo.canOverrideExistingModule();
        this.mHasConstants = reactModuleInfo.hasConstants();
        this.mProvider = provider;
        this.mIsCxxModule = reactModuleInfo.isCxxModule();
        if (reactModuleInfo.needsEagerInit() != null) {
            this.mModule = create();
        }
    }

    public ModuleHolder(NativeModule nativeModule) {
        this.mName = nativeModule.getName();
        this.mCanOverrideExistingModule = nativeModule.canOverrideExistingModule();
        this.mHasConstants = true;
        this.mIsCxxModule = CxxModuleWrapper.class.isAssignableFrom(nativeModule.getClass());
        this.mModule = nativeModule;
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.NATIVE_MODULE, "NativeModule init: %s", this.mName);
    }

    void markInitializable() {
        NativeModule nativeModule;
        synchronized (this) {
            boolean z = true;
            this.mInitializable = true;
            if (this.mModule != null) {
                Assertions.assertCondition(this.mIsInitializing ^ true);
                nativeModule = this.mModule;
            } else {
                z = false;
                nativeModule = null;
            }
        }
        if (z) {
            doInitialize(nativeModule);
        }
    }

    synchronized boolean hasInstance() {
        return this.mModule != null;
    }

    public synchronized void destroy() {
        if (this.mModule != null) {
            this.mModule.onCatalystInstanceDestroy();
        }
    }

    @DoNotStrip
    public String getName() {
        return this.mName;
    }

    public boolean getCanOverrideExistingModule() {
        return this.mCanOverrideExistingModule;
    }

    public boolean getHasConstants() {
        return this.mHasConstants;
    }

    public boolean isCxxModule() {
        return this.mIsCxxModule;
    }

    @com.facebook.proguard.annotations.DoNotStrip
    public com.facebook.react.bridge.NativeModule getModule() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.mModule;	 Catch:{ all -> 0x003f }
        if (r0 == 0) goto L_0x0009;	 Catch:{ all -> 0x003f }
    L_0x0005:
        r0 = r3.mModule;	 Catch:{ all -> 0x003f }
        monitor-exit(r3);	 Catch:{ all -> 0x003f }
        return r0;	 Catch:{ all -> 0x003f }
    L_0x0009:
        r0 = r3.mIsCreating;	 Catch:{ all -> 0x003f }
        r1 = 1;	 Catch:{ all -> 0x003f }
        r2 = 0;	 Catch:{ all -> 0x003f }
        if (r0 != 0) goto L_0x0012;	 Catch:{ all -> 0x003f }
    L_0x000f:
        r3.mIsCreating = r1;	 Catch:{ all -> 0x003f }
        goto L_0x0013;	 Catch:{ all -> 0x003f }
    L_0x0012:
        r1 = 0;	 Catch:{ all -> 0x003f }
    L_0x0013:
        monitor-exit(r3);	 Catch:{ all -> 0x003f }
        if (r1 == 0) goto L_0x0025;
    L_0x0016:
        r0 = r3.create();
        monitor-enter(r3);
        r3.mIsCreating = r2;	 Catch:{ all -> 0x0022 }
        r3.notifyAll();	 Catch:{ all -> 0x0022 }
        monitor-exit(r3);	 Catch:{ all -> 0x0022 }
        return r0;	 Catch:{ all -> 0x0022 }
    L_0x0022:
        r0 = move-exception;	 Catch:{ all -> 0x0022 }
        monitor-exit(r3);	 Catch:{ all -> 0x0022 }
        throw r0;
    L_0x0025:
        monitor-enter(r3);
    L_0x0026:
        r0 = r3.mModule;	 Catch:{ all -> 0x003c }
        if (r0 != 0) goto L_0x0032;	 Catch:{ all -> 0x003c }
    L_0x002a:
        r0 = r3.mIsCreating;	 Catch:{ all -> 0x003c }
        if (r0 == 0) goto L_0x0032;
    L_0x002e:
        r3.wait();	 Catch:{ InterruptedException -> 0x0026 }
        goto L_0x0026;
    L_0x0032:
        r0 = r3.mModule;	 Catch:{ all -> 0x003c }
        r0 = expolib_v1.com.facebook.infer.annotation.Assertions.assertNotNull(r0);	 Catch:{ all -> 0x003c }
        r0 = (com.facebook.react.bridge.NativeModule) r0;	 Catch:{ all -> 0x003c }
        monitor-exit(r3);	 Catch:{ all -> 0x003c }
        return r0;	 Catch:{ all -> 0x003c }
    L_0x003c:
        r0 = move-exception;	 Catch:{ all -> 0x003c }
        monitor-exit(r3);	 Catch:{ all -> 0x003c }
        throw r0;
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x003f }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.ModuleHolder.getModule():com.facebook.react.bridge.NativeModule");
    }

    private NativeModule create() {
        int i = 0;
        SoftAssertions.assertCondition(this.mModule == null, "Creating an already created module.");
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, this.mName, this.mInstanceKey);
        SystraceMessage.beginSection(0, "ModuleHolder.createModule").arg("name", this.mName).flush();
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.NATIVE_MODULE, "NativeModule init: %s", this.mName);
        try {
            NativeModule nativeModule = (NativeModule) ((Provider) Assertions.assertNotNull(this.mProvider)).get();
            this.mProvider = null;
            synchronized (this) {
                this.mModule = nativeModule;
                if (this.mInitializable && !this.mIsInitializing) {
                    i = 1;
                }
            }
            if (i != 0) {
                doInitialize(nativeModule);
            }
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END, this.mInstanceKey);
            SystraceMessage.endSection(0).flush();
            return nativeModule;
        } catch (Throwable th) {
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END, this.mInstanceKey);
            SystraceMessage.endSection(0).flush();
        }
    }

    private void doInitialize(NativeModule nativeModule) {
        SystraceMessage.beginSection(0, "ModuleHolder.initialize").arg("name", this.mName).flush();
        ReactMarker.logMarker(ReactMarkerConstants.INITIALIZE_MODULE_START, this.mName, this.mInstanceKey);
        try {
            boolean z;
            synchronized (this) {
                z = true;
                if (!this.mInitializable || this.mIsInitializing) {
                    z = false;
                } else {
                    this.mIsInitializing = true;
                }
            }
            if (z) {
                nativeModule.initialize();
                synchronized (this) {
                    this.mIsInitializing = false;
                }
            }
            ReactMarker.logMarker(ReactMarkerConstants.INITIALIZE_MODULE_END, this.mInstanceKey);
            SystraceMessage.endSection(0).flush();
        } catch (Throwable th) {
            ReactMarker.logMarker(ReactMarkerConstants.INITIALIZE_MODULE_END, this.mInstanceKey);
            SystraceMessage.endSection(0).flush();
        }
    }
}
