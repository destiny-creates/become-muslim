package expo.modules.localization;

import android.content.Context;
import expo.p304a.C6006c;
import expo.p304a.C7369b;
import java.util.Collections;
import java.util.List;

public class LocalizationPackage extends C7369b {
    public List<C6006c> createExportedModules(Context context) {
        return Collections.singletonList(new LocalizationModule(context));
    }
}
