package expo.modules.contacts.models;

import android.database.Cursor;
import com.facebook.internal.FacebookRequestErrorClassification;
import expo.modules.contacts.EXColumns;

public class UrlAddressModel extends BaseModel {
    public String getContentType() {
        return "vnd.android.cursor.item/website";
    }

    public String getDataAlias() {
        return "url";
    }

    protected String getLabelFromCursor(Cursor cursor) {
        String labelFromCursor = super.getLabelFromCursor(cursor);
        if (labelFromCursor != null) {
            return labelFromCursor;
        }
        switch (cursor.getInt(cursor.getColumnIndex(EXColumns.TYPE))) {
            case 1:
                return "homepage";
            case 2:
                return "blog";
            case 3:
                return "profile";
            case 4:
                return "home";
            case 5:
                return "work";
            case 6:
                return "ftp";
            case 7:
                return FacebookRequestErrorClassification.KEY_OTHER;
            default:
                return "unknown";
        }
    }
}
