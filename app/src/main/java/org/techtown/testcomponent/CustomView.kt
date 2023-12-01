package org.techtown.testcomponent

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.LinearLayout
import org.techtown.testcomponent.databinding.CustomViewBinding

class CustomView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr) {

    private val binding = CustomViewBinding.inflate(LayoutInflater.from(context), this, true)

    companion object {
        val EMPTY_COLOR = Color.parseColor("#c00000")
        val OCCUPIED_COLOR = Color.parseColor("#00B050")
        val RESERVED_COLOR = Color.parseColor("#eba603")
    }

    init {
        applyAttrs(attrs)
    }

    // XML 레이아웃에서 설정한 속성 적용
    private fun applyAttrs(attrs: AttributeSet? = null) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomView)

        // 상태 (empty, occupied, reserved)
        typedArray.getString(R.styleable.CustomView_state)?.apply { setState(this) }

        // 텍스트
        typedArray.getString(R.styleable.CustomView_text)?.apply { setText(this) }

        // 글자 크기 (small, normal, big)
        typedArray.getString(R.styleable.CustomView_textSize)?.apply { setTitleSize(this) }

        typedArray.recycle()
    }

    /**
     * 상태 설정
     */
    fun setState(state: String) = with(binding.area2Layout) {
        when (state.uppercase()) {
            "EMPTY" -> setBackgroundColor(EMPTY_COLOR)
            "OCCUPIED" -> setBackgroundColor(OCCUPIED_COLOR)
            "RESERVED" -> setBackgroundColor(RESERVED_COLOR)
        }
    }

    /**
     * 텍스트 설정
     */
    fun setText(text: String) = with(binding.statusTextView) { this.text = text }

    /**
     * 글자 크기 설정
     */
    fun setTitleSize(size: String) = with(binding.titleTextView) {
        when (size.uppercase()) {
            "SMALL" -> setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10.0f)
            "NORMAL" -> setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20.0f)
            "BIG" -> setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30.0f)
        }
    }
}