package com.tmq.htmlparser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by quytm on 7/21/2017.
 */
public class HTMLScannerTest {

    private HTMLScanner scanner;
    private String testCase1;
    private String testCase2;

    @Before
    public void init() {
        scanner = new HTMLScanner();
        testCase1 = "<body>Tran Minh Quy</body>";
        testCase2 = "<img src='sdfkds.com'>Tran Minh Quy</img>";
    }

    @Test
    public void testScanTagNameIsBody() {
        String name = scanner.scanOpenTagName(testCase1);

        Assert.assertEquals("body", name);
    }

    @Test
    public void testScanTagNameIsImg() {
        String name = scanner.getExtendTagName("img src='sdfkds.com'");

        Assert.assertEquals("img", name);
    }

    @Test
    public void testGetEndTagPosition() {

    }

}
