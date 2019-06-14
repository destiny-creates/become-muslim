package expolib_v1.p321a;

import expolib_v1.p321a.C6228l.C6227a;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p321a.p322a.p329g.C6192e;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: JavaNetCookieJar */
/* renamed from: expolib_v1.a.t */
public final class C7487t implements C6229m {
    /* renamed from: b */
    private final CookieHandler f25978b;

    public C7487t(CookieHandler cookieHandler) {
        this.f25978b = cookieHandler;
    }

    public void saveFromResponse(C6237r c6237r, List<C6228l> list) {
        if (this.f25978b != null) {
            List arrayList = new ArrayList();
            for (C6228l a : list) {
                arrayList.add(a.m25685a(true));
            }
            try {
                this.f25978b.put(c6237r.m25762a(), Collections.singletonMap("Set-Cookie", arrayList));
            } catch (Throwable e) {
                C6192e b = C6192e.m25495b();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Saving cookies failed for ");
                stringBuilder.append(c6237r.m25764c("/..."));
                b.mo5296a(5, stringBuilder.toString(), e);
            }
        }
    }

    public List<C6228l> loadForRequest(C6237r c6237r) {
        try {
            List list = null;
            for (Entry entry : this.f25978b.get(c6237r.m25762a(), Collections.emptyMap()).entrySet()) {
                String str = (String) entry.getKey();
                if (("Cookie".equalsIgnoreCase(str) || "Cookie2".equalsIgnoreCase(str)) && !((List) entry.getValue()).isEmpty()) {
                    for (String str2 : (List) entry.getValue()) {
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.addAll(m33954a(c6237r, str2));
                    }
                }
            }
            if (list != null) {
                c6237r = Collections.unmodifiableList(list);
            } else {
                c6237r = Collections.emptyList();
            }
            return c6237r;
        } catch (Throwable e) {
            C6192e b = C6192e.m25495b();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Loading cookies failed for ");
            stringBuilder.append(c6237r.m25764c("/..."));
            b.mo5296a(5, stringBuilder.toString(), e);
            return Collections.emptyList();
        }
    }

    /* renamed from: a */
    private List<C6228l> m33954a(C6237r c6237r, String str) {
        List<C6228l> arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int a = C6165c.m25304a(str, i, length, ";,");
            int a2 = C6165c.m25303a(str, i, a, '=');
            String c = C6165c.m25325c(str, i, a2);
            if (!c.startsWith("$")) {
                String c2 = a2 < a ? C6165c.m25325c(str, a2 + 1, a) : "";
                if (c2.startsWith("\"") && c2.endsWith("\"")) {
                    c2 = c2.substring(1, c2.length() - 1);
                }
                arrayList.add(new C6227a().m25671a(c).m25673b(c2).m25674c(c6237r.m25769f()).m25672a());
            }
            i = a + 1;
        }
        return arrayList;
    }
}
