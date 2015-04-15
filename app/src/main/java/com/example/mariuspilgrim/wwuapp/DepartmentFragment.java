package com.example.mariuspilgrim.wwuapp;

import android.app.AlertDialog;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DepartmentFragment extends android.support.v4.app.Fragment {

    public DepartmentFragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_department, container, false);

        TextView textView_welcome = (TextView) rootView.findViewById(R.id.department_prof_list);
        textView_welcome.setTextColor(Color.parseColor("#852339"));

        String prof_list = getResources().getText(R.string.department_fragment_prof_list)
                + "<br/>"
                + "&#8226; <a href=\"https://www.wi.uni-muenster.de/department/groups/is/people/joerg-becker\">Prof. Dr. Dr. h.c. Jörg Becker</a><br/>"
                + "&#8226; <a href=\"https://www.wi.uni-muenster.de/department/groups/logistik/people/bernd-hellingrath\">Prof. Dr.-Ing. Bernd Hellingrath</a><br/>"
                + "&#8226; <a href=\"https://www.wi.uni-muenster.de/department/groups/wi/people/stefan-klein\">Prof. Dr. Stefan Klein</a><br/>"
                + "&#8226; <a href=\"https://www.wi.uni-muenster.de/department/groups/pi/people/herbert-kuchen\">Prof. Dr. Herbert Kuchen</a><br/>"
                + "&#8226; <a href=\"https://www.wi.uni-muenster.de/department/groups/statistik/people/heike-trautmann\">Prof. Dr. Heike Trautmann</a><br/>"
                + "&#8226; <a href=\"https://www.wi.uni-muenster.de/department/groups/dbis/people/gottfried-vossen\">Prof. Dr. Gottfried Vossen</a><br/>"
                + "&#8226; <a href=\"https://www.wi.uni-muenster.de/department/groups/qm-logistik/people/stephan-meisel\">Prof. Dr. Stephan Meisel</a>";

        textView_welcome.setText(Html.fromHtml(prof_list));
        textView_welcome.setMovementMethod(LinkMovementMethod.getInstance()); //To make links active, you need to call setMovementMethod() on the TextView object.

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