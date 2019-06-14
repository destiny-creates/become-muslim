package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.os.Bundle;
import android.support.v4.app.ac.C0278a;
import android.util.Log;
import android.util.SparseArray;
import com.facebook.applinks.AppLinkData;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NotificationCompatJellybean */
class ae {
    /* renamed from: a */
    private static final Object f734a = new Object();
    /* renamed from: b */
    private static Field f735b;
    /* renamed from: c */
    private static boolean f736c;
    /* renamed from: d */
    private static final Object f737d = new Object();

    /* renamed from: a */
    public static SparseArray<Bundle> m813a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    /* renamed from: a */
    public static Bundle m811a(Notification notification) {
        synchronized (f734a) {
            if (f736c) {
                return null;
            }
            try {
                if (f735b == null) {
                    Field declaredField = Notification.class.getDeclaredField(AppLinkData.ARGUMENTS_EXTRAS_KEY);
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        f735b = declaredField;
                    } else {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f736c = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) f735b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f735b.set(notification, bundle);
                }
                return bundle;
            } catch (Notification notification2) {
                Log.e("NotificationCompat", "Unable to access notification extras", notification2);
                f736c = true;
                return null;
            } catch (Notification notification22) {
                Log.e("NotificationCompat", "Unable to access notification extras", notification22);
                f736c = true;
                return null;
            }
        }
    }

    /* renamed from: a */
    public static Bundle m810a(Builder builder, C0278a c0278a) {
        builder.addAction(c0278a.m762a(), c0278a.m763b(), c0278a.m764c());
        builder = new Bundle(c0278a.m765d());
        if (c0278a.m767f() != null) {
            builder.putParcelableArray("android.support.remoteInputs", m814a(c0278a.m767f()));
        }
        if (c0278a.m768g() != null) {
            builder.putParcelableArray("android.support.dataRemoteInputs", m814a(c0278a.m768g()));
        }
        builder.putBoolean("android.support.allowGeneratedReplies", c0278a.m766e());
        return builder;
    }

    /* renamed from: a */
    private static Bundle m812a(ah ahVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", ahVar.m841a());
        bundle.putCharSequence("label", ahVar.m842b());
        bundle.putCharSequenceArray("choices", ahVar.m843c());
        bundle.putBoolean("allowFreeFormInput", ahVar.m846f());
        bundle.putBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY, ahVar.m847g());
        ah<String> d = ahVar.m844d();
        if (!(d == null || d.isEmpty())) {
            ArrayList arrayList = new ArrayList(d.size());
            for (String add : d) {
                arrayList.add(add);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    /* renamed from: a */
    private static Bundle[] m814a(ah[] ahVarArr) {
        if (ahVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[ahVarArr.length];
        for (int i = 0; i < ahVarArr.length; i++) {
            bundleArr[i] = m812a(ahVarArr[i]);
        }
        return bundleArr;
    }
}
