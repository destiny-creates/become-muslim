package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.C0366b;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskStackBuilder */
public final class al implements Iterable<Intent> {
    /* renamed from: a */
    private static final C0290c f774a;
    /* renamed from: b */
    private final ArrayList<Intent> f775b = new ArrayList();
    /* renamed from: c */
    private final Context f776c;

    /* compiled from: TaskStackBuilder */
    /* renamed from: android.support.v4.app.al$a */
    public interface C0289a {
        /* renamed from: a */
        Intent mo3558a();
    }

    /* compiled from: TaskStackBuilder */
    /* renamed from: android.support.v4.app.al$c */
    static class C0290c {
        C0290c() {
        }
    }

    /* compiled from: TaskStackBuilder */
    /* renamed from: android.support.v4.app.al$b */
    static class C3175b extends C0290c {
        C3175b() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f774a = new C3175b();
        } else {
            f774a = new C0290c();
        }
    }

    private al(Context context) {
        this.f776c = context;
    }

    /* renamed from: a */
    public static al m858a(Context context) {
        return new al(context);
    }

    /* renamed from: a */
    public al m861a(Intent intent) {
        this.f775b.add(intent);
        return this;
    }

    /* renamed from: a */
    public al m859a(Activity activity) {
        Intent a = activity instanceof C0289a ? ((C0289a) activity).mo3558a() : null;
        if (a == null) {
            a = aa.m753a(activity);
        }
        if (a != null) {
            ComponentName component = a.getComponent();
            if (component == null) {
                component = a.resolveActivity(this.f776c.getPackageManager());
            }
            m860a(component);
            m861a(a);
        }
        return this;
    }

    /* renamed from: a */
    public al m860a(ComponentName componentName) {
        int size = this.f775b.size();
        try {
            componentName = aa.m754a(this.f776c, componentName);
            while (componentName != null) {
                this.f775b.add(size, componentName);
                componentName = aa.m754a(this.f776c, componentName.getComponent());
            }
            return this;
        } catch (ComponentName componentName2) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(componentName2);
        }
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f775b.iterator();
    }

    /* renamed from: a */
    public void m862a() {
        m863a(null);
    }

    /* renamed from: a */
    public void m863a(Bundle bundle) {
        if (this.f775b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f775b.toArray(new Intent[this.f775b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (C0366b.m1106a(this.f776c, intentArr, bundle) == null) {
            bundle = new Intent(intentArr[intentArr.length - 1]);
            bundle.addFlags(268435456);
            this.f776c.startActivity(bundle);
        }
    }
}
