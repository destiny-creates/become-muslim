package com.polidea.p254a.p256b.p262f;

import android.os.ParcelUuid;
import android.support.v7.widget.LinearLayoutManager;
import android.util.SparseArray;
import com.facebook.imageutils.JfifUtil;
import com.polidea.p254a.p256b.C5615p;
import com.polidea.p254a.p256b.p260d.C7044n;
import com.polidea.p254a.p263c.C5620c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Deprecated
/* compiled from: UUIDUtil */
/* renamed from: com.polidea.a.b.f.aa */
public class aa {
    /* renamed from: a */
    public static final ParcelUuid f18723a = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");

    /* renamed from: a */
    public C5620c m23812a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        List arrayList = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        Map hashMap = new HashMap();
        String str = null;
        int i = 0;
        int i2 = -1;
        int i3 = LinearLayoutManager.INVALID_OFFSET;
        while (i < bArr.length) {
            try {
                int i4 = i + 1;
                i = bArr[i] & JfifUtil.MARKER_FIRST_BYTE;
                if (i == 0) {
                    return new C7044n(arrayList.isEmpty() ? null : arrayList, sparseArray, hashMap, i2, i3, str, bArr);
                }
                i--;
                int i5 = i4 + 1;
                i4 = bArr[i4] & JfifUtil.MARKER_FIRST_BYTE;
                if (i4 == 22) {
                    hashMap.put(aa.m23811b(aa.m23810a(bArr, i5, 2)), aa.m23810a(bArr, i5 + 2, i - 2));
                } else if (i4 != JfifUtil.MARKER_FIRST_BYTE) {
                    switch (i4) {
                        case 1:
                            i2 = bArr[i5] & JfifUtil.MARKER_FIRST_BYTE;
                            break;
                        case 2:
                        case 3:
                            aa.m23809a(bArr, i5, i, 2, arrayList);
                            break;
                        case 4:
                        case 5:
                            aa.m23809a(bArr, i5, i, 4, arrayList);
                            break;
                        case 6:
                        case 7:
                            aa.m23809a(bArr, i5, i, 16, arrayList);
                            break;
                        case 8:
                        case 9:
                            str = new String(aa.m23810a(bArr, i5, i));
                            break;
                        case 10:
                            i3 = bArr[i5];
                            break;
                        default:
                            break;
                    }
                } else {
                    sparseArray.put(((bArr[i5 + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8) + (JfifUtil.MARKER_FIRST_BYTE & bArr[i5]), aa.m23810a(bArr, i5 + 2, i - 2));
                }
                i += i5;
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unable to parse scan record: ");
                stringBuilder.append(Arrays.toString(bArr));
                C5615p.m23869c(e, stringBuilder.toString(), new Object[0]);
                return new C7044n(null, null, null, -1, LinearLayoutManager.INVALID_OFFSET, null, bArr);
            }
        }
        if (arrayList.isEmpty()) {
        }
        return new C7044n(arrayList.isEmpty() ? null : arrayList, sparseArray, hashMap, i2, i3, str, bArr);
    }

    /* renamed from: b */
    private static ParcelUuid m23811b(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            if (!(length == 2 || length == 4)) {
                if (length != 16) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("uuidBytes length invalid - ");
                    stringBuilder.append(length);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            if (length == 16) {
                bArr = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                return new ParcelUuid(new UUID(bArr.getLong(8), bArr.getLong(0)));
            }
            long j;
            if (length == 2) {
                j = ((long) (bArr[0] & JfifUtil.MARKER_FIRST_BYTE)) + ((long) ((bArr[1] & JfifUtil.MARKER_FIRST_BYTE) << 8));
            } else {
                j = ((long) ((bArr[3] & JfifUtil.MARKER_FIRST_BYTE) << 24)) + ((((long) (bArr[0] & JfifUtil.MARKER_FIRST_BYTE)) + ((long) ((bArr[1] & JfifUtil.MARKER_FIRST_BYTE) << 8))) + ((long) ((bArr[2] & JfifUtil.MARKER_FIRST_BYTE) << 16)));
            }
            return new ParcelUuid(new UUID(f18723a.getUuid().getMostSignificantBits() + (j << 32), f18723a.getUuid().getLeastSignificantBits()));
        }
        throw new IllegalArgumentException("uuidBytes cannot be null");
    }

    /* renamed from: a */
    private static int m23809a(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(aa.m23811b(aa.m23810a(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    /* renamed from: a */
    private static byte[] m23810a(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return obj;
    }
}
