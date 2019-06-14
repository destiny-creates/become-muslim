package host.exp.exponent.generated;

import com.facebook.common.internal.DoNotStrip;
import host.exp.exponent.BuildConfig;
import host.exp.exponent.C6301d.C6297a;
import host.exp.exponent.C6301d.C6298b;
import java.util.ArrayList;
import java.util.List;

@DoNotStrip
public class AppConstants {
    public static boolean ARE_REMOTE_UPDATES_ENABLED = true;
    public static final List<C6297a> EMBEDDED_RESPONSES;
    public static boolean FCM_ENABLED = false;
    public static String INITIAL_URL = "exp://exp.host/@thunkable/thunkableCompanion";
    public static final String RELEASE_CHANNEL = "built-8302";
    public static final String SHELL_APP_SCHEME = "expf8bdc6285ccd434db9f08dc875888ea9";
    public static boolean SHOW_LOADING_VIEW_IN_SHELL_APP = false;
    public static final String VERSION_NAME = "2.10.7";

    static {
        List arrayList = new ArrayList();
        arrayList.add(new C6297a("https://exp.host/@thunkable/thunkableCompanion", "assets://shell-app-manifest.json", "application/json"));
        arrayList.add(new C6297a("https://d1wp6m56sqw74a.cloudfront.net/%40thunkable%2FthunkableCompanion%2F1.0.0%2Fcb75f40f9833852dcc84ac0aa8b5eac4-32.0.0-android.js", "assets://shell-app.bundle", "application/javascript"));
        EMBEDDED_RESPONSES = arrayList;
    }

    public static C6298b get() {
        C6298b c6298b = new C6298b();
        c6298b.f20485a = VERSION_NAME;
        c6298b.f20486b = INITIAL_URL;
        c6298b.f20487c = SHELL_APP_SCHEME;
        c6298b.f20488d = RELEASE_CHANNEL;
        c6298b.f20489e = SHOW_LOADING_VIEW_IN_SHELL_APP;
        c6298b.f20490f = ARE_REMOTE_UPDATES_ENABLED;
        c6298b.f20491g = EMBEDDED_RESPONSES;
        c6298b.f20492h = BuildConfig.VERSION_CODE;
        c6298b.f20493i = FCM_ENABLED;
        return c6298b;
    }
}
