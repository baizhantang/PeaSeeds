package cc.jethro.peaseeds;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jethro on 2016/11/19.
 */

public class AnalysisFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.analysis_fragment, container, false);
        return view;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            //相当于fragment的onResume
            AnalysisAdapter analysisAdapter = new AnalysisAdapter(getActivity(),
                    R.layout.analysis_item, DataHandle.analysisDatas);
            ListView listView = (ListView) getActivity().findViewById(R.id.list_view);
            listView.setAdapter(analysisAdapter);
            listView.setEnabled(false);
        }else {
            //相当于fragment的onPause
        }
    }
}
