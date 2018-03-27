package test.t01;

import com.sun.org.apache.xpath.internal.operations.Number;
import jdk.internal.util.xml.impl.Input;
import main.t01.KeyWordsFromFileByte;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Ekaterina Semenova on 26.03.2018.
 */
@DisplayName("Testing KeyWordsFromFileByte.java")//Behavior driving devepoping
public class KeyWordsFromFileByteTest {
    private static final Integer NUMBER = 1;
    @Test
    @DisplayName("getKeyWords() returns Map<String, Integer>")
    void getKeyWordsShouldReturnMap(){
        KeyWordsFromFileByte keyWordsFromFileByte = new KeyWordsFromFileByte(new File("src\\test\\filetest\\test"));
        Map<String, Integer> map = new TreeMap<>();
        map.put("abstract", NUMBER);
        map.put("continue", NUMBER);
        map.put("for", NUMBER);
        map.put("new", NUMBER);
        map.put("switch", NUMBER);
        map.put("assert", NUMBER);
        map.put("default", NUMBER);
        map.put("goto", NUMBER);
        map.put("package", NUMBER);
        map.put("synchronized", NUMBER);
        map.put("boolean", NUMBER);
        map.put("do",NUMBER);
        map.put("private",NUMBER);
        map.put("if",NUMBER);
        map.put("this",NUMBER);
        map.put("break",NUMBER);
        map.put("double",NUMBER);
        map.put("implements",NUMBER);
        map.put("protected",NUMBER);
        map.put("throw",NUMBER);
        map.put("import",NUMBER);
        map.put("byte",NUMBER);
        map.put("else",NUMBER);
        map.put("throws",NUMBER);
        map.put("public",NUMBER);
        map.put("case",NUMBER);
        map.put("enum",NUMBER);
        map.put("instanceof",NUMBER);
        map.put("return",NUMBER);
        map.put("transient",NUMBER);
        map.put("extends",NUMBER);
        map.put("catch",NUMBER);
        map.put("int",NUMBER);
        map.put("short",NUMBER);
        map.put("try",NUMBER);
        map.put("final",NUMBER);
        map.put("interface",NUMBER);
        map.put("static",NUMBER);
        map.put("void",NUMBER);
        map.put("char",NUMBER);
        map.put("finally",NUMBER);
        map.put("long",NUMBER);
        map.put("strictfp",NUMBER);
        map.put("class",NUMBER);
        map.put("volatile",NUMBER);
        map.put("float",NUMBER);
        map.put("const",NUMBER);
        map.put("native",NUMBER);
        map.put("super",NUMBER);
        map.put("while",NUMBER);
        map.put("true",NUMBER);
        map.put("false",NUMBER);
        map.put("null",NUMBER);
        assertEquals(map, keyWordsFromFileByte.getKeyWords());
    }

}
