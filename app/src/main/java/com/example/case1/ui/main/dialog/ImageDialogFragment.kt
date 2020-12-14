package com.example.case1.ui.main.dialog

import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.case1.R
import com.example.case1.ui.main.base.BaseDialogFragment
import com.example.case1.ui.main.detail.ArticleDetailFragmentArgs
import kotlinx.android.synthetic.main.fragment_image_dialog.*

class ImageDialogFragment : BaseDialogFragment() {

    private val args: ArticleDetailFragmentArgs by navArgs()

    override fun getLayoutId(): Int {
        return R.layout.fragment_image_dialog
    }

    override fun initViews() {
        Glide.with(imageViewPopup)
            .load(args.article.imageUrl)
            .into(imageViewPopup)
    }

    override fun setDialogStyle() {
        setStyle(STYLE_NO_FRAME, R.style.Theme_AppCompat_Light_Dialog_Alert_fullWidth)
    }
}