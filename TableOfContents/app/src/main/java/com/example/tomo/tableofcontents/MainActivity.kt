package com.example.tomo.tableofcontents

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tomo.tableofcontents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val contents = listOf(
                Content.Table(listOf(
                        TableContent("tag1", "caption1"),
                        TableContent("tag2", "caption2"),
                        TableContent("tag3", "caption3"),
                        TableContent("tag4", "caption4"),
                        TableContent("tag5", "caption5"),
                        TableContent("tag6", "caption6"),
                        TableContent("tag7", "caption7"),
                        TableContent("tag8", "caption8"),
                        TableContent("tag9", "caption9"),
                        TableContent("tag10", "caption10")
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

        val controller = EpoxyController()
        controller.setData(data)
        binding.recyclerView.adapter = controller.adapter
    }
}
