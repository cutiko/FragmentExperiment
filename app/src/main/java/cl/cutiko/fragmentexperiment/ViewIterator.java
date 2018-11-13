package cl.cutiko.fragmentexperiment;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

class ViewIterator {

    static final String TAG = "VIEW_ITERATOR";
    private static final int UNKNOWN = -1;

    static void traverseChilds(ViewGroup group){
        final Context context = group.getContext();
        int size = group.getChildCount();
        for (int i = 0; i < size; i++) {
            View view = group.getChildAt(i);
            viewInfo(view, context);
            if (view instanceof ViewGroup) {
                ViewGroup childGroup = (ViewGroup) view;
                traverseChilds(childGroup);
            }
        }

    }

    static void printStart(String where){
        Log.d(TAG, "######################################### " + where.toUpperCase());
    }

    static void viewInfo(View view, Context context) {
        if (view == null || context == null) {
            Log.e(TAG, "viewInfo: View or Context was null");
            return;
        }
        int id = view.getId();
        String name = context.getString(R.string.unknown_id);
        if (UNKNOWN != id) {
            name = context.getResources().getResourceEntryName(id);
        }

        Log.d(TAG, "traverseChilds: " + name);
        Log.d(TAG, "traverseChilds: " + view.getClass().getName());
    }

}
