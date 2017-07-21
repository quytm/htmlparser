# Practice about Visitor Design Pattern

## Requirement

Design & implement a simple program html parser

## Suggestion

Using visitor pattern

More detail for reference: 
It takes a good deal of patience to find a real-world case in which refactoring to Visitor
actually makes sense. I found such a case while pair-programming some code that uses an opensource,
streaming HTML parser (see http://sourceforge.net/projects/htmlparser). To understand
this refactoring, I’ll need to give you a brief overview of one of the parser’s main features:
scanners.


As the parser parses HTML (or XML), it recognizes tags and text. For example, consider the
following HTML:
```
<HTML>
<BODY>
    Hello, and welcome to my web page! I work for
    <A HREF="http://industriallogic.com">
        <IMG SRC="http://industriallogic.com/images/logo141x145.gif">
    </A>
</BODY>
</HTML>
```

In its plain vanilla configuration, the parser identifies the following objects in the above
HTML:

```
HTMLTag (for the <BODY> tag)
HTMLStringNode (for the String, “Hello, and welcome…”)
HTMLTag (for the <A HREF=”…”> tag)
HTMLTag (for the <IMG SRC=”…”> tag)
HTMLEndTag (for the </A> tag)
HTMLEndTag (for the </BODY> tag)
```

By default, the parser finds HTMLTags, `HTMLStringNodes` and `HTMLEndTags`. If you want
the parser to create more specific objects for common HTML tags, like links, images and forms,
you have to register the appropriate scanner for each tag you’re interested in. Fortunately, the
parser provides a convenience method for registering all of the most common scanners in one
method call (it’s called registerScanners()). If that method had been called, prior to
obtaining the found tag objects in the above HTML, the parser would’ve recognize the following
objects:

```
HTMLTag (for the <BODY> tag)
HTMLStringNode (for the String, “Hello, and welcome…”)
HTMLLinkTag (for the <A HREF=”…”>…</A> tags)
HTMLImageTag (for the <IMG SRC=”…”> tag)
HTMLEndTag (for the </BODY> tag)
```


In other words, once the most common scanners have been registered, the parser can now
recogize that `<A HREF=”…”>` is an `HTMLLinkTag` object and `<IMG SRC=”…”>` is an
`HTMLImageTag` object.


The parser allows programmers to create and register their own custom scanners. Such
scanners are usually written to identify non-standard tags in HTML or XML. For example, while
working on some code to transform HTTP parameters into XML, my colleague, Somik Raha, and
I found that we needed the ability to find the number of <parameter> tags in XML like this:


DRAFT of Refactoring To Patterns, Copyright © 2003, Joshua Kerievsky, Industrial Logic, Inc. All Rights Reserved.

```
<input>
    <parameter name='key1'>value1</param>
    <parameter name='key2'>value2</param>
</input>
```


Since the parser has no idea what a `<parameter>` tag is, we wrote a custom scanner
(ParameterScanner) and custom tag (ParameterTag) to make the parser capable of
recognizing ParameterTag objects.