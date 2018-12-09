package pl.lightmobile.focustest

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo.IME_ACTION_DONE
import android.view.inputmethod.EditorInfo.IME_ACTION_NEXT
import kotlinx.android.synthetic.main.view_labeled_edit.view.*

class LabeledEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {

        inflate(context, R.layout.view_labeled_edit, this)
        isFocusable = true
        isFocusableInTouchMode = true
        descendantFocusability = ViewGroup.FOCUS_AFTER_DESCENDANTS

        if(attrs != null) {
            val attributes = context.obtainStyledAttributes(attrs, R.styleable.LabeledEditText)
            try {
                label.text = attributes.getString(R.styleable.LabeledEditText_label)
                edit.nextFocusForwardId = attributes.getResourceId(
                    R.styleable.LabeledEditText_android_nextFocusForward,
                    View.NO_ID
                )
                edit.imeOptions = if(edit.nextFocusForwardId == View.NO_ID) IME_ACTION_DONE else IME_ACTION_NEXT
            } finally {
                attributes.recycle()
            }
        }
    }
}
