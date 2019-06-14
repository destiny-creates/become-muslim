package expo.adapters.react.views;

import android.view.ViewGroup;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import expo.p304a.C6007d;
import expo.p304a.C6012g;
import expo.p304a.p305a.C6001h;
import java.util.Map;

public class ViewGroupManagerAdapter<M extends C6012g<V>, V extends ViewGroup> extends ViewGroupManager<V> implements C6001h {
    private M mViewManager;

    public ViewGroupManagerAdapter(M m) {
        this.mViewManager = m;
    }

    protected V createViewInstance(ThemedReactContext themedReactContext) {
        return (ViewGroup) this.mViewManager.createViewInstance(themedReactContext);
    }

    public void onDropViewInstance(V v) {
        this.mViewManager.onDropViewInstance(v);
        super.onDropViewInstance(v);
    }

    public Map<String, Object> getConstants() {
        return C6016a.m25161b(this.mViewManager);
    }

    public String getName() {
        return C6016a.m25158a(this.mViewManager);
    }

    @ReactProp(name = "proxiedProperties")
    public void setProxiedProperties(V v, ReadableMap readableMap) {
        C6016a.m25160a(getName(), this.mViewManager, v, readableMap);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return C6016a.m25162c(this.mViewManager);
    }

    public void setModuleRegistry(C6007d c6007d) {
        C6016a.m25159a(this.mViewManager, c6007d);
    }
}
