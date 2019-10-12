package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class practice {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Mos_QLO: 3.9788");
        list.add("avg_delay: 1685.847ms");
        String mos = list.get(0).substring(list.get(0).indexOf(": ")+2);
        System.out.println(mos);
        String delay = list.get(1).substring(list.get(1).indexOf(": ")+2, list.get(1).indexOf("ms"));
        System.out.println(delay);
        String ne = "bts-tap.webex.com,meetingId=Automation42 mos_lqo=4.0498 avg_delay=1829.647";
        ne = ne.replace("\n", "").replace("\r","");
        System.out.println(ne);
    }
}
