package com.example.tomo.tableofcontents

import android.content.Context
import android.databinding.DataBindingUtil
import android.graphics.Paint
import android.view.LayoutInflater
import com.airbnb.epoxy.TypedEpoxyController
import com.example.tomo.tableofcontents.databinding.LinkBinding
import com.example.tomo.tableofcontents.databinding.TableOfContentsPartsBinding

class EpoxyController(private val context: Context, private val callback: TableOfContentsCallback) : TypedEpoxyController<Data>() {

    override fun buildModels(data: Data) {

        data.contents.forEach {
            when (it) {
                is Content.TableOfContents -> {
                    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                    TableOfContentsPartsBindingModel_()
                            .onBind { model, view, position ->
                                val container = (view.dataBinding as TableOfContentsPartsBinding).container
                                if (container.childCount == 0) {
                                    it.links.forEach {
                                        val binding = DataBindingUtil.inflate<LinkBinding>(inflater, R.layout.link, null, false)
                                        binding.link = it
                                        binding.callback = callback
                                        binding.title.paintFlags = binding.title.paintFlags or Paint.UNDERLINE_TEXT_FLAG
                                        container.addView(binding.root)
                                    }
                                }
                            }
                            .onUnbind { model, view ->
                                val container = (view.dataBinding as TableOfContentsPartsBinding).container
                                container.removeAllViews()
                            }
                            .id(modelCountBuiltSoFar)
                            .addTo(this)
                }

                is Content.CaptionParts -> {
                    CaptionPartsBindingModel_()
                            .id(modelCountBuiltSoFar)
                            .caption(it)
                            .addTo(this)
                }

                is Content.TextParts -> {
                    TextPartsBindingModel_()
                            .id(modelCountBuiltSoFar)
                            .text(it.text)
                            .addTo(this)
                }
            }
        }
    }
}