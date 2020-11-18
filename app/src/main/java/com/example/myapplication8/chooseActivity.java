package com.example.myapplication8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class chooseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tt);

        int[] icon={R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04,R.drawable.img05,
                R.drawable.img06,R.drawable.img07,R.drawable.img08,R.drawable.img09};
        final GridView gridView=findViewById(R.id.grid);
        ImageView[]tmp = new ImageView[8];
        List list=new ArrayList<Map<String,Object>>();
        String[] from={"image"};
        int[] to={R.id.image};
        for (int i=0;i<icon.length;i++){
            Map map=new HashMap();
            map.put("image",icon[i]);
            tmp[i]=findViewById(R.id.image);
            tmp[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=getIntent();
                    int i=v.getId();
                    intent.putExtra("picaddr",i);
                    chooseActivity.this.setResult(1,intent);
                    chooseActivity.this.finish();
                }
            });
            list.add(map);
        }

        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.show,from,to);
        gridView.setAdapter(simpleAdapter);
    }
}
