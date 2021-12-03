package com.space;

import cn.hutool.core.util.PinyinUtil;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@SpringBootTest
public class HutoolTest {


//    @Test
//    public void test() {
//        String pinyin = PinyinUtil.getFirstLetter("薛春峰","");
//        log.info("------------>{}", pinyin);
//    }


    @Test
    public void test1() {
        String pinyin = PinyinUtil.getAllFirstLetter("薛春峰");
        log.info("------------>{}", pinyin);
        String bearer = "Bearer ";
        String token = "bearer;eyJ0eXAiOiJKV1QiLYyNDQxNjYwNTU4NiwiaXNzdWVyIjoid2Fuemh1IiwibnUb2wZSsgs2vvGecw";
        int index = token.indexOf(";");
        String newStr = token.substring(index + 1);

        log.info("------------>{}", bearer + newStr);
    }

}
