package com.shevy.bitsandpizzas

import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.shevy.bitsandpizzas.CaptionedImagesAdapter.*

class CaptionedImagesAdapter(
    private val captions: Array<String?>,
    private val imageIds: IntArray

) :
    RecyclerView.Adapter<ViewHolder>() {
    private var listener: CaptionedImagesAdapter.Listener? = null

    interface Listener {
        fun onClick(position: Int)
    }

    class ViewHolder(internal val cardView: CardView) : RecyclerView.ViewHolder(
        cardView
    )

    override fun getItemCount(): Int {
        return captions.size
    }

    fun setListener(listener: CaptionedImagesAdapter.Listener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val cv: CardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_captioned_image, parent, false) as CardView
        return ViewHolder(cv)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardView: CardView = holder.cardView
        val imageView: ImageView = cardView.findViewById(R.id.info_image)
        val drawable = ContextCompat.getDrawable(cardView.context, imageIds[position])
        imageView.setImageDrawable(drawable)
        imageView.contentDescription = captions[position]
        val textView: TextView = cardView.findViewById(R.id.info_text)
        textView.text = captions[position]
        cardView.setOnClickListener {
            listener?.onClick(position)
        }
    }
}

/*
internal class CaptionedImagesAdapter(
    private val captions: Array<String>,
    private val imageIds: IntArray
) :
    RecyclerView.Adapter<ViewHolder>() {
    private var listener: CaptionedImagesAdapter.Listener? = null

    internal interface Listener {
        fun onClick(position: Int)
    }

    class ViewHolder(private val cardView: CardView) : RecyclerView.ViewHolder(
        cardView
    )

    override fun getItemCount(): Int {
        return captions.size
    }

    fun setListener(listener: CaptionedImagesAdapter.Listener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val cv = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_captioned_image, parent, false) as CardView
        return ViewHolder(cv)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardView: CardView = holder.cardView
        val imageView = cardView.findViewById<View>(R.id.info_image) as ImageView
        val drawable = ContextCompat.getDrawable(cardView.context, imageIds[position])
        imageView.setImageDrawable(drawable)
        imageView.contentDescription = captions[position]
        val textView = cardView.findViewById<View>(R.id.info_text) as TextView
        textView.text = captions[position]
        cardView.setOnClickListener {
            if (listener != null) {
                listener.onClick(position)
            }
        }
    }
}*/
