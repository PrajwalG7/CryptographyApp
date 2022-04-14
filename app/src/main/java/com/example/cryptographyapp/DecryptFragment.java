package com.example.cryptographyapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DecryptFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DecryptFragment extends Fragment  implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DecryptFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DecryptFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DecryptFragment newInstance(String param1, String param2) {
        DecryptFragment fragment = new DecryptFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    //Variable Declaration
    EditText etdec;
    TextView dectv;
    ClipboardManager cplboard;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_decrypt, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etdec = view.findViewById(R.id.etdec);
        dectv = view.findViewById(R.id.dectv);
        cplboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
        Button btndec = view.findViewById(R.id.btndec);
        Button btndecCp = view.findViewById(R.id.btncp1);

        btndec.setOnClickListener(this);
        btndecCp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btndec:
                String temp = etdec.getText().toString();
                String rv = Decode.dec(temp);
                dectv.setText(rv);
                //Toast.makeText(getActivity(), "dec", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btncp1:
                String data = dectv.getText().toString().trim();
                if (!data.isEmpty()) {
                    ClipData temp2 = ClipData.newPlainText("text", data);
                    cplboard.setPrimaryClip(temp2);
                    Toast.makeText(getActivity(), "Copied", Toast.LENGTH_SHORT).show();
                    break;
                }

        }
    }
}