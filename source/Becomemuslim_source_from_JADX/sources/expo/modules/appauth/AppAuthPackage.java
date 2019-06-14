package expo.modules.appauth;

import android.content.Context;
import expo.p304a.C6006c;
import expo.p304a.C7369b;
import java.util.Collections;
import java.util.List;

public class AppAuthPackage extends C7369b {
    public List<C6006c> createExportedModules(Context context) {
        return Collections.singletonList(new AppAuthModule(context));
    }
}
