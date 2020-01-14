package com.example.dam2m8_enviomensajes.ui.send;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dam2m8_enviomensajes.R;

public class SendFragment extends Fragment {

    private SendViewModel sendViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(SendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_send, container, false);
        final EditText sendMsgEditText = root.findViewById(R.id.sendMsgEditText);
        final Button enviar = root.findViewById(R.id.sendMsgButton);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sendMsgEditText.getText().toString() != null) {
                    sendViewModel.WriteMsgFirebase(sendMsgEditText.getText().toString());
                }
            }
        });


        return root;
    }
}