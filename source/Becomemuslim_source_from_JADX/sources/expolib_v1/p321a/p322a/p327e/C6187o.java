package expolib_v1.p321a.p322a.p327e;

import java.io.IOException;

/* compiled from: StreamResetException */
/* renamed from: expolib_v1.a.a.e.o */
public final class C6187o extends IOException {
    /* renamed from: a */
    public final C6169b f20032a;

    public C6187o(C6169b c6169b) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stream was reset: ");
        stringBuilder.append(c6169b);
        super(stringBuilder.toString());
        this.f20032a = c6169b;
    }
}
