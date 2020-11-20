package com.example.newssecond

import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //配置RecyclerView的样式
        mRecycler.layoutManager = LinearLayoutManager(
            this,LinearLayoutManager.VERTICAL,false
        )

        //设置适配器 （提供具体显示的数据）RecyclerView.Adapter
        val adapter = NewsAdapter()
        adapter.callBack = {
            startActivity(Intent(this,SecondActivity::class.java))
        }
        mRecycler.addItemDecoration(object :RecyclerView.ItemDecoration(){
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            super.getItemOffsets(outRect, view, parent, state)
                outRect.set(0,0,0,40)
            }
        })


    }
}