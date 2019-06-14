package expo.modules.contacts.models;

import android.database.Cursor;
import expo.modules.contacts.EXColumns;
import java.util.Map;

public class ExtraNameModel extends BaseModel {
    public String getContentType() {
        return "vnd.android.cursor.item/nickname";
    }

    public String getDataAlias() {
        return "value";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mapStringToType(java.lang.String r7) {
        /*
        r6 = this;
        r0 = r7.hashCode();
        r1 = 2;
        r2 = 4;
        r3 = 3;
        r4 = 1;
        r5 = 0;
        switch(r0) {
            case -2028219097: goto L_0x0035;
            case -1946065477: goto L_0x002b;
            case 269062575: goto L_0x0021;
            case 688538947: goto L_0x0017;
            case 1544803905: goto L_0x000d;
            default: goto L_0x000c;
        };
    L_0x000c:
        goto L_0x003f;
    L_0x000d:
        r0 = "default";
        r7 = r7.equals(r0);
        if (r7 == 0) goto L_0x003f;
    L_0x0015:
        r7 = 0;
        goto L_0x0040;
    L_0x0017:
        r0 = "maidenName";
        r7 = r7.equals(r0);
        if (r7 == 0) goto L_0x003f;
    L_0x001f:
        r7 = 2;
        goto L_0x0040;
    L_0x0021:
        r0 = "initials";
        r7 = r7.equals(r0);
        if (r7 == 0) goto L_0x003f;
    L_0x0029:
        r7 = 1;
        goto L_0x0040;
    L_0x002b:
        r0 = "otherName";
        r7 = r7.equals(r0);
        if (r7 == 0) goto L_0x003f;
    L_0x0033:
        r7 = 4;
        goto L_0x0040;
    L_0x0035:
        r0 = "shortName";
        r7 = r7.equals(r0);
        if (r7 == 0) goto L_0x003f;
    L_0x003d:
        r7 = 3;
        goto L_0x0040;
    L_0x003f:
        r7 = -1;
    L_0x0040:
        switch(r7) {
            case 0: goto L_0x0049;
            case 1: goto L_0x0047;
            case 2: goto L_0x0046;
            case 3: goto L_0x0045;
            case 4: goto L_0x0044;
            default: goto L_0x0043;
        };
    L_0x0043:
        return r5;
    L_0x0044:
        return r1;
    L_0x0045:
        return r2;
    L_0x0046:
        return r3;
    L_0x0047:
        r7 = 5;
        return r7;
    L_0x0049:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.contacts.models.ExtraNameModel.mapStringToType(java.lang.String):int");
    }

    protected String getLabelFromCursor(Cursor cursor) {
        String labelFromCursor = super.getLabelFromCursor(cursor);
        if (labelFromCursor != null) {
            return labelFromCursor;
        }
        switch (cursor.getInt(cursor.getColumnIndex(EXColumns.TYPE))) {
            case 1:
                return "nickname";
            case 2:
                return "otherName";
            case 3:
                return "maidenName";
            case 4:
                return "shortName";
            case 5:
                return "initials";
            default:
                return "unknown";
        }
    }

    public void fromMap(Map<String, Object> map) {
        super.fromMap(map);
    }
}
