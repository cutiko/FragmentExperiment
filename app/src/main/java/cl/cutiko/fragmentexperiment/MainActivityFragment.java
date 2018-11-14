package cl.cutiko.fragmentexperiment;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @CallSuper
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewIterator.printStart("onViewCreated " + getClass().getSimpleName());
        ViewIterator.viewInfo(view, getContext());
    }

    @Override
    public void onStart() {
        super.onStart();
        ViewGroup viewGroup = (ViewGroup) getView();
        ViewIterator.printStart("onStart " + getClass().getSimpleName());
        ViewIterator.viewInfo(viewGroup, getContext());
        ViewIterator.traverseChilds(viewGroup);
        ViewGroup rootFragment = getView().findViewById(R.id.rootFragment);
        if (rootFragment == null) {
            Log.d(ViewIterator.TAG, getClass().getSimpleName() + " onStart: root fragment id is null");
        } else {
            Log.d(ViewIterator.TAG, getClass().getSimpleName() + " onStart: root fragment id found");
        }

    }
}
