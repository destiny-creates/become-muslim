package ai.api.p005a;

import android.content.Context;
import android.text.TextUtils;
import java.util.UUID;

/* compiled from: SessionIdStorage */
/* renamed from: ai.api.a.e */
public abstract class C0008e {
    /* renamed from: a */
    public static synchronized String m23a(Context context) {
        synchronized (C0008e.class) {
            context = context.getSharedPreferences("APIAI_preferences", 0);
            Object string = context.getString("sessionId", "");
            if (TextUtils.isEmpty(string)) {
                context = context.edit();
                String uuid = UUID.randomUUID().toString();
                context.putString("sessionId", uuid);
                context.commit();
                return uuid;
            }
            return string;
        }
    }
}
