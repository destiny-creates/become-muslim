package expo.modules.gl;

import android.content.Context;
import expo.p304a.C6007d;
import expo.p304a.C6012g;
import expo.p304a.C6012g.C6011b;
import expo.p304a.p305a.C6001h;
import java.util.Arrays;
import java.util.List;

public class GLViewManager extends C6012g<GLView> implements C6001h {
    private C6007d mModuleRegistry;

    public String getName() {
        return "ExponentGLView";
    }

    public GLView createViewInstance(Context context) {
        return new GLView(context, this.mModuleRegistry);
    }

    public C6011b getViewManagerType() {
        return C6011b.SIMPLE;
    }

    public List<String> getExportedEventNames() {
        return Arrays.asList(new String[]{"onSurfaceCreate"});
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mModuleRegistry = c6007d;
    }
}
