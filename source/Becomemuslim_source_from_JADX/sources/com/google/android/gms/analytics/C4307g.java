package com.google.android.gms.analytics;

import android.content.Context;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* renamed from: com.google.android.gms.analytics.g */
public class C4307g implements C2706b {
    /* renamed from: a */
    private final TreeSet<String> f11353a = new TreeSet();

    public C4307g(Context context, Collection<String> collection) {
        m13983a(context, (Collection) collection);
    }

    /* renamed from: a */
    public void m13983a(Context context, Collection<String> collection) {
        this.f11353a.clear();
        Set<String> hashSet = new HashSet();
        if (collection != null) {
            hashSet.addAll(collection);
        }
        if (context != null) {
            hashSet.add(context.getApplicationContext().getPackageName());
        }
        for (String str : hashSet) {
            Object obj = 1;
            Iterator it = this.f11353a.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str.startsWith(str2)) {
                    obj = null;
                } else {
                    if (str2.startsWith(str)) {
                        this.f11353a.remove(str2);
                    }
                    if (obj != null) {
                        this.f11353a.add(str);
                    }
                }
            }
            if (obj != null) {
                this.f11353a.add(str);
            }
        }
    }

    /* renamed from: a */
    protected Throwable m13982a(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    /* renamed from: b */
    protected StackTraceElement m13984b(Throwable th) {
        th = th.getStackTrace();
        if (th != null) {
            if (th.length != 0) {
                for (StackTraceElement stackTraceElement : th) {
                    String className = stackTraceElement.getClassName();
                    Iterator it = this.f11353a.iterator();
                    while (it.hasNext()) {
                        if (className.startsWith((String) it.next())) {
                            return stackTraceElement;
                        }
                    }
                }
                return th[0];
            }
        }
        return null;
    }

    /* renamed from: a */
    protected String m13981a(Throwable th, StackTraceElement stackTraceElement, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(th.getClass().getSimpleName());
        if (stackTraceElement != null) {
            String[] split = stackTraceElement.getClassName().split("\\.");
            String str2 = "unknown";
            if (split != null && split.length > 0) {
                str2 = split[split.length - 1];
            }
            stringBuilder.append(String.format(" (@%s:%s:%s)", new Object[]{str2, stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())}));
        }
        if (str != null) {
            stringBuilder.append(String.format(" {%s}", new Object[]{str}));
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public String mo2354a(String str, Throwable th) {
        return m13981a(m13982a(th), m13984b(m13982a(th)), str);
    }
}
