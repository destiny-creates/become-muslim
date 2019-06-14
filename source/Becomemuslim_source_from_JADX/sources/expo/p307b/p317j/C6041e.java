package expo.p307b.p317j;

import android.os.Bundle;
import java.util.Map;

/* compiled from: TaskManagerInterface */
/* renamed from: expo.b.j.e */
public interface C6041e {
    void executeTaskWithBody(Bundle bundle);

    void flushQueuedEvents();

    String getAppId();

    boolean isRunningInHeadlessMode();

    void registerTask(String str, Class cls, Map<String, Object> map);

    boolean taskHasConsumerOfClass(String str, Class cls);

    void unregisterTask(String str, Class cls);
}
