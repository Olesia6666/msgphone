package com.example.msgphone.portal.index;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.msgphone.activity.AddNewsActivity;
import com.example.msgphone.activity.NewsDetailActivity;
import com.example.msgphone.adpter.NewsAdapter;
import com.example.msgphone.bean.NewsItemInfo;
import com.example.msgphone.bean.DataBean;
import com.example.msgphone.R;
import com.example.msgphone.adpter.ImageAdapter;
import com.example.msgphone.interfaces.BaseGoodsFragment;
import com.example.msgphone.presenter.NewsFragmentPresenterImpl;
import com.example.msgphone.utils.NewsFragmentPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements BaseGoodsFragment {
    private Banner banner;
    private ListView newsListView;
    private NewsAdapter newsAdapter;
    private List<NewsItemInfo> newsList;
    private FloatingActionButton fab;
    private NewsFragmentPresenter newsFragmentPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index, container, false);
        banner = view.findViewById(R.id.banner);
        newsListView = view.findViewById(R.id.fragment_goods_books);
        fab = view.findViewById(R.id.fab);

        //books列表默认值初始化
        newsList = new ArrayList<NewsItemInfo>();
        NewsItemInfo book = new NewsItemInfo();
        book.setBookName("测试书名");
        book.setBookAuthor("测试作者");
        book.setIconPath("p3.png");

        newsList.add(book);
        newsList.add(book);


        return view;
    }

    public void initData() {
        List<DataBean> dataBeans = new ArrayList<>();

        dataBeans.add(new DataBean("p1.png"));
        dataBeans.add(new DataBean("p2.png"));
        dataBeans.add(new DataBean("p3.png"));
        dataBeans.add(new DataBean("p4.png"));
        dataBeans.add(new DataBean("p5.png"));
        useBanner(dataBeans);

        newsAdapter = new NewsAdapter(newsList, getContext());
        newsListView.setAdapter(newsAdapter);

        newsFragmentPresenter.switchType();
    }


    public void useBanner(List<DataBean> datas) {
        banner.addBannerLifecycleObserver(this)//添加生命周期观察者
                .setAdapter(new ImageAdapter(datas))
                .setIndicator(new CircleIndicator(getActivity()))
                .setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(Object data, int position) {
                        Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                        intent.putExtra("bookInfo", newsList.get(position));
                        startActivity(intent);
                    }
                });
    }

    public void initLister() {
        newsListView.setOnItemClickListener(new BookItemOnclickLisenter());
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddNewsActivity.class);
                intent.putExtra("id", newsList.size()+2+"");
                startActivity(intent);
            }
        });
    }

    @Override
    public void showToast(String dialogText) {

    }

    @Override
    public void updateBookListView(List<NewsItemInfo> booksList) {
        this.newsList = booksList;
        newsAdapter.setBooksList(this.newsList);
        newsAdapter.notifyDataSetChanged();
    }


    class BookItemOnclickLisenter implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
            intent.putExtra("bookInfo", newsList.get(position));
            startActivity(intent);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        newsFragmentPresenter = new NewsFragmentPresenterImpl(this);
        banner.start();
        initData();
        initLister();
    }

    @Override
    public void onStop() {
        super.onStop();
        //停止轮播
        banner.stop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //销毁
        banner.destroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        newsAdapter.notifyDataSetChanged();
    }


}
