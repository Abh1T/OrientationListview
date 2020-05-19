package com.example.orientationlistviewproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import static java.lang.Integer.parseInt;

public class Dialogs extends AppCompatDialogFragment {
    private EditText editname;
    private EditText editim;
    private EditText editap;
    private EditText editpo;
    private EditText editdesc;
    private dialoglisren dialoglisren;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflate = getActivity().getLayoutInflater();
        View view = inflate.inflate(R.layout.thismydialog, null);
        builder.setView(view);
        builder.setTitle("Add to List");
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    String name = editname.getText().toString();
                    int im = 0;
                    int po = 0;
                    if (((editim.getText().toString()).equals(null)) || (editim.getText().equals(null))) {
                        im = -1;
                    } else {
                        String temp = editim.getText().toString();
                        im = parseInt(temp);
                    }
                    String app = editap.getText().toString();
                    if (((editpo.getText().toString()).equals(null)) || (editpo.getText().equals(null))) {
                        po = -1;
                    } else {
                        String temp = editpo.getText().toString();
                        po = parseInt(temp);
                    }
                    String desc = editdesc.getText().toString();
                    dialoglisren.applyTexts(name, im, app, po, desc);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        editap = view.findViewById(R.id.editappear);
        editdesc = view.findViewById(R.id.editdesc);
        editim = view.findViewById(R.id.editint);
        editname = view.findViewById(R.id.editname);
        editpo = view.findViewById(R.id.editpower);
                return builder.create();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try {
            dialoglisren = (dialoglisren)context;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public interface dialoglisren{
        void applyTexts(String name, int im, String ap, int po, String desc);
    }
}
