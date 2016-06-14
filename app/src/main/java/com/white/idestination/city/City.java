package com.white.idestination.city;

/**
 * Created by Administrator on 2016/6/6.
 */
public class City {


    public City() {
    }

    /**
     * countryid=1966
     * cityid=50
     * 香港
     */
    public static String getURL(String countryid, String cityid) {

        return "http://open.qyer.com/lastminute/destnation/page?client_id=qyer_discount_androi&client_secret=227097da1d07a2a9860f&track_user_id=&track_deviceid=000000000000000&track_app_version=1.9.8&track_app_channel=wandoujiayh&track_device_info=vbox86p&track_os=Android6.0&app_installtime=1464770753649&size=1440x2560&ra_referer=&countryid=" + countryid + "&cityid=" + cityid;

    }

}
