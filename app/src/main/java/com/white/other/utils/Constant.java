package com.white.other.utils;

/**
 * Created by A8 on 2016/6/1.
 */
public class Constant {
    public static final String HOT="http://open.qyer.com/lastminute/page/local_leisure?client_id=qyer_discount_androi&client_secret=227097da1d07a2a9860f&track_user_id=&track_deviceid=000000000000000&track_app_version=1.9.8&track_app_channel=wandoujiayh&track_device_info=vbox86p&track_os=Android5.0&app_installtime=1464765765791&size=768x1184&ra_referer=app_home&city_id=%20HTTP/1.1";

    public static final String HOME_URL = "http://open.qyer.com/lastminute/home/major?client_id=qyer_discount_androi&client_secret=227097da1d07a2a9860f&track_user_id=&track_deviceid=865586022953519&track_app_version=1.9.8&track_app_channel=wandoujiayh&track_device_info=hwPE&track_os=Android4.4.2&app_installtime=1464769962860&size=1080x1776&ra_referer=&lat=22.534599&lon=113.945138&oauth_token=";

    public static final String HOME_CHOICENESS_DATA = "http://open.qyer.com/lastminute/app_selected_product?client_id=qyer_discount_androi&client_secret=227097da1d07a2a9860f&track_user_id=&track_deviceid=865586022953519&track_app_version=1.9.8&track_app_channel=wandoujiayh&track_device_info=hwPE&track_os=Android4.4.2&app_installtime=1464769962860&size=1080x1776&ra_referer=&lat=22.534612&lon=113.945124&";


    /**
     * 目的地URL
     */
    public static final String DES_CITY =
            "http://open.qyer.com/lastminute/conf/destination?client_id=qyer_discount_androi&client_secret=227097da1d07a2a9860f&track_user_id=&track_deviceid=000000000000000&track_app_version=1.9.8&track_app_channel=wandoujiayh&track_device_info=vbox86p&track_os=Android6.0&app_installtime=1464770753649&size=1440x2560&ra_referer=app_home";


    /**
     * 获取推荐页面的数据
     *
     * @param callback
     */
    public static void getDes(QyerTask.IRequestCallback callback) {
        QyerTask.IRequest request = new QyerTask.IRequest() {

            @Override
            public Object doRequest() {
                return HttpUtil.doGet(DES_CITY);
            }
        };
        QyerTask task = new QyerTask(request, callback);
        task.execute();
    }



    public static String getURL(String countryid, String cityid) {

        return "http://open.qyer.com/lastminute/destnation/page?client_id=qyer_discount_androi&client_secret=227097da1d07a2a9860f&track_user_id=&track_deviceid=000000000000000&track_app_version=1.9.8&track_app_channel=wandoujiayh&track_device_info=vbox86p&track_os=Android6.0&app_installtime=1464770753649&size=1440x2560&ra_referer=&countryid=" + countryid + "&cityid=" + cityid;

    }

}
