package com.example.newssecond

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.NumberFormatException

/**
 *@Description
 *@Author PC
 *@QQ 1578684787
 */
class NewsAdapter :RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){

    var callBack:((Int)->Unit)? = null
    inner class NewsViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        //从当前view中 获取每一个控件
        val titleTextView = itemView.findViewById<TextView>(R.id.mTitle)
        val iconImageView = itemView.findViewById<ImageView>(R.id.mIcon)
        val likeTextView = itemView.findViewById<TextView>(R.id.mLike)
        var mPosition = 0
        init {
            itemView.setOnClickListener{
                callBack?.let {
                    it(mPosition)
                }
            }
        }
    }

    //设置position对应的那个item的类型
    override fun getItemViewType(position: Int): Int {
        //获取position对应的数据模型
        val model = Repository.getInstance().datas[position]
        return model.type
    }
    //创建一个Item 使用LayoutInflater xml -> xml
    //只是创建的躯壳 没有具体数据
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val lf = LayoutInflater.from(parent.context)
        var view:View
        //判断当前这个item类型
        if (viewType == 0){
            view = lf.inflate(R.layout.news_land_item,parent,false)
        }else{
            view = lf.inflate(R.layout.news_port_item,parent,false)
        }
        return NewsViewHolder(view)
    }


    //绑定具体数据
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        //获取position对应的数据模型
        val model = Repository.getInstance().datas[position]
        holder.titleTextView.text = model.title
        holder.iconImageView.setImageResource(model.imageID)
        holder.likeTextView.text = "${model.like} 跟帖"
        holder.mPosition = position
    }

    //确定有多少行 item cell
    override fun getItemCount(): Int {
        return Repository.getInstance().datas.size
    }
}