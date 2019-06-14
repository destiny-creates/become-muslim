package expo.modules.contacts.models;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.database.Cursor;
import android.provider.ContactsContract.Data;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.ServerProtocol;
import expo.modules.contacts.EXColumns;
import java.util.Map;

public class PostalAddressModel extends BaseModel {
    public String getContentType() {
        return "vnd.android.cursor.item/postal-address_v2";
    }

    public String getDataAlias() {
        return "formattedAddress";
    }

    public int mapStringToType(String str) {
        int hashCode = str.hashCode();
        if (hashCode != 3208415) {
            if (hashCode == 3655441) {
                if (str.equals("work") != null) {
                    str = true;
                    switch (str) {
                        case null:
                            return 1;
                        case 1:
                            return 2;
                        default:
                            return 3;
                    }
                }
            }
        } else if (str.equals("home") != null) {
            str = null;
            switch (str) {
                case null:
                    return 1;
                case 1:
                    return 2;
                default:
                    return 3;
            }
        }
        str = -1;
        switch (str) {
            case null:
                return 1;
            case 1:
                return 2;
            default:
                return 3;
        }
    }

    public void fromCursor(Cursor cursor) {
        super.fromCursor(cursor);
        putString(cursor, "formattedAddress", EXColumns.DATA);
        putString(cursor, "street", EXColumns.DATA_4);
        putString(cursor, "poBox", EXColumns.DATA_5);
        putString(cursor, "neighborhood", EXColumns.DATA_6);
        putString(cursor, "city", EXColumns.DATA_7);
        putString(cursor, "region", EXColumns.DATA_8);
        putString(cursor, ServerProtocol.DIALOG_PARAM_STATE, EXColumns.DATA_8);
        putString(cursor, "postalCode", EXColumns.DATA_9);
        putString(cursor, UserDataStore.COUNTRY, EXColumns.DATA_10);
    }

    public void fromMap(Map<String, Object> map) {
        super.fromMap(map);
        mapValue(map, "region", ServerProtocol.DIALOG_PARAM_STATE);
    }

    public ContentProviderOperation getOperation() {
        return ContentProviderOperation.newInsert(Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue(EXColumns.MIMETYPE, getContentType()).withValue(EXColumns.TYPE, getType()).withValue(EXColumns.DATA_4, getString("street")).withValue(EXColumns.DATA_7, getString("city")).withValue(EXColumns.DATA_8, getString("region")).withValue(EXColumns.DATA_9, getString("postalCode")).withValue(EXColumns.DATA_10, getString(UserDataStore.COUNTRY)).build();
    }

    public ContentValues getContentValues() {
        ContentValues contentValues = super.getContentValues();
        contentValues.put(EXColumns.DATA_4, getString("street"));
        contentValues.put(EXColumns.DATA_7, getString("city"));
        contentValues.put(EXColumns.DATA_8, getString("region"));
        contentValues.put(EXColumns.DATA_10, getString(UserDataStore.COUNTRY));
        contentValues.put(EXColumns.DATA_9, getString("postalCode"));
        return contentValues;
    }

    protected String getLabelFromCursor(Cursor cursor) {
        String labelFromCursor = super.getLabelFromCursor(cursor);
        if (labelFromCursor != null) {
            return labelFromCursor;
        }
        switch (cursor.getInt(cursor.getColumnIndex(EXColumns.TYPE))) {
            case 1:
                return "home";
            case 2:
                return "work";
            case 3:
                return FacebookRequestErrorClassification.KEY_OTHER;
            default:
                return "unknown";
        }
    }
}
