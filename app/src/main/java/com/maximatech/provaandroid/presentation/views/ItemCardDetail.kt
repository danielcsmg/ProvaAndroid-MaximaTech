package com.maximatech.provaandroid.presentation.views

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import com.maximatech.provaandroid.R
import androidx.core.content.withStyledAttributes
import androidx.core.view.isVisible
import com.maximatech.provaandroid.databinding.ItemCardDetailBinding

class DetailItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr) {
    private var binding: ItemCardDetailBinding =
        ItemCardDetailBinding.inflate(LayoutInflater.from(context), this, true)
    private val titleTextView: TextView = binding.tvClientTitleCard
    private val subtitleTextView: TextView = binding.tvClientSubtitleCard

    init {
        attrs?.let {
             context.withStyledAttributes(it, R.styleable.ItemCardDetail, 0, 0) {
                 val title = getString(R.styleable.ItemCardDetail_detailTitle)
                 val subtitle = getString(R.styleable.ItemCardDetail_detailSubtitle)
                 val iconDrawable = getDrawable(R.styleable.ItemCardDetail_detailIcon)

                 titleTextView.text = title
                 subtitleTextView.text = subtitle
                 setIcon(iconDrawable)
             }
         }
    }

    /**
     * Define o texto para o título.
     * @param title O texto a ser exibido como título.
     */
    fun setTitle(title: CharSequence?) {
        titleTextView.text = title
    }

    /**
     * Define o texto para o subtítulo.
     * @param subtitle O texto a ser exibido como subtítulo.
     */
    fun setSubtitle(subtitle: CharSequence?) {
        subtitleTextView.text = subtitle
    }

    /**
     * Define o ícone a ser exibido a partir de um ID de recurso drawable.
     * @param resId O ID do recurso drawable.
     */
    fun setIcon(image: Drawable?) {
        if (image != null) {
            try {
                binding.ivDetailIcon.setImageDrawable(image)
                binding.ivDetailIcon.isVisible = true
            } catch (e: Exception) {
                binding.ivDetailIcon.isVisible = false
            }
        } else {
            binding.ivDetailIcon.isVisible = false
        }
    }
}

