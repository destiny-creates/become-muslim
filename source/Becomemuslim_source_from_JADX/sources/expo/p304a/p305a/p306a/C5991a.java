package expo.p304a.p305a.p306a;

import android.os.Bundle;

/* compiled from: EventEmitter */
/* renamed from: expo.a.a.a.a */
public interface C5991a {

    /* compiled from: EventEmitter */
    /* renamed from: expo.a.a.a.a$b */
    public interface C5990b {
        boolean canCoalesce();

        short getCoalescingKey();

        Bundle getEventBody();

        String getEventName();
    }

    /* compiled from: EventEmitter */
    /* renamed from: expo.a.a.a.a$a */
    public static abstract class C7368a implements C5990b {
        public boolean canCoalesce() {
            return true;
        }

        public short getCoalescingKey() {
            return (short) 0;
        }
    }

    /* renamed from: a */
    void mo5141a(int i, C5990b c5990b);

    /* renamed from: a */
    void mo5142a(String str, Bundle bundle);
}
