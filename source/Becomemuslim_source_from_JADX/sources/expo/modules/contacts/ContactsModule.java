package expo.modules.contacts;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import com.facebook.GraphRequest;
import com.facebook.share.internal.MessengerShareContentUtility;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5995b;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6001h;
import expo.p307b.p315h.C6033a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContactsModule extends C6006c implements C6001h {
    private static final List<String> DEFAULT_PROJECTION = new C60821();
    private static final String TAG = "ContactsModule";
    private C6007d mModuleRegistry;

    /* renamed from: expo.modules.contacts.ContactsModule$1 */
    static class C60821 extends ArrayList<String> {
        C60821() {
            add(EXColumns.CONTACT_ID);
            add(EXColumns.LOOKUP_KEY);
            add(EXColumns.MIMETYPE);
            add(EXColumns.DISPLAY_NAME);
            add(EXColumns.PHOTO_URI);
            add(EXColumns.PHOTO_THUMBNAIL_URI);
            add(EXColumns.DATA);
            add(EXColumns.TYPE);
            add(EXColumns.DATA_5);
            add(EXColumns.LABEL);
            add(EXColumns.DATA_4);
            add(EXColumns.DATA_6);
            add(EXColumns.DATA_7);
            add(EXColumns.DATA_8);
            add(EXColumns.DATA_9);
            add(EXColumns.DATA);
            add(EXColumns.DATA_4);
            add(EXColumns.DATA_5);
        }
    }

    /* renamed from: expo.modules.contacts.ContactsModule$4 */
    class C60854 implements Comparator<Contact> {
        C60854() {
        }

        public int compare(Contact contact, Contact contact2) {
            return contact.getFirstName().compareToIgnoreCase(contact2.getFirstName());
        }
    }

    /* renamed from: expo.modules.contacts.ContactsModule$5 */
    class C60865 implements Comparator<Contact> {
        C60865() {
        }

        public int compare(Contact contact, Contact contact2) {
            return contact.getLastName().compareToIgnoreCase(contact2.getLastName());
        }
    }

    public String getName() {
        return "ExpoContacts";
    }

    public ContactsModule(Context context) {
        super(context);
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mModuleRegistry = c6007d;
    }

    @C5996c
    public void getContactsAsync(final Map<String, Object> map, final C6009f c6009f) {
        if (!isMissingPermissions(c6009f)) {
            new Thread(new Runnable() {
                public void run() {
                    ArrayList arrayList = null;
                    String str = (map.containsKey("sort") && (map.get("sort") instanceof String)) ? (String) map.get("sort") : null;
                    if (map.containsKey(GraphRequest.FIELDS_PARAM) && (map.get(GraphRequest.FIELDS_PARAM) instanceof ArrayList)) {
                        arrayList = (ArrayList) map.get(GraphRequest.FIELDS_PARAM);
                    }
                    Set access$000 = ContactsModule.this.getFieldsSet(arrayList);
                    if (map.containsKey("id") && (map.get("id") instanceof String)) {
                        Contact access$100 = ContactsModule.this.getContactById((String) map.get("id"), access$000, c6009f);
                        if (access$100 != null) {
                            Collection arrayList2 = new ArrayList();
                            arrayList2.add(access$100);
                            ArrayList access$200 = ContactsModule.this.serializeContacts(arrayList2, access$000, c6009f);
                            if (access$200 != null) {
                                Object bundle = new Bundle();
                                bundle.putParcelableArrayList("data", access$200);
                                c6009f.mo5137a(bundle);
                            }
                        }
                    } else if (map.containsKey("name") && (map.get("name") instanceof String)) {
                        HashMap access$300 = ContactsModule.this.getContactByName((String) map.get("name"), access$000, str, c6009f);
                        arrayList = ContactsModule.this.serializeContacts((Collection) access$300.get("data"), access$000, c6009f);
                        if (arrayList != null) {
                            Object bundle2 = new Bundle();
                            bundle2.putParcelableArrayList("data", arrayList);
                            bundle2.putBoolean("hasNextPage", ((Boolean) access$300.get("hasNextPage")).booleanValue());
                            bundle2.putBoolean("hasPreviousPage", ((Boolean) access$300.get("hasPreviousPage")).booleanValue());
                            c6009f.mo5137a(bundle2);
                        }
                    } else {
                        ContactsModule.this.getAllContactsAsync(map, access$000, str, c6009f);
                    }
                }
            }).start();
        }
    }

    @C5996c
    public void addContactAsync(Map<String, Object> map, String str, C6009f c6009f) {
        if (isMissingPermissions(c6009f) == null) {
            if (isMissingWritePermissions(c6009f) == null) {
                try {
                    map = getResolver().applyBatch("com.android.contacts", mutateContact(null, map).toOperationList());
                    if (map.length > null) {
                        c6009f.mo5137a(String.valueOf(ContentUris.parseId(map[null].uri)));
                    } else {
                        c6009f.m25152a("E_ADD_CONTACT_FAILED", "Given contact couldn't be added.");
                    }
                } catch (Throwable e) {
                    c6009f.m25155a(e);
                }
            }
        }
    }

    @C5996c
    public void updateContactAsync(Map<String, Object> map, C6009f c6009f) {
        if (!isMissingPermissions(c6009f)) {
            if (!isMissingWritePermissions(c6009f)) {
                Object obj = map.containsKey("id") ? (String) map.get("id") : null;
                Contact contactById = getContactById(obj, getFieldsSet(null), c6009f);
                if (contactById != null) {
                    try {
                        if (getResolver().applyBatch("com.android.contacts", mutateContact(contactById, map).toOperationList()).length > null) {
                            c6009f.mo5137a(obj);
                        } else {
                            c6009f.m25152a("E_UPDATE_CONTACT_FAILED", "Given contact couldn't be updated.");
                        }
                    } catch (Throwable e) {
                        c6009f.m25155a(e);
                    }
                } else {
                    c6009f.m25152a("E_CONTACTS", "Couldn't find contact");
                }
            }
        }
    }

    @C5996c
    public void removeContactAsync(String str, C6009f c6009f) {
        if (!isMissingPermissions(c6009f)) {
            if (!isMissingWritePermissions(c6009f)) {
                try {
                    getResolver().delete(Uri.withAppendedPath(Contacts.CONTENT_URI, str), null, null);
                    c6009f.mo5137a(null);
                } catch (Throwable e) {
                    c6009f.m25155a(e);
                }
            }
        }
    }

    @C5996c
    public void shareContactAsync(String str, String str2, C6009f c6009f) {
        str = getLookupKeyForContactId(str);
        if (str == null) {
            c6009f.m25152a("E_CONTACTS", "Couldn't find lookup key for contact.");
        }
        str = Uri.withAppendedPath(Contacts.CONTENT_VCARD_URI, str);
        c6009f = new Intent("android.intent.action.SEND");
        c6009f.setType("text/x-vcard");
        c6009f.putExtra("android.intent.extra.STREAM", str);
        c6009f.putExtra("android.intent.extra.SUBJECT", str2);
        ((C5995b) this.mModuleRegistry.m25133a(C5995b.class)).getCurrentActivity().startActivity(c6009f);
    }

    @C5996c
    public void writeContactToFileAsync(Map<String, Object> map, C6009f c6009f) {
        if (!isMissingPermissions(c6009f)) {
            map = getLookupKeyForContactId(map.containsKey("id") ? (String) map.get("id") : null);
            if (map == null) {
                c6009f.m25152a("E_CONTACTS", "Couldn't find lookup key for contact.");
            }
            c6009f.mo5137a(Uri.withAppendedPath(Contacts.CONTENT_VCARD_URI, map).toString());
        }
    }

    @C5996c
    public void presentFormAsync(String str, Map<String, Object> map, Map<String, Object> map2, C6009f c6009f) {
        if (isMissingPermissions(c6009f) == null) {
            if (str != null) {
                str = getContactById(str, getFieldsSet(null), c6009f);
                if (str == null) {
                    c6009f.m25152a("E_CONTACTS", "Couldn't find contact with ID.");
                    return;
                }
                presentEditForm(str);
                c6009f.mo5137a(Integer.valueOf(null));
                return;
            }
            presentForm(mutateContact(null, map));
        }
    }

    private void presentForm(Contact contact) {
        Intent intent = new Intent("android.intent.action.INSERT", Contacts.CONTENT_URI);
        intent.putExtra("name", contact.displayName);
        intent.putParcelableArrayListExtra("data", contact.getContentValues());
        intent.setFlags(268435456);
        ((C5995b) this.mModuleRegistry.m25133a(C5995b.class)).getCurrentActivity().startActivity(intent);
    }

    private void presentEditForm(Contact contact) {
        contact = Contacts.getLookupUri(Long.parseLong(contact.contactId), contact.lookupKey);
        Intent intent = new Intent("android.intent.action.EDIT");
        intent.setDataAndType(contact, "vnd.android.cursor.item/contact");
        ((C5995b) this.mModuleRegistry.m25133a(C5995b.class)).getCurrentActivity().startActivity(intent);
    }

    @C5996c
    public void getContactByPhoneNumber(final String str, final C6009f c6009f) {
        if (!isMissingPermissions(c6009f)) {
            AsyncTask.execute(new Runnable() {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                    r9 = this;
                    r0 = new android.os.Bundle;
                    r0.<init>();
                    r1 = android.provider.ContactsContract.PhoneLookup.CONTENT_FILTER_URI;
                    r2 = r2;
                    r2 = android.net.Uri.encode(r2);
                    r4 = android.net.Uri.withAppendedPath(r1, r2);
                    r1 = "display_name";
                    r5 = new java.lang.String[]{r1};
                    r1 = expo.modules.contacts.ContactsModule.this;
                    r3 = r1.getResolver();
                    r6 = 0;
                    r7 = 0;
                    r8 = 0;
                    r1 = r3.query(r4, r5, r6, r7, r8);
                    if (r1 != 0) goto L_0x0030;
                L_0x0026:
                    r0 = r3;
                    r1 = "E_CONTACTS";
                    r2 = "Couldn't query contact by number";
                    r0.m25152a(r1, r2);
                    return;
                L_0x0030:
                    r2 = r1.moveToFirst();	 Catch:{ Exception -> 0x0051 }
                    if (r2 == 0) goto L_0x0045;
                L_0x0036:
                    r2 = "display_name";
                    r2 = r1.getColumnIndex(r2);	 Catch:{ Exception -> 0x0051 }
                    r2 = r1.getString(r2);	 Catch:{ Exception -> 0x0051 }
                    r3 = "displayName";
                    r0.putString(r3, r2);	 Catch:{ Exception -> 0x0051 }
                L_0x0045:
                    r2 = r1.isClosed();
                    if (r2 != 0) goto L_0x005e;
                L_0x004b:
                    r1.close();
                    goto L_0x005e;
                L_0x004f:
                    r0 = move-exception;
                    goto L_0x0064;
                L_0x0051:
                    r2 = move-exception;
                    r3 = r3;	 Catch:{ all -> 0x004f }
                    r3.m25155a(r2);	 Catch:{ all -> 0x004f }
                    r2 = r1.isClosed();
                    if (r2 != 0) goto L_0x005e;
                L_0x005d:
                    goto L_0x004b;
                L_0x005e:
                    r1 = r3;
                    r1.mo5137a(r0);
                    return;
                L_0x0064:
                    r2 = r1.isClosed();
                    if (r2 != 0) goto L_0x006d;
                L_0x006a:
                    r1.close();
                L_0x006d:
                    throw r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: expo.modules.contacts.ContactsModule.3.run():void");
                }
            });
        }
    }

    private ContentResolver getResolver() {
        return getContext().getContentResolver();
    }

    private expo.modules.contacts.Contact mutateContact(expo.modules.contacts.Contact r4, java.util.Map<java.lang.String, java.lang.Object> r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        if (r4 != 0) goto L_0x000f;
    L_0x0002:
        r4 = new expo.modules.contacts.Contact;
        r0 = java.util.UUID.randomUUID();
        r0 = r0.toString();
        r4.<init>(r0);
    L_0x000f:
        r0 = "firstName";
        r0 = r5.containsKey(r0);
        if (r0 == 0) goto L_0x0021;
    L_0x0017:
        r0 = "firstName";
        r0 = r5.get(r0);
        r0 = (java.lang.String) r0;
        r4.firstName = r0;
    L_0x0021:
        r0 = "middleName";
        r0 = r5.containsKey(r0);
        if (r0 == 0) goto L_0x0033;
    L_0x0029:
        r0 = "middleName";
        r0 = r5.get(r0);
        r0 = (java.lang.String) r0;
        r4.middleName = r0;
    L_0x0033:
        r0 = "lastName";
        r0 = r5.containsKey(r0);
        if (r0 == 0) goto L_0x0045;
    L_0x003b:
        r0 = "lastName";
        r0 = r5.get(r0);
        r0 = (java.lang.String) r0;
        r4.lastName = r0;
    L_0x0045:
        r0 = "namePrefix";
        r0 = r5.containsKey(r0);
        if (r0 == 0) goto L_0x0057;
    L_0x004d:
        r0 = "namePrefix";
        r0 = r5.get(r0);
        r0 = (java.lang.String) r0;
        r4.prefix = r0;
    L_0x0057:
        r0 = "nameSuffix";
        r0 = r5.containsKey(r0);
        if (r0 == 0) goto L_0x0069;
    L_0x005f:
        r0 = "nameSuffix";
        r0 = r5.get(r0);
        r0 = (java.lang.String) r0;
        r4.suffix = r0;
    L_0x0069:
        r0 = "phoneticFirstName";
        r0 = r5.containsKey(r0);
        if (r0 == 0) goto L_0x007b;
    L_0x0071:
        r0 = "phoneticFirstName";
        r0 = r5.get(r0);
        r0 = (java.lang.String) r0;
        r4.phoneticFirstName = r0;
    L_0x007b:
        r0 = "phoneticMiddleName";
        r0 = r5.containsKey(r0);
        if (r0 == 0) goto L_0x008d;
    L_0x0083:
        r0 = "phoneticMiddleName";
        r0 = r5.get(r0);
        r0 = (java.lang.String) r0;
        r4.phoneticMiddleName = r0;
    L_0x008d:
        r0 = "phoneticLastName";
        r0 = r5.containsKey(r0);
        if (r0 == 0) goto L_0x009f;
    L_0x0095:
        r0 = "phoneticLastName";
        r0 = r5.get(r0);
        r0 = (java.lang.String) r0;
        r4.phoneticLastName = r0;
    L_0x009f:
        r0 = "company";
        r0 = r5.containsKey(r0);
        if (r0 == 0) goto L_0x00b1;
    L_0x00a7:
        r0 = "company";
        r0 = r5.get(r0);
        r0 = (java.lang.String) r0;
        r4.company = r0;
    L_0x00b1:
        r0 = "jobTitle";
        r0 = r5.containsKey(r0);
        if (r0 == 0) goto L_0x00c3;
    L_0x00b9:
        r0 = "jobTitle";
        r0 = r5.get(r0);
        r0 = (java.lang.String) r0;
        r4.jobTitle = r0;
    L_0x00c3:
        r0 = "department";
        r0 = r5.containsKey(r0);
        if (r0 == 0) goto L_0x00d5;
    L_0x00cb:
        r0 = "department";
        r0 = r5.get(r0);
        r0 = (java.lang.String) r0;
        r4.department = r0;
    L_0x00d5:
        r0 = "note";
        r0 = r5.containsKey(r0);
        if (r0 == 0) goto L_0x00e7;
    L_0x00dd:
        r0 = "note";
        r0 = r5.get(r0);
        r0 = (java.lang.String) r0;
        r4.note = r0;
    L_0x00e7:
        r0 = "addresses";	 Catch:{ Exception -> 0x01c7 }
        r0 = r5.containsKey(r0);	 Catch:{ Exception -> 0x01c7 }
        r1 = 0;	 Catch:{ Exception -> 0x01c7 }
        if (r0 == 0) goto L_0x00f9;	 Catch:{ Exception -> 0x01c7 }
    L_0x00f0:
        r0 = "addresses";	 Catch:{ Exception -> 0x01c7 }
        r0 = r5.get(r0);	 Catch:{ Exception -> 0x01c7 }
        r0 = (java.util.List) r0;	 Catch:{ Exception -> 0x01c7 }
        goto L_0x00fa;	 Catch:{ Exception -> 0x01c7 }
    L_0x00f9:
        r0 = r1;	 Catch:{ Exception -> 0x01c7 }
    L_0x00fa:
        r2 = expo.modules.contacts.models.PostalAddressModel.class;	 Catch:{ Exception -> 0x01c7 }
        r0 = expo.modules.contacts.models.BaseModel.decodeList(r0, r2);	 Catch:{ Exception -> 0x01c7 }
        if (r0 == 0) goto L_0x0104;	 Catch:{ Exception -> 0x01c7 }
    L_0x0102:
        r4.addresses = r0;	 Catch:{ Exception -> 0x01c7 }
    L_0x0104:
        r0 = "phoneNumbers";	 Catch:{ Exception -> 0x01c7 }
        r0 = r5.containsKey(r0);	 Catch:{ Exception -> 0x01c7 }
        if (r0 == 0) goto L_0x0115;	 Catch:{ Exception -> 0x01c7 }
    L_0x010c:
        r0 = "phoneNumbers";	 Catch:{ Exception -> 0x01c7 }
        r0 = r5.get(r0);	 Catch:{ Exception -> 0x01c7 }
        r0 = (java.util.List) r0;	 Catch:{ Exception -> 0x01c7 }
        goto L_0x0116;	 Catch:{ Exception -> 0x01c7 }
    L_0x0115:
        r0 = r1;	 Catch:{ Exception -> 0x01c7 }
    L_0x0116:
        r2 = expo.modules.contacts.models.PhoneNumberModel.class;	 Catch:{ Exception -> 0x01c7 }
        r0 = expo.modules.contacts.models.BaseModel.decodeList(r0, r2);	 Catch:{ Exception -> 0x01c7 }
        if (r0 == 0) goto L_0x0120;	 Catch:{ Exception -> 0x01c7 }
    L_0x011e:
        r4.phones = r0;	 Catch:{ Exception -> 0x01c7 }
    L_0x0120:
        r0 = "emails";	 Catch:{ Exception -> 0x01c7 }
        r0 = r5.containsKey(r0);	 Catch:{ Exception -> 0x01c7 }
        if (r0 == 0) goto L_0x0131;	 Catch:{ Exception -> 0x01c7 }
    L_0x0128:
        r0 = "emails";	 Catch:{ Exception -> 0x01c7 }
        r0 = r5.get(r0);	 Catch:{ Exception -> 0x01c7 }
        r0 = (java.util.List) r0;	 Catch:{ Exception -> 0x01c7 }
        goto L_0x0132;	 Catch:{ Exception -> 0x01c7 }
    L_0x0131:
        r0 = r1;	 Catch:{ Exception -> 0x01c7 }
    L_0x0132:
        r2 = expo.modules.contacts.models.EmailModel.class;	 Catch:{ Exception -> 0x01c7 }
        r0 = expo.modules.contacts.models.BaseModel.decodeList(r0, r2);	 Catch:{ Exception -> 0x01c7 }
        if (r0 == 0) goto L_0x013c;	 Catch:{ Exception -> 0x01c7 }
    L_0x013a:
        r4.emails = r0;	 Catch:{ Exception -> 0x01c7 }
    L_0x013c:
        r0 = "instantMessageAddresses";	 Catch:{ Exception -> 0x01c7 }
        r0 = r5.containsKey(r0);	 Catch:{ Exception -> 0x01c7 }
        if (r0 == 0) goto L_0x014d;	 Catch:{ Exception -> 0x01c7 }
    L_0x0144:
        r0 = "instantMessageAddresses";	 Catch:{ Exception -> 0x01c7 }
        r0 = r5.get(r0);	 Catch:{ Exception -> 0x01c7 }
        r0 = (java.util.List) r0;	 Catch:{ Exception -> 0x01c7 }
        goto L_0x014e;	 Catch:{ Exception -> 0x01c7 }
    L_0x014d:
        r0 = r1;	 Catch:{ Exception -> 0x01c7 }
    L_0x014e:
        r2 = expo.modules.contacts.models.ImAddressModel.class;	 Catch:{ Exception -> 0x01c7 }
        r0 = expo.modules.contacts.models.BaseModel.decodeList(r0, r2);	 Catch:{ Exception -> 0x01c7 }
        if (r0 == 0) goto L_0x0158;	 Catch:{ Exception -> 0x01c7 }
    L_0x0156:
        r4.imAddresses = r0;	 Catch:{ Exception -> 0x01c7 }
    L_0x0158:
        r0 = "urlAddresses";	 Catch:{ Exception -> 0x01c7 }
        r0 = r5.containsKey(r0);	 Catch:{ Exception -> 0x01c7 }
        if (r0 == 0) goto L_0x0169;	 Catch:{ Exception -> 0x01c7 }
    L_0x0160:
        r0 = "urlAddresses";	 Catch:{ Exception -> 0x01c7 }
        r0 = r5.get(r0);	 Catch:{ Exception -> 0x01c7 }
        r0 = (java.util.List) r0;	 Catch:{ Exception -> 0x01c7 }
        goto L_0x016a;	 Catch:{ Exception -> 0x01c7 }
    L_0x0169:
        r0 = r1;	 Catch:{ Exception -> 0x01c7 }
    L_0x016a:
        r2 = expo.modules.contacts.models.UrlAddressModel.class;	 Catch:{ Exception -> 0x01c7 }
        r0 = expo.modules.contacts.models.BaseModel.decodeList(r0, r2);	 Catch:{ Exception -> 0x01c7 }
        if (r0 == 0) goto L_0x0174;	 Catch:{ Exception -> 0x01c7 }
    L_0x0172:
        r4.urlAddresses = r0;	 Catch:{ Exception -> 0x01c7 }
    L_0x0174:
        r0 = "extraNames";	 Catch:{ Exception -> 0x01c7 }
        r0 = r5.containsKey(r0);	 Catch:{ Exception -> 0x01c7 }
        if (r0 == 0) goto L_0x0185;	 Catch:{ Exception -> 0x01c7 }
    L_0x017c:
        r0 = "extraNames";	 Catch:{ Exception -> 0x01c7 }
        r0 = r5.get(r0);	 Catch:{ Exception -> 0x01c7 }
        r0 = (java.util.List) r0;	 Catch:{ Exception -> 0x01c7 }
        goto L_0x0186;	 Catch:{ Exception -> 0x01c7 }
    L_0x0185:
        r0 = r1;	 Catch:{ Exception -> 0x01c7 }
    L_0x0186:
        r2 = expo.modules.contacts.models.ExtraNameModel.class;	 Catch:{ Exception -> 0x01c7 }
        r0 = expo.modules.contacts.models.BaseModel.decodeList(r0, r2);	 Catch:{ Exception -> 0x01c7 }
        if (r0 == 0) goto L_0x0190;	 Catch:{ Exception -> 0x01c7 }
    L_0x018e:
        r4.extraNames = r0;	 Catch:{ Exception -> 0x01c7 }
    L_0x0190:
        r0 = "dates";	 Catch:{ Exception -> 0x01c7 }
        r0 = r5.containsKey(r0);	 Catch:{ Exception -> 0x01c7 }
        if (r0 == 0) goto L_0x01a1;	 Catch:{ Exception -> 0x01c7 }
    L_0x0198:
        r0 = "dates";	 Catch:{ Exception -> 0x01c7 }
        r0 = r5.get(r0);	 Catch:{ Exception -> 0x01c7 }
        r0 = (java.util.List) r0;	 Catch:{ Exception -> 0x01c7 }
        goto L_0x01a2;	 Catch:{ Exception -> 0x01c7 }
    L_0x01a1:
        r0 = r1;	 Catch:{ Exception -> 0x01c7 }
    L_0x01a2:
        r2 = expo.modules.contacts.models.DateModel.class;	 Catch:{ Exception -> 0x01c7 }
        r0 = expo.modules.contacts.models.BaseModel.decodeList(r0, r2);	 Catch:{ Exception -> 0x01c7 }
        if (r0 == 0) goto L_0x01ac;	 Catch:{ Exception -> 0x01c7 }
    L_0x01aa:
        r4.dates = r0;	 Catch:{ Exception -> 0x01c7 }
    L_0x01ac:
        r0 = "relationships";	 Catch:{ Exception -> 0x01c7 }
        r0 = r5.containsKey(r0);	 Catch:{ Exception -> 0x01c7 }
        if (r0 == 0) goto L_0x01bd;	 Catch:{ Exception -> 0x01c7 }
    L_0x01b4:
        r0 = "relationships";	 Catch:{ Exception -> 0x01c7 }
        r5 = r5.get(r0);	 Catch:{ Exception -> 0x01c7 }
        r1 = r5;	 Catch:{ Exception -> 0x01c7 }
        r1 = (java.util.List) r1;	 Catch:{ Exception -> 0x01c7 }
    L_0x01bd:
        r5 = expo.modules.contacts.models.RelationshipModel.class;	 Catch:{ Exception -> 0x01c7 }
        r5 = expo.modules.contacts.models.BaseModel.decodeList(r1, r5);	 Catch:{ Exception -> 0x01c7 }
        if (r5 == 0) goto L_0x01c7;	 Catch:{ Exception -> 0x01c7 }
    L_0x01c5:
        r4.relationships = r5;	 Catch:{ Exception -> 0x01c7 }
    L_0x01c7:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.contacts.ContactsModule.mutateContact(expo.modules.contacts.Contact, java.util.Map):expo.modules.contacts.Contact");
    }

    private String getLookupKeyForContactId(String str) {
        ContentResolver resolver = getResolver();
        Uri uri = Contacts.CONTENT_URI;
        String[] strArr = new String[]{EXColumns.LOOKUP_KEY};
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("_id = ");
        stringBuilder.append(str);
        str = resolver.query(uri, strArr, stringBuilder.toString(), null, null);
        return str.moveToFirst() ? str.getString(0) : null;
    }

    private Contact getContactById(String str, Set<String> set, C6009f c6009f) {
        set = createProjectionForQuery(set);
        List list = (List) set.get("projection");
        String str2 = (String) set.get("selection");
        ArrayList arrayList = (ArrayList) set.get("selectionArgs");
        str = getResolver().query(Data.CONTENT_URI, (String[]) list.toArray(new String[list.size()]), "contact_id = ?", new String[]{str}, null);
        if (str != null) {
            try {
                ArrayList arrayList2 = new ArrayList(loadContactsFrom(str).values());
                if (arrayList2.size() > 0) {
                    Contact contact = (Contact) arrayList2.get(0);
                    str.close();
                    return contact;
                }
            } catch (Throwable e) {
                c6009f.m25155a(e);
            } catch (Throwable th) {
                str.close();
            }
            str.close();
        }
        return null;
    }

    private ArrayList serializeContacts(Collection<Contact> collection, Set<String> set, C6009f c6009f) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (Contact toMap : collection) {
                arrayList.add(toMap.toMap(set));
            }
        } catch (Throwable e) {
            c6009f.m25155a(e);
        }
        return arrayList;
    }

    private HashMap<String, Object> getContactByName(String str, Set<String> set, String str2, C6009f c6009f) {
        return fetchContacts(0, 9999, new String[]{str}, EXColumns.DISPLAY_NAME, set, str2, c6009f);
    }

    private Set<String> ensureFieldsSet(Set<String> set) {
        return set == null ? newHashSet("phoneNumbers", "emails", "addresses", "note", "birthday", "dates", "instantMessageAddresses", "urlAddresses", "extraNames", "relationships", "phoneticFirstName", "phoneticLastName", "phoneticMiddleName", "namePrefix", "nameSuffix", "name", "firstName", "middleName", "lastName", "nickname", "id", "jobTitle", "company", "department", MessengerShareContentUtility.MEDIA_IMAGE, "imageAvailable", "note") : set;
    }

    private Set<String> convertReadableArray(ArrayList arrayList) {
        Set<String> hashSet = new HashSet();
        arrayList = arrayList.iterator();
        while (arrayList.hasNext()) {
            Object next = arrayList.next();
            if (next instanceof String) {
                hashSet.add((String) next);
            }
        }
        return hashSet;
    }

    private Set<String> getFieldsSet(ArrayList arrayList) {
        if (arrayList != null) {
            return ensureFieldsSet(convertReadableArray(arrayList));
        }
        return ensureFieldsSet(null);
    }

    private void getAllContactsAsync(Map<String, Object> map, Set<String> set, String str, C6009f c6009f) {
        int intValue = (map.containsKey("pageOffset") && (map.get("pageOffset") instanceof Number)) ? ((Number) map.get("pageOffset")).intValue() : 0;
        int intValue2 = (map.containsKey("pageSize") && (map.get("pageSize") instanceof Number)) ? ((Number) map.get("pageSize")).intValue() : 0;
        map = fetchContacts(intValue, intValue2, null, null, set, str, c6009f);
        if (map != null) {
            ArrayList arrayList = (ArrayList) map.get("data");
            ArrayList arrayList2 = new ArrayList();
            try {
                str = arrayList.iterator();
                while (str.hasNext()) {
                    arrayList2.add(((Contact) str.next()).toMap(set));
                }
                Object bundle = new Bundle();
                bundle.putBoolean("hasNextPage", ((Boolean) map.get("hasNextPage")).booleanValue());
                bundle.putBoolean("hasPreviousPage", ((Boolean) map.get("hasPreviousPage")).booleanValue());
                bundle.putParcelableArrayList("data", arrayList2);
                bundle.putInt("total", ((Integer) map.get("total")).intValue());
                c6009f.mo5137a(bundle);
            } catch (Throwable e) {
                c6009f.m25155a(e);
            }
        }
    }

    private HashMap createProjectionForQuery(Set<String> set) {
        List arrayList = new ArrayList(DEFAULT_PROJECTION);
        ArrayList arrayList2 = new ArrayList(Arrays.asList(new String[]{"vnd.android.cursor.item/name", "vnd.android.cursor.item/organization"}));
        Object obj = "mimetype=? OR mimetype=?";
        if (set.contains("phoneNumbers")) {
            arrayList.add(EXColumns.DATA);
            arrayList.add(EXColumns.TYPE);
            arrayList.add(EXColumns.LABEL);
            arrayList.add(EXColumns.IS_PRIMARY);
            arrayList.add(EXColumns.ID);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(obj);
            stringBuilder.append(" OR mimetype=?");
            obj = stringBuilder.toString();
            arrayList2.add("vnd.android.cursor.item/phone_v2");
        }
        if (set.contains("emails")) {
            arrayList.add(EXColumns.DATA);
            arrayList.add(EXColumns.DATA);
            arrayList.add(EXColumns.TYPE);
            arrayList.add(EXColumns.LABEL);
            arrayList.add(EXColumns.IS_PRIMARY);
            arrayList.add(EXColumns.ID);
            stringBuilder = new StringBuilder();
            stringBuilder.append(obj);
            stringBuilder.append(" OR mimetype=?");
            obj = stringBuilder.toString();
            arrayList2.add("vnd.android.cursor.item/email_v2");
        }
        if (set.contains("addresses")) {
            arrayList.add(EXColumns.DATA);
            arrayList.add(EXColumns.TYPE);
            arrayList.add(EXColumns.LABEL);
            arrayList.add(EXColumns.DATA_4);
            arrayList.add(EXColumns.DATA_5);
            arrayList.add(EXColumns.DATA_6);
            arrayList.add(EXColumns.DATA_7);
            arrayList.add(EXColumns.DATA_8);
            arrayList.add(EXColumns.DATA_9);
            arrayList.add(EXColumns.DATA_10);
            stringBuilder = new StringBuilder();
            stringBuilder.append(obj);
            stringBuilder.append(" OR mimetype=?");
            obj = stringBuilder.toString();
            arrayList2.add("vnd.android.cursor.item/postal-address_v2");
        }
        if (set.contains("note")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(obj);
            stringBuilder.append(" OR mimetype=?");
            obj = stringBuilder.toString();
            arrayList2.add("vnd.android.cursor.item/note");
        }
        if (set.contains("birthday") || set.contains("dates")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(obj);
            stringBuilder.append(" OR mimetype=?");
            obj = stringBuilder.toString();
            arrayList2.add("vnd.android.cursor.item/contact_event");
        }
        if (set.contains("instantMessageAddresses")) {
            arrayList.add(EXColumns.DATA);
            arrayList.add(EXColumns.TYPE);
            arrayList.add(EXColumns.DATA_5);
            arrayList.add(EXColumns.ID);
            stringBuilder = new StringBuilder();
            stringBuilder.append(obj);
            stringBuilder.append(" OR mimetype=?");
            obj = stringBuilder.toString();
            arrayList2.add("vnd.android.cursor.item/im");
        }
        if (set.contains("urlAddresses")) {
            arrayList.add(EXColumns.DATA);
            arrayList.add(EXColumns.TYPE);
            arrayList.add(EXColumns.ID);
            stringBuilder = new StringBuilder();
            stringBuilder.append(obj);
            stringBuilder.append(" OR mimetype=?");
            obj = stringBuilder.toString();
            arrayList2.add("vnd.android.cursor.item/website");
        }
        if (set.contains("extraNames")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(obj);
            stringBuilder.append(" OR mimetype=?");
            obj = stringBuilder.toString();
            arrayList2.add("vnd.android.cursor.item/nickname");
        }
        if (set.contains("relationships")) {
            arrayList.add(EXColumns.DATA);
            arrayList.add(EXColumns.TYPE);
            arrayList.add(EXColumns.ID);
            stringBuilder = new StringBuilder();
            stringBuilder.append(obj);
            stringBuilder.append(" OR mimetype=?");
            obj = stringBuilder.toString();
            arrayList2.add("vnd.android.cursor.item/relation");
        }
        if (set.contains("phoneticFirstName")) {
            arrayList.add(EXColumns.DATA_7);
        }
        if (set.contains("phoneticLastName")) {
            arrayList.add(EXColumns.DATA_9);
        }
        if (set.contains("phoneticMiddleName")) {
            arrayList.add(EXColumns.DATA_8);
        }
        if (set.contains("namePrefix")) {
            arrayList.add(EXColumns.DATA_4);
        }
        if (set.contains("nameSuffix") != null) {
            arrayList.add(EXColumns.DATA_6);
        }
        set = new HashMap();
        set.put("projection", arrayList);
        set.put("selection", obj);
        set.put("selectionArgs", arrayList2);
        return set;
    }

    private HashMap<String, Object> fetchContacts(int i, int i2, String[] strArr, String str, Set<String> set, String str2, C6009f c6009f) {
        Cursor query;
        ContactsModule contactsModule = this;
        int i3 = i2;
        HashMap<String, Object> hashMap = strArr;
        boolean z = false;
        Object obj = i3 == 0 ? 1 : null;
        String str3 = str != null ? str : EXColumns.CONTACT_ID;
        HashMap createProjectionForQuery = createProjectionForQuery(set);
        List list = (List) createProjectionForQuery.get("projection");
        String str4 = (String) createProjectionForQuery.get("selection");
        ContentResolver resolver = getResolver();
        ArrayList arrayList = (ArrayList) createProjectionForQuery.get("selectionArgs");
        if (hashMap == null || hashMap.length <= 0) {
            query = resolver.query(Data.CONTENT_URI, (String[]) list.toArray(new String[list.size()]), str4, (String[]) arrayList.toArray(new String[arrayList.size()]), null);
        } else {
            String[] strArr2 = (String[]) list.toArray(new String[list.size()]);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str3);
            stringBuilder.append(" = ?");
            hashMap = strArr;
            query = resolver.query(Data.CONTENT_URI, strArr2, stringBuilder.toString(), hashMap, null);
        }
        if (query != null) {
            try {
                Map loadContactsFrom = loadContactsFrom(query);
                ArrayList arrayList2 = new ArrayList();
                ArrayList sortContactsBy = sortContactsBy(new ArrayList(loadContactsFrom.values()), str2);
                int size = sortContactsBy.size();
                hashMap = new HashMap();
                int i4 = obj != null ? 0 : i;
                while (i4 < size) {
                    Contact contact = (Contact) sortContactsBy.get(i4);
                    if (obj == null && i4 - i >= i3) {
                        break;
                    }
                    arrayList2.add(contact);
                    i4++;
                }
                hashMap.put("data", arrayList2);
                hashMap.put("hasPreviousPage", Boolean.valueOf(i > 0));
                str3 = "hasNextPage";
                if (i + i3 < size) {
                    z = true;
                }
                hashMap.put(str3, Boolean.valueOf(z));
                hashMap.put("total", Integer.valueOf(size));
                return hashMap;
            } catch (Throwable e) {
                c6009f.m25155a(e);
            } finally {
                query.close();
            }
        }
        return null;
    }

    private ArrayList<Contact> sortContactsBy(ArrayList<Contact> arrayList, String str) {
        if (str == null) {
            return arrayList;
        }
        Object obj = -1;
        int hashCode = str.hashCode();
        if (hashCode != -1459599807) {
            if (hashCode == 132835675) {
                if (str.equals("firstName") != null) {
                    obj = null;
                }
            }
        } else if (str.equals("lastName") != null) {
            obj = 1;
        }
        switch (obj) {
            case null:
                Collections.sort(arrayList, new C60854());
                return arrayList;
            case 1:
                Collections.sort(arrayList, new C60865());
                return arrayList;
            default:
                return arrayList;
        }
    }

    private static Set<String> newHashSet(String... strArr) {
        Set hashSet = new HashSet();
        for (Object add : strArr) {
            hashSet.add(add);
        }
        return hashSet;
    }

    private Map<String, Contact> loadContactsFrom(Cursor cursor) {
        Map<String, Contact> linkedHashMap = new LinkedHashMap();
        while (cursor.moveToNext()) {
            String string = cursor.getString(cursor.getColumnIndex(EXColumns.CONTACT_ID));
            if (!linkedHashMap.containsKey(string)) {
                linkedHashMap.put(string, new Contact(string));
            }
            ((Contact) linkedHashMap.get(string)).fromCursor(cursor);
        }
        return linkedHashMap;
    }

    private boolean isMissingPermissions(C6009f c6009f) {
        C6033a c6033a = (C6033a) this.mModuleRegistry.m25133a(C6033a.class);
        boolean z = false;
        if (c6033a == null) {
            c6009f.m25152a("E_NO_PERMISSIONS", "Permissions module is null. Are you sure all the installed Expo modules are properly linked?");
            return false;
        }
        int[] permissions = c6033a.getPermissions(new String[]{"android.permission.READ_CONTACTS"});
        if (permissions.length == 1 && permissions[0] == 0) {
            z = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        if (!valueOf.booleanValue()) {
            c6009f.m25152a("E_MISSING_PERMISSION", "Missing read contacts permission.");
        }
        return valueOf.booleanValue() ^ 1;
    }

    private boolean isMissingWritePermissions(C6009f c6009f) {
        C6033a c6033a = (C6033a) this.mModuleRegistry.m25133a(C6033a.class);
        boolean z = false;
        if (c6033a == null) {
            c6009f.m25152a("E_NO_PERMISSIONS", "Permissions module is null. Are you sure all the installed Expo modules are properly linked?");
            return false;
        }
        int[] permissions = c6033a.getPermissions(new String[]{"android.permission.WRITE_CONTACTS"});
        if (permissions.length == 1 && permissions[0] == 0) {
            z = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        if (!valueOf.booleanValue()) {
            c6009f.m25152a("E_MISSING_PERMISSION", "Missing write contacts permission.");
        }
        return valueOf.booleanValue() ^ 1;
    }
}
