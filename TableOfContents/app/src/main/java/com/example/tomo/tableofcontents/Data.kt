package com.example.tomo.tableofcontents

data class Data(val contents: List<Content>)

sealed class Content {
    data class TableOfContentsParts(val links: List<Link>) : Content()
    data class CaptionParts(val tag: String, val title: String) : Content()
    data class TextParts(val text: String) : Content()
}


data class Link(val tag: String, val title: String)