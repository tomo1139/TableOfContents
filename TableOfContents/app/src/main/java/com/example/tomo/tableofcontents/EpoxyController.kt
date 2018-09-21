package com.example.tomo.tableofcontents

import com.airbnb.epoxy.TypedEpoxyController

class EpoxyController : TypedEpoxyController<Data>() {

    override fun buildModels(data: Data) {

        data.contents.forEach {
            when (it) {
                is Content.Table -> {

                }

                is Content.CaptionParts -> {
                    CaptionPartsBindingModel_()
                            .id(modelCountBuiltSoFar)
                            .text(it.title)
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