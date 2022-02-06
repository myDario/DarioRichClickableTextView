package com.labstyle.darioandroid.dariorichtextclickable

import android.graphics.Color
import android.text.Html
import android.text.Spannable
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.URLSpan
import android.view.View
import android.widget.TextView

class DarioRichTextClickable {
    companion object {
        fun transform(textView: TextView, text: String, clickHandlers: List<Runnable>? = null) {
            val clickSpans = ArrayList<ClickableSpan>()
            val spannedHtml = Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY)

            textView.text = spannedHtml

            textView.movementMethod = LinkMovementMethod.getInstance()
            textView.highlightColor = Color.TRANSPARENT
            textView.autoLinkMask = 0
            val spannable: Spannable = textView.text as Spannable

            val spans: Array<Any> = spannedHtml.getSpans(0, spannedHtml.length - 1, Any::class.java)
            spans.filterIsInstance<URLSpan>().forEach { span ->
                val start = spannedHtml.getSpanStart(span)
                val end = spannedHtml.getSpanEnd(span)

                val clickSpan: ClickableSpan = object: ClickableSpan() {
                    override fun onClick(widget: View) {
                        clickHandlers?.let { handlers ->
                            val index = clickSpans.indexOf(this)
                            if (index >= 0 && handlers.size > index) {
                                handlers[index].run()
                            }
                        }
                    }

                    override fun updateDrawState(ds: TextPaint) {
                        super.updateDrawState(ds)
                        ds.isUnderlineText = false
                        ds.color = textView.currentTextColor
                    }
                }

                spannable.removeSpan(span)
                spannable.setSpan(clickSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                clickSpans.add(clickSpan)
            }
        }
    }
}