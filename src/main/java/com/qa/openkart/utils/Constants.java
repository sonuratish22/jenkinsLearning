package com.qa.openkart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {

    public static  final Duration DEFAULT_TIME_OUT = Duration.ofSeconds(5);
    public static final String ACC_PAGE_TITLE = "My Account";
    public static final List<String> expectedHeaderLists = new ArrayList<String>(Arrays.asList("My Account", "My Orders", "My Affiliate Account", "Newsletter"));
}
