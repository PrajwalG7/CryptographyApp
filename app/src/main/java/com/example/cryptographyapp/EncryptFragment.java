package com.example.cryptographyapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EncryptFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EncryptFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EncryptFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EncryptFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EncryptFragment newInstance(String param1, String param2) {
        EncryptFragment fragment = new EncryptFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    //variable declartion

    EditText etenc;
    TextView enctv;
    ClipboardManager cpb;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        //code goes here
      //  Toast.makeText(getActivity(), "Encryption", Toast.LENGTH_SHORT).show();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_encrypt, container, false);
        View view = inflater.inflate(R.layout.fragment_encrypt, container, false);
        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etenc = view.findViewById(R.id.etenc);
        enctv = view.findViewById(R.id.enctv);
        cpb = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);

        Button btn = view.findViewById(R.id.btnenc);
        btn.setOnClickListener(this);

        Button btn2 = view.findViewById(R.id.btncp2);
        btn2.setOnClickListener(this);

    }

    //TODO:use switch case to handle onClick for specific btn_ID

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnenc:
                String temp = etenc.getText().toString();
                String rv = Encode.enc(temp);
                enctv.setText(rv);
                break;

            case R.id.btncp2:
                String data = enctv.getText().toString().trim();
                if (!data.isEmpty()) {
                    ClipData temp2 = ClipData.newPlainText("text", data);
                    cpb.setPrimaryClip(temp2);
                    Toast.makeText(getActivity(), "Copied", Toast.LENGTH_SHORT).show();
                    break;

                }

        }
    }
}