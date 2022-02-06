## Usage

### Dependency
```gradle
	dependencies {
	        implementation 'com.github.myDario:DarioRichClickableTextView:1.0.0'
	}
```

### Apply to TextView
```kotlin
val richText = "<b>hello</b> <a href='#'>world</a>"
findViewById<TextView>(R.id.textview01)?.let { textview ->
    DarioRichTextClickable.transform(textview, richText, listOf(
        Runnable {
            Log.d("dbg", "1st click handler")
        }
    ))
}
```
