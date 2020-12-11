package com.example.case1.ui.main.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.case1.R
import com.example.case1.ui.main.detail.ArticleDetailFragmentArgs
import kotlinx.android.synthetic.main.fragment_image_dialog.*


class ImageDialogFragment : DialogFragment() {
    private val args: ArticleDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image_dialog, container, false).apply {
            dialog?.setCanceledOnTouchOutside(true)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.Theme_AppCompat_Light_Dialog_Alert_fullWidth)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(imageViewPopup) //nerede kullanacağız
            .load(args.article.urlToImage) //neyi yükleyeceğiz
            .into(imageViewPopup) //nereye yükleyeceğiz
    }
}
