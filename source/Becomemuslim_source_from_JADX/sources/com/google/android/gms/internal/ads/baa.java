package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.gmsg.ae;
import com.google.android.gms.common.util.C2905p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@cm
public abstract class baa<ReferenceT> {
    /* renamed from: a */
    private final Map<String, CopyOnWriteArrayList<ae<? super ReferenceT>>> f15117a = new HashMap();

    /* renamed from: a */
    private final synchronized void mo6650a(String str, Map<String, String> map) {
        if (mt.m19917a(2)) {
            String str2 = "Received GMSG: ";
            String valueOf = String.valueOf(str);
            jn.m30864a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            for (String valueOf2 : map.keySet()) {
                String str3 = (String) map.get(valueOf2);
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf2).length() + 4) + String.valueOf(str3).length());
                stringBuilder.append("  ");
                stringBuilder.append(valueOf2);
                stringBuilder.append(": ");
                stringBuilder.append(str3);
                jn.m30864a(stringBuilder.toString());
            }
        }
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f15117a.get(str);
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                nu.f15846a.execute(new bab(this, (ae) it.next(), map));
            }
        }
    }

    /* renamed from: a */
    public final synchronized void m19186a(String str, ae<? super ReferenceT> aeVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f15117a.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f15117a.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(aeVar);
    }

    /* renamed from: a */
    public final synchronized void m19187a(String str, C2905p<ae<? super ReferenceT>> c2905p) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f15117a.get(str);
        if (copyOnWriteArrayList != null) {
            Collection arrayList = new ArrayList();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ae aeVar = (ae) it.next();
                if (c2905p.a(aeVar)) {
                    arrayList.add(aeVar);
                }
            }
            copyOnWriteArrayList.removeAll(arrayList);
        }
    }

    /* renamed from: a */
    public final boolean m19188a(Uri uri) {
        if (!"gmsg".equalsIgnoreCase(uri.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            return false;
        }
        String path = uri.getPath();
        ax.e();
        mo6650a(path, jw.m19693a(uri));
        return true;
    }

    /* renamed from: b */
    public final synchronized void m19189b(String str, ae<? super ReferenceT> aeVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f15117a.get(str);
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(aeVar);
        }
    }

    /* renamed from: k */
    public synchronized void mo4356k() {
        this.f15117a.clear();
    }

    /* renamed from: o */
    public abstract ReferenceT mo4357o();
}
