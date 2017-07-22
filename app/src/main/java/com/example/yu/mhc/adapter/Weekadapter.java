package com.example.yu.mhc.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yu.mhc.R;
import com.example.yu.mhc.bean.WeekBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.List;

/**
 * Created by YU on 2017/6/28.
 */
public class Weekadapter extends BaseAdapter{
        private List<WeekBean.DataBean.ComicsBean> list;
            private Context context;
    private final ImageLoader imageloader;
    private final DisplayImageOptions options;

    public Weekadapter(List<WeekBean.DataBean.ComicsBean> list, Context context) {
                this.list = list;
                this.context = context;
                 //创建默认的ImageLoader配置参数
                         ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                                 .createDefault(context);

                         //将configuration配置到imageloader中
        imageloader = ImageLoader.getInstance();
                        imageloader.init(configuration);

        options = new DisplayImageOptions.Builder()
                 .cacheInMemory(true)
                 .cacheOnDisk(true)
                 .bitmapConfig(Bitmap.Config.ARGB_8888)
                 .showImageOnLoading(R.mipmap.ic_launcher)
                 .showImageForEmptyUri(R.mipmap.ic_launcher)
                 .showImageOnFail(R.mipmap.ic_launcher)
                 .imageScaleType(ImageScaleType.EXACTLY)
                 .build();
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder holder;
                if (convertView==null){
                    holder=new ViewHolder();
                    convertView=View.inflate(context, R.layout.week_item,null);
                    holder.label_text=(TextView)convertView.findViewById(R.id.label_text);
                    holder.title=(TextView)convertView.findViewById(R.id.title);
                    holder.ztitle=(TextView)convertView.findViewById(R.id.ztitle);
                    holder.nickname=(TextView)convertView.findViewById(R.id.nickname);
                    holder.cover_image_url=(ImageView) convertView.findViewById(R.id.cover_image_url);
                     convertView.setTag(holder);
                }else{
                    holder= (ViewHolder) convertView.getTag();
                }
                WeekBean.DataBean.ComicsBean bean=list.get(position);
                holder.label_text.setText(bean.getLabel_text());
                holder.ztitle.setText(bean.getTitle());
                holder.title.setText(bean.getTopic().getTitle());
                holder.nickname.setText("作者:"+bean.getTopic().getUser().getNickname());
                imageloader.displayImage(bean.getCover_image_url(),holder.cover_image_url,options);
                return convertView;
            }
            class  ViewHolder{
                TextView label_text,title,nickname,ztitle;
                ImageView cover_image_url;
            }

}
