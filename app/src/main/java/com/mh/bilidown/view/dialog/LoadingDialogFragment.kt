package com.mh.bilidown.view.dialog

import android.os.Bundle
import android.view.*
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.fragment.app.BaseDialogFragment
import com.mh.bilidown.R
import kotlinx.android.synthetic.main.dialog.*

/**
 * 通用加载
 */
class LoadingDialogFragment : BaseDialogFragment() {

    companion object {
        fun newInstance(content: String?): LoadingDialogFragment {
            val fragment = LoadingDialogFragment()
            content?.let {
                val bundle = Bundle()
                bundle.putString("content", content)
                fragment.arguments = bundle
            }
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog, container, false)
        dialog?.setCanceledOnTouchOutside(true)
        val window = dialog?.window
        window?.setBackgroundDrawableResource(R.color.color_00ffffff)
        window?.decorView?.setPadding(0, 0, 0, 0)
        val wlp = window?.attributes
        wlp?.gravity = Gravity.CENTER
        wlp?.width = WindowManager.LayoutParams.MATCH_PARENT
        wlp?.height = WindowManager.LayoutParams.MATCH_PARENT
        window?.attributes = wlp
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mLoading.animation = RotateAnimation(0f, 359f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f).apply {
            interpolator = LinearInterpolator()
            duration = 800//设置动画持续周期
            repeatCount = -1//设置重复次数
            fillAfter = false//动画执行完后是否停留在执行完的状态
        }
        arguments?.getString("content").let {
            if (it.isNullOrEmpty()) {
                mTips.visibility = View.GONE
            } else {
                mTips.text = it
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        mLoading?.clearAnimation()
    }

    fun setContent(content: String?) {
        mTips?.text = content?:""
    }
}