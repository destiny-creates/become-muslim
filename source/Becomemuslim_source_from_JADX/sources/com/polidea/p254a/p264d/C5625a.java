package com.polidea.p254a.p264d;

import com.facebook.imageutils.JfifUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GattStatusParser */
/* renamed from: com.polidea.a.d.a */
public class C5625a {
    /* renamed from: a */
    private static final Map<Integer, String> f18798a;

    static {
        Map hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), "GATT_SUCCESS");
        hashMap.put(Integer.valueOf(1), "GATT_INVALID_HANDLE");
        hashMap.put(Integer.valueOf(2), "GATT_READ_NOT_PERMIT");
        hashMap.put(Integer.valueOf(3), "GATT_WRITE_NOT_PERMIT");
        hashMap.put(Integer.valueOf(4), "GATT_INVALID_PDU");
        hashMap.put(Integer.valueOf(5), "GATT_INSUF_AUTHENTICATION");
        hashMap.put(Integer.valueOf(6), "GATT_REQ_NOT_SUPPORTED");
        hashMap.put(Integer.valueOf(7), "GATT_INVALID_OFFSET");
        hashMap.put(Integer.valueOf(8), "GATT_INSUF_AUTHORIZATION");
        hashMap.put(Integer.valueOf(9), "GATT_PREPARE_Q_FULL");
        hashMap.put(Integer.valueOf(10), "GATT_NOT_FOUND");
        hashMap.put(Integer.valueOf(11), "GATT_NOT_LONG");
        hashMap.put(Integer.valueOf(12), "GATT_INSUF_KEY_SIZE");
        hashMap.put(Integer.valueOf(13), "GATT_INVALID_ATTR_LEN");
        hashMap.put(Integer.valueOf(14), "GATT_ERR_UNLIKELY");
        hashMap.put(Integer.valueOf(15), "GATT_INSUF_ENCRYPTION");
        hashMap.put(Integer.valueOf(16), "GATT_UNSUPPORT_GRP_TYPE");
        hashMap.put(Integer.valueOf(17), "GATT_INSUF_RESOURCE");
        hashMap.put(Integer.valueOf(135), "GATT_ILLEGAL_PARAMETER");
        hashMap.put(Integer.valueOf(128), "GATT_NO_RESOURCES");
        hashMap.put(Integer.valueOf(129), "GATT_INTERNAL_ERROR");
        hashMap.put(Integer.valueOf(130), "GATT_WRONG_STATE");
        hashMap.put(Integer.valueOf(131), "GATT_DB_FULL");
        hashMap.put(Integer.valueOf(132), "GATT_BUSY");
        hashMap.put(Integer.valueOf(133), "GATT_ERROR");
        hashMap.put(Integer.valueOf(134), "GATT_CMD_STARTED");
        hashMap.put(Integer.valueOf(136), "GATT_PENDING");
        hashMap.put(Integer.valueOf(137), "GATT_AUTH_FAIL");
        hashMap.put(Integer.valueOf(138), "GATT_MORE");
        hashMap.put(Integer.valueOf(139), "GATT_INVALID_CFG");
        hashMap.put(Integer.valueOf(140), "GATT_SERVICE_STARTED");
        hashMap.put(Integer.valueOf(0), "GATT_SUCCESS");
        hashMap.put(Integer.valueOf(141), "GATT_ENCRYPED_NO_MITM");
        hashMap.put(Integer.valueOf(142), "GATT_NOT_ENCRYPTED");
        hashMap.put(Integer.valueOf(143), "GATT_CONGESTED");
        hashMap.put(Integer.valueOf(253), "GATT_CCC_CFG_ERR");
        hashMap.put(Integer.valueOf(254), "GATT_PRC_IN_PROGRESS");
        hashMap.put(Integer.valueOf(JfifUtil.MARKER_FIRST_BYTE), "GATT_OUT_OF_RANGE");
        f18798a = Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: a */
    public static String m23920a(int i) {
        String str = (String) f18798a.get(Integer.valueOf(i));
        return str == null ? "UNKNOWN" : str;
    }
}
