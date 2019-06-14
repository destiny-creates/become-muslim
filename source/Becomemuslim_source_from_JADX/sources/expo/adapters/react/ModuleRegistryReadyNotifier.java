package expo.adapters.react;

import com.facebook.react.bridge.BaseJavaModule;
import expo.p304a.C6007d;

public class ModuleRegistryReadyNotifier extends BaseJavaModule {
    private C6007d mModuleRegistry;

    public String getName() {
        return null;
    }

    public ModuleRegistryReadyNotifier(C6007d c6007d) {
        this.mModuleRegistry = c6007d;
    }

    public void initialize() {
        this.mModuleRegistry.m25143c();
    }
}
