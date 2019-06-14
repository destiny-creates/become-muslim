package com.polidea.p254a.p256b.p260d;

import android.bluetooth.le.ScanRecord;
import android.os.ParcelUuid;
import com.polidea.p254a.p263c.C5620c;
import java.util.List;

/* compiled from: ScanRecordImplNativeWrapper */
/* renamed from: com.polidea.a.b.d.o */
public class C7045o implements C5620c {
    /* renamed from: a */
    private final ScanRecord f25008a;

    public C7045o(ScanRecord scanRecord) {
        this.f25008a = scanRecord;
    }

    /* renamed from: a */
    public List<ParcelUuid> mo5010a() {
        return this.f25008a.getServiceUuids();
    }

    /* renamed from: a */
    public byte[] mo5011a(int i) {
        return this.f25008a.getManufacturerSpecificData(i);
    }

    /* renamed from: a */
    public byte[] mo5012a(ParcelUuid parcelUuid) {
        return this.f25008a.getServiceData(parcelUuid);
    }

    /* renamed from: b */
    public String mo5013b() {
        return this.f25008a.getDeviceName();
    }

    /* renamed from: c */
    public byte[] mo5014c() {
        return this.f25008a.getBytes();
    }
}
