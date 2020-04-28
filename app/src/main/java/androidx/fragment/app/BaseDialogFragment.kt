package androidx.fragment.app

import android.os.Bundle

open class BaseDialogFragment: DialogFragment() {

    override fun show(manager: FragmentManager, tag: String?) {
        mDismissed = false
        mShownByMe = true
        val ft = manager.beginTransaction()
        ft.add(this, tag)
        ft.commitNowAllowingStateLoss()
    }

    override fun dismiss() {
        super.dismissAllowingStateLoss()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dialog?.setOnShowListener(null)
        dialog?.setOnCancelListener(null)
        dialog?.setOnDismissListener(null)
    }
}