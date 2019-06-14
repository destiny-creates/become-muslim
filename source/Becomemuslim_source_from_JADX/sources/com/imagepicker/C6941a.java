package com.imagepicker;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.imagepicker.C5412b.C5406b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: ImagePickerPackage */
/* renamed from: com.imagepicker.a */
public class C6941a implements ReactPackage {
    /* renamed from: a */
    public static final int f24805a = C5406b.DefaultExplainingPermissionsTheme;
    /* renamed from: b */
    private final int f24806b = f24805a;

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new NativeModule[]{new ImagePickerModule(reactApplicationContext, this.f24806b)});
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
