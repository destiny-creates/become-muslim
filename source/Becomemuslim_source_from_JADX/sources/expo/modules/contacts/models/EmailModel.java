package expo.modules.contacts.models;

import android.database.Cursor;
import com.facebook.internal.FacebookRequestErrorClassification;
import expo.modules.contacts.EXColumns;

public class EmailModel extends BaseModel {
    public String getContentType() {
        return "vnd.android.cursor.item/email_v2";
    }

    public String getDataAlias() {
        return "email";
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
            case 4:
                return "mobile";
            default:
                return "unknown";
        }
    }
}
