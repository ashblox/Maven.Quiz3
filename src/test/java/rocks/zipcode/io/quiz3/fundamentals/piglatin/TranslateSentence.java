package rocks.zipcode.io.quiz3.fundamentals.piglatin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.zipcode.io.quiz3.fundamentals.PigLatinGenerator;

/**
 * @author leon on 09/12/2018.
 */
public class TranslateSentence {
    private PigLatinGenerator p;

    @Before
    public void setUp() throws Exception {
        this.p = new PigLatinGenerator();
    }

    @Test
    public void startsWithVowelTest() {
        String input = "always";
        Assert.assertTrue(p.startsWithVowel(input));
    }

    @Test
    public void findFirstVowelTest() {
        String input = "thorough";
        int expected = 2;
        int actual = p.findFirstVowel(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findFirstVowelTest2() {
        String input = "frogtown";
        int expected = 2;
        int actual = p.findFirstVowel(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void translateWithConsonantStartTest() {
        String input = "frogtown";
        String expected = "ogtownfray";
        String actual = p.translateWithConsonantStart(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsAllAlphaCharsTest1() {
        String input = "This is a test";
        Assert.assertTrue(p.containsAllAlphaChars(input));
    }

    @Test
    public void containsAllAlphaCharsTest2() {
        String input = "H0w @re you?";
        Assert.assertFalse(p.containsAllAlphaChars(input));
    }

    @Test
    public void containsNoVowelsTest1() {
        String input = "frkst";
        Assert.assertTrue(p.containsNoVowels(input));
    }

    @Test
    public void containsNoVowelsTest2() {
        String input = "always";
        Assert.assertFalse(p.containsNoVowels(input));
    }

    @Test
    public void translateOneWordTest1() {
        String input = "asdf&xf";
        Assert.assertNull(p.translateOneWord(input));
    }

    @Test
    public void translateOneWordTest2() {
        String input = "artery";
        String expected = "arteryway";
        String actual = p.translateOneWord(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void translateOneWordTest3() {
        String input = "Kansas";
        String expected = "ansasKay";
        String actual = p.translateOneWord(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void translateOneWordTest4() {
        String input = "ghtvr";
        String expected = "ghtvray";
        String actual = p.translateOneWord(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTheQuickBrownFoxJumpsOverTheLazyDog() {
        String input = "The Quick Brown Fox Jumps Over The Lazy Dog";
        String expected = "eThay uickQay ownBray oxFay umpsJay Overway eThay azyLay ogDay";
        String actual = p.translate(input);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_thequickbrownfoxjumpsoverthelazydog() {
        String input = "The Quick Brown Fox Jumps Over The Lazy Dog".toLowerCase();
        String expected = "eThay uickQay ownBray oxFay umpsJay Overway eThay azyLay ogDay".toLowerCase();
        String actual = p.translate(input);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testTHEQUICKBROWNFOXJUMPSOVERTHELAZYDOG() {
        String input = "The Quick Brown Fox Jumps Over The Lazy Dog".toUpperCase();
        String expected = "ETHay UICKQay OWNBRay OXFay UMPSJay OVERway ETHay AZYLay OGDay";
        String actual = p.translate(input);
        Assert.assertEquals(expected, actual);

    }
}
