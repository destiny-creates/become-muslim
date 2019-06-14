package com.polidea.p254a.p256b.p260d;

import android.annotation.SuppressLint;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.bluetooth.le.ScanSettings.Builder;
import com.polidea.p254a.p263c.C5619b;
import com.polidea.p254a.p263c.C5624e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AndroidScanObjectsConverter */
/* renamed from: com.polidea.a.b.d.a */
public class C5585a {
    /* renamed from: a */
    private final int f18698a;

    public C5585a(int i) {
        this.f18698a = i;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public ScanSettings m23773a(C5624e c5624e) {
        Builder builder = new Builder();
        if (this.f18698a >= 23) {
            m23772a(c5624e, builder);
        }
        return builder.setReportDelay(c5624e.m23919e()).setScanMode(c5624e.m23915a()).build();
    }

    /* renamed from: a */
    private void m23772a(C5624e c5624e, Builder builder) {
        builder.setCallbackType(c5624e.m23916b()).setMatchMode(c5624e.m23917c()).setNumOfMatches(c5624e.m23918d());
    }

    /* renamed from: a */
    public List<ScanFilter> m23774a(C5619b... c5619bArr) {
        Object obj = (c5619bArr == null || c5619bArr.length <= 0) ? null : 1;
        if (obj == null) {
            return null;
        }
        List<ScanFilter> arrayList = new ArrayList(c5619bArr.length);
        for (C5619b a : c5619bArr) {
            arrayList.add(m23771a(a));
        }
        return arrayList;
    }

    /* renamed from: a */
    private ScanFilter m23771a(C5619b c5619b) {
        ScanFilter.Builder builder = new ScanFilter.Builder();
        if (c5619b.m23897g() != null) {
            builder.setServiceData(c5619b.m23897g(), c5619b.m23895e(), c5619b.m23896f());
        }
        return builder.setDeviceAddress(c5619b.m23894d()).setDeviceName(c5619b.m23890a()).setManufacturerData(c5619b.m23898h(), c5619b.m23899i(), c5619b.m23900j()).setServiceUuid(c5619b.m23892b(), c5619b.m23893c()).build();
    }
}
