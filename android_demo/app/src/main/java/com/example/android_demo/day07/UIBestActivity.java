package com.example.android_demo.day07;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_demo.R;

import java.util.ArrayList;
import java.util.List;

public class UIBestActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uibest);
        initList();
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(UIBestActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        msgRecyclerView.setLayoutManager(linearLayoutManager);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msgList.add(new Msg(inputText.getText().toString(), Msg.TYPE_SENT));
                adapter.notifyItemInserted(msgList.size()-1);
                msgRecyclerView.scrollToPosition(msgList.size()-1);
                inputText.setText("");
            }
        });
    }

    public void initList() {
        Msg msg1 = new Msg("Hello", Msg.TYPE_RECEIVED);
        Msg msg2 = new Msg("Hello 2", Msg.TYPE_SENT);
        Msg msg3 = new Msg("Hello 3", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg3);
    }
}