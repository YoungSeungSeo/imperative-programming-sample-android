package com.example.layouttestandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 데이터 생성
        List<String> data = makeData();

        // adapter 생성
        mAdapter = new MainListAdapter(MainActivity.this, data);

        // RecyclerView 초기화
        RecyclerView rcvMain = findViewById(R.id.rcv_main);
        rcvMain.setAdapter(mAdapter);
        rcvMain.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    private List<String> makeData() {
        String[] _data = {"꽁치", "갈치", "고등어", "삼치", "멸치", "참치", "쥐치", "기타등등"};
        return Arrays.asList(_data);
    }

    static class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {

        private Context mContext;
        private List<String> mData;

        public MainListAdapter(Context mContext, List<String> mData) {
            this.mContext = mContext;
            this.mData = mData;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.layout_main_list_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.bindView(mData.get(position));
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvLabel;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tvLabel = itemView.findViewById(R.id.tv_label);
            }

            public void bindView(String data) {
                tvLabel.setText(data);
            }
        }
    }
}
