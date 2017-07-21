package com.tmq.htmlparser;


import com.tmq.htmlparser.dom.Node;
import com.tmq.htmlparser.dom.TagNode;

/**
 * Created by quytm58 on 20/07/17.
 */
public class HTMLParser{

    public static Node parse(String input) {
        input = standardized(input);

        // todo: scan


        return new TagNode();
    }

    /**
     * standardized input: clear duplicated space, ...
     * @param input HTML string
     * @return standard HTML string
     */
    public static String standardized(String input) {
        // todo: do st
        return input;
    }

}
