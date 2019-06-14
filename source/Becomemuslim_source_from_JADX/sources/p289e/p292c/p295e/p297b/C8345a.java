package p289e.p292c.p295e.p297b;

import java.util.Iterator;
import p289e.p292c.p295e.p296a.C5952c;

/* compiled from: BaseLinkedQueue */
/* renamed from: e.c.e.b.a */
abstract class C8345a<E> extends C8257b<E> {
    C8345a() {
    }

    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final int size() {
        C5952c a = m42865a();
        C5952c b = m33648b();
        int i = 0;
        while (a != b && i < Integer.MAX_VALUE) {
            C5952c c;
            while (true) {
                c = a.m24886c();
                if (c != null) {
                    break;
                }
            }
            i++;
            a = c;
        }
        return i;
    }

    public final boolean isEmpty() {
        return m42865a() == m33648b();
    }
}
