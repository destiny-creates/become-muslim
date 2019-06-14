package expo.modules.contacts;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import expo.modules.contacts.models.BaseModel;
import expo.modules.contacts.models.DateModel;
import expo.modules.contacts.models.EmailModel;
import expo.modules.contacts.models.ExtraNameModel;
import expo.modules.contacts.models.ImAddressModel;
import expo.modules.contacts.models.PhoneNumberModel;
import expo.modules.contacts.models.PostalAddressModel;
import expo.modules.contacts.models.RelationshipModel;
import expo.modules.contacts.models.UrlAddressModel;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Contact {
    protected List<BaseModel> addresses = new ArrayList();
    protected String company = "";
    protected String contactId;
    protected String contactType = "person";
    protected List<BaseModel> dates = new ArrayList();
    protected String department = "";
    protected String displayName;
    protected List<BaseModel> emails = new ArrayList();
    protected List<BaseModel> extraNames = new ArrayList();
    protected String firstName = "";
    protected boolean hasPhoto = false;
    protected List<BaseModel> imAddresses = new ArrayList();
    protected boolean isMe = false;
    protected String jobTitle = "";
    protected String lastName = "";
    protected String lookupKey;
    protected String middleName = "";
    protected String note;
    protected List<BaseModel> phones = new ArrayList();
    protected String phoneticFirstName = "";
    protected String phoneticLastName = "";
    protected String phoneticMiddleName = "";
    protected String photoUri;
    protected String prefix = "";
    protected String rawPhotoUri;
    protected List<BaseModel> relationships = new ArrayList();
    protected String suffix = "";
    protected List<BaseModel> urlAddresses = new ArrayList();

    public void fromCursor(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex(EXColumns.MIMETYPE));
        Object string2 = cursor.getString(cursor.getColumnIndex(EXColumns.DISPLAY_NAME));
        if (!TextUtils.isEmpty(string2) && TextUtils.isEmpty(this.displayName)) {
            this.displayName = string2;
        }
        if (TextUtils.isEmpty(this.rawPhotoUri)) {
            string2 = cursor.getString(cursor.getColumnIndex(EXColumns.PHOTO_URI));
            if (!TextUtils.isEmpty(string2)) {
                this.hasPhoto = true;
                this.rawPhotoUri = string2;
            }
        }
        if (TextUtils.isEmpty(this.photoUri)) {
            string2 = cursor.getString(cursor.getColumnIndex(EXColumns.PHOTO_THUMBNAIL_URI));
            if (!TextUtils.isEmpty(string2)) {
                this.hasPhoto = true;
                this.photoUri = string2;
            }
        }
        if (string.equals("vnd.android.cursor.item/name")) {
            this.lookupKey = cursor.getString(cursor.getColumnIndex(EXColumns.LOOKUP_KEY));
            this.firstName = cursor.getString(cursor.getColumnIndex(EXColumns.TYPE));
            this.middleName = cursor.getString(cursor.getColumnIndex(EXColumns.DATA_5));
            this.lastName = cursor.getString(cursor.getColumnIndex(EXColumns.LABEL));
            this.prefix = cursor.getString(cursor.getColumnIndex(EXColumns.DATA_4));
            this.suffix = cursor.getString(cursor.getColumnIndex(EXColumns.DATA_6));
            this.phoneticFirstName = cursor.getString(cursor.getColumnIndex(EXColumns.DATA_7));
            this.phoneticMiddleName = cursor.getString(cursor.getColumnIndex(EXColumns.DATA_8));
            this.phoneticLastName = cursor.getString(cursor.getColumnIndex(EXColumns.DATA_9));
        } else if (string.equals("vnd.android.cursor.item/organization")) {
            this.company = cursor.getString(cursor.getColumnIndex(EXColumns.DATA));
            this.jobTitle = cursor.getString(cursor.getColumnIndex(EXColumns.DATA_4));
            this.department = cursor.getString(cursor.getColumnIndex(EXColumns.DATA_5));
        } else if (string.equals("vnd.android.cursor.item/note")) {
            this.note = cursor.getString(cursor.getColumnIndex(EXColumns.DATA));
        } else if (string.equals("vnd.android.cursor.item/contact_event")) {
            r0 = new DateModel();
            r0.fromCursor(cursor);
            this.dates.add(r0);
        } else if (string.equals("vnd.android.cursor.item/email_v2")) {
            r0 = new EmailModel();
            r0.fromCursor(cursor);
            this.emails.add(r0);
        } else if (string.equals("vnd.android.cursor.item/im")) {
            r0 = new ImAddressModel();
            r0.fromCursor(cursor);
            this.imAddresses.add(r0);
        } else if (string.equals("vnd.android.cursor.item/phone_v2")) {
            r0 = new PhoneNumberModel();
            r0.fromCursor(cursor);
            this.phones.add(r0);
        } else if (string.equals("vnd.android.cursor.item/postal-address_v2")) {
            r0 = new PostalAddressModel();
            r0.fromCursor(cursor);
            this.addresses.add(r0);
        } else if (string.equals("vnd.android.cursor.item/relation")) {
            r0 = new RelationshipModel();
            r0.fromCursor(cursor);
            this.relationships.add(r0);
        } else if (string.equals("vnd.android.cursor.item/website")) {
            r0 = new UrlAddressModel();
            r0.fromCursor(cursor);
            this.urlAddresses.add(r0);
        } else if (string.equals("vnd.android.cursor.item/nickname")) {
            r0 = new ExtraNameModel();
            r0.fromCursor(cursor);
            this.extraNames.add(r0);
        }
        Object obj = null;
        cursor = (this.company == null || this.company.equals("") != null) ? null : true;
        if (cursor != null) {
            cursor = (this.firstName == null || this.firstName.equals("") != null) ? null : true;
            string2 = (this.middleName == null || this.middleName.equals("")) ? null : 1;
            if (!(this.lastName == null || this.lastName.equals(""))) {
                obj = 1;
            }
            if (cursor == null && string2 == null && r0 == null) {
                this.contactType = "company";
                return;
            } else {
                this.contactType = "person";
                return;
            }
        }
        this.contactType = "person";
    }

    public String getFirstName() {
        if (this.firstName == null) {
            return this.displayName;
        }
        return this.firstName;
    }

    public String getLastName() {
        if (this.lastName == null) {
            return this.displayName;
        }
        return this.lastName;
    }

    public Contact(String str) {
        this.contactId = str;
    }

    public byte[] toByteArray(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public ArrayList<ContentProviderOperation> toOperationList() {
        Bitmap decodeFile;
        ArrayList<ContentProviderOperation> arrayList = new ArrayList();
        arrayList.add(ContentProviderOperation.newInsert(RawContacts.CONTENT_URI).withValue("account_type", null).withValue("account_name", null).build());
        int i = 0;
        arrayList.add(ContentProviderOperation.newInsert(Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue(EXColumns.MIMETYPE, "vnd.android.cursor.item/name").withValue(EXColumns.DATA, this.displayName).withValue(EXColumns.TYPE, this.firstName).withValue(EXColumns.DATA_5, this.middleName).withValue(EXColumns.LABEL, this.lastName).withValue(EXColumns.DATA_7, this.phoneticFirstName).withValue(EXColumns.DATA_8, this.phoneticMiddleName).withValue(EXColumns.DATA_9, this.phoneticLastName).withValue(EXColumns.DATA_4, this.prefix).withValue(EXColumns.DATA_6, this.suffix).build());
        arrayList.add(ContentProviderOperation.newInsert(Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue(EXColumns.MIMETYPE, "vnd.android.cursor.item/organization").withValue(EXColumns.DATA, this.company).withValue(EXColumns.DATA_4, this.jobTitle).withValue(EXColumns.DATA_5, this.department).build());
        Builder withValue = ContentProviderOperation.newInsert(Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue(EXColumns.MIMETYPE, "vnd.android.cursor.item/note").withValue(EXColumns.DATA, this.note);
        arrayList.add(withValue.build());
        withValue.withYieldAllowed(true);
        if (!(this.photoUri == null || this.photoUri.isEmpty())) {
            decodeFile = BitmapFactory.decodeFile(this.photoUri);
            if (decodeFile != null) {
                arrayList.add(ContentProviderOperation.newInsert(Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue(EXColumns.MIMETYPE, "vnd.android.cursor.item/photo").withValue("data15", toByteArray(decodeFile)).build());
            }
        }
        if (!(this.rawPhotoUri == null || this.rawPhotoUri.isEmpty())) {
            decodeFile = BitmapFactory.decodeFile(this.rawPhotoUri);
            if (decodeFile != null) {
                arrayList.add(ContentProviderOperation.newInsert(Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue(EXColumns.MIMETYPE, "vnd.android.cursor.item/photo").withValue("data15", toByteArray(decodeFile)).build());
            }
        }
        List[] baseModels = getBaseModels();
        int length = baseModels.length;
        while (i < length) {
            List<BaseModel> list = baseModels[i];
            if (list != null) {
                for (BaseModel operation : list) {
                    arrayList.add(operation.getOperation());
                }
            }
            i++;
        }
        return arrayList;
    }

    List[] getBaseModels() {
        return new List[]{this.dates, this.emails, this.imAddresses, this.phones, this.addresses, this.relationships, this.urlAddresses, this.extraNames};
    }

    public Bundle toMap(Set<String> set) {
        String stringBuilder;
        ArrayList arrayList;
        boolean contains;
        Bundle bundle = new Bundle();
        bundle.putString("lookupKey", this.lookupKey);
        bundle.putString("id", this.contactId);
        String str = "name";
        if (TextUtils.isEmpty(this.displayName)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.firstName);
            stringBuilder2.append(" ");
            stringBuilder2.append(this.lastName);
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = this.displayName;
        }
        bundle.putString(str, stringBuilder);
        if (!TextUtils.isEmpty(this.firstName)) {
            bundle.putString("firstName", this.firstName);
        }
        if (!TextUtils.isEmpty(this.middleName)) {
            bundle.putString("middleName", this.middleName);
        }
        if (!TextUtils.isEmpty(this.lastName)) {
            bundle.putString("lastName", this.lastName);
        }
        if (!TextUtils.isEmpty(this.suffix)) {
            bundle.putString("nameSuffix", this.suffix);
        }
        if (!TextUtils.isEmpty(this.prefix)) {
            bundle.putString("namePrefix", this.prefix);
        }
        if (!TextUtils.isEmpty(this.phoneticFirstName)) {
            bundle.putString("phoneticFirstName", this.phoneticFirstName);
        }
        if (!TextUtils.isEmpty(this.phoneticLastName)) {
            bundle.putString("phoneticLastName", this.phoneticLastName);
        }
        if (!TextUtils.isEmpty(this.phoneticMiddleName)) {
            bundle.putString("phoneticMiddleName", this.phoneticMiddleName);
        }
        bundle.putString("contactType", this.contactType);
        if (!TextUtils.isEmpty(this.company)) {
            bundle.putString("company", this.company);
        }
        if (!TextUtils.isEmpty(this.jobTitle)) {
            bundle.putString("jobTitle", this.jobTitle);
        }
        if (!TextUtils.isEmpty(this.department)) {
            bundle.putString("department", this.department);
        }
        bundle.putBoolean("imageAvailable", this.hasPhoto);
        if (set.contains(MessengerShareContentUtility.MEDIA_IMAGE) && this.photoUri != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("uri", this.photoUri);
            bundle.putBundle(MessengerShareContentUtility.MEDIA_IMAGE, bundle2);
        }
        if (set.contains("rawImage") && this.rawPhotoUri != null) {
            bundle2 = new Bundle();
            bundle2.putString("uri", this.rawPhotoUri);
            bundle.putBundle(MessengerShareContentUtility.MEDIA_IMAGE, bundle2);
        }
        if (set.contains("note") && !TextUtils.isEmpty(this.note)) {
            bundle.putString("note", this.note);
        }
        if (set.contains("phoneNumbers") && this.phones.size() > 0) {
            arrayList = new ArrayList();
            for (BaseModel map : this.phones) {
                arrayList.add(map.getMap());
            }
            bundle.putParcelableArrayList("phoneNumbers", arrayList);
        }
        if (set.contains("emails") && this.emails.size() > 0) {
            arrayList = new ArrayList();
            for (BaseModel map2 : this.emails) {
                arrayList.add(map2.getMap());
            }
            bundle.putParcelableArrayList("emails", arrayList);
        }
        if (set.contains("addresses") && this.addresses.size() > 0) {
            arrayList = new ArrayList();
            for (BaseModel map22 : this.addresses) {
                arrayList.add(map22.getMap());
            }
            bundle.putParcelableArrayList("addresses", arrayList);
        }
        if (set.contains("instantMessageAddresses") && this.imAddresses.size() > 0) {
            arrayList = new ArrayList();
            for (BaseModel map222 : this.imAddresses) {
                arrayList.add(map222.getMap());
            }
            bundle.putParcelableArrayList("instantMessageAddresses", arrayList);
        }
        if (set.contains("urlAddresses") && this.urlAddresses.size() > 0) {
            arrayList = new ArrayList();
            for (BaseModel map2222 : this.urlAddresses) {
                arrayList.add(map2222.getMap());
            }
            bundle.putParcelableArrayList("urlAddresses", arrayList);
        }
        if (set.contains("relationships") && this.relationships.size() > 0) {
            arrayList = new ArrayList();
            for (BaseModel map22222 : this.relationships) {
                arrayList.add(map22222.getMap());
            }
            bundle.putParcelableArrayList("relationships", arrayList);
        }
        if (this.extraNames.size() > 0) {
            contains = set.contains("nickname");
            boolean contains2 = set.contains("maidenName");
            for (int i = 0; i < this.extraNames.size(); i++) {
                ExtraNameModel extraNameModel = (ExtraNameModel) this.extraNames.get(i);
                Object data = extraNameModel.getData();
                String label = extraNameModel.getLabel();
                if (contains2 && label != null && label.equals("maidenName") && !TextUtils.isEmpty(data)) {
                    bundle.putString(label, data);
                }
                if (contains && label != null && label.equals("nickname") && !TextUtils.isEmpty(data)) {
                    bundle.putString(label, data);
                }
            }
        }
        contains = set.contains("birthday");
        set = set.contains("dates");
        if (set != null || contains) {
            Calendar instance = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("--MM-dd", Locale.getDefault());
            ArrayList arrayList2 = new ArrayList();
            for (BaseModel baseModel : this.dates) {
                Bundle bundle3 = new Bundle();
                String data2 = baseModel.getData();
                String label2 = baseModel.getLabel();
                int startsWith = data2.startsWith("--") ^ 1;
                if (startsWith != 0) {
                    instance.setTime(simpleDateFormat.parse(data2));
                } else {
                    instance.setTime(simpleDateFormat2.parse(data2));
                }
                if (startsWith != 0) {
                    bundle3.putInt("year", instance.get(1));
                }
                bundle3.putInt("month", instance.get(2));
                bundle3.putInt("day", instance.get(5));
                bundle3.putString("format", "gregorian");
                if (contains && label2 != null && label2.equals("birthday")) {
                    bundle.putBundle("birthday", bundle3);
                } else {
                    bundle3.putString("label", label2);
                    arrayList2.add(bundle3);
                }
            }
            if (set != null && arrayList2.size() > null) {
                bundle.putParcelableArrayList("dates", arrayList2);
            }
        }
        return bundle;
    }

    public ArrayList<ContentValues> getContentValues() {
        Bitmap decodeFile;
        ArrayList<ContentValues> arrayList = new ArrayList();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EXColumns.MIMETYPE, "vnd.android.cursor.item/identity");
        contentValues.put(EXColumns.TYPE, this.firstName);
        contentValues.put(EXColumns.DATA_5, this.middleName);
        contentValues.put(EXColumns.LABEL, this.lastName);
        contentValues.put(EXColumns.DATA_4, this.prefix);
        contentValues.put(EXColumns.DATA_6, this.suffix);
        contentValues.put(EXColumns.DATA_7, this.phoneticFirstName);
        contentValues.put(EXColumns.DATA_8, this.phoneticMiddleName);
        contentValues.put(EXColumns.DATA_9, this.phoneticLastName);
        arrayList.add(contentValues);
        contentValues = new ContentValues();
        contentValues.put(EXColumns.MIMETYPE, "vnd.android.cursor.item/organization");
        contentValues.put(EXColumns.DATA, this.company);
        contentValues.put(EXColumns.DATA_4, this.jobTitle);
        contentValues.put(EXColumns.DATA_5, this.department);
        arrayList.add(contentValues);
        contentValues = new ContentValues();
        contentValues.put(EXColumns.MIMETYPE, "vnd.android.cursor.item/note");
        contentValues.put(EXColumns.DATA, this.note);
        arrayList.add(contentValues);
        if (!(this.photoUri == null || this.photoUri.isEmpty())) {
            decodeFile = BitmapFactory.decodeFile(this.photoUri);
            if (decodeFile != null) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(EXColumns.MIMETYPE, "vnd.android.cursor.item/photo");
                contentValues2.put("data15", toByteArray(decodeFile));
                arrayList.add(contentValues2);
            }
        }
        if (!(this.rawPhotoUri == null || this.rawPhotoUri.isEmpty())) {
            decodeFile = BitmapFactory.decodeFile(this.rawPhotoUri);
            if (decodeFile != null) {
                contentValues2 = new ContentValues();
                contentValues2.put(EXColumns.MIMETYPE, "vnd.android.cursor.item/photo");
                contentValues2.put("data15", toByteArray(decodeFile));
                arrayList.add(contentValues2);
            }
        }
        for (List<BaseModel> list : getBaseModels()) {
            if (list != null) {
                for (BaseModel contentValues3 : list) {
                    arrayList.add(contentValues3.getContentValues());
                }
            }
        }
        return arrayList;
    }
}
