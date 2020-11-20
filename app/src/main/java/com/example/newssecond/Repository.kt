package com.example.newssecond

/**
 *@Description
 *@Author PC
 *@QQ 1578684787
 */
//数据中心 用于管理所有数据(单例设计模式的应用)
class Repository private constructor(){
    //自己使用的可变数据
    private val mdatas = mutableListOf<NewsModel>()
    //封装成不可变的 提供给外部使用
    var datas:List<NewsModel> = listOf()
        get() {
        if (field.isEmpty()){
            loadData()
            field = mdatas.toList()
        }
            return field
    }

    //提供静态方法
    companion object{
        private var instance = Repository()
        fun getInstance() = instance
    }

    //获取数据的接口
    fun loadData(){
        //当前通过localUtil获取数据
        val dataSource:DataInface = LocalUtil()
        //将获取的数据添加到数据源中
        mdatas.addAll(dataSource.getData())
    }
    //更改数据的接口
}