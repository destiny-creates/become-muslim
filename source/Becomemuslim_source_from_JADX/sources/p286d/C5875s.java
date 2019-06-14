package p286d;

import java.io.Closeable;
import java.io.Flushable;

/* compiled from: Sink */
/* renamed from: d.s */
public interface C5875s extends Closeable, Flushable {
    void close();

    void flush();

    C5877u timeout();

    void write(C8037c c8037c, long j);
}
