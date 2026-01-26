package baekjoon.silver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

@DisplayName("비밀번호 찾기")
class BOJ17219Test {

    @Test
    void testCase1_basicCase() throws IOException {
        String input = """
                3 2
                google password1
                naver pass123
                daum qwerty
                google
                daum
                """;
        String expected = """
                password1
                qwerty
                """.strip();
        assertEquals(expected, BOJ_17219.solve(input).strip());
    }

    @Test
    void testCase2_singleEntry() throws IOException {
        String input = """
                1 1
                github ghpass
                github
                """;
        String expected = "ghpass";
        assertEquals(expected, BOJ_17219.solve(input).strip());
    }

    @Test
    void testCase3_largeCase() throws IOException {
        String input = """
                4 3
                siteA aaa
                siteB bbb
                siteC ccc
                siteD ddd
                siteB
                siteD
                siteA
                """;
        String expected = """
                bbb
                ddd
                aaa
                """.strip();
        assertEquals(expected, BOJ_17219.solve(input).strip());
    }

    @Test
    void testCase4() throws IOException {
        String input = """
                16 4
                noj.am IU
                acmicpc.net UAENA
                startlink.io THEKINGOD
                google.com ZEZE
                nate.com VOICEMAIL
                naver.com REDQUEEN
                daum.net MODERNTIMES
                utube.com BLACKOUT
                zum.com LASTFANTASY
                dreamwiz.com RAINDROP
                hanyang.ac.kr SOMEDAY
                dhlottery.co.kr BOO
                duksoo.hs.kr HAVANA
                hanyang-u.ms.kr OBLIVIATE
                yd.es.kr LOVEATTACK
                mcc.hanyang.ac.kr ADREAMER
                startlink.io
                acmicpc.net
                noj.am
                mcc.hanyang.ac.kr
                """;
        String expected = """
                THEKINGOD
                UAENA
                IU
                ADREAMER
                """;
        assertEquals(expected, BOJ_17219.solve(input));
    }
}
