package com.techacademy;

import org.springframework.web.bind.annotation.RestController;
import java.util.Calendar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{yyyyMMdd}")
    public String dispDayOfWeek(@PathVariable String yyyyMMdd) {
        String date = yyyyMMdd;
        String year = date.substring(0,4);
        String month= date.substring(4,6);
        String day = date.substring(6,8);

        Calendar time = Calendar.getInstance();
        time.set(Calendar.YEAR,Integer.parseInt(year));
        time.set(Calendar.MONTH, Integer.parseInt(month)-1);
        time.set(Calendar.DATE,Integer.parseInt(day));
        int dayOfweek = time.get(Calendar.DAY_OF_WEEK);

        String[] weekDays = {"", "日", "月", "火", "水", "木", "金", "土"};
        return  weekDays[dayOfweek] + "曜日";

    }

    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1,@PathVariable int val2) {
        int res = val1 + val2;
        return "計算結果は" + res;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1,@PathVariable int val2) {
        int res = val1 - val2;
        return "計算結果は" + res;
    }

    @GetMapping("/time/{val1}/{val2}")
    public String calcTime(@PathVariable int val1,@PathVariable int val2) {
        int res = val1 * val2;
        return "計算結果は" + res;
    }
    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivid(@PathVariable int val1,@PathVariable int val2) {
        int res = val1 / val2;
        return "計算結果は" + res;
    }



}
