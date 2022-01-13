# DarioRichClickableTextView
A rich text component for iOS &amp; Android with anchor click support

## String format
The format of the string to provide supports some usual standard HTML.
Anchor links `<a>` will be clickable, and an array (or list) of callback functions may be provided to handle the clicks.
```html
The <b>quick</b> <span style='color:#a52a2a;'>brown</span> <i>fox</i>
jumps <a>over</a> <u>the</u> <a>lazy dog</a>.
```

![Preview render](/img/preview0.png)

In the above render, `over` and `lazy dog` are clickable.
