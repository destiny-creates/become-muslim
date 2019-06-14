package expo.modules.gl;

import android.content.Context;
import expo.p304a.C6006c;
import expo.p304a.C6012g;
import expo.p304a.C7369b;
import java.util.Collections;
import java.util.List;

public class GLPackage extends C7369b {
    public List<C6006c> createExportedModules(Context context) {
        return Collections.singletonList(new GLObjectManagerModule(context));
    }

    public List<C6012g> createViewManagers(Context context) {
        return Collections.singletonList(new GLViewManager());
    }
}
