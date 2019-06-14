package okhttp3.internal.cache2;

import java.nio.channels.FileChannel;
import p286d.C8037c;

final class FileOperator {
    private final FileChannel fileChannel;

    FileOperator(FileChannel fileChannel) {
        this.fileChannel = fileChannel;
    }

    public void write(long j, C8037c c8037c, long j2) {
        if (j2 < 0 || j2 > c8037c.m38961a()) {
            throw new IndexOutOfBoundsException();
        }
        while (j2 > 0) {
            long transferFrom = this.fileChannel.transferFrom(c8037c, j, j2);
            j += transferFrom;
            j2 -= transferFrom;
        }
    }

    public void read(long j, C8037c c8037c, long j2) {
        if (j2 >= 0) {
            while (j2 > 0) {
                long transferTo = this.fileChannel.transferTo(j, j2, c8037c);
                j += transferTo;
                j2 -= transferTo;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
