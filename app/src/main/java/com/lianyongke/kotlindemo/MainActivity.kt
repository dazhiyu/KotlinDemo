package com.lianyongke.kotlindemo

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mContext : Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hello.text = "hello this world and Thinker"

        hello.setTextColor(Color.RED)

        hello.textSize = 23f

        main_recycler.layoutManager = LinearLayoutManager(this)

        main_recycler.adapter = DemoAdapter()

        hello.visibility = View.VISIBLE

        hello.setOnClickListener {
            myTextview.text = "睡你麻痹"//在此时初始化
            main_linear.addView(myTextview)
        }

        var data: LongArray = longArrayOf(1, 2, 3)
        if (1 in data) {
            Toast.makeText(this, "1 在data数组中", Toast.LENGTH_LONG).show()
        }

        var stringData: ArrayList<String> = arrayListOf()

        for (i in 1..5) {//遍历1-5
            stringData.add(i.toString())
        }

        for (item in stringData) { //增强for循环格式
            if ("ss".equals(item))
                Toast.makeText(this, "哈哈", Toast.LENGTH_LONG).show()
        }

        var listData: ArrayList<CartBean> = arrayListOf()
        listData.add(CartBean("1", "2", "3"))
        listData.add(CartBean("1", "2", "3"))
        listData.add(CartBean("1", "2", "3"))
        listData.get(1).goodPrice = "ksdks";

    }

    private val myTextview: TextView by lazy {
        //此时并不初始化
        Log.e("-----", "-------ddddddd");
        TextView(this)
    }

    inner class DemoAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        //        用var定义变量（像js）
//        用val定义常量（相当于final）
        private var data: List<String> = ArrayList()

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
            return CeShiHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false))
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
            val ceshi = holder as CeShiHolder//居然是final类型不报警。。。。
            ceshi.name.text = "一切都是如此简单---------"+position
        }

        override fun getItemCount(): Int {
            return 10
        }

    }

    data class CartBean(var id: String, var goodbean: String, var goodPrice: String) {
        object one {
            var str = "dsj"
        }

        companion object {
            private var state = "0"
        }
    }

    class CeShiHolder : RecyclerView.ViewHolder {

        var name : TextView

        constructor(view:View) : super(view) {
            name = view.findViewById(R.id.item_name)
        }

    }
}
