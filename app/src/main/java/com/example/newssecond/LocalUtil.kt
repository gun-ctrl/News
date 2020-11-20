package com.example.newssecond

/**
 *@Description
 *@Author PC
 *@QQ 1578684787
 */
class LocalUtil :DataInface{
    override fun getData(): ArrayList<NewsModel> {
        val d1 = NewsModel("Android开发",R.drawable.img1,20,0)
        val d2 = NewsModel("IOS开发",R.drawable.img2,30,1)
        val d3 = NewsModel("Python开发",R.drawable.img3,30,0)
        val d4 = NewsModel("Web开发",R.drawable.img1,20,1)
        return  arrayListOf(d1,d2,d3,d4)
    }
}