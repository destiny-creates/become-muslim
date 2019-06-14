package com.polidea.p254a.p263c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.polidea.p254a.p256b.p260d.C5588h;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/* compiled from: ScanFilter */
/* renamed from: com.polidea.a.c.b */
public final class C5619b implements Parcelable {
    public static final Creator<C5619b> CREATOR = new C56171();
    /* renamed from: k */
    private static final C5619b f18772k = new C5618a().m23882a();
    /* renamed from: a */
    private final String f18773a;
    /* renamed from: b */
    private final String f18774b;
    /* renamed from: c */
    private final ParcelUuid f18775c;
    /* renamed from: d */
    private final ParcelUuid f18776d;
    /* renamed from: e */
    private final ParcelUuid f18777e;
    /* renamed from: f */
    private final byte[] f18778f;
    /* renamed from: g */
    private final byte[] f18779g;
    /* renamed from: h */
    private final int f18780h;
    /* renamed from: i */
    private final byte[] f18781i;
    /* renamed from: j */
    private final byte[] f18782j;

    /* compiled from: ScanFilter */
    /* renamed from: com.polidea.a.c.b$1 */
    static class C56171 implements Creator<C5619b> {
        C56171() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m23873a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m23874a(i);
        }

        /* renamed from: a */
        public C5619b[] m23874a(int i) {
            return new C5619b[i];
        }

        /* renamed from: a */
        public C5619b m23873a(Parcel parcel) {
            ParcelUuid parcelUuid;
            byte[] bArr;
            C5618a c5618a = new C5618a();
            if (parcel.readInt() == 1) {
                c5618a.m23881a(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                c5618a.m23883b(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                parcelUuid = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                c5618a.m23877a(parcelUuid);
                if (parcel.readInt() == 1) {
                    c5618a.m23878a(parcelUuid, (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader()));
                }
            }
            if (parcel.readInt() == 1) {
                parcelUuid = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                if (parcel.readInt() == 1) {
                    bArr = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr);
                    if (parcel.readInt() == 0) {
                        c5618a.m23879a(parcelUuid, bArr);
                    } else {
                        byte[] bArr2 = new byte[parcel.readInt()];
                        parcel.readByteArray(bArr2);
                        c5618a.m23880a(parcelUuid, bArr, bArr2);
                    }
                }
            }
            int readInt = parcel.readInt();
            if (parcel.readInt() == 1) {
                byte[] bArr3 = new byte[parcel.readInt()];
                parcel.readByteArray(bArr3);
                if (parcel.readInt() == 0) {
                    c5618a.m23875a(readInt, bArr3);
                } else {
                    bArr = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr);
                    c5618a.m23876a(readInt, bArr3, bArr);
                }
            }
            return c5618a.m23882a();
        }
    }

    /* compiled from: ScanFilter */
    /* renamed from: com.polidea.a.c.b$a */
    public static final class C5618a {
        /* renamed from: a */
        private String f18762a;
        /* renamed from: b */
        private String f18763b;
        /* renamed from: c */
        private ParcelUuid f18764c;
        /* renamed from: d */
        private ParcelUuid f18765d;
        /* renamed from: e */
        private ParcelUuid f18766e;
        /* renamed from: f */
        private byte[] f18767f;
        /* renamed from: g */
        private byte[] f18768g;
        /* renamed from: h */
        private int f18769h = -1;
        /* renamed from: i */
        private byte[] f18770i;
        /* renamed from: j */
        private byte[] f18771j;

        /* renamed from: a */
        public C5618a m23881a(String str) {
            this.f18762a = str;
            return this;
        }

        /* renamed from: b */
        public C5618a m23883b(String str) {
            if (str != null) {
                if (!BluetoothAdapter.checkBluetoothAddress(str)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("invalid device address ");
                    stringBuilder.append(str);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            this.f18763b = str;
            return this;
        }

        /* renamed from: a */
        public C5618a m23877a(ParcelUuid parcelUuid) {
            this.f18764c = parcelUuid;
            this.f18765d = null;
            return this;
        }

        /* renamed from: a */
        public C5618a m23878a(ParcelUuid parcelUuid, ParcelUuid parcelUuid2) {
            if (this.f18765d != null) {
                if (this.f18764c == null) {
                    throw new IllegalArgumentException("uuid is null while uuidMask is not null!");
                }
            }
            this.f18764c = parcelUuid;
            this.f18765d = parcelUuid2;
            return this;
        }

        /* renamed from: a */
        public C5618a m23879a(ParcelUuid parcelUuid, byte[] bArr) {
            if (parcelUuid != null) {
                this.f18766e = parcelUuid;
                this.f18767f = bArr;
                this.f18768g = null;
                return this;
            }
            throw new IllegalArgumentException("serviceDataUuid is null");
        }

        /* renamed from: a */
        public C5618a m23880a(ParcelUuid parcelUuid, byte[] bArr, byte[] bArr2) {
            if (parcelUuid != null) {
                if (this.f18768g != null) {
                    if (this.f18767f == null) {
                        throw new IllegalArgumentException("serviceData is null while serviceDataMask is not null");
                    } else if (this.f18767f.length != this.f18768g.length) {
                        throw new IllegalArgumentException("size mismatch for service data and service data mask");
                    }
                }
                this.f18766e = parcelUuid;
                this.f18767f = bArr;
                this.f18768g = bArr2;
                return this;
            }
            throw new IllegalArgumentException("serviceDataUuid is null");
        }

        /* renamed from: a */
        public C5618a m23875a(int i, byte[] bArr) {
            if (bArr != null) {
                if (i < 0) {
                    throw new IllegalArgumentException("invalid manufacture id");
                }
            }
            this.f18769h = i;
            this.f18770i = bArr;
            this.f18771j = 0;
            return this;
        }

        /* renamed from: a */
        public C5618a m23876a(int i, byte[] bArr, byte[] bArr2) {
            if (bArr != null) {
                if (i < 0) {
                    throw new IllegalArgumentException("invalid manufacture id");
                }
            }
            if (this.f18771j != null) {
                if (this.f18770i == null) {
                    throw new IllegalArgumentException("manufacturerData is null while manufacturerDataMask is not null");
                } else if (this.f18770i.length != this.f18771j.length) {
                    throw new IllegalArgumentException("size mismatch for manufacturerData and manufacturerDataMask");
                }
            }
            this.f18769h = i;
            this.f18770i = bArr;
            this.f18771j = bArr2;
            return this;
        }

        /* renamed from: a */
        public C5619b m23882a() {
            return new C5619b(this.f18762a, this.f18763b, this.f18764c, this.f18765d, this.f18766e, this.f18767f, this.f18768g, this.f18769h, this.f18770i, this.f18771j);
        }
    }

    public int describeContents() {
        return 0;
    }

    private C5619b(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        this.f18773a = str;
        this.f18775c = parcelUuid;
        this.f18776d = parcelUuid2;
        this.f18774b = str2;
        this.f18777e = parcelUuid3;
        this.f18778f = bArr;
        this.f18779g = bArr2;
        this.f18780h = i;
        this.f18781i = bArr3;
        this.f18782j = bArr4;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeInt(this.f18773a == null ? 0 : 1);
        if (this.f18773a != null) {
            parcel.writeString(this.f18773a);
        }
        parcel.writeInt(this.f18774b == null ? 0 : 1);
        if (this.f18774b != null) {
            parcel.writeString(this.f18774b);
        }
        parcel.writeInt(this.f18775c == null ? 0 : 1);
        if (this.f18775c != null) {
            parcel.writeParcelable(this.f18775c, i);
            parcel.writeInt(this.f18776d == null ? 0 : 1);
            if (this.f18776d != null) {
                parcel.writeParcelable(this.f18776d, i);
            }
        }
        parcel.writeInt(this.f18777e == null ? 0 : 1);
        if (this.f18777e != null) {
            parcel.writeParcelable(this.f18777e, i);
            parcel.writeInt(this.f18778f == 0 ? 0 : 1);
            if (this.f18778f != 0) {
                parcel.writeInt(this.f18778f.length);
                parcel.writeByteArray(this.f18778f);
                parcel.writeInt(this.f18779g == 0 ? 0 : 1);
                if (this.f18779g != 0) {
                    parcel.writeInt(this.f18779g.length);
                    parcel.writeByteArray(this.f18779g);
                }
            }
        }
        parcel.writeInt(this.f18780h);
        parcel.writeInt(this.f18781i == 0 ? 0 : 1);
        if (this.f18781i != 0) {
            parcel.writeInt(this.f18781i.length);
            parcel.writeByteArray(this.f18781i);
            if (this.f18782j == 0) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (this.f18782j != 0) {
                parcel.writeInt(this.f18782j.length);
                parcel.writeByteArray(this.f18782j);
            }
        }
    }

    /* renamed from: a */
    public String m23890a() {
        return this.f18773a;
    }

    /* renamed from: b */
    public ParcelUuid m23892b() {
        return this.f18775c;
    }

    /* renamed from: c */
    public ParcelUuid m23893c() {
        return this.f18776d;
    }

    /* renamed from: d */
    public String m23894d() {
        return this.f18774b;
    }

    /* renamed from: e */
    public byte[] m23895e() {
        return this.f18778f;
    }

    /* renamed from: f */
    public byte[] m23896f() {
        return this.f18779g;
    }

    /* renamed from: g */
    public ParcelUuid m23897g() {
        return this.f18777e;
    }

    /* renamed from: h */
    public int m23898h() {
        return this.f18780h;
    }

    /* renamed from: i */
    public byte[] m23899i() {
        return this.f18781i;
    }

    /* renamed from: j */
    public byte[] m23900j() {
        return this.f18782j;
    }

    /* renamed from: a */
    public boolean m23891a(C5588h c5588h) {
        if (c5588h == null) {
            return false;
        }
        BluetoothDevice a = c5588h.m23780a();
        if (this.f18774b != null && (a == null || !this.f18774b.equals(a.getAddress()))) {
            return false;
        }
        c5588h = c5588h.m23782c();
        if (c5588h == null && (this.f18773a != null || this.f18775c != null || this.f18781i != null || this.f18778f != null)) {
            return false;
        }
        if (this.f18773a != null && !this.f18773a.equals(c5588h.mo5013b()) && !this.f18773a.equals(a.getName())) {
            return false;
        }
        if (this.f18775c != null && !m23884a(this.f18775c, this.f18776d, c5588h.mo5010a())) {
            return false;
        }
        if (this.f18777e != null && !m23888a(this.f18778f, this.f18779g, c5588h.mo5012a(this.f18777e))) {
            return false;
        }
        if (this.f18780h < 0 || m23888a(this.f18781i, this.f18782j, c5588h.mo5011a(this.f18780h)) != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m23884a(ParcelUuid parcelUuid, ParcelUuid parcelUuid2, List<ParcelUuid> list) {
        if (parcelUuid == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        for (ParcelUuid parcelUuid3 : list) {
            UUID uuid;
            if (parcelUuid2 == null) {
                uuid = null;
            } else {
                uuid = parcelUuid2.getUuid();
            }
            if (m23886a(parcelUuid.getUuid(), uuid, parcelUuid3.getUuid())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m23886a(UUID uuid, UUID uuid2, UUID uuid3) {
        if (uuid2 == null) {
            return uuid.equals(uuid3);
        }
        boolean z = false;
        if ((uuid.getLeastSignificantBits() & uuid2.getLeastSignificantBits()) != (uuid3.getLeastSignificantBits() & uuid2.getLeastSignificantBits())) {
            return false;
        }
        if ((uuid.getMostSignificantBits() & uuid2.getMostSignificantBits()) == (uuid2.getMostSignificantBits() & uuid3.getMostSignificantBits())) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private boolean m23888a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr3 != null) {
            if (bArr3.length >= bArr.length) {
                if (bArr2 == null) {
                    for (bArr2 = null; bArr2 < bArr.length; bArr2++) {
                        if (bArr3[bArr2] != bArr[bArr2]) {
                            return false;
                        }
                    }
                    return true;
                }
                for (int i = 0; i < bArr.length; i++) {
                    if ((bArr2[i] & bArr3[i]) != (bArr2[i] & bArr[i])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BluetoothLeScanFilter [mDeviceName=");
        stringBuilder.append(this.f18773a);
        stringBuilder.append(", mDeviceAddress=");
        stringBuilder.append(this.f18774b);
        stringBuilder.append(", mUuid=");
        stringBuilder.append(this.f18775c);
        stringBuilder.append(", mUuidMask=");
        stringBuilder.append(this.f18776d);
        stringBuilder.append(", mServiceDataUuid=");
        stringBuilder.append(String.valueOf(this.f18777e));
        stringBuilder.append(", mServiceData=");
        stringBuilder.append(Arrays.toString(this.f18778f));
        stringBuilder.append(", mServiceDataMask=");
        stringBuilder.append(Arrays.toString(this.f18779g));
        stringBuilder.append(", mManufacturerId=");
        stringBuilder.append(this.f18780h);
        stringBuilder.append(", mManufacturerData=");
        stringBuilder.append(Arrays.toString(this.f18781i));
        stringBuilder.append(", mManufacturerDataMask=");
        stringBuilder.append(Arrays.toString(this.f18782j));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f18773a, this.f18774b, Integer.valueOf(this.f18780h), Integer.valueOf(Arrays.hashCode(this.f18781i)), Integer.valueOf(Arrays.hashCode(this.f18782j)), this.f18777e, Integer.valueOf(Arrays.hashCode(this.f18778f)), Integer.valueOf(Arrays.hashCode(this.f18779g)), this.f18775c, this.f18776d});
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C5619b c5619b = (C5619b) obj;
                if (!C5619b.m23885a(this.f18773a, c5619b.f18773a) || !C5619b.m23885a(this.f18774b, c5619b.f18774b) || this.f18780h != c5619b.f18780h || !C5619b.m23887a(this.f18781i, c5619b.f18781i) || !C5619b.m23887a(this.f18782j, c5619b.f18782j) || !C5619b.m23885a(this.f18777e, c5619b.f18777e) || !C5619b.m23887a(this.f18778f, c5619b.f18778f) || !C5619b.m23887a(this.f18779g, c5619b.f18779g) || !C5619b.m23885a(this.f18775c, c5619b.f18775c) || C5619b.m23885a(this.f18776d, c5619b.f18776d) == null) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m23885a(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m23887a(byte[] bArr, byte[] bArr2) {
        if (bArr != bArr2) {
            if (bArr == null || bArr2 == null || Arrays.equals(bArr, bArr2) == null) {
                return null;
            }
        }
        return 1;
    }

    /* renamed from: k */
    public static C5619b m23889k() {
        return new C5618a().m23882a();
    }
}
