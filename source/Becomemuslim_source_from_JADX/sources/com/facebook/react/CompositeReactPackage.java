package com.facebook.react;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class CompositeReactPackage implements ReactPackage, ViewManagerOnDemandReactPackage {
    private final List<ReactPackage> mChildReactPackages = new ArrayList();

    public CompositeReactPackage(ReactPackage reactPackage, ReactPackage reactPackage2, ReactPackage... reactPackageArr) {
        this.mChildReactPackages.add(reactPackage);
        this.mChildReactPackages.add(reactPackage2);
        Collections.addAll(this.mChildReactPackages, reactPackageArr);
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        Map hashMap = new HashMap();
        for (ReactPackage createNativeModules : this.mChildReactPackages) {
            for (NativeModule nativeModule : createNativeModules.createNativeModules(reactApplicationContext)) {
                hashMap.put(nativeModule.getName(), nativeModule);
            }
        }
        return new ArrayList(hashMap.values());
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        Map hashMap = new HashMap();
        for (ReactPackage createViewManagers : this.mChildReactPackages) {
            for (ViewManager viewManager : createViewManagers.createViewManagers(reactApplicationContext)) {
                hashMap.put(viewManager.getName(), viewManager);
            }
        }
        return new ArrayList(hashMap.values());
    }

    public List<String> getViewManagerNames(ReactApplicationContext reactApplicationContext) {
        Collection hashSet = new HashSet();
        for (ReactPackage reactPackage : this.mChildReactPackages) {
            if (reactPackage instanceof ViewManagerOnDemandReactPackage) {
                Collection viewManagerNames = ((ViewManagerOnDemandReactPackage) reactPackage).getViewManagerNames(reactApplicationContext);
                if (viewManagerNames != null) {
                    hashSet.addAll(viewManagerNames);
                }
            }
        }
        return new ArrayList(hashSet);
    }

    public ViewManager createViewManager(ReactApplicationContext reactApplicationContext, String str) {
        ListIterator listIterator = this.mChildReactPackages.listIterator(this.mChildReactPackages.size());
        while (listIterator.hasPrevious()) {
            ReactPackage reactPackage = (ReactPackage) listIterator.previous();
            if (reactPackage instanceof ViewManagerOnDemandReactPackage) {
                ViewManager createViewManager = ((ViewManagerOnDemandReactPackage) reactPackage).createViewManager(reactApplicationContext, str);
                if (createViewManager != null) {
                    return createViewManager;
                }
            }
        }
        return null;
    }
}
