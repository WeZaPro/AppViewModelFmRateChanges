package com.taweesak.appviewmodelfmratechange.Fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.taweesak.appviewmodelfmratechange.Model.Model;
import com.taweesak.appviewmodelfmratechange.R;
import com.taweesak.appviewmodelfmratechange.ViewModel.PageViewModel;

public class BFragment extends Fragment {

    PageViewModel pageViewModel;
    TextView textView;
    ImageView imageView;

    public BFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // init ViewModel
        pageViewModel = ViewModelProviders.of(requireActivity()).get(PageViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findView(view);
        reStoreValue();
    }

    private void reStoreValue() {
        pageViewModel.getRate().observe(getActivity(), new Observer<Model>() {
            @Override
            public void onChanged(Model model) {

                     if(model.getRates()>0){
                         //Toast.makeText(getActivity(),"text : "+s,Toast.LENGTH_SHORT).show();
                         textView.setText(""+model.getRates());
                         changeFlag(model);
                     }else {
                         textView.setText(" ค่าที่ใส่ต้องมากกว่า 0 เท่านั้น");
                         imageView.setImageResource(R.drawable.my_image2);
                     }
            }
        });
    }

    private void changeFlag(Model model) {
        switch (model.getChoice()){
            case 0:
                imageView.setImageResource(R.drawable.usa);
                break;
            case 1:
                imageView.setImageResource(R.drawable.japan);
                break;
            case 2:
                imageView.setImageResource(R.drawable.europe);
                break;
        }
    }

    private void findView(View view) {
        textView =view.findViewById(R.id.textView);
        imageView = view.findViewById(R.id.imageView);
    }
}
