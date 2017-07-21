package com.tmq.htmlparser.dom;


import com.tmq.htmlparser.HTMLScanner;

/**
 * Created by quytm58 on 20/07/17.
 */
public interface Item {

    void scanOpenTag(HTMLScanner scanner);

    void scanEndTag(HTMLScanner scanner);

    void scanContent(HTMLScanner scanner);

}
