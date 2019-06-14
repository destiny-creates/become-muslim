package expolib_v1.p321a;

import java.util.Collections;
import java.util.List;

/* compiled from: CookieJar */
/* renamed from: expolib_v1.a.m */
public interface C6229m {
    /* renamed from: a */
    public static final C6229m f20280a = new C74851();

    /* compiled from: CookieJar */
    /* renamed from: expolib_v1.a.m$1 */
    static class C74851 implements C6229m {
        public void saveFromResponse(C6237r c6237r, List<C6228l> list) {
        }

        C74851() {
        }

        public List<C6228l> loadForRequest(C6237r c6237r) {
            return Collections.emptyList();
        }
    }

    List<C6228l> loadForRequest(C6237r c6237r);

    void saveFromResponse(C6237r c6237r, List<C6228l> list);
}
