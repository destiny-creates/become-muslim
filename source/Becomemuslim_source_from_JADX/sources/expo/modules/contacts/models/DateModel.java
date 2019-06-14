package expo.modules.contacts.models;

import android.database.Cursor;
import com.facebook.internal.FacebookRequestErrorClassification;
import expo.modules.contacts.EXColumns;

public class DateModel extends BaseModel {
    public String getContentType() {
        return "vnd.android.cursor.item/contact_event";
    }

    public String getDataAlias() {
        return "date";
    }

    public int mapStringToType(String str) {
        int hashCode = str.hashCode();
        if (hashCode != -940675184) {
            if (hashCode != 106069776) {
                if (hashCode == 1069376125) {
                    if (str.equals("birthday") != null) {
                        str = true;
                        switch (str) {
                            case null:
                                return 1;
                            case 1:
                                return 3;
                            case 2:
                                return 2;
                            default:
                                return 0;
                        }
                    }
                }
            } else if (str.equals(FacebookRequestErrorClassification.KEY_OTHER) != null) {
                str = 2;
                switch (str) {
                    case null:
                        return 1;
                    case 1:
                        return 3;
                    case 2:
                        return 2;
                    default:
                        return 0;
                }
            }
        } else if (str.equals("anniversary") != null) {
            str = null;
            switch (str) {
                case null:
                    return 1;
                case 1:
                    return 3;
                case 2:
                    return 2;
                default:
                    return 0;
            }
        }
        str = -1;
        switch (str) {
            case null:
                return 1;
            case 1:
                return 3;
            case 2:
                return 2;
            default:
                return 0;
        }
    }

    public void fromMap(java.util.Map<java.lang.String, java.lang.Object> r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        super.fromMap(r8);
        r0 = "date";
        r8 = r8.get(r0);
        r8 = (java.lang.String) r8;
        r0 = "--";
        r0 = r8.startsWith(r0);
        r1 = 1;
        r0 = r0 ^ r1;
        r0 = java.lang.Boolean.valueOf(r0);
        r2 = java.util.Calendar.getInstance();
        r3 = new java.text.SimpleDateFormat;
        r4 = "yyyy-MM-dd";
        r5 = java.util.Locale.getDefault();
        r3.<init>(r4, r5);
        r4 = new java.text.SimpleDateFormat;
        r5 = "--MM-dd";
        r6 = java.util.Locale.getDefault();
        r4.<init>(r5, r6);
        r5 = r0.booleanValue();	 Catch:{ Exception -> 0x0046 }
        if (r5 == 0) goto L_0x003f;	 Catch:{ Exception -> 0x0046 }
    L_0x0037:
        r8 = r3.parse(r8);	 Catch:{ Exception -> 0x0046 }
        r2.setTime(r8);	 Catch:{ Exception -> 0x0046 }
        goto L_0x0046;	 Catch:{ Exception -> 0x0046 }
    L_0x003f:
        r8 = r4.parse(r8);	 Catch:{ Exception -> 0x0046 }
        r2.setTime(r8);	 Catch:{ Exception -> 0x0046 }
    L_0x0046:
        r8 = r0.booleanValue();
        if (r8 == 0) goto L_0x0057;
    L_0x004c:
        r8 = r7.map;
        r0 = "year";
        r3 = r2.get(r1);
        r8.putInt(r0, r3);
    L_0x0057:
        r8 = r7.map;
        r0 = "month";
        r3 = 2;
        r3 = r2.get(r3);
        r3 = r3 + r1;
        r8.putInt(r0, r3);
        r8 = r7.map;
        r0 = "day";
        r1 = 5;
        r1 = r2.get(r1);
        r8.putInt(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.contacts.models.DateModel.fromMap(java.util.Map):void");
    }

    protected String getLabelFromCursor(Cursor cursor) {
        String labelFromCursor = super.getLabelFromCursor(cursor);
        if (labelFromCursor != null) {
            return labelFromCursor;
        }
        switch (cursor.getInt(cursor.getColumnIndex(EXColumns.TYPE))) {
            case 1:
                return "anniversary";
            case 2:
                return FacebookRequestErrorClassification.KEY_OTHER;
            case 3:
                return "birthday";
            default:
                return "unknown";
        }
    }
}
