package com.example.tomo.tableofcontents

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tomo.tableofcontents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TableOfContentsCallback {

    private val binding: ActivityMainBinding by lazy { DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val contents = listOf(
                Content.TableOfContents(listOf(
                        Link("tag1", "caption1"),
                        Link("tag2", "caption2"),
                        Link("tag3", "caption3"),
                        Link("tag4", "caption4"),
                        Link("tag5", "caption5"),
                        Link("tag6", "caption6"),
                        Link("tag7", "caption7"),
                        Link("tag8", "caption8"),
                        Link("tag9", "caption9"),
                        Link("tag10", "caption10")
                )),
                Content.CaptionParts("tag1", "caption1"), Content.TextParts("textParts1"),
                Content.CaptionParts("tag2", "caption2"), Content.TextParts("textParts2"),
                Content.CaptionParts("tag3", "caption3"), Content.TextParts("textParts3"),
                Content.CaptionParts("tag4", "caption4"), Content.TextParts("textParts4"),
                Content.CaptionParts("tag5", "caption5"), Content.TextParts("textParts5"),
                Content.CaptionParts("tag6", "caption6"), Content.TextParts("textParts6"),
                Content.CaptionParts("tag7", "caption7"), Content.TextParts("textParts7"),
                Content.CaptionParts("tag8", "caption8"), Content.TextParts("textParts8"),
                Content.CaptionParts("tag9", "caption9"), Content.TextParts("textParts9"),
                Content.CaptionParts("tag10", "caption10"), Content.TextParts("textParts10")
        )
        val data = Data(contents)

        val controller = EpoxyController(this, this)
        controller.setData(data)
        binding.recyclerView.adapter = controller.adapter
    }

    override fun onClickLink(link: Link) {
        Log.e("dbg", link.toString())
    }
}
