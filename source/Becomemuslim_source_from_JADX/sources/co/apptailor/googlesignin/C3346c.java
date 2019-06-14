package co.apptailor.googlesignin;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: RNGoogleSigninPackage */
/* renamed from: co.apptailor.googlesignin.c */
public class C3346c implements ReactPackage {
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        List<NativeModule> arrayList = new ArrayList();
        arrayList.add(new RNGoogleSigninModule(reactApplicationContext));
        return arrayList;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new ViewManager[]{new RNGoogleSigninButtonViewManager()});
    }
}
