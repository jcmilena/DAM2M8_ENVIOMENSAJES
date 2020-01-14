package com.example.dam2m8_enviomensajes.ui.receive;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dam2m8_enviomensajes.Model.Mensaje;
import com.example.dam2m8_enviomensajes.R;

public class ReceiveFragment extends Fragment {

    private ReceiveViewModel receiveViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        receiveViewModel =
                ViewModelProviders.of(this).get(ReceiveViewModel.class);
        View root = inflater.inflate(R.layout.fragment_receive, container, false);

        final TextView from = root.findViewById(R.id.remiteTextView);
        final TextView msg = root.findViewById(R.id.receiveMsgTextView);

        receiveViewModel.readMsgID("pVBEOgINbVOGdkne7Sjhg3ycW6h2");

        receiveViewModel.getMsgID().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                receiveViewModel.readMsg(s);
                Log.i("VIEWMODEL getMsgID", s);
            }
        });

        receiveViewModel.getMsg().observe(this, new Observer<Mensaje>() {
            @Override
            public void onChanged(Mensaje mensaje) {
                from.setText(mensaje.getEmisor());
                msg.setText(mensaje.getMensaje());
                Log.i("VIEWMODEL getMsg", mensaje.toString());
            }
        });

        return root;
    }
}