package com.polidea.p254a.p256b.p260d;

import android.os.ParcelUuid;
import android.util.SparseArray;
import com.polidea.p254a.p263c.C5620c;
import java.util.List;
import java.util.Map;

/* compiled from: ScanRecordImplCompat */
/* renamed from: com.polidea.a.b.d.n */
public class C7044n implements C5620c {
    /* renamed from: a */
    private final int f25001a;
    /* renamed from: b */
    private final List<ParcelUuid> f25002b;
    /* renamed from: c */
    private final SparseArray<byte[]> f25003c;
    /* renamed from: d */
    private final Map<ParcelUuid, byte[]> f25004d;
    /* renamed from: e */
    private final int f25005e;
    /* renamed from: f */
    private final String f25006f;
    /* renamed from: g */
    private final byte[] f25007g;

    public C7044n(List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i, int i2, String str, byte[] bArr) {
        this.f25002b = list;
        this.f25003c = sparseArray;
        this.f25004d = map;
        this.f25006f = str;
        this.f25001a = i;
        this.f25005e = i2;
        this.f25007g = bArr;
    }

    /* renamed from: a */
    public List<ParcelUuid> mo5010a() {
        return this.f25002b;
    }

    /* renamed from: a */
    public byte[] mo5011a(int i) {
        return (byte[]) this.f25003c.get(i);
    }

    /* renamed from: a */
    public byte[] mo5012a(ParcelUuid parcelUuid) {
        return parcelUuid == null ? null : (byte[]) this.f25004d.get(parcelUuid);
    }

    /* renamed from: b */
    public String mo5013b() {
        return this.f25006f;
    }

    /* renamed from: c */
    public byte[] mo5014c() {
        return this.f25007g;
    }
}
