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
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.taweesak.appviewmodelfmratechange.Model.Model;
import com.taweesak.appviewmodelfmratechange.R;
import com.taweesak.appviewmodelfmratechange.ViewModel.PageViewModel;

public class AFragment extends Fragment {

    PageViewModel pageViewModel;
    EditText editText;
    Button button;
    RadioGroup radioGroup;
    RadioButton radioButton;
    double rateDouble;
    Model model;
    private int selectId, choice;

    RadioButton radioButton0,radioButton1,radioButton2;

    public AFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: create onCreate + create viewModel Obj
        // init ViewModel
        pageViewModel = ViewModelProviders.of(requireActivity()).get(PageViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO: create view
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        ;
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // TODO: create onViewCreate + create event

        findView(view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertValue();
            }
        });

        // reStore value
        viewModelGetValue();
    }

    private void viewModelGetValue() {
        pageViewModel.getRate().observe(getActivity(), new Observer<Model>() {
            @Override
            public void onChanged(Model model) {
                //ดึงค่าต้นฉบับ หลังทำ ViewModel
                editText.setText("" + model.getRatesOriginalNumber());

                // reStoreRadioButton
                reStoreRadioButton(model);
            }
        });
    }

    private void reStoreRadioButton(Model model) {
        switch (model.getChoice()){
            case 0:
                radioButton0.setChecked(true);
                break;
            case 1:
                radioButton1.setChecked(true);
                break;
            case 2:
                radioButton2.setChecked(true);
                break;
        }
    }

    private void convertValue() {
        checkRadioButton();

        try {
            rateDouble = Double.parseDouble(editText.getText().toString());
            model = new Model(rateDouble, choice);

            pageViewModel.setRate(model);
            Toast.makeText(getActivity(), "set data : " + model.getRates(), Toast.LENGTH_SHORT).show();

            }catch (NumberFormatException e){

            Toast.makeText(getActivity(), "ค่าที่ใส่ต้องเป็นตัวเลขเท่านั้น" , Toast.LENGTH_SHORT).show();
        }
    }

    private void checkRadioButton() {
        selectId = radioGroup.getCheckedRadioButtonId();
        radioButton = getActivity().findViewById(selectId);
        switch (radioButton.getId()) {
            case R.id.zeroText:
                choice = 0;
                break;
            case R.id.oneText:
                choice = 1;
                break;
            case R.id.twotext:
                choice = 2;
                break;
        }
    }

    private void findView(@NonNull View view) {
        editText = view.findViewById(R.id.editText);
        button = view.findViewById(R.id.button);
        radioGroup = view.findViewById(R.id.radioGroup);

        //แปลง xml Obj เป็น Code
        radioButton0 = view.findViewById(R.id.zeroText);
        radioButton1 = view.findViewById(R.id.oneText);
        radioButton2 = view.findViewById(R.id.twotext);
    }
}
