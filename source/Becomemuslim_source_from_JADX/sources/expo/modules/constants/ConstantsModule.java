package expo.modules.constants;

import android.content.Context;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6001h;
import expo.p307b.p310c.C6023a;
import java.util.Map;

public class ConstantsModule extends C6006c implements C6001h {
    private C6007d mModuleRegistry;

    public String getName() {
        return "ExponentConstants";
    }

    public ConstantsModule(Context context) {
        super(context);
    }

    public Map<String, Object> getConstants() {
        return ((C6023a) this.mModuleRegistry.m25133a(C6023a.class)).getConstants();
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mModuleRegistry = c6007d;
    }

    @C5996c
    public void getWebViewUserAgentAsync(C6009f c6009f) {
        c6009f.mo5137a(System.getProperty("http.agent"));
    }
}
