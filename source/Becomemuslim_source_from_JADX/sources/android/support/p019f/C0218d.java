package android.support.p019f;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* compiled from: ZipUtil */
/* renamed from: android.support.f.d */
final class C0218d {

    /* compiled from: ZipUtil */
    /* renamed from: android.support.f.d$a */
    static class C0217a {
        /* renamed from: a */
        long f538a;
        /* renamed from: b */
        long f539b;

        C0217a() {
        }
    }

    /* renamed from: a */
    static long m552a(File file) {
        long j = "r";
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, j);
        try {
            j = C0218d.m553a(randomAccessFile, C0218d.m554a(randomAccessFile));
            return j;
        } finally {
            randomAccessFile.close();
        }
    }

    /* renamed from: a */
    static C0217a m554a(RandomAccessFile randomAccessFile) {
        long length = randomAccessFile.length() - 22;
        long j = 0;
        if (length >= 0) {
            long j2 = length - 65536;
            if (j2 >= 0) {
                j = j2;
            }
            int reverseBytes = Integer.reverseBytes(101010256);
            while (true) {
                randomAccessFile.seek(length);
                if (randomAccessFile.readInt() == reverseBytes) {
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    C0217a c0217a = new C0217a();
                    c0217a.f539b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    c0217a.f538a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    return c0217a;
                }
                length--;
                if (length < j) {
                    throw new ZipException("End Of Central Directory signature not found");
                }
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("File too short to be a zip file: ");
            stringBuilder.append(randomAccessFile.length());
            throw new ZipException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    static long m553a(RandomAccessFile randomAccessFile, C0217a c0217a) {
        CRC32 crc32 = new CRC32();
        long j = c0217a.f539b;
        randomAccessFile.seek(c0217a.f538a);
        byte[] bArr = new byte[16384];
        c0217a = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
        while (c0217a != -1) {
            crc32.update(bArr, 0, c0217a);
            j -= (long) c0217a;
            if (j == 0) {
                break;
            }
            c0217a = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
        }
        return crc32.getValue();
    }
}
