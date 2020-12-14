package com.example.case1.ui.main.dialog

import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.case1.R
import com.example.case1.databinding.FragmentImageDialogBinding
import com.example.case1.ui.main.base.BaseDialogFragment
import com.example.case1.ui.main.detail.ArticleDetailFragmentArgs

class ImageDialogFragment : BaseDialogFragment<FragmentImageDialogBinding>() {

    private val args: ArticleDetailFragmentArgs by navArgs()

    override fun getViewBinding() = FragmentImageDialogBinding.inflate(layoutInflater)

    override fun initViews() {
        binding?.imageViewPopup?.let {
            Glide.with(binding?.imageViewPopup!!)
                .load(args.article.imageUrl)
                .into(it)
        }
    }

    override fun setDialogStyle() {
        setStyle(STYLE_NO_FRAME, R.style.Theme_AppCompat_Light_Dialog_Alert_fullWidth)
    }
}