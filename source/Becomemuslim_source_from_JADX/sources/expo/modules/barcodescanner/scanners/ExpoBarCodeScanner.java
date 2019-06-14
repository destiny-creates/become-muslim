package expo.modules.barcodescanner.scanners;

import android.content.Context;
import expo.p307b.p308a.C6017a;
import expo.p307b.p308a.C6020d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class ExpoBarCodeScanner implements C6017a {
    protected List<Integer> mBarCodeTypes;
    protected Context mContext;

    public abstract boolean isAvailable();

    ExpoBarCodeScanner(Context context) {
        this.mContext = context;
    }

    boolean areNewAndOldBarCodeTypesEqual(List<Integer> list) {
        if (this.mBarCodeTypes == null) {
            return false;
        }
        Set hashSet = new HashSet(this.mBarCodeTypes);
        Collection hashSet2 = new HashSet(list);
        if (hashSet.size() != hashSet2.size()) {
            return false;
        }
        hashSet.removeAll(hashSet2);
        return hashSet.isEmpty();
    }

    List<Integer> parseBarCodeTypesFromSettings(C6020d c6020d) {
        c6020d = c6020d.getTypes();
        if (c6020d != null) {
            if (c6020d instanceof List) {
                List<Integer> arrayList = new ArrayList();
                for (Object next : (List) c6020d) {
                    if (next instanceof Number) {
                        arrayList.add(Integer.valueOf(((Number) next).intValue()));
                    }
                }
                return arrayList;
            }
        }
        return null;
    }
}
