package org.techtown.testcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.techtown.testcomponent.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    companion object {
        private const val EMPTY = "empty"
        private const val OCCUPIED = "occupied"
        private const val RESERVED = "reserved"
        private const val SMALL = "small"
        private const val NORMAL = "normal"
        private const val BIG = "big"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initButton()
    }

    private fun initButton() = with(binding) {
        try1Button.setOnClickListener { setLotView(EMPTY) }
        try2Button.setOnClickListener { setLotView(OCCUPIED) }
        try3Button.setOnClickListener { setLotView(RESERVED) }
    }

    private fun ActivityMainBinding.setLotView(state: String) = testLotView.apply {
        setTitleSize(getRandomSize())
        setState(state)
        setText(state)
    }

    private fun getRandomSize(): String = when (Random.nextInt(1, 4)) {
        1 -> SMALL
        2 -> NORMAL
        else -> BIG
    }
}