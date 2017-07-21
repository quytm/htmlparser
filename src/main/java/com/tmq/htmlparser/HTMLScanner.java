package com.tmq.htmlparser;

import com.tmq.htmlparser.dom.ExtendTagNode;
import com.tmq.htmlparser.dom.Item;
import com.tmq.htmlparser.dom.Node;
import com.tmq.htmlparser.dom.TagNode;

/**
 * Created by quytm on 7/21/2017.
 */
public class HTMLScanner {

    private static char PREFIX_TAG = '<';
    private static char SUFIX_TAG = '>';
    private static char SLASH = '/';


//    public String visit(TagNode tagNode){
//
//        return "";
//    }
//
//    public String visit(ExtendTagNode extendTagNode){
//
//        return "";
//    }

    public Node scan(String input) {
        Node currentNode = createNode(input);



        return currentNode;
    }

    public Node createNode(String input) {
        Node currentNode;
        String openTagName = scanOpenTagName(input);

        if (!openTagName.contains(" ")) {
            currentNode = new TagNode();
            currentNode.setName(openTagName);
        } else {
            currentNode = new ExtendTagNode();
            currentNode.setName(getExtendTagName(openTagName));
            ((ExtendTagNode)currentNode).setOpenTag(openTagName);
        }

        return currentNode;
    }

    public String scanOpenTagName(String input) {
        int startPrefixTag = input.indexOf(PREFIX_TAG);
        int endPrefixTag = input.indexOf(SUFIX_TAG);

        return input.substring(startPrefixTag + 1, endPrefixTag);
    }

    public String getExtendTagName(String openTagName) {
        int startPrefixTag = openTagName.indexOf(PREFIX_TAG);
        int endPrefixTag = openTagName.indexOf(" ");
        return openTagName.substring(startPrefixTag + 1, endPrefixTag);
    }


    // ------------------- Item

    public Node scanContent(Node node) {
        // todo
        return new TagNode();
    }

    public Node scanEndTag(Node node) {
        // todo
        return new TagNode();
    }

    // ------------------ TagNode

    public TagNode scanOpenTag(TagNode tagNode) {
        // todo
        return new TagNode();
    }

    // ------------------- ExtendTagNode

    public ExtendTagNode scanOpenTag(ExtendTagNode ExtendTagNode) {
        // todo
        return new ExtendTagNode();
    }

}
