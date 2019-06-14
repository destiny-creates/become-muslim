package expolib_v1.p321a;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* compiled from: Dns */
/* renamed from: expolib_v1.a.o */
public interface C6231o {
    /* renamed from: a */
    public static final C6231o f20288a = new C74861();

    /* compiled from: Dns */
    /* renamed from: expolib_v1.a.o$1 */
    static class C74861 implements C6231o {
        C74861() {
        }

        /* renamed from: a */
        public List<InetAddress> mo5327a(String str) {
            if (str != null) {
                return Arrays.asList(InetAddress.getAllByName(str));
            }
            throw new UnknownHostException("hostname == null");
        }
    }

    /* renamed from: a */
    List<InetAddress> mo5327a(String str);
}
