package com.example.liangxiao.staggeredgridtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private WaterFallAdapter mWaterFallAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycleViews);
        mLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mWaterFallAdapter = new WaterFallAdapter(this,buildData());
        mRecyclerView.setAdapter(mWaterFallAdapter);
    }


    private List<PersonCard> buildData() {

        String[] names = {"邓紫棋", "范冰冰", "杨幂", "Angelababy", "唐嫣", "柳岩","1","2","3","4"};
        String[] imgUrs = {"http://img.my.csdn.net/uploads/201309/01/1378037235_3453.jpg",
                "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1477122795&di=f740bd484870f9bcb0cafe454a6465a2&src=http://tpic.home.news.cn/xhCloudNewsPic/xhpic1501/M08/28/06/wKhTlVfs1h2EBoQfAAAAAF479OI749.jpg",
                "http://img.my.csdn.net/uploads/201309/01/1378037235_7476.jpg",
                "https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=fd90a83e900a304e4d22a7fae1c9a7c3/d01373f082025aafa480a2f1fcedab64034f1a5d.jpg",
                "http://img.my.csdn.net/uploads/201309/01/1378037235_9280.jpg",
                "https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=005560fc8b5494ee982208191df4e0e1/c2fdfc039245d68827b453e7a3c27d1ed21b243b.jpg",
                "http://img.my.csdn.net/uploads/201309/01/1378037234_3539.jpg",
                "http://img.my.csdn.net/uploads/201309/01/1378037234_6318.jpg",
                "http://img.my.csdn.net/uploads/201309/01/1378037194_2965.jpg",
                "http://img.my.csdn.net/uploads/201309/01/1378037193_1687.jpg",
        };

        List<PersonCard> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            PersonCard p = new PersonCard();
            p.avatarUrl = imgUrs[i];
            p.name = names[i];
            p.imgHeight = (i % 2) * 100 + 400; //偶数和奇数的图片设置不同的高度，以到达错开的目的
            list.add(p);
        }
        return list;
    }

}
