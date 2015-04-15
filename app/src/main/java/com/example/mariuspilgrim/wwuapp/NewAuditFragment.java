package com.example.mariuspilgrim.wwuapp;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mariuspilgrim on 12/03/15.
 */
public class NewAuditFragment extends Fragment {

    //public static final String ARG_MOSCSECAU_NUMBER = "MOSCSECAU_number";

    public NewAuditFragment() {
        // Empty constructor required for fragment subclasses

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_new_audit_list, container, false);
        //int i = getArguments().getInt(ARG_MOSCSECAU_NUMBER);
        //String menuItem = getResources().getStringArray(R.array.menu_items_array)[i];
        //getActivity().setTitle(menuItem);

        Intent intent = new Intent(getActivity(), NewAuditActivityList.class);
        startActivity(intent);

        /*
            Button button_setDefaultInputValues = (Button) rootView.findViewById(R.id.btn_setDefaultInputValues);
            button_setDefaultInputValues.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                    setDefaultInputValues(rootView);//Finally not null
                    } catch (NullPointerException ex) {
                        messageBox("setDefaultInputValues, set to rootview?",ex.toString());
                    }
                }
            });

        Button button_sendMessage = (Button) rootView.findViewById(R.id.btn_sendMessage);
        button_sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(rootView);
                }
            });
            */
        return rootView;
    }

    /**
     * Creating exception handling box
     * @param method
     * @param message
     */
    public void messageBox(String method, String message) {
        AlertDialog.Builder messageBox = new AlertDialog.Builder(getActivity());
        messageBox.setTitle(method);
        messageBox.setMessage(message);
        messageBox.setCancelable(false);
        messageBox.setNeutralButton("OK", null);
        messageBox.show();
    }

}