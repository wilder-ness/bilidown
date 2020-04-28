package com.mh.bilidown.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.mh.bilidown.view.dialog.LoadingDialogFragment
import kotlinx.android.synthetic.main.common_title.*

abstract class BaseActivity : AppCompatActivity() {
    private var loadingFragment: LoadingDialogFragment? = null
    @get:LayoutRes
    protected abstract val layoutResId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        initView()
        observeLiveData()
    }

    abstract fun initView()

    protected open fun observeLiveData() {

    }

    open fun showLoading(content: String?) {
        if (loadingFragment == null) {
            loadingFragment = LoadingDialogFragment.newInstance(content)
            if (loadingFragment?.isAdded != true) {
                loadingFragment?.show(supportFragmentManager, "loading")
            }
        } else {
            if (loadingFragment?.isAdded != true) {
                loadingFragment?.show(supportFragmentManager, "loading")
                loadingFragment?.setContent(content)
            }
        }

    }

    open fun hideLoading() {
        loadingFragment?.dismiss()
    }

    /**
     * 通用标题
     * back + title
     */
    protected fun setCommonTitle(title: String) {
        mTitle.text = title
        mBack.visibility = View.VISIBLE
        mBack.setOnClickListener {
            finish()
        }
    }

    protected open fun setStatusBar() {

    }
}