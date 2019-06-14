package com.facebook.react;

import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.systrace.SystraceMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class LazyReactPackage implements ReactPackage {

    /* renamed from: com.facebook.react.LazyReactPackage$1 */
    static class C38001 implements ReactModuleInfoProvider {
        C38001() {
        }

        public Map<String, ReactModuleInfo> getReactModuleInfos() {
            return Collections.emptyMap();
        }
    }

    public abstract List<ModuleSpec> getNativeModules(ReactApplicationContext reactApplicationContext);

    public abstract ReactModuleInfoProvider getReactModuleInfoProvider();

    public static com.facebook.react.module.model.ReactModuleInfoProvider getReactModuleInfoProviderViaReflection(com.facebook.react.LazyReactPackage r4) {
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
        r0 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0082 }
        r0.<init>();	 Catch:{ ClassNotFoundException -> 0x0082 }
        r1 = r4.getClass();	 Catch:{ ClassNotFoundException -> 0x0082 }
        r1 = r1.getCanonicalName();	 Catch:{ ClassNotFoundException -> 0x0082 }
        r0.append(r1);	 Catch:{ ClassNotFoundException -> 0x0082 }
        r1 = "$$ReactModuleInfoProvider";	 Catch:{ ClassNotFoundException -> 0x0082 }
        r0.append(r1);	 Catch:{ ClassNotFoundException -> 0x0082 }
        r0 = r0.toString();	 Catch:{ ClassNotFoundException -> 0x0082 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0082 }
        if (r0 == 0) goto L_0x005e;
    L_0x001f:
        r0 = r0.newInstance();	 Catch:{ InstantiationException -> 0x0042, IllegalAccessException -> 0x0026 }
        r0 = (com.facebook.react.module.model.ReactModuleInfoProvider) r0;	 Catch:{ InstantiationException -> 0x0042, IllegalAccessException -> 0x0026 }
        return r0;
    L_0x0026:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Unable to instantiate ReactModuleInfoProvider for ";
        r2.append(r3);
        r4 = r4.getClass();
        r2.append(r4);
        r4 = r2.toString();
        r1.<init>(r4, r0);
        throw r1;
    L_0x0042:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Unable to instantiate ReactModuleInfoProvider for ";
        r2.append(r3);
        r4 = r4.getClass();
        r2.append(r4);
        r4 = r2.toString();
        r1.<init>(r4, r0);
        throw r1;
    L_0x005e:
        r0 = new java.lang.RuntimeException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "ReactModuleInfoProvider class for ";
        r1.append(r2);
        r4 = r4.getClass();
        r4 = r4.getCanonicalName();
        r1.append(r4);
        r4 = " not found.";
        r1.append(r4);
        r4 = r1.toString();
        r0.<init>(r4);
        throw r0;
    L_0x0082:
        r4 = new com.facebook.react.LazyReactPackage$1;
        r4.<init>();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.LazyReactPackage.getReactModuleInfoProviderViaReflection(com.facebook.react.LazyReactPackage):com.facebook.react.module.model.ReactModuleInfoProvider");
    }

    public final List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        List<NativeModule> arrayList = new ArrayList();
        for (ModuleSpec moduleSpec : getNativeModules(reactApplicationContext)) {
            SystraceMessage.beginSection(0, "createNativeModule").arg("module", moduleSpec.getType()).flush();
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, moduleSpec.getClassName());
            try {
                NativeModule nativeModule = (NativeModule) moduleSpec.getProvider().get();
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
                SystraceMessage.endSection(0).flush();
                arrayList.add(nativeModule);
            } catch (ReactApplicationContext reactApplicationContext2) {
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
                SystraceMessage.endSection(0).flush();
                throw reactApplicationContext2;
            }
        }
        return arrayList;
    }

    public List<ModuleSpec> getViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        ReactApplicationContext<ModuleSpec> viewManagers = getViewManagers(reactApplicationContext);
        if (viewManagers != null) {
            if (!viewManagers.isEmpty()) {
                List<ViewManager> arrayList = new ArrayList();
                for (ModuleSpec provider : viewManagers) {
                    arrayList.add((ViewManager) provider.getProvider().get());
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }
}
