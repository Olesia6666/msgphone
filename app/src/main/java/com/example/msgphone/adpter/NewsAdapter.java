package com.example.msgphone.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.msgphone.R;
import com.example.msgphone.bean.NewsItemInfo;
import com.example.msgphone.utils.LoadLocalPic;

import java.util.List;

public class NewsAdapter extends BaseAdapter {
    private List<NewsItemInfo> booksList;
    private Context mContext;

    public NewsAdapter(List<NewsItemInfo> booksList, Context context) {
        this.booksList = booksList;
        mContext = context;
    }

    public void setBooksList(List<NewsItemInfo> booksList) {
        this.booksList = booksList;
    }

    @Override
    public int getCount() {
        return booksList.size();
    }

    @Override
    public Object getItem(int position) {
        return booksList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_news_view, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.bookCoverImageView = convertView.findViewById(R.id.fragment_goods_book_cover_imageView);
            viewHolder.bookNameTextView = convertView.findViewById(R.id.fragment_goods_book_name_textView);
            viewHolder.authorTextView = convertView.findViewById(R.id.fragment_goods_book_author_textView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (!booksList.isEmpty()) {
            NewsItemInfo book = booksList.get(position);
            viewHolder.bookCoverImageView.setImageBitmap(LoadLocalPic.getBookCoverBitmap(book.getIconPath()));
            viewHolder.bookNameTextView.setText(book.getBookName());
            viewHolder.authorTextView.setText("新闻作者:" + book.getBookAuthor());
        }

        return convertView;
    }

    class ViewHolder {
        ImageView bookCoverImageView;

        TextView bookNameTextView;

        TextView authorTextView;
    }


}



