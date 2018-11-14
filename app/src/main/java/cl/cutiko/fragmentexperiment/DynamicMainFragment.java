package cl.cutiko.fragmentexperiment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

public class DynamicMainFragment extends MainActivityFragment {

    public static DynamicMainFragment newInstance() {
        return new DynamicMainFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ViewIterator.printStart(getClass().getSimpleName());
        super.onViewCreated(view, savedInstanceState);
    }
}
