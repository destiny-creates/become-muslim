package okhttp3.internal.http2;

import java.util.List;
import p286d.C7204e;

public interface PushObserver {
    public static final PushObserver CANCEL = new C76711();

    /* renamed from: okhttp3.internal.http2.PushObserver$1 */
    class C76711 implements PushObserver {
        public boolean onHeaders(int i, List<Header> list, boolean z) {
            return true;
        }

        public boolean onRequest(int i, List<Header> list) {
            return true;
        }

        public void onReset(int i, ErrorCode errorCode) {
        }

        C76711() {
        }

        public boolean onData(int i, C7204e c7204e, int i2, boolean z) {
            c7204e.mo6309i((long) i2);
            return true;
        }
    }

    boolean onData(int i, C7204e c7204e, int i2, boolean z);

    boolean onHeaders(int i, List<Header> list, boolean z);

    boolean onRequest(int i, List<Header> list);

    void onReset(int i, ErrorCode errorCode);
}
