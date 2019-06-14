package expo.p307b.p317j;

import android.os.Bundle;
import java.util.Map;

/* compiled from: TaskInterface */
/* renamed from: expo.b.j.d */
public interface C6040d {
    void execute(Bundle bundle, Error error);

    void execute(Bundle bundle, Error error, C6039c c6039c);

    String getAppId();

    String getAppUrl();

    C6038b getConsumer();

    String getName();

    Map<String, Object> getOptions();

    Bundle getOptionsBundle();

    void setOptions(Map<String, Object> map);
}
