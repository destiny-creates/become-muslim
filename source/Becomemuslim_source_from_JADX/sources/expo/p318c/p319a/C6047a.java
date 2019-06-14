package expo.p318c.p319a;

import android.content.Context;
import android.util.Log;
import expo.p318c.p319a.p320a.C6044a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AppLoaderProvider */
/* renamed from: expo.c.a.a */
public class C6047a {
    /* renamed from: a */
    private static Map<String, Class> f19813a = new HashMap();

    /* compiled from: AppLoaderProvider */
    /* renamed from: expo.c.a.a$a */
    public static abstract class C6043a {
        public void onComplete(boolean z, Exception exception) {
        }
    }

    /* renamed from: a */
    public static void m25174a(String str, Class cls) {
        f19813a.put(str, cls);
    }

    /* renamed from: a */
    public static C6044a m25173a(String str, Context context) {
        try {
            return (C6044a) ((Class) f19813a.get(str)).getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
        } catch (String str2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot initialize app loader. ");
            stringBuilder.append(str2.getMessage());
            Log.e("Expo", stringBuilder.toString());
            return null;
        }
    }
}
