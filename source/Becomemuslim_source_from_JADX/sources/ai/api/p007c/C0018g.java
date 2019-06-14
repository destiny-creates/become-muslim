package ai.api.p007c;

import ai.api.p009e.C0031c;
import com.google.p127a.C2162l;
import com.google.p127a.C4053q;
import com.google.p127a.p128a.C2120c;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Result */
/* renamed from: ai.api.c.g */
public class C0018g implements Serializable {
    private static final long serialVersionUID = 1;
    @C2120c(a = "action")
    /* renamed from: a */
    private String f74a;
    @C2120c(a = "parameters")
    /* renamed from: b */
    private HashMap<String, C2162l> f75b;
    @C2120c(a = "resolvedQuery")
    /* renamed from: c */
    private String f76c;

    /* renamed from: a */
    void m64a() {
        if (this.f75b != null) {
            List<String> linkedList = new LinkedList();
            for (String str : this.f75b.keySet()) {
                C2162l c2162l = (C2162l) this.f75b.get(str);
                if (c2162l != null && c2162l.m6000i() && ((C4053q) c2162l).m12487q() && C0031c.m89a(c2162l.mo2032b())) {
                    linkedList.add(str);
                }
            }
            for (String remove : linkedList) {
                this.f75b.remove(remove);
            }
        }
    }

    public String toString() {
        return String.format("Result {action='%s', resolvedQuery='%s'}", new Object[]{this.f74a, this.f76c});
    }
}
