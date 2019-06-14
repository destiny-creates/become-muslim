package expo.modules.taskManager;

import android.content.Context;
import expo.p304a.C6006c;
import expo.p304a.C7369b;
import expo.p304a.p305a.C5998e;
import expo.p304a.p305a.C6003j;
import java.util.Collections;
import java.util.List;

public class TaskManagerPackage extends C7369b {
    public List<C6006c> createExportedModules(Context context) {
        return Collections.singletonList(new TaskManagerModule(context));
    }

    public List<C5998e> createInternalModules(Context context) {
        return Collections.singletonList(new TaskManagerInternalModule(context));
    }

    public List<C6003j> createSingletonModules(Context context) {
        return Collections.singletonList(new TaskService(context));
    }
}
