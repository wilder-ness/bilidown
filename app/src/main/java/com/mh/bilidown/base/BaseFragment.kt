package com.mh.bilidown.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.mh.bilidown.view.dialog.LoadingDialogFragment

abstract class BaseFragment : Fragment() {
    private var loadingFragment: LoadingDialogFragment? = null
    @get:LayoutRes
    protected abstract val layoutResId: Int
    protected var mActivity: FragmentActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeLiveData()
    }

    abstract fun initView()




     open fun showLoading(content: String?) {
        if (loadingFragment == null) {
            loadingFragment = LoadingDialogFragment.newInstance(content)
            if (loadingFragment?.isAdded != true) {
                childFragmentManager.let { loadingFragment?.show(it, "loading") }
            }
        } else {
            if (loadingFragment?.isAdded != true) {
                childFragmentManager.let { loadingFragment?.show(it, "loading") }
                loadingFragment?.setContent(content)
            }
        }
    }

     open fun hideLoading() {
        loadingFragment?.dismiss()
    }

    protected open fun observeLiveData() {

    }
}