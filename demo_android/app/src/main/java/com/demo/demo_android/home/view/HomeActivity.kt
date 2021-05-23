package com.demo.demo_android.home.view


import android.os.Bundle
import android.widget.Button
import com.demo.demo_android.R
import com.demo.demo_android.core.views.BaseActivity
import com.demo.demo_android.home.contract.HomeContract
import com.demo.demo_android.home.presenter.HomePresenterImpl


class HomeActivity : BaseActivity(), HomeContract.HomeView {

    private lateinit var presenter: HomeContract.HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = HomePresenterImpl(view = this)

        findViewById<Button>(R.id.button).setOnClickListener{
            initalRouter("/helloworld")
            presenter.callMethodChannel()
        }

    }

    override fun getChannel() = getChannelManager()


    override fun finishActivie() {
        finish()
    }

    override fun initComponents() {

    }


}