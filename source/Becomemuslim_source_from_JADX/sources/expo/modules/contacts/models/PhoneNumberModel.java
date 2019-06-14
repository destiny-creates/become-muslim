package expo.modules.contacts.models;

import android.database.Cursor;
import com.facebook.internal.FacebookRequestErrorClassification;
import expo.modules.contacts.EXColumns;
import java.util.Map;

public class PhoneNumberModel extends BaseModel {
    public String getContentType() {
        return "vnd.android.cursor.item/phone_v2";
    }

    public String getDataAlias() {
        return "number";
    }

    public void fromMap(Map<String, Object> map) {
        super.fromMap(map);
        this.map.putString("digits", getData().replaceAll("[^\\d.]", ""));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mapStringToType(java.lang.String r18) {
        /*
        r17 = this;
        r0 = r18;
        r1 = r18.hashCode();
        r2 = 15;
        r3 = 14;
        r4 = 13;
        r5 = 12;
        r6 = 11;
        r7 = 10;
        r8 = 9;
        r9 = 8;
        r10 = 6;
        r11 = 5;
        r12 = 4;
        r13 = 3;
        r14 = 2;
        r15 = 1;
        r16 = 0;
        switch(r1) {
            case -1171162643: goto L_0x00f6;
            case -1073799780: goto L_0x00ec;
            case -1073745133: goto L_0x00e1;
            case -1073352754: goto L_0x00d7;
            case -1068855134: goto L_0x00cd;
            case -863168709: goto L_0x00c2;
            case -508612650: goto L_0x00b7;
            case -172220347: goto L_0x00ad;
            case 98260: goto L_0x00a3;
            case 108243: goto L_0x0098;
            case 3208415: goto L_0x008d;
            case 3241780: goto L_0x0081;
            case 3343801: goto L_0x0075;
            case 3655441: goto L_0x006a;
            case 106069776: goto L_0x005e;
            case 106426307: goto L_0x0053;
            case 108270587: goto L_0x0047;
            case 110244366: goto L_0x003b;
            case 1076099890: goto L_0x002f;
            case 1429828318: goto L_0x0023;
            default: goto L_0x0021;
        };
    L_0x0021:
        goto L_0x0101;
    L_0x0023:
        r1 = "assistant";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x002b:
        r0 = 17;
        goto L_0x0102;
    L_0x002f:
        r1 = "workPager";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x0037:
        r0 = 16;
        goto L_0x0102;
    L_0x003b:
        r1 = "telex";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x0043:
        r0 = 13;
        goto L_0x0102;
    L_0x0047:
        r1 = "radio";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x004f:
        r0 = 12;
        goto L_0x0102;
    L_0x0053:
        r1 = "pager";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x005b:
        r0 = 5;
        goto L_0x0102;
    L_0x005e:
        r1 = "other";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x0066:
        r0 = 19;
        goto L_0x0102;
    L_0x006a:
        r1 = "work";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x0072:
        r0 = 2;
        goto L_0x0102;
    L_0x0075:
        r1 = "main";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x007d:
        r0 = 10;
        goto L_0x0102;
    L_0x0081:
        r1 = "isdn";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x0089:
        r0 = 9;
        goto L_0x0102;
    L_0x008d:
        r1 = "home";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x0095:
        r0 = 0;
        goto L_0x0102;
    L_0x0098:
        r1 = "mms";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x00a0:
        r0 = 18;
        goto L_0x0102;
    L_0x00a3:
        r1 = "car";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x00ab:
        r0 = 7;
        goto L_0x0102;
    L_0x00ad:
        r1 = "callback";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x00b5:
        r0 = 6;
        goto L_0x0102;
    L_0x00b7:
        r1 = "companyMain";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x00bf:
        r0 = 8;
        goto L_0x0102;
    L_0x00c2:
        r1 = "ttyTdd";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x00ca:
        r0 = 14;
        goto L_0x0102;
    L_0x00cd:
        r1 = "mobile";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x00d5:
        r0 = 1;
        goto L_0x0102;
    L_0x00d7:
        r1 = "faxWork";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x00df:
        r0 = 3;
        goto L_0x0102;
    L_0x00e1:
        r1 = "workMobile";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x00e9:
        r0 = 15;
        goto L_0x0102;
    L_0x00ec:
        r1 = "faxHome";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x00f4:
        r0 = 4;
        goto L_0x0102;
    L_0x00f6:
        r1 = "otherFax";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0101;
    L_0x00fe:
        r0 = 11;
        goto L_0x0102;
    L_0x0101:
        r0 = -1;
    L_0x0102:
        switch(r0) {
            case 0: goto L_0x0137;
            case 1: goto L_0x0135;
            case 2: goto L_0x0133;
            case 3: goto L_0x0131;
            case 4: goto L_0x012f;
            case 5: goto L_0x012d;
            case 6: goto L_0x012a;
            case 7: goto L_0x0127;
            case 8: goto L_0x0124;
            case 9: goto L_0x0121;
            case 10: goto L_0x011e;
            case 11: goto L_0x011b;
            case 12: goto L_0x0118;
            case 13: goto L_0x0138;
            case 14: goto L_0x0115;
            case 15: goto L_0x0112;
            case 16: goto L_0x010f;
            case 17: goto L_0x010c;
            case 18: goto L_0x0109;
            case 19: goto L_0x0107;
            default: goto L_0x0105;
        };
    L_0x0105:
        r2 = 0;
        goto L_0x0138;
    L_0x0107:
        r2 = 7;
        goto L_0x0138;
    L_0x0109:
        r2 = 20;
        goto L_0x0138;
    L_0x010c:
        r2 = 19;
        goto L_0x0138;
    L_0x010f:
        r2 = 18;
        goto L_0x0138;
    L_0x0112:
        r2 = 17;
        goto L_0x0138;
    L_0x0115:
        r2 = 16;
        goto L_0x0138;
    L_0x0118:
        r2 = 14;
        goto L_0x0138;
    L_0x011b:
        r2 = 13;
        goto L_0x0138;
    L_0x011e:
        r2 = 12;
        goto L_0x0138;
    L_0x0121:
        r2 = 11;
        goto L_0x0138;
    L_0x0124:
        r2 = 10;
        goto L_0x0138;
    L_0x0127:
        r2 = 9;
        goto L_0x0138;
    L_0x012a:
        r2 = 8;
        goto L_0x0138;
    L_0x012d:
        r2 = 6;
        goto L_0x0138;
    L_0x012f:
        r2 = 5;
        goto L_0x0138;
    L_0x0131:
        r2 = 4;
        goto L_0x0138;
    L_0x0133:
        r2 = 3;
        goto L_0x0138;
    L_0x0135:
        r2 = 2;
        goto L_0x0138;
    L_0x0137:
        r2 = 1;
    L_0x0138:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.contacts.models.PhoneNumberModel.mapStringToType(java.lang.String):int");
    }

    protected String getLabelFromCursor(Cursor cursor) {
        String labelFromCursor = super.getLabelFromCursor(cursor);
        if (labelFromCursor != null) {
            return labelFromCursor;
        }
        cursor = cursor.getInt(cursor.getColumnIndex(EXColumns.TYPE));
        if (cursor == 7) {
            return FacebookRequestErrorClassification.KEY_OTHER;
        }
        switch (cursor) {
            case 1:
                return "home";
            case 2:
                return "mobile";
            case 3:
                return "work";
            default:
                return "unknown";
        }
    }
}
