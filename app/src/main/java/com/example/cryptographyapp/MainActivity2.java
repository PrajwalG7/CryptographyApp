package com.example.cryptographyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button Encrypt;
    Button Decrypt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();


        Encrypt=findViewById(R.id.Encrypt);
        Decrypt=findViewById(R.id.Decrypt);

        Encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getSupportFragmentManager().getFragments()!=null&& getSupportFragmentManager().getFragments().size()>0){
                    for(int i=0;i<getSupportFragmentManager().getFragments().size();i++){
                       Fragment frg=getSupportFragmentManager().getFragments().get(i);
                        if(frg!=null) {
                            getSupportFragmentManager().beginTransaction().remove(frg).commit();
                        }
                    }
                }

                FragmentManager frm=getSupportFragmentManager();
                FragmentTransaction frt=frm.beginTransaction();
                frt.add(R.id.wrapper,new EncryptFragment());
                frt.addToBackStack(null);
                frt.commit();


            }
        });


        Decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getSupportFragmentManager().getFragments()!=null&& getSupportFragmentManager().getFragments().size()>0){
                    for(int i=0;i<getSupportFragmentManager().getFragments().size();i++){
                        Fragment frg=getSupportFragmentManager().getFragments().get(i);
                        if(frg!=null) {
                            getSupportFragmentManager().beginTransaction().remove(frg).commit();
                        }
                    }
                }
                FragmentManager frm=getSupportFragmentManager();
                FragmentTransaction frt=frm.beginTransaction();
                frt.add(R.id.wrapper,new DecryptFragment());
                frt.addToBackStack(null);
                frt.commit();

            }
        });







    }
}