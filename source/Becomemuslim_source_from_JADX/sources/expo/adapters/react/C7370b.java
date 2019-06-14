package expo.adapters.react;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import expo.adapters.react.views.SimpleViewManagerAdapter;
import expo.adapters.react.views.ViewGroupManagerAdapter;
import expo.p304a.C6007d;
import expo.p304a.C6012g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ModuleRegistryAdapter */
/* renamed from: expo.adapters.react.b */
public class C7370b implements ReactPackage {
    protected C7372e mModuleRegistryProvider;

    public C7370b(C7372e c7372e) {
        this.mModuleRegistryProvider = c7372e;
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return getNativeModulesFromModuleRegistry(reactApplicationContext, this.mModuleRegistryProvider.mo5139a(reactApplicationContext));
    }

    protected List<NativeModule> getNativeModulesFromModuleRegistry(ReactApplicationContext reactApplicationContext, C6007d c6007d) {
        List<NativeModule> arrayList = new ArrayList(2);
        arrayList.add(new NativeModulesProxy(reactApplicationContext, c6007d));
        arrayList.add(new ModuleRegistryReadyNotifier(c6007d));
        return arrayList;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        List<ViewManager> arrayList = new ArrayList();
        for (C6012g c6012g : this.mModuleRegistryProvider.m33788b(reactApplicationContext)) {
            switch (c6012g.getViewManagerType()) {
                case GROUP:
                    arrayList.add(new ViewGroupManagerAdapter(c6012g));
                    break;
                case SIMPLE:
                    arrayList.add(new SimpleViewManagerAdapter(c6012g));
                    break;
                default:
                    break;
            }
        }
        return arrayList;
    }
}
