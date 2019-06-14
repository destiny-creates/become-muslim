package expo.p307b.p317j;

import android.os.Bundle;
import expo.p304a.p305a.C6003j;
import java.util.List;
import java.util.Map;

/* compiled from: TaskServiceInterface */
/* renamed from: expo.b.j.g */
public interface C7390g extends C6003j {
    void executeTask(C6040d c6040d, Bundle bundle, Error error, C6039c c6039c);

    Bundle getTaskOptions(String str, String str2);

    List<Bundle> getTasksForAppId(String str);

    boolean hasRegisteredTask(String str, String str2);

    void notifyTaskFinished(String str, String str2, Map<String, Object> map);

    void registerTask(String str, String str2, String str3, Class cls, Map<String, Object> map);

    void setTaskManager(C6041e c6041e, String str, String str2);

    boolean taskHasConsumerOfClass(String str, String str2, Class cls);

    void unregisterAllTasksForAppId(String str);

    void unregisterTask(String str, String str2, Class cls);
}
