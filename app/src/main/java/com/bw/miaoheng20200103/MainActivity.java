package com.bw.miaoheng20200103;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.miaoheng20200103.adapter.MlssAdapter;
import com.bw.miaoheng20200103.adapter.PzshAdapter;
import com.bw.miaoheng20200103.adapter.RxxpAdapter;
import com.bw.miaoheng20200103.entity.BanerEntity;
import com.bw.miaoheng20200103.entity.DataEntity;
import com.bw.miaoheng20200103.util.Utils;
import com.stx.xhb.androidx.XBanner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private XBanner xBanner;
    private RecyclerView rv_mlss;
    private RecyclerView rv_pzsh;
    private RecyclerView rv_rxxp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xBanner = findViewById(R.id.xbander);
        rv_mlss = findViewById(R.id.rv_mlss);
        rv_pzsh = findViewById(R.id.rv_pzsh);
        rv_rxxp = findViewById(R.id.rv_rxxp);
        rv_rxxp.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        rv_mlss.setLayoutManager(new LinearLayoutManager(this));
        rv_pzsh.setLayoutManager(new GridLayoutManager(this,2));
        Utils.getInstance().getData(new Utils.UtilsCallBack() {
            @Override
            public void cuccess(Object object) {
                 if(object instanceof BanerEntity){
                     //展示轮播图
                     final List<BanerEntity.ResultBean> result = ((BanerEntity) object).getResult();
                     xBanner.setBannerData(result);
                     xBanner.loadImage(new XBanner.XBannerAdapter() {
                         @Override
                         public void loadBanner(XBanner banner, Object model, View view, int position) {
                             Glide.with(MainActivity.this).load(result.get(position).getImageUrl()).into((ImageView) view);
                         }
                     });
                 }else if(object instanceof DataEntity){
                     //展示列表的数据
                     List<DataEntity.ResultBean.RxxpBean.CommodityListBean> commodityList = ((DataEntity) object).getResult().getRxxp().getCommodityList();
                     rv_rxxp.setAdapter(new RxxpAdapter(MainActivity.this,commodityList));
                     List<DataEntity.ResultBean.MlssBean.CommodityListBeanXX> commodityList1 = ((DataEntity) object).getResult().getMlss().getCommodityList();
                     rv_mlss.setAdapter(new MlssAdapter(MainActivity.this,commodityList1));
                     List<DataEntity.ResultBean.PzshBean.CommodityListBeanX> commodityList2 = ((DataEntity) object).getResult().getPzsh().getCommodityList();
                     rv_pzsh.setAdapter(new PzshAdapter(MainActivity.this,commodityList2));
                 }
            }
        });

    }
}
