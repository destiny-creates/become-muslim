package okhttp3.internal.huc;

import okhttp3.internal.http.UnrepeatableRequestBody;
import p286d.C5870l;
import p286d.C5871m;
import p286d.C7203d;
import p286d.C8037c;

final class StreamedRequestBody extends OutputStreamRequestBody implements UnrepeatableRequestBody {
    private final C5871m pipe = new C5871m(8192);

    StreamedRequestBody(long j) {
        initOutputStream(C5870l.m24719a(this.pipe.m24734b()), j);
    }

    public void writeTo(C7203d c7203d) {
        C8037c c8037c = new C8037c();
        while (this.pipe.m24733a().read(c8037c, 8192) != -1) {
            c7203d.write(c8037c, c8037c.m38961a());
        }
    }
}
