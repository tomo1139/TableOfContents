package com.example.tomo.tableofcontents

data class Data(val contents: List<Content>)

sealed class Content {
    data class Table(val content: List<TableContent>) : Content()
    data class CaptionParts(val tag: String, val title: String) : Content()
    data class TextParts(val text: String) : Content()
}


data class TableContent(val tag: String, val title: String)