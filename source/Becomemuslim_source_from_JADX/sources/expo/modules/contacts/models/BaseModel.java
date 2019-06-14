package expo.modules.contacts.models;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.Data;
import android.text.TextUtils;
import expo.modules.contacts.CommonProvider;
import expo.modules.contacts.EXColumns;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseModel implements CommonProvider {
    protected final Bundle map = new Bundle();

    public String getContentType() {
        return null;
    }

    public String getDataAlias() {
        return EXColumns.DATA;
    }

    public String getIdAlias() {
        return "id";
    }

    public String getIsPrimaryAlias() {
        return "isPrimary";
    }

    public String getLabelAlias() {
        return "label";
    }

    public String getTypeAlias() {
        return "type";
    }

    public int mapStringToType(String str) {
        return 0;
    }

    public static ArrayList decodeList(List list, Class cls) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            BaseModel baseModel = (BaseModel) cls.newInstance();
            baseModel.fromMap((Map) list.get(i));
            arrayList.add(baseModel);
        }
        return arrayList;
    }

    BaseModel() {
    }

    protected void mapValue(Map<String, Object> map, String str) {
        mapValue(map, str, null);
    }

    protected void mapValue(Map<String, Object> map, String str, String str2) {
        if (map.containsKey(str)) {
            Bundle bundle = this.map;
            if (str2 == null) {
                str2 = str;
            }
            bundle.putString(str2, (String) map.get(str));
        }
    }

    public void fromCursor(Cursor cursor) {
        putString(cursor, getIdAlias(), EXColumns.ID);
        this.map.putString(getLabelAlias(), getLabelFromCursor(cursor));
        putString(cursor, getDataAlias(), EXColumns.DATA);
        putString(cursor, EXColumns.LABEL, EXColumns.LABEL);
        putString(cursor, getTypeAlias(), EXColumns.TYPE);
        putInt(cursor, getIsPrimaryAlias(), EXColumns.IS_PRIMARY);
    }

    public ContentProviderOperation getOperation() {
        return ContentProviderOperation.newInsert(Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue(EXColumns.MIMETYPE, getContentType()).withValue(EXColumns.TYPE, Integer.valueOf(mapStringToType(getLabel()))).withValue(EXColumns.DATA, getData()).withValue(EXColumns.ID, getId()).build();
    }

    public String getId() {
        return getString(getIdAlias());
    }

    public String getLabel() {
        return getString(getLabelAlias());
    }

    public String getData() {
        return getString(getDataAlias());
    }

    public String getType() {
        return getString(getTypeAlias());
    }

    public int getIsPrimary() {
        return this.map.containsKey(getIsPrimaryAlias()) ? this.map.getInt(getIsPrimaryAlias()) : 0;
    }

    public String getString(String str) {
        return this.map.containsKey(str) ? this.map.getString(str) : null;
    }

    public void fromMap(Map<String, Object> map) {
        for (String mapValue : map.keySet()) {
            mapValue(map, mapValue);
        }
    }

    public Bundle getMap() {
        return this.map;
    }

    protected String getLabelFromCursor(Cursor cursor) {
        if (cursor.getInt(cursor.getColumnIndex(EXColumns.TYPE)) != 0) {
            return null;
        }
        cursor = cursor.getString(cursor.getColumnIndex(EXColumns.LABEL));
        if (cursor == null) {
            cursor = "unknown";
        }
        return cursor;
    }

    protected void putString(Cursor cursor, String str, String str2) {
        str2 = cursor.getColumnIndex(str2);
        if (str2 != -1) {
            cursor = cursor.getString(str2);
            if (TextUtils.isEmpty(cursor) == null) {
                this.map.putString(str, cursor);
            }
        }
    }

    protected void putInt(Cursor cursor, String str, String str2) {
        str2 = cursor.getColumnIndex(str2);
        if (str2 != -1) {
            this.map.putInt(str, cursor.getInt(str2));
        }
    }

    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(EXColumns.MIMETYPE, getContentType());
        contentValues.put(EXColumns.DATA, getData());
        contentValues.put(EXColumns.TYPE, getType());
        contentValues.put(EXColumns.LABEL, getLabel());
        contentValues.put(EXColumns.ID, getId());
        contentValues.put(EXColumns.IS_PRIMARY, Integer.valueOf(getIsPrimary()));
        return contentValues;
    }
}
