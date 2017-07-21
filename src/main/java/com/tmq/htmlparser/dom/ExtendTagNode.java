package com.tmq.htmlparser.dom;


import com.tmq.htmlparser.HTMLScanner;

/**
 * Created by quytm58 on 20/07/17.
 */
public class ExtendTagNode extends Node {

    private String openTag;

    public String getOpenTag() {
        return openTag;
    }

    public void setOpenTag(String openTag) {
        this.openTag = openTag;
    }


    public void scanOpenTag(HTMLScanner scanner) {
        scanner.scanOpenTag(this);
    }

    public void scanEndTag(HTMLScanner scanner) {
        scanner.scanEndTag(this);
    }

    public void scanContent(HTMLScanner scanner) {
        scanner.scanContent(this);
    }
}
